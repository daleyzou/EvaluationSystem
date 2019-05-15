package cc.daleyzou.patient.dao;

import cc.daleyzou.common.config.MyMapper;
import cc.daleyzou.patient.domain.Instance;

import java.util.List;

public interface InstanceMapper extends MyMapper<Instance> {
    List<Instance> findAllByPkTBLPatientID(Long pkTBLPatientID);
}