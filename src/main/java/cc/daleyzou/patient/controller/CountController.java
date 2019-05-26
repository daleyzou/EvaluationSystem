/**
 * @projectName project
 * @package cc.daleyzou.patient.controller
 * @className cc.daleyzou.patient.controller.CountController
 * @copyright Copyright 2019 daleyzou, Inc. All rights reserved.
 */
package cc.daleyzou.patient.controller;

import cc.daleyzou.patient.domain.Count;
import cc.daleyzou.patient.service.CountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * CountController
 * @description 计算射血分数 Controller类
 * @author daleyzou
 * @date 2019年05月23日 9:25
 * @version 1.0.0
 */
@Controller
public class CountController {
    private static final Logger LOG = LoggerFactory.getLogger(PatientController.class);


    @Autowired
    CountService countService;

    @RequestMapping(value = "/patient/num/{pkTBLPatientID}", method = RequestMethod.GET)
    @ResponseBody
    public void countNum(@PathVariable Long pkTBLPatientID) {
        countService.countNum(pkTBLPatientID);
    }

    @RequestMapping(value = "/test/num/{pkTBLPatientID}", method = RequestMethod.GET)
    @ResponseBody
    public void testCountNum(@PathVariable Long pkTBLPatientID) {
        countService.countNum(pkTBLPatientID);
    }

    @RequestMapping(value = "/patient/moveJpgToDir/{pkTBLPatientID}", method = RequestMethod.GET)
    @ResponseBody
    public void moveJpgToDir(@PathVariable Long pkTBLPatientID) {
        countService.moveJpgToDir(pkTBLPatientID);
    }

    @RequestMapping(value = "/patient/sketchPicture/{pkTBLPatientID}", method = RequestMethod.GET)
    @ResponseBody
    public void sketchPicture(@PathVariable Long pkTBLPatientID) {
        countService.sketchPicture(pkTBLPatientID);
    }

    @RequestMapping(value = "/sketch", method = RequestMethod.GET)
    public String getSketchPicture(@RequestParam(value = "pkTBLPatientID") Long pkTBLPatientID) {

        List<Count> counts = countService.getSketchPicture(pkTBLPatientID);
        return "patient/sketch/sketch";
    }

    @RequestMapping(value = "/sketchAnimation", method = RequestMethod.GET)
    public String getSliceSketchAnimation(@RequestParam(value = "pkTBLPatientID") Long pkTBLPatientID,
            @RequestParam(value = "sliceLocation") String sliceLocation, Model model) {

        Count count = countService.getSliceSketchPicture(pkTBLPatientID, sliceLocation);
        if (count == null){
            LOG.error("pkTBLPatientID: " + pkTBLPatientID + "   sliceLocation: " + sliceLocation + "查询tbl_count数据为空！");
            return "查询数据为空";
        }
        String[] strs = count.getInstanceUidAll().split(",");
        List<String> uids = Arrays.asList(strs);
        model.addAttribute("uids", uids);
        return "patient/sketch/sketch";
    }

    @RequestMapping(value = "/sketchPicture", method = RequestMethod.GET)
    public String getSliceSketchPicture(@RequestParam(value = "pkTBLPatientID") Long pkTBLPatientID,
            @RequestParam(value = "sliceLocation") String sliceLocation, Model model) {
        Count count = countService.getSliceSketchPicture(pkTBLPatientID, sliceLocation);
        if (count == null){
            LOG.error("pkTBLPatientID: " + pkTBLPatientID + "   sliceLocation: " + sliceLocation + "查询tbl_count数据为空！");
            return "查询数据为空";
        }
        String[] strs = count.getInstanceUidAll().split(",");
        List<String> uids = Arrays.asList(strs);
        model.addAttribute("uids", uids);
        return "patient/sketch/picture";
    }
}
