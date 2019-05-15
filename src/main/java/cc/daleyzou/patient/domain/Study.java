package cc.daleyzou.patient.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tbl_study")
public class Study {
    /**
     * 主键
     */
    @Id
    @Column(name = "pkTBLStudyID")
    private Long pktblstudyid;

    /**
     * 编号
     */
    @Column(name = "accessionNumber")
    private String accessionnumber;

    /**
     * 患者历史
     */
    @Column(name = "additionalPatientHistory")
    private String additionalpatienthistory;

    /**
     * 可以认可的诊断描述
     */
    @Column(name = "admittingDiagnosesDescription")
    private String admittingdiagnosesdescription;

    /**
     * 创建时间
     */
    @Column(name = "createdDate")
    private Date createddate;

    /**
     * 修改时间
     */
    @Column(name = "modifiedDate")
    private Date modifieddate;

    /**
     * 相关医师姓名
     */
    @Column(name = "referringPhysicianName")
    private String referringphysicianname;

    /**
     * 研究时间
     */
    @Column(name = "studyDateTime")
    private Date studydatetime;

    /**
     * 研究描述
     */
    @Column(name = "studyDescription")
    private String studydescription;

    /**
     * 研究id
     */
    @Column(name = "studyID")
    private String studyid;

    /**
     * 研究实例id
     */
    @Column(name = "studyInstanceUID")
    private String studyinstanceuid;

    /**
     * 优先研究id
     */
    @Column(name = "studyPriorityID")
    private String studypriorityid;

    /**
     * 状态id
     */
    @Column(name = "studyStatusID")
    private String studystatusid;

    /**
     * 患者id
     */
    @Column(name = "pkTBLPatientID")
    private Long pktblpatientid;

    /**
     * 获取主键
     *
     * @return pkTBLStudyID - 主键
     */
    public Long getPktblstudyid() {
        return pktblstudyid;
    }

    /**
     * 设置主键
     *
     * @param pktblstudyid 主键
     */
    public void setPktblstudyid(Long pktblstudyid) {
        this.pktblstudyid = pktblstudyid;
    }

    /**
     * 获取编号
     *
     * @return accessionNumber - 编号
     */
    public String getAccessionnumber() {
        return accessionnumber;
    }

    /**
     * 设置编号
     *
     * @param accessionnumber 编号
     */
    public void setAccessionnumber(String accessionnumber) {
        this.accessionnumber = accessionnumber == null ? null : accessionnumber.trim();
    }

    /**
     * 获取患者历史
     *
     * @return additionalPatientHistory - 患者历史
     */
    public String getAdditionalpatienthistory() {
        return additionalpatienthistory;
    }

    /**
     * 设置患者历史
     *
     * @param additionalpatienthistory 患者历史
     */
    public void setAdditionalpatienthistory(String additionalpatienthistory) {
        this.additionalpatienthistory = additionalpatienthistory == null ? null : additionalpatienthistory.trim();
    }

    /**
     * 获取可以认可的诊断描述
     *
     * @return admittingDiagnosesDescription - 可以认可的诊断描述
     */
    public String getAdmittingdiagnosesdescription() {
        return admittingdiagnosesdescription;
    }

    /**
     * 设置可以认可的诊断描述
     *
     * @param admittingdiagnosesdescription 可以认可的诊断描述
     */
    public void setAdmittingdiagnosesdescription(String admittingdiagnosesdescription) {
        this.admittingdiagnosesdescription = admittingdiagnosesdescription == null ? null : admittingdiagnosesdescription.trim();
    }

    /**
     * 获取创建时间
     *
     * @return createdDate - 创建时间
     */
    public Date getCreateddate() {
        return createddate;
    }

    /**
     * 设置创建时间
     *
     * @param createddate 创建时间
     */
    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    /**
     * 获取修改时间
     *
     * @return modifiedDate - 修改时间
     */
    public Date getModifieddate() {
        return modifieddate;
    }

    /**
     * 设置修改时间
     *
     * @param modifieddate 修改时间
     */
    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    /**
     * 获取相关医师姓名
     *
     * @return referringPhysicianName - 相关医师姓名
     */
    public String getReferringphysicianname() {
        return referringphysicianname;
    }

    /**
     * 设置相关医师姓名
     *
     * @param referringphysicianname 相关医师姓名
     */
    public void setReferringphysicianname(String referringphysicianname) {
        this.referringphysicianname = referringphysicianname == null ? null : referringphysicianname.trim();
    }

    /**
     * 获取研究时间
     *
     * @return studyDateTime - 研究时间
     */
    public Date getStudydatetime() {
        return studydatetime;
    }

    /**
     * 设置研究时间
     *
     * @param studydatetime 研究时间
     */
    public void setStudydatetime(Date studydatetime) {
        this.studydatetime = studydatetime;
    }

    /**
     * 获取研究描述
     *
     * @return studyDescription - 研究描述
     */
    public String getStudydescription() {
        return studydescription;
    }

    /**
     * 设置研究描述
     *
     * @param studydescription 研究描述
     */
    public void setStudydescription(String studydescription) {
        this.studydescription = studydescription == null ? null : studydescription.trim();
    }

    /**
     * 获取研究id
     *
     * @return studyID - 研究id
     */
    public String getStudyid() {
        return studyid;
    }

    /**
     * 设置研究id
     *
     * @param studyid 研究id
     */
    public void setStudyid(String studyid) {
        this.studyid = studyid == null ? null : studyid.trim();
    }

    /**
     * 获取研究实例id
     *
     * @return studyInstanceUID - 研究实例id
     */
    public String getStudyinstanceuid() {
        return studyinstanceuid;
    }

    /**
     * 设置研究实例id
     *
     * @param studyinstanceuid 研究实例id
     */
    public void setStudyinstanceuid(String studyinstanceuid) {
        this.studyinstanceuid = studyinstanceuid == null ? null : studyinstanceuid.trim();
    }

    /**
     * 获取优先研究id
     *
     * @return studyPriorityID - 优先研究id
     */
    public String getStudypriorityid() {
        return studypriorityid;
    }

    /**
     * 设置优先研究id
     *
     * @param studypriorityid 优先研究id
     */
    public void setStudypriorityid(String studypriorityid) {
        this.studypriorityid = studypriorityid == null ? null : studypriorityid.trim();
    }

    /**
     * 获取状态id
     *
     * @return studyStatusID - 状态id
     */
    public String getStudystatusid() {
        return studystatusid;
    }

    /**
     * 设置状态id
     *
     * @param studystatusid 状态id
     */
    public void setStudystatusid(String studystatusid) {
        this.studystatusid = studystatusid == null ? null : studystatusid.trim();
    }

    /**
     * 获取患者id
     *
     * @return pkTBLPatientID - 患者id
     */
    public Long getPktblpatientid() {
        return pktblpatientid;
    }

    /**
     * 设置患者id
     *
     * @param pktblpatientid 患者id
     */
    public void setPktblpatientid(Long pktblpatientid) {
        this.pktblpatientid = pktblpatientid;
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