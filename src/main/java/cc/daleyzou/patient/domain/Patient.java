package cc.daleyzou.patient.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tbl_patient")
public class Patient {
    /**
     * 主键
     */
    @Id
    @Column(name = "pkTBLPatientID")
    private Long pktblpatientid;

    /**
     * 创建日期
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdDate")
    private Date createddate;

    /**
     * 修改日期
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modifiedDate")
    private Date modifieddate;

    /**
     * 年龄
     */
    @Column(name = "patientAge")
    private String patientage;

    /**
     * 患者出生日期
     */
    @Column(name = "patientBirthday")
    private Date patientbirthday;

    /**
     * 患者 id
     */
    @Column(name = "patientID")
    private String patientid;

    /**
     * 患者姓名
     */
    @Column(name = "patientName")
    private String patientname;

    /**
     * 患者性别
     */
    @Column(name = "patientSex")
    private String patientsex;

    /**
     * 心脏射血分数
     */
    @Column(name = "ef")
    private Float ef;

    /**
     * 获取主键
     *
     * @return pkTBLPatientID - 主键
     */
    public Long getPktblpatientid() {
        return pktblpatientid;
    }

    /**
     * 设置主键
     *
     * @param pktblpatientid 主键
     */
    public void setPktblpatientid(Long pktblpatientid) {
        this.pktblpatientid = pktblpatientid;
    }

    /**
     * 获取创建日期
     *
     * @return createdDate - 创建日期
     */
    public Date getCreateddate() {
        return createddate;
    }

    /**
     * 设置创建日期
     *
     * @param createddate 创建日期
     */
    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    /**
     * 获取修改日期
     *
     * @return modifiedDate - 修改日期
     */
    public Date getModifieddate() {
        return modifieddate;
    }

    /**
     * 设置修改日期
     *
     * @param modifieddate 修改日期
     */
    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    /**
     * 获取年龄
     *
     * @return patientAge - 年龄
     */
    public String getPatientage() {
        return patientage;
    }

    /**
     * 设置年龄
     *
     * @param patientage 年龄
     */
    public void setPatientage(String patientage) {
        this.patientage = patientage == null ? null : patientage.trim();
    }

    /**
     * 获取患者出生日期
     *
     * @return patientBirthday - 患者出生日期
     */
    public Date getPatientbirthday() {
        return patientbirthday;
    }

    /**
     * 设置患者出生日期
     *
     * @param patientbirthday 患者出生日期
     */
    public void setPatientbirthday(Date patientbirthday) {
        this.patientbirthday = patientbirthday;
    }

    /**
     * 获取患者 id
     *
     * @return patientID - 患者 id
     */
    public String getPatientid() {
        return patientid;
    }

    /**
     * 设置患者 id
     *
     * @param patientid 患者 id
     */
    public void setPatientid(String patientid) {
        this.patientid = patientid == null ? null : patientid.trim();
    }

    /**
     * 获取患者姓名
     *
     * @return patientName - 患者姓名
     */
    public String getPatientname() {
        return patientname;
    }

    /**
     * 设置患者姓名
     *
     * @param patientname 患者姓名
     */
    public void setPatientname(String patientname) {
        this.patientname = patientname == null ? null : patientname.trim();
    }

    /**
     * 获取患者性别
     *
     * @return patientSex - 患者性别
     */
    public String getPatientsex() {
        return patientsex;
    }

    /**
     * 设置患者性别
     *
     * @param patientsex 患者性别
     */
    public void setPatientsex(String patientsex) {
        this.patientsex = patientsex == null ? null : patientsex.trim();
    }

    /**
     * 获取心脏射血分数
     *
     * @return ef - 心脏射血分数
     */
    public Float getEf() {
        return ef;
    }

    /**
     * 设置心脏射血分数
     *
     * @param ef 心脏射血分数
     */
    public void setEf(Float ef) {
        this.ef = ef;
    }

    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        modifieddate = new Date();
        if (createddate == null) {
            createddate = new Date();
        }
    }
}