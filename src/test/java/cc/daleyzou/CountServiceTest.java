/**
 * @projectName EasyPACS
 * @package org.easy
 * @className org.easy.CountServiceTest
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package cc.daleyzou;

import cc.daleyzou.patient.service.CountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * CountServiceTest
 * @description TODO
 * @author daleyzou
 * @date 2019年04月11日 9:28
 * @version 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CountServiceTest {

    @Autowired
    CountService countService;

    /**
     * CountServiceTest
     * @description 测试在指定的目录下生成一个患者的JPG文件
     * @param
     * @return
     * @author daleyzou
     * @date 2019/4/16 22:29
     * @version 1.0.0
     */
    @Test
    public void testConvertAndMove(){
        for (int i = 5; i <= 8; i++){
            countService.moveJpgToDir(new Long(i));
            System.out.println("第" + i + "个生成图片完毕");
        }
//        countService.moveJpgToDir(new Long(6));
        System.out.println("程序计算结束！！！");
    }

    @Test
    public void testSplitPicture(){
        countService.splitPicture(new Long(5));
    }

    public void  getData(String path){
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

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Test
    public void testReadPic(){
        String path = "D:\\Graduation\\EasyPACS\\tmp\\workspace\\result\\IM-0004-0059-o.png";
        getData(path);
    }

}
