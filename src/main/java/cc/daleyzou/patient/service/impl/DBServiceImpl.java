package cc.daleyzou.patient.service.impl;

import cc.daleyzou.common.util.DicomEntityBuilder;
import cc.daleyzou.patient.component.ActiveDicoms;
import cc.daleyzou.patient.dao.*;
import cc.daleyzou.patient.domain.*;
import cc.daleyzou.patient.server.DicomReader;
import cc.daleyzou.patient.service.DBService;

import cc.daleyzou.system.domain.Dict;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class DBServiceImpl implements DBService {

    private static final Logger LOG = LoggerFactory.getLogger(DBServiceImpl.class);

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

    @Transactional
    @Override
    public Patient buildPatient(DicomReader reader) {

        LOG.info("In process; Patient Name: {}, Patient ID: {}", reader.getPatientName(), reader.getPatientID());
        //check if patient exists
        Example patientExample = new Example(Patient.class);
        Criteria patientExampleCriteria = patientExample.createCriteria();
        patientExampleCriteria.andCondition("patientID=", reader.getPatientID());
        List<Patient> patients = patientMapper.selectByExample(patientExample);
        Patient patient = (patients.isEmpty() ? null : patients.get(0));
        if (patient == null) {
            //let's create new patient
            patient = DicomEntityBuilder
                    .newPatient(reader.getPatientAge(), reader.getPatientBirthDay(), reader.getPatientID(), reader.getPatientName(),
                            reader.getPatientSex());
            patientMapper.insert(patient);
            patient = patientMapper.selectByExample(patientExample).get(0);
        } else {
            LOG.info("Patient already exists; Patient Name: {}, Patient ID: {} ", reader.getPatientName(), reader.getPatientID());
        }

        return patient;
    }

    @Transactional
    @Override
    public Study buildStudy(DicomReader reader, Patient patient) {

        //check if study exists
        Example studyExample = new Example(Study.class);
        Example.Criteria studyExampleCriteria = studyExample.createCriteria();
        studyExampleCriteria.andCondition("studyInstanceUID=", reader.getStudyInstanceUID());
        Study study = studyMapper.selectOneByExample(studyExample);
        if (study == null) {//let's create new study
            study = DicomEntityBuilder
                    .newStudy(reader.getAccessionNumber(), reader.getAdditionalPatientHistory(), reader.getAdmittingDiagnosesDescription(),
                            reader.getReferringPhysicianName(), reader.getSeriesDateTime(), reader.getStudyID(),
                            reader.getStudyDescription(), reader.getStudyInstanceUID(), reader.getStudyPriorityID(),
                            reader.getStudyStatusID());
            study.setPktblpatientid(patient.getPktblpatientid());
            studyMapper.insert(study);
            study = studyMapper.selectOneByExample(studyExample);
        } else {
            LOG.info("Study already exists; Study Instance UID:  {}", study.getStudyinstanceuid());
        }

        return study;
    }

    @Transactional
    @Override
    public Series buildSeries(DicomReader reader, Study study) {

        //check if series exists
        Example seriesExample = new Example(Series.class);
        Example.Criteria seriesExampleCriteria = seriesExample.createCriteria();
        seriesExampleCriteria.andCondition("seriesInstanceUID=", reader.getSeriesInstanceUID());
        seriesExampleCriteria.andCondition("seriesNumber=", reader.getSeriesNumber());

        Series series = seriesMapper.selectOneByExample(seriesExample);
        if (series == null) {//let's create new series
            series = DicomEntityBuilder
                    .newSeries(reader.getBodyPartExamined(), reader.getLaterality(), reader.getOperatorsName(), reader.getPatientPosition(),
                            reader.getProtocolName(), reader.getSeriesDateTime(), reader.getSeriesDescription(),
                            reader.getSeriesInstanceUID(), reader.getSeriesNumber());
            series.setPktblstudyid(study.getPktblstudyid());
            seriesMapper.insert(series);
            series = seriesMapper.selectOneByExample(seriesExample);
        } else {
            LOG.info("Series already exists; Series Instance UID: {}", series.getSeriesinstanceuid());
        }

        return series;
    }

    @Transactional
    @Override
    public Equipment buildEquipment(DicomReader reader, Series series) {

        //check if equipment exists
        Example equipmentExample = new Example(Equipment.class);
        Example.Criteria equipmentExampleCriteria = equipmentExample.createCriteria();
        equipmentExampleCriteria.andCondition("pkTBLSeriesID=", series.getPktblseriesid());
        Equipment equipment = equipmentMapper.selectOneByExample(equipmentExample);
        if (equipment == null) {
            equipment = DicomEntityBuilder
                    .newEquipment(reader.getConversionType(), reader.getDeviceSerialNumber(), reader.getInstitutionAddress(),
                            reader.getInstitutionName(), reader.getInstitutionalDepartmentName(), reader.getManufacturer(),
                            reader.getManufacturerModelName(), reader.getModality(), reader.getSoftwareVersion(), reader.getStationName());
            //set the Series to Equipment because we now have the pkTBLSeriesID
            equipment.setPktblseriesid(series.getPktblseriesid());
            equipmentMapper.insert(equipment);
            equipment = equipmentMapper.selectOneByExample(equipmentExample);
        } else {
            LOG.info("Equipment already exists; Equipment Primary ID {}", equipment.getPktblequipmentid());
        }
        return equipment;
    }

    @Transactional
    @Override
    public Instance buildInstance(DicomReader reader, Series series) {

        //check first if instance exists
        Example instanceExample = new Example(Instance.class);
        Example.Criteria instanceExampleCriteria = instanceExample.createCriteria();
        instanceExampleCriteria.andCondition("sopInstanceUID=", reader.getSOPInstanceUID());
        Instance instance = instanceMapper.selectOneByExample(instanceExample);
        if (instance == null) {//let's create new instance along with dependent objects

            // 计算掉了，还需要计算 spacingBetweenSlices

            instance = DicomEntityBuilder
                    .newInstance(reader.getAcquisitionDateTime(), reader.getContentDateTime(), reader.getExposureTime(),
                            reader.getImageOrientation(), reader.getImagePosition(), reader.getImageType(), reader.getInstanceNumber(),
                            reader.getKvp(), reader.getMediaStorageSopInstanceUID(), reader.getPatientOrientation(),
                            reader.getPixelSpacing(), reader.getSliceLocation(), reader.getSliceThickness(), reader.getSopClassUID(),
                            reader.getSOPInstanceUID(), reader.getTransferSyntaxUID(), reader.getWindowCenter(), reader.getWindowWidth(),
                            reader.getXrayTubeCurrent(), reader.getSpacingBetweenSlices());
            instance.setPktblseriesid(series.getPktblseriesid());
            instanceMapper.insert(instance);
            instance = instanceMapper.selectOneByExample(instanceExample);

        } else {
            LOG.info("Instance already exists; SOP Instance UID {}, Instance Number {}", instance.getInstancenumber(),
                    instance.getInstancenumber());
        }

        return instance;
    }

    // apply dicom logic; patient -> study -> series -> instance
    @Transactional
    @Override
    public void buildEntities(DicomReader reader) {
        try {
            LOG.info(
                    "=================================================================================================================================");
            printStats(reader.getPatientName() + " " + reader.getPatientID() + " " + reader.getPatientAge() + " " + reader.getPatientSex()
                    + " Started");
            Patient patient = buildPatient(reader);
            // 多线程环境下安全保证，ConcurrentHashMap是线程安全的，如果正在保存这个患者的文件，会阻塞
            activeDicoms.add(reader.getMediaStorageSopInstanceUID(), patient.toString());

            if (patient != null) {
                Study study = buildStudy(reader, patient);
                if (study != null) {
                    Series series = buildSeries(reader, study);
                    if (series != null) {
                        Equipment equipment = buildEquipment(reader, series);//one2one relationship with series
                        Instance instance = buildInstance(reader, series);

                        //update entity modification dates according to the instance creation
                        series.setModifieddate(instance.getCreateddate());
                        seriesMapper.insert(series);

                        equipment.setModifieddate(instance.getCreateddate());
                        equipmentMapper.insert(equipment);

                        study.setModifieddate(instance.getCreateddate());
                        studyMapper.insert(study);

                        patient.setModifieddate(instance.getCreateddate());
                        patientMapper.insert(patient);

                        //try{ entityManager.getTransaction().commit(); }	catch(Exception e){}

                        LOG.info("Dicom Instance saved successfully! {}", instance.toString());
                    }
                }
            }

            //LOG.info("Yes {} exists!", reader.getMediaStorageSopInstanceUID());
            activeDicoms.remove(reader.getMediaStorageSopInstanceUID());

            printStats(reader.getPatientName() + " " + reader.getPatientID() + " " + reader.getPatientAge() + " " + reader.getPatientSex()
                    + " Ended");
            LOG.info(
                    "=================================================================================================================================");
            LOG.info("");

        } catch (Exception e) {
            LOG.error(e.getMessage());
        }

    }

    public void printStats(String status) {
        //String str = Thread.currentThread().getName().split("@@")[0];
        //Thread.currentThread().setName(String.valueOf(Thread.currentThread().getId()));
        LOG.info("{} {} {} [Active Threads: {}] ", Thread.currentThread().getId(), Thread.currentThread().getName(), status,
                Thread.activeCount());

    }

}
