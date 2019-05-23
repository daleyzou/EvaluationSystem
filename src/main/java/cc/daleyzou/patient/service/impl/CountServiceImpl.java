/**
 * @projectName EasyPACS
 * @package org.easy.service.impl
 * @className org.easy.service.impl.CountServiceImpl
 * @copyright Copyright 2019 daleyzou, Inc. All rights reserved.
 */
package cc.daleyzou.patient.service.impl;

import cc.daleyzou.common.util.Constant;
import cc.daleyzou.common.util.FileUtils;
import cc.daleyzou.patient.dao.CountMapper;
import cc.daleyzou.patient.dao.InstanceMapper;
import cc.daleyzou.patient.dao.PatientMapper;
import cc.daleyzou.patient.domain.Count;
import cc.daleyzou.patient.domain.Instance;
import cc.daleyzou.patient.domain.Patient;
import cc.daleyzou.patient.domain.PatientJpg;
import cc.daleyzou.patient.service.CountService;
import org.apache.commons.io.FilenameUtils;
import org.dcm4che3.tool.dcm2jpg.Dcm2Jpg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * CountServiceImpl
 * @description TODO
 * @author zoudaifa
 * @date 2019年04月10日 8:57
 * @version 1.0.0
 */
@Service
public class CountServiceImpl implements CountService {

    private static final Logger LOG = LoggerFactory.getLogger(CountServiceImpl.class);

    private static final String PNG_EXT = ".png";


    @Autowired
    InstanceMapper instanceMapper;
    @Autowired
    CountMapper countMapper;
    @Autowired
    PatientMapper patientMapper;

    String pacsOriginalPath = Constant.TEMP_IMAGE;

    String pacsResultPath = Constant.TEMP_RESULT;

    private String pacsDcmStoragePath = Constant.STORAGE_DCM;

    @Override
    public void moveJpgToDir(Long pkTBLPatientID) {
        try {

            // 查询该患者的所有心脏dcm文件
            List<Instance> instances = instanceMapper.findAllByPkTBLPatientID(pkTBLPatientID);
            if (CollectionUtils.isEmpty(instances)) {
                // TODO 没有这个患者的dcm文件数据
                System.out.println("没有患者数据");
            }
            int count = 1;
            int num = 1;
            for (Instance instance : instances) {
                if (count % 50 == 0){
                    num++;
                }
                count++;
                File dicomFile = new File(pacsDcmStoragePath + "/" + instance.getMediastoragesopinstanceuid() + ".dcm");
                Dcm2Jpg dcm2Jpg = new Dcm2Jpg();
                dcm2Jpg.initImageWriter("PNG", "PNG", null, null, null);
                String newfilename = FilenameUtils.removeExtension(dicomFile.getName()) + PNG_EXT;
                String outputPath = pacsOriginalPath + pkTBLPatientID.toString() + num + "/";
                // 目录不存在就创建
                boolean orExistsDir = FileUtils.createOrExistsDir(outputPath);
                if (!orExistsDir){
                    LOG.error("创建目录失败");
                }
                File tempImage = new File(outputPath, newfilename);
                // 如果文件不存在，就进行文件转换
                if (!tempImage.exists()) {
                    dcm2Jpg.convert(dicomFile, tempImage);
                }

                if (!tempImage.exists())
                    // 文件不存在
                    throw new Exception();
            }
            // 创建心脏分割结果存放目录
            String resultPath = pacsResultPath + pkTBLPatientID + "/";
            // 目录不存在就创建
            boolean orExistsDir = FileUtils.createOrExistsDir(resultPath);
            if (!orExistsDir){
                LOG.error("创建心脏分割结果存放目录失败");
            }
        }catch (Exception e){
            String message = "将患者id为" + pkTBLPatientID.toString() + "进行文件处理失败！";
            LOG.error(message, e);
        }
    }

    @Override
    public void splitPicture(Long pkTBLPatientID) {
        // 需传入的参数
        String a = "你好", b = "123", c = "邹代发", d = "qingdao";
        System.out.println("Java中动态参数已经初始化,准备传参");
        // 设置命令行传入参数
        String[] args1 = new String[] { "python","D:\\PycharmProjects\\sementation_part(内膜)\\daleyzouGraduation.py", a,b, c, d };
        //Java数据a,b,c,d传入Python
        Process pr;
        try {
            pr = Runtime.getRuntime().exec(args1); //最核心的函数

            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream(), "gbk"));
            String line;
            List<String> lines = new ArrayList<String>();

            System.out.println("-----------------------------------------------");

