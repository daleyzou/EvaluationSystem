package cc.daleyzou.patient.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tbl_series")
public class Series {
    /**
     * 主键
     */
    @Id
    @Column(name = "pkTBLSeriesID")
    private Long pktblseriesid;

    /**
     * 身体部位检查
     */
    @Column(name = "bodyPartExamined")
    private String bodypartexamined;

    /**
     * 创建时间
     */
    @Column(name = "createdDate")
    private Date createddate;

    /**
     * 偏侧
     */
    private String laterality;

    /**
     * 修改时间
     */
    @Column(name = "modifiedDate")
    private Date modifieddate;

    /**
     * 操作人姓名
     */
    @Column(name = "operatorsName")
    private String operatorsname;

    /**
     * 患者位置
     */
    @Column(name = "patientPosition")
    private String patientposition;

    /**
     * 协议
     */
    @Column(name = "protocolName")
    private String protocolname;

    /**
     * 序列日期
     */
    @Column(name = "seriesDateTime")
    private Date seriesdatetime;

    /**
     * 序列描述
     */
    @Column(name = "seriesDescription")
    private String seriesdescription;

    /**
     * 序列实例id
     */
    @Column(name = "seriesInstanceUID")
    private String seriesinstanceuid;

    /**
     * 序列号
     */
    @Column(name = "seriesNumber")
    private Integer seriesnumber;

    /**
     * 研究id
     */
    @Column(name = "pkTBLStudyID")
    private Long pktblstudyid;

    /**
     * 获取主键
     *
     * @return pkTBLSeriesID - 主键
     */
    public Long getPktblseriesid() {
        return pktblseriesid;
    }

    /**
     * 设置主键
     *
     * @param pktblseriesid 主键
     */
    public void setPktblseriesid(Long pktblseriesid) {
        this.pktblseriesid = pktblseriesid;
    }

    /**
     * 获取身体部位检查
     *
     * @return bodyPartExamined - 身体部位检查
     */
    public String getBodypartexamined() {
        return bodypartexamined;
    }

    /**
     * 设置身体部位检查
     *
     * @param bodypartexamined 身体部位检查
     */
    public void setBodypartexamined(String bodypartexamined) {
        this.bodypartexamined = bodypartexamined == null ? null : bodypartexamined.trim();
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
     * 获取偏侧
     *
     * @return laterality - 偏侧
     */
    public String getLaterality() {
        return laterality;
    }

    /**
     * 设置偏侧
     *
     * @param laterality 偏侧
     */
    public void setLaterality(String laterality) {
        this.laterality = laterality == null ? null : laterality.trim();
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
     * 获取操作人姓名
     *
     * @return operatorsName - 操作人姓名
     */
    public String getOperatorsname() {
        return operatorsname;
    }

    /**
     * 设置操作人姓名
     *
     * @param operatorsname 操作人姓名
     */
    public void setOperatorsname(String operatorsname) {
        this.operatorsname = operatorsname == null ? null : operatorsname.trim();
    }

    /**
     * 获取患者位置
     *
     * @return patientPosition - 患者位置
     */
    public String getPatientposition() {
        return patientposition;
    }

    /**
     * 设置患者位置
     *
     * @param patientposition 患者位置
     */
    public void setPatientposition(String patientposition) {
        this.patientposition = patientposition == null ? null : patientposition.trim();
    }

    /**
     * 获取协议
     *
     * @return protocolName - 协议
     */
    public String getProtocolname() {
        return protocolname;
    }

    /**
     * 设置协议
     *
     * @param protocolname 协议
     */
    public void setProtocolname(String protocolname) {
        this.protocolname = protocolname == null ? null : protocolname.trim();
    }

    /**
     * 获取序列日期
     *
     * @return seriesDateTime - 序列日期
     */
    public Date getSeriesdatetime() {
        return seriesdatetime;
    }

    /**
     * 设置序列日期
     *
     * @param seriesdatetime 序列日期
     */
    public void setSeriesdatetime(Date seriesdatetime) {
        this.seriesdatetime = seriesdatetime;
    }

    /**
     * 获取序列描述
     *
     * @return seriesDescription - 序列描述
     */
    public String getSeriesdescription() {
        return seriesdescription;
    }

    /**
     * 设置序列描述
     *
     * @param seriesdescription 序列描述
     */
    public void setSeriesdescription(String seriesdescription) {
        this.seriesdescription = seriesdescription == null ? null : seriesdescription.trim();
    }

    /**
     * 获取序列实例id
     *
     * @return seriesInstanceUID - 序列实例id
     */
    public String getSeriesinstanceuid() {
        return seriesinstanceuid;
    }

    /**
     * 设置序列实例id
     *
     * @param seriesinstanceuid 序列实例id
     */
    public void setSeriesinstanceuid(String seriesinstanceuid) {
        this.seriesinstanceuid = seriesinstanceuid == null ? null : seriesinstanceuid.trim();
    }

    /**
     * 获取序列号
     *
     * @return seriesNumber - 序列号
     */
    public Integer getSeriesnumber() {
        return seriesnumber;
    }

    /**
     * 设置序列号
     *
     * @param seriesnumber 序列号
     */
    public void setSeriesnumber(Integer seriesnumber) {
        this.seriesnumber = seriesnumber;
    }

    /**
     * 获取研究id
     *
     * @return pkTBLStudyID - 研究id
     */
    public Long getPktblstudyid() {
        return pktblstudyid;
    }

    /**
     * 设置研究id
     *
     * @param pktblstudyid 研究id
     */
    public void setPktblstudyid(Long pktblstudyid) {
        this.pktblstudyid = pktblstudyid;
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