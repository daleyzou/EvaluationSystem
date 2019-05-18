/**
 * @projectName project
 * @package cc.daleyzou
 * @className cc.daleyzou.DBService
 * @copyright Copyright 2019 daleyzou, Inc. All rights reserved.
 */
package cc.daleyzou;

import cc.daleyzou.patient.dao.PatientMapper;
import cc.daleyzou.patient.domain.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * DBService
 * @description TODO
 * @author daleyzou
 * @date 2019年05月16日 0:18
 * @version 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DBServiceTest {

    @Autowired
    PatientMapper patientMapper;


    @Test
    public void testGetPatient(){
        Example patientExample = new Example(Patient.class);
        patientExample.createCriteria().andCondition("patientID=", 11);
        List<Patient> patients = patientMapper.selectByExample(patientExample);
    }

}
