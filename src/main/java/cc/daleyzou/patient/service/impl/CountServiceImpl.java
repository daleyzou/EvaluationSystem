/**
 * @projectName EasyPACS
 * @package org.easy.service.impl
 * @className org.easy.service.impl.CountServiceImpl
 * @copyright Copyright 2019 daleyzou, Inc. All rights reserved.
 */
package cc.daleyzou.patient.service.impl;

import cc.daleyzou.common.util.Constant;
import cc.daleyzou.common.util.FileUtils;
import cc.daleyzou.patient.dao.InstanceMapper;
import cc.daleyzou.patient.domain.Instance;
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
import java.util.ArrayList;
import java.util.List;

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
            }
            for (Instance instance : instances) {
                File dicomFile = new File(pacsDcmStoragePath + "/" + instance.getMediastoragesopinstanceuid() + ".dcm");
                Dcm2Jpg dcm2Jpg = new Dcm2Jpg();
                dcm2Jpg.initImageWriter("PNG", "PNG", null, null, null);
                String newfilename = FilenameUtils.removeExtension(dicomFile.getName()) + PNG_EXT;
                String outputPath =  + pkTBLPatientID + "/";
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

                    int[] rgb = new int[3];

                    rgb[0] = (pixel & 0xff0000) >> 16;
                    rgb[1] = (pixel & 0xff00) >> 8;
                    rgb[2] = (pixel & 0xff);
                    System.out.println("i=" + i + ",j=" + j + ":(" + rgb[0] + "," + rgb[1] + "," + rgb[2] + ")");

                    if (rgb[0] == 255) {
                        num++;
                    }
                }
            }

            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("图片中的白色像素：");
            System.out.println(num);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");

            return num;

        }catch (IOException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void countEF() {

    }
}
