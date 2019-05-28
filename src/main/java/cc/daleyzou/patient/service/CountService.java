/**
 * @projectName EasyPACS
 * @package org.easy.service
 * @className org.easy.service.CountService
 * @copyright Copyright 2019 Daleyzou, Inc. All rights reserved.
 */
package cc.daleyzou.patient.service;

import cc.daleyzou.patient.domain.Count;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CountService
 * @description 计算射血分数
 * @author daleyzou
 * @date 2019年03月24日 18:49
 * @version 1.0.0
 */
@Service
public interface CountService {

    void moveDcmToDir(Long pkTBLPatientID);

    /**
     * CountService
     * @description 将要进行图像分割的图片移动到指定的目录
     * @param pkTBLPatientID 患者的主键
     * @return
     * @author daleyzou
     * @date 2019/4/10 8:40
     * @version 1.0.0
     */
    void moveJpgToDirTest(Long pkTBLPatientID);
    void moveJpgToDir(Long pkTBLPatientID);

    /**
     * CountService
     * @description 调用Python程序，分割图片，识别出图片中的心脏部位
     * @param
     * @return
     * @author daleyzou
     * @date 2019/4/12 11:40
     * @version 1.0.0
     */
    String splitPicture(Long pkTBLPatientID);

//    // 将计算后得到的左心室面积存入instance的对应字段，patient表有一个字段用于标识是否已经计算射血分数
    void saveData(Long pkTBLPatientID);
//
   // 计算射血分数
    void countEF(Long pkTBLPatientID);

    /**
     * CountService
     * @description 计算图片中白色像素点的个数，计算射血分数
     * @param pkTBLPatientID
     * @return
     * @author daleyzou
     * @date 2019/5/23 9:36
     * @version 1.0.0
     */
    void countNum(Long pkTBLPatientID);

    /**
     * CountService
     * @description 标记图片
     * @param pkTBLPatientID
     * @return
     * @author daleyzou
     * @date 2019/5/24 18:05
     * @version 1.0.0
     */
    void sketchPicture(Long pkTBLPatientID);
    void sketchPictureTest(Long pkTBLPatientID);

    /**
     * CountService
     * @description 提高图片对比度
     * @param pkTBLPatientID
     * @return
     * @author daleyzou
     * @date 2019/5/28 19:51
     * @version 1.0.0
     */
    String constractPicture(Long pkTBLPatientID);

    /**
     * CountService
     * @description 获取患者的每一个切片数据
     * @param pkTBLPatientID
     * @return
     * @author daleyzou
     * @date 2019/5/25 14:33
     * @version 1.0.0
     */
    List<Count> getSketchPicture(Long pkTBLPatientID);

    /**
     * CountService
     * @description 得到患者该切片下的计算数据
     * @param pkTBLPatientID
     * @param sliceLocation
     * @return
     * @author daleyzou
     * @date 2019/5/25 18:15
     * @version 1.0.0
     */
    Count getSliceSketchPicture(Long pkTBLPatientID, String sliceLocation);

    /**
     * CountService
     * @description 得到患者每一个切片的数据，用户在网页上展示
     * @param pkTBLPatientID
     * @return
     * @author daleyzou
     * @date 2019/5/27 13:38
     * @version 1.0.0
     */
    List<Count> getSliceChart(Long pkTBLPatientID);
}