            while ((line = in.readLine()) != null) {
                System.out.println(line);
                lines.add(line); //把Python的print值保存了下来

            }
            System.out.println("-------------------------------------------------");

            in.close();

            pr.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Java调Python结束");

    }

    @Override
    public void saveData(Long pkTBLPatientID) {


    }
    public int getNum(String path){
        try{
            BufferedImage bimg = ImageIO.read(new File(path));
            int [][] data = new int[bimg.getWidth()][bimg.getHeight()];
            //方式一：通过getRGB()方式获得像素矩阵
            //此方式为沿Height方向扫描

            int num = 0;
            for(int i=0;i<bimg.getWidth();i++) {
                for (int j = 0; j < bimg.getHeight(); j++) {
                    data[i][j] = bimg.getRGB(i, j);
                    int pixel = bimg.getRGB(i, j);


                    int rgb = (pixel & 0xff0000) >> 16;
                    LOG.info("i=" + i + ",j=" + j + ":(" + rgb  + ")");

                    if (rgb == 255) {
                        num++;
                    }
                }
            }

            LOG.info("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            LOG.info("图片中的白色像素：");
            LOG.info(String.valueOf(num));
            LOG.info("++++++++++++++++++++++++++++++++++++++++++++++++++++");

            return num;

        }catch (IOException e){
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
        return 0;
    }

    @Override
    public void countEF(Long pkTBLPatientID) {

    }

    @Override
    public void countNum(Long pkTBLPatientID) {
        // 查询该患者的所有心脏dcm文件
        HashMap<Float, List<Instance>> resultMap = new HashMap<>();
        List<Instance> instances = instanceMapper.findAllByPkTBLPatientID(pkTBLPatientID);
        // 遍历实例，找出每个切片位置上的最大值、最小值
        for (Instance instance : instances) {
            String path = pacsResultPath + pkTBLPatientID.toString() + "/" + instance.getSopinstanceuid() + PNG_EXT;
            int num = getNum(path);
            if (num == 0) {
                continue;
            }
            instance.setNum(num);
            if (resultMap.containsKey(instance.getSlicelocation())) {
                resultMap.get(instance.getSlicelocation()).add(instance);
            } else {
                List<Instance> instanceList = new ArrayList<>();
                instanceList.add(instance);
                resultMap.put(instance.getSlicelocation(), instanceList);
            }
            instanceMapper.updateByPrimaryKey(instance);
        }
        // 根据每个切片位置的像素点数量排序
        Iterator<Map.Entry<Float, List<Instance>>> entries = resultMap.entrySet().iterator();

        Float pixelspacing = instances.get(0).getPixelspacing();
        Float height = instances.get(0).getSpacingbetweenslices();

        int maxCount = 0;
        int minCount = 0;

        while (entries.hasNext()) {
            Map.Entry<Float, List<Instance>> entry = entries.next();

            // 小数据量不计入分析
            if (entry.getValue().size() < 15){
                continue;
            }

            // 该切片下的舒张末期
            Instance max = Collections.max(entry.getValue());
            // 该切片下的收缩末期
            Instance min = Collections.min(entry.getValue());

            Count count = new Count();
            count.setPatientId(pkTBLPatientID);
            count.setSliceLocation(entry.getKey());
            count.setEdvInstanceId(max.getPktblinstanceid());
            count.setEsInstanceId(min.getPktblinstanceid());
            count.setEdvSopInstanceUid(max.getSopinstanceuid());
            count.setEsSopInstanceUid(min.getSopinstanceuid());
            count.setMaxNum(max.getNum());
            count.setMinNum(min.getNum());

            // 计算舒张末期容积
            float edv = max.getNum() * pixelspacing * height;
            edv *= (1e-3);
            count.setEdv(edv);
            // 计算收缩末期容积
            float es = min.getNum() * pixelspacing * height;
            es *= (1e-3);
            count.setEs(es);
//            List<String> list = entry.getValue().stream().map(Instance::getSopinstanceuid).collect(Collectors.toList());
            String instanceUidAll = entry.getValue().stream().map(Instance::getSopinstanceuid).collect(Collectors.joining(","));
            // 设置该切片下的所有实例uid
            count.setInstanceUidAll(instanceUidAll);

            maxCount += max.getNum();
            minCount += min.getNum();

            countMapper.insert(count);
        }

        // 计算射血分数
        float ef = (float)(maxCount - minCount)/maxCount * 100;

        Patient patient = patientMapper.selectByPrimaryKey(pkTBLPatientID);
        patient.setModifieddate(new Date());
        patient.setEf(ef);
        patientMapper.updateByPrimaryKey(patient);

        System.out.println("Test");
    }
}
