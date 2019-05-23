package cc.daleyzou.patient.domain;

import javax.persistence.*;

@Table(name = "tbl_count")
public class Count {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 舒张末期容积
     */
    private Float edv;

    /**
     * 收缩末期容积
     */
    private Float es;

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
     * 舒张末期实例id
     */
    @Column(name = "edv_instance_id")
    private Long edvInstanceId;

    /**
     * 舒张末期实例随机id
     */
    @Column(name = "edv_sop_instance_uid")
    private String edvSopInstanceUid;

    /**
     * 收缩末期实例id
     */
    @Column(name = "es_instance_id")
    private Long esInstanceId;

    /**
     * 收缩末期实例随机id
     */
    @Column(name = "es_sop_instance_uid")
    private String esSopInstanceUid;

    /**
     * 舒张末期像素点个数
     */
    @Column(name = "max_num")
    private Integer maxNum;

    /**
     * 收缩末期像素点个数
     */
    @Column(name = "min_num")
    private Integer minNum;

    /**
     * 切片下的所有实例uid
     */
    @Column(name = "instance_uid_all")
    private String instanceUidAll;

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
     * 获取舒张末期容积
     *
     * @return edv - 舒张末期容积
     */
    public Float getEdv() {
        return edv;
    }

    /**
     * 设置舒张末期容积
     *
     * @param edv 舒张末期容积
     */
    public void setEdv(Float edv) {
        this.edv = edv;
    }

    /**
     * 获取收缩末期容积
     *
     * @return es - 收缩末期容积
     */
    public Float getEs() {
        return es;
    }

    /**
     * 设置收缩末期容积
     *
     * @param es 收缩末期容积
     */
    public void setEs(Float es) {
        this.es = es;
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
     * 获取舒张末期实例id
     *
     * @return edv_instance_id - 舒张末期实例id
     */
    public Long getEdvInstanceId() {
        return edvInstanceId;
    }

    /**
     * 设置舒张末期实例id
     *
     * @param edvInstanceId 舒张末期实例id
     */
    public void setEdvInstanceId(Long edvInstanceId) {
        this.edvInstanceId = edvInstanceId;
    }

    /**
     * 获取舒张末期实例随机id
     *
     * @return edv_sop_instance_uid - 舒张末期实例随机id
     */
    public String getEdvSopInstanceUid() {
        return edvSopInstanceUid;
    }

    /**
     * 设置舒张末期实例随机id
     *
     * @param edvSopInstanceUid 舒张末期实例随机id
     */
    public void setEdvSopInstanceUid(String edvSopInstanceUid) {
        this.edvSopInstanceUid = edvSopInstanceUid == null ? null : edvSopInstanceUid.trim();
    }

    /**
     * 获取收缩末期实例id
     *
     * @return es_instance_id - 收缩末期实例id
     */
    public Long getEsInstanceId() {
        return esInstanceId;
    }

    /**
     * 设置收缩末期实例id
     *
     * @param esInstanceId 收缩末期实例id
     */
    public void setEsInstanceId(Long esInstanceId) {
        this.esInstanceId = esInstanceId;
    }

    /**
     * 获取收缩末期实例随机id
     *
     * @return es_sop_instance_uid - 收缩末期实例随机id
     */
    public String getEsSopInstanceUid() {
        return esSopInstanceUid;
    }

    /**
     * 设置收缩末期实例随机id
     *
     * @param esSopInstanceUid 收缩末期实例随机id
     */
    public void setEsSopInstanceUid(String esSopInstanceUid) {
        this.esSopInstanceUid = esSopInstanceUid == null ? null : esSopInstanceUid.trim();
    }

    /**
     * 获取舒张末期像素点个数
     *
     * @return max_num - 舒张末期像素点个数
     */
    public Integer getMaxNum() {
        return maxNum;
    }

    /**
     * 设置舒张末期像素点个数
     *
     * @param maxNum 舒张末期像素点个数
     */
    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    /**
     * 获取收缩末期像素点个数
     *
     * @return min_num - 收缩末期像素点个数
     */
    public Integer getMinNum() {
        return minNum;
    }

    /**
     * 设置收缩末期像素点个数
     *
     * @param minNum 收缩末期像素点个数
     */
    public void setMinNum(Integer minNum) {
        this.minNum = minNum;
    }

    /**
     * 获取切片下的所有实例uid
     *
     * @return instance_uid_all - 切片下的所有实例uid
     */
    public String getInstanceUidAll() {
        return instanceUidAll;
    }

    /**
     * 设置切片下的所有实例uid
     *
     * @param instanceUidAll 切片下的所有实例uid
     */
    public void setInstanceUidAll(String instanceUidAll) {
        this.instanceUidAll = instanceUidAll == null ? null : instanceUidAll.trim();
    }
}