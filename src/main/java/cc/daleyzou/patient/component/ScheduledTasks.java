/**
 * @projectName project
 * @package cc.daleyzou.patient.component
 * @className cc.daleyzou.patient.component.ScheduledTasks
 * @copyright Copyright 2019 daleyzou, Inc. All rights reserved.
 */
package cc.daleyzou.patient.component;

import cc.daleyzou.patient.controller.PatientController;
import cc.daleyzou.patient.dao.PatientMapper;
import cc.daleyzou.patient.domain.Patient;
import cc.daleyzou.patient.service.CountService;
import org.jsoup.helper.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * ScheduledTasks
 * @description TODO
 * @author daleyzou
 * @date 2019年05月29日 0:03
 * @version 1.0.0
 */
@Component
public class ScheduledTasks {
    private static final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);


    @Autowired
    CountService countService;

    @Autowired
    PatientMapper patientMapper;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // 每天的凌晨执行定时任务
//    @Scheduled(cron="0 0 0 1/1 * ? ")
    public void countEF() {
        try {
            LOG.info("开始执行自动计算射血分数的任务：" + dateFormat.format(new Date()));
            List<Patient> patients = patientMapper.selectAll();
            if (CollectionUtils.isEmpty(patients)){
                return;
            }
            for (Patient patient : patients){
                // 没有需要计算的患者数据
                if (patient.getEf() != null){
                    continue;
                }
                Long pkTBLPatientID = patient.getPktblpatientid();
                LOG.info("开始计算患者数据，患者id" + pkTBLPatientID.toString());
                countService.moveJpgToDirTest(pkTBLPatientID);
                countService.constractPicture(pkTBLPatientID);
                countService.splitPicture(pkTBLPatientID);
                countService.moveJpgToDir(pkTBLPatientID);
                countService.countNum(pkTBLPatientID);
                countService.sketchPicture(pkTBLPatientID);
                LOG.info("患者数据计算结束，患者id" + pkTBLPatientID.toString());
            }
            LOG.info("执行自动计算射血分数的任务结束：" + dateFormat.format(new Date()));
        }catch (Exception e){
            e.printStackTrace();
            LOG.error(e.getMessage());
        }
    }

}
