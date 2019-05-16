/**
 * @projectName project
 * @package cc.daleyzou.patient.controller
 * @className cc.daleyzou.patient.controller.PatientController
 * @copyright Copyright 2019 daleyzou, Inc. All rights reserved.
 */
package cc.daleyzou.patient.controller;

import cc.daleyzou.common.controller.BaseController;
import cc.daleyzou.common.util.Constant;
import cc.daleyzou.patient.component.ActiveDicoms;
import cc.daleyzou.patient.dao.*;
import cc.daleyzou.patient.domain.Instance;
import cc.daleyzou.patient.domain.Patient;
import cc.daleyzou.patient.domain.Series;
import cc.daleyzou.patient.domain.Study;
import cc.daleyzou.patient.rest.*;
import cc.daleyzou.system.domain.User;
import com.github.pagehelper.PageHelper;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.dcm4che3.tool.dcm2jpg.Dcm2Jpg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * PatientController
 * @description TODO
 * @author daleyzou
 * @date 2019年05月16日 15:04
 * @version 1.0.0
 */
@Controller
public class PatientController extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(PatientController.class);

    private static final String JPG_EXT = ".jpg";

    @Autowired
    InstanceMapper instanceMapper;
    @Autowired
    SeriesMapper seriesMapper;
    @Autowired
    StudyMapper studyMapper;
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    EquipmentMapper equipmentMapper;

    @Autowired
    private ActiveDicoms activeDicoms;


    private String pacsImageStoragePath = Constant.STORAGE_IMAGE;


    private String pacsDcmStoragePath = Constant.STORAGE_DCM;

    @RequestMapping("patient/welcome")
    public String index(Model model) {
        return "patient/patient/welcome";
    }

    @RequestMapping(value = "/server", method = RequestMethod.GET)
    public String server(@RequestParam(defaultValue = "1", value = "page", required = false) Integer page,
            @RequestParam(defaultValue = "10", value = "size", required = false) Integer size,
            @RequestParam(defaultValue = "0", value = "pkTBLPatientID", required = false) Long pkTBLPatientID,
            @RequestParam(defaultValue = "0", value = "pkTBLStudyID", required = false) Long pkTBLStudyID,
            @RequestParam(defaultValue = "0", value = "pkTBLSeriesID", required = false) Long pkTBLSeriesID, Model model) {

        LOG.debug("server()");

        int firstResult = (page == null) ? 0 : (page - 1) * size;
        PageHelper.startPage(page, size);
        List<Patient> patients = patientMapper.selectAll();
        model.addAttribute("patients", patients);
        float nrOfPages = (float) patientMapper.selectCount(null) / size;
        int maxPages = (int) (((nrOfPages > (int) nrOfPages) || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages);

        int begin = Math.max(1, page - 5);
        int end = Math.min(begin + 10, maxPages); // how many pages to display in the pagination bar

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", page);
        model.addAttribute("maxPages", maxPages);



        LOG.info("page no:{} page size:{} nrOfPages:{} maxPages:{}", page, size, nrOfPages, maxPages);

        return "patient/patient/server";

    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String showDetails(@RequestParam(defaultValue = "0", value = "pkTBLPatientID", required = false) Long pkTBLPatientID,
            Model model) {

        if (pkTBLPatientID != 0) {
            //add to our model
            Patient patient = patientMapper.selectByPrimaryKey(pkTBLPatientID);
            if (patient != null){
                Example studyExample = new Example(Study.class);
                Example.Criteria studyExampleCriteria = studyExample.createCriteria();
                studyExampleCriteria.andCondition("pkTBLPatientID=", patient.getPktblpatientid());
                List<Study> studies = studyMapper.selectByExample(studyExample);

                Example seriesExample = new Example(Series.class);
                Example.Criteria seriesExampleCriteria = seriesExample.createCriteria();
                seriesExampleCriteria.andCondition("pkTBLStudyID=", studies.get(0).getPktblstudyid());
                List<Series> series1 = seriesMapper.selectByExample(seriesExample);

                Example instanceExample = new Example(Instance.class);
                Example.Criteria instanceExampleCriteria = instanceExample.createCriteria();
                instanceExampleCriteria.andCondition("pkTBLSeriesID=", series1.get(0).getPktblseriesid());
                List<Instance> instances = instanceMapper.selectByExample(instanceExample);

                model.addAttribute("studies", studies);
                model.addAttribute("series1", series1);
                model.addAttribute("instances", instances);

            }else {
                return "index";
            }
            model.addAttribute("patient", patient);
        }

        return "patient/patient/details";
    }

    @RequestMapping(value = "/details/{pkTBLInstanceID}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable Long pkTBLInstanceID, HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        java.io.File tempImage = null;
        Instance instance = instanceMapper.selectByPrimaryKey(pkTBLInstanceID);

        if (instance != null) {
            File dicomFile = new File(pacsDcmStoragePath + "/" + instance.getMediastoragesopinstanceuid() + ".dcm");

            /********************************************************* TEMP IMAGE FILE CREATION *****************************************************************/
            Dcm2Jpg dcm2Jpg = null;
            try {
                // 每一次都需要创建一个实例，因为 Dcm2Jpg 线程不安全
                dcm2Jpg = new Dcm2Jpg();
                // default JPEG writer class, compressionType, and quality
                dcm2Jpg.initImageWriter("JPEG", "jpeg", null, null, null);
                //remove the .dcm and  assign a JPG extension
                String newfilename = FilenameUtils.removeExtension(dicomFile.getName()) + JPG_EXT;
                //create the temporary image file instance
                tempImage = new java.io.File(pacsImageStoragePath, newfilename);

                // 如果文件不存在，就进行文件转换
                if (!tempImage.exists()) {
                    //save the new jpeg into the .img temp folder
                    dcm2Jpg.convert(dicomFile, tempImage);
                }

                if (!tempImage.exists())
                    // 文件不存在
                    throw new Exception();

            } catch (Exception e) {
                LOG.error("failed convert {} to jpeg... Exception: {}", dicomFile, e.getMessage());
            }
            /********************************************************** END OF TEMP FILE CREATION ***************************************************************/

            final HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);

            if (tempImage != null) {
                byte[] bytes = IOUtils.toByteArray(new FileInputStream(tempImage));
                return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.CREATED);
            }

        }

        return null;
    }

    /**
     * HomeController
     * @description 实时的转换得到图片，便于用于网页展示
     * @param pkTBLInstanceID dicom 文件的文件名（去除了后缀）
     * @return dicom-》jpg后的图片的路径
     * @author zoudaifa
     * @date 2019/3/23 18:16
     * @version 1.0.0
     */
    @RequestMapping(value = "/showimage/{pkTBLInstanceID}", method = RequestMethod.GET)
    public @ResponseBody
    String showImage(@PathVariable Long pkTBLInstanceID) throws IOException {

        String img = "";
        File file = null;
        int width = 0;
        int height = 0;
        Instance instance = null;
        Dimension newImageSize = null;

        try {
            instance = instanceMapper.selectByPrimaryKey(pkTBLInstanceID);

            if (instance != null) {

                File dicomFile = new File(pacsDcmStoragePath + "/" + instance.getMediastoragesopinstanceuid() + ".dcm");
                String newfilename = FilenameUtils.removeExtension(dicomFile.getName()) + JPG_EXT;
                //create the temporary image file instance
                file = new java.io.File(pacsImageStoragePath, newfilename);
                BufferedImage bimg = ImageIO.read(file);
                width = bimg.getWidth();
                height = bimg.getHeight();
                LOG.debug("Original width:" + width + " Original height:" + height);
                System.setProperty("java.awt.headless", "true");

                /*getScreenSize doesn't work properly, hold this until get it fixed and keep 1000x800 constant size*/
                //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

                //keep constant size for now
                Dimension screenSize = new Dimension(1000, 800);
                //                if (width >= MAX_IMAGE_WIDTH || height >= MAX_IMAGE_HEIGHT) {
                //                    Dimension imgSize = new Dimension(width, height);
                //                    Dimension boundary = new Dimension(MAX_IMAGE_WIDTH, MAX_IMAGE_HEIGHT);
                //                    newImageSize = Utils.getScaledDimension(imgSize, boundary);
                //                    width = newImageSize.width;
                //                    height = newImageSize.height;
                //                }

                // 设置显示的图片的宽度和高度
                width = 512;
                height = 512;

                LOG.debug("Screen width:" + screenSize.width + "  Screen Height:" + screenSize.height);
                LOG.debug("Image width:" + width + " Image height:" + height);

                if (file.exists()) {
                    img = "<img  src=\'/details/" + pkTBLInstanceID + "\' style=\'width: " + width + "px; height: " + height + "px;\' /> ";
                }
            }

        } catch (Exception ex) {
            LOG.error("将文件转换为jpg图片过程中出错: {}", ex.getMessage());
        }
        return img;
    }


    @RequestMapping(value = "/live", method = RequestMethod.GET)
    public @ResponseBody
    AjaxResult live() {
        return new AjaxResult(true, activeDicoms.toString());
    }


    @RequestMapping(value = "/study", method = RequestMethod.GET)
    public @ResponseBody
    AjaxStudy study(@RequestParam(defaultValue = "0", value = "pkTBLStudyID", required = false) Long pkTBLStudyID) {
        Study study = studyMapper.selectByPrimaryKey(pkTBLStudyID);
        return new AjaxStudy(true, study);
    }

    @RequestMapping(value = "/series", method = RequestMethod.GET)
    public @ResponseBody
    AjaxSeries series(@RequestParam(defaultValue = "0", value = "pkTBLSeriesID", required = false) Long pkTBLSeriesID) {
        Series series = seriesMapper.selectByPrimaryKey(pkTBLSeriesID);
        return new AjaxSeries(true, series);
    }

    @RequestMapping(value = "/instance", method = RequestMethod.GET)
    public @ResponseBody
    AjaxInstance instance(@RequestParam(defaultValue = "0", value = "pkTBLInstanceID", required = false) Long pkTBLInstanceID) {
        Instance instance = instanceMapper.selectByPrimaryKey(pkTBLInstanceID);
        return new AjaxInstance(true, instance);
    }

    @RequestMapping(value = "/patient", method = RequestMethod.GET)
    public @ResponseBody
    AjaxPatient patient(@RequestParam(defaultValue = "0", value = "pkTBLPatientID", required = false) Long pkTBLPatientID) {
        Patient patient = patientMapper.selectByPrimaryKey(pkTBLPatientID);
        return new AjaxPatient(true, patient);
    }
}
