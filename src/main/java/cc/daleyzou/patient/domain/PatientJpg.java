package cc.daleyzou.patient.domain;

import javax.persistence.*;

@Table(name = "tbl_patient_jpg")
public class PatientJpg {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 患者id
     */
    @Column(name = "patient_id")
    private Long patientId;

    /**
     * 切片位置
     */
    @Column(name = "slice_location")
    private Float sliceLocation;

    /**
     * 实例随机id
     */
    @Column(name = "sop_instance_uid")
    private String sopInstanceUid;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取患者id
     *
     * @return patient_id - 患者id
     */
    public Long getPatientId() {
        return patientId;
    }

    /**
     * 设置患者id
     *
     * @param patientId 患者id
     */
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    /**
     * 获取切片位置
     *
     * @return slice_location - 切片位置
     */
    public Float getSliceLocation() {
        return sliceLocation;
    }

    /**
     * 设置切片位置
     *
     * @param sliceLocation 切片位置
     */
    public void setSliceLocation(Float sliceLocation) {
        this.sliceLocation = sliceLocation;
    }

    /**
     * 获取实例随机id
     *
     * @return sop_instance_uid - 实例随机id
     */
    public String getSopInstanceUid() {
        return sopInstanceUid;
    }

    /**
     * 设置实例随机id
     *
     * @param sopInstanceUid 实例随机id
     */
    public void setSopInstanceUid(String sopInstanceUid) {
        this.sopInstanceUid = sopInstanceUid == null ? null : sopInstanceUid.trim();
    }
}