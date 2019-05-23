package cc.daleyzou.patient.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tbl_instance")
public class Instance implements Comparable <Instance> {
    /**
     * 主键
     */
    @Id
    @Column(name = "pkTBLInstanceID")
    private Long pktblinstanceid;

    /**
     * 获取时间
     */
    @Column(name = "acquisitionDateTime")
    private Date acquisitiondatetime;

    /**
     * 内容时间
     */
    @Column(name = "contentDateTime")
    private Date contentdatetime;

    /**
     * 创建时间
     */
    @Column(name = "createdDate")
    private Date createddate;

    /**
     * 曝光时间
     */
    @Column(name = "exposureTime")
    private Integer exposuretime;

    /**
     * 图像取向
     */
    @Column(name = "imageOrientation")
    private String imageorientation;

    /**
     * 图像位置
     */
    @Column(name = "imagePosition")
    private String imageposition;

    /**
     * 图像类型
     */
    @Column(name = "imageType")
    private String imagetype;

    /**
     * 实例号
     */
    @Column(name = "instanceNumber")
    private Integer instancenumber;

    /**
     * kvp
     */
    private String kvp;

    /**
     * 媒体存储uid
     */
    @Column(name = "mediaStorageSopInstanceUID")
    private String mediastoragesopinstanceuid;

    /**
     * 更新时间
     */
    @Column(name = "modifiedDate")
    private Date modifieddate;

    /**
     * 患者取向
     */
    @Column(name = "patientOrientation")
    private String patientorientation;

    /**
     * 像素间距
     */
    @Column(name = "pixelSpacing")
    private Float pixelspacing;

    /**
     * 切片位置
     */
    @Column(name = "sliceLocation")
    private Float slicelocation;

    /**
     * 切片厚度
     */
    @Column(name = "sliceThickness")
    private Float slicethickness;

    /**
     * sopClassUID
     */
    @Column(name = "sopClassUID")
    private String sopclassuid;

    /**
     * sopInstanceUID
     */
    @Column(name = "sopInstanceUID")
    private String sopinstanceuid;

    /**
     * transferSyntaxUID
     */
    @Column(name = "transferSyntaxUID")
    private String transfersyntaxuid;

    /**
     * 窗口中心
     */
    @Column(name = "windowCenter")
    private String windowcenter;

    /**
     * 窗口宽度
     */
    @Column(name = "windowWidth")
    private String windowwidth;

    /**
     * 当前 x 射线管
     */
    @Column(name = "xrayTubeCurrent")
    private Integer xraytubecurrent;

    /**
     * 序列id
     */
    @Column(name = "pkTBLSeriesID")
    private Long pktblseriesid;

    /**
     * 切片间的距离
     */
    @Column(name = "spacingBetweenSlices")
    private Float spacingbetweenslices;

    /**
     * 心脏容积

     */
    @Column(name = "heartVolume")
    private Float heartvolume;

    @Column(name = "num")
    private Integer num;
    /**
     * 获取主键
     *
     * @return pkTBLInstanceID - 主键
     */
    public Long getPktblinstanceid() {
        return pktblinstanceid;
    }

    /**
     * 设置主键
     *
     * @param pktblinstanceid 主键
     */
    public void setPktblinstanceid(Long pktblinstanceid) {
        this.pktblinstanceid = pktblinstanceid;
    }

    /**
     * 获取获取时间
     *
     * @return acquisitionDateTime - 获取时间
     */
    public Date getAcquisitiondatetime() {
        return acquisitiondatetime;
    }

    /**
     * 设置获取时间
     *
     * @param acquisitiondatetime 获取时间
     */
    public void setAcquisitiondatetime(Date acquisitiondatetime) {
        this.acquisitiondatetime = acquisitiondatetime;
    }

    /**
     * 获取内容时间
     *
     * @return contentDateTime - 内容时间
     */
    public Date getContentdatetime() {
        return contentdatetime;
    }

    /**
     * 设置内容时间
     *
     * @param contentdatetime 内容时间
     */
    public void setContentdatetime(Date contentdatetime) {
        this.contentdatetime = contentdatetime;
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
     * 获取曝光时间
     *
     * @return exposureTime - 曝光时间
     */
    public Integer getExposuretime() {
        return exposuretime;
    }

    /**
     * 设置曝光时间
     *
     * @param exposuretime 曝光时间
     */
    public void setExposuretime(Integer exposuretime) {
        this.exposuretime = exposuretime;
    }

    /**
     * 获取图像取向
     *
     * @return imageOrientation - 图像取向
     */
    public String getImageorientation() {
        return imageorientation;
    }

    /**
     * 设置图像取向
     *
     * @param imageorientation 图像取向
     */
    public void setImageorientation(String imageorientation) {
        this.imageorientation = imageorientation == null ? null : imageorientation.trim();
    }

    /**
     * 获取图像位置
     *
     * @return imagePosition - 图像位置
     */
    public String getImageposition() {
        return imageposition;
    }

    /**
     * 设置图像位置
     *
     * @param imageposition 图像位置
     */
    public void setImageposition(String imageposition) {
        this.imageposition = imageposition == null ? null : imageposition.trim();
    }

    /**
     * 获取图像类型
     *
     * @return imageType - 图像类型
     */
    public String getImagetype() {
        return imagetype;
    }

    /**
     * 设置图像类型
     *
     * @param imagetype 图像类型
     */
    public void setImagetype(String imagetype) {
        this.imagetype = imagetype == null ? null : imagetype.trim();
    }

    /**
     * 获取实例号
     *
     * @return instanceNumber - 实例号
     */
    public Integer getInstancenumber() {
        return instancenumber;
    }

    /**
     * 设置实例号
     *
     * @param instancenumber 实例号
     */
    public void setInstancenumber(Integer instancenumber) {
        this.instancenumber = instancenumber;
    }

    /**
     * 获取kvp
     *
     * @return kvp - kvp
     */
    public String getKvp() {
        return kvp;
    }

    /**
     * 设置kvp
     *
     * @param kvp kvp
     */
    public void setKvp(String kvp) {
        this.kvp = kvp == null ? null : kvp.trim();
    }

    /**
     * 获取媒体存储uid
     *
     * @return mediaStorageSopInstanceUID - 媒体存储uid
     */
    public String getMediastoragesopinstanceuid() {
        return mediastoragesopinstanceuid;
    }

    /**
     * 设置媒体存储uid
     *
     * @param mediastoragesopinstanceuid 媒体存储uid
     */
    public void setMediastoragesopinstanceuid(String mediastoragesopinstanceuid) {
        this.mediastoragesopinstanceuid = mediastoragesopinstanceuid == null ? null : mediastoragesopinstanceuid.trim();
    }

    /**
     * 获取更新时间
     *
     * @return modifiedDate - 更新时间
     */
    public Date getModifieddate() {
        return modifieddate;
    }

    /**
     * 设置更新时间
     *
     * @param modifieddate 更新时间
     */
    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    /**
     * 获取患者取向
     *
     * @return patientOrientation - 患者取向
     */
    public String getPatientorientation() {
        return patientorientation;
    }

    /**
     * 设置患者取向
     *
     * @param patientorientation 患者取向
     */
    public void setPatientorientation(String patientorientation) {
        this.patientorientation = patientorientation == null ? null : patientorientation.trim();
    }

    /**
     * 获取像素间距
     *
     * @return pixelSpacing - 像素间距
     */
    public Float getPixelspacing() {
        return pixelspacing;
    }

    /**
     * 设置像素间距
     *
     * @param pixelspacing 像素间距
     */
    public void setPixelspacing(Float pixelspacing) {
        this.pixelspacing = pixelspacing;
    }

    /**
     * 获取切片位置
     *
     * @return sliceLocation - 切片位置
     */
    public Float getSlicelocation() {
        return slicelocation;
    }

    /**
     * 设置切片位置
     *
     * @param slicelocation 切片位置
     */
    public void setSlicelocation(Float slicelocation) {
        this.slicelocation = slicelocation;
    }

    /**
     * 获取切片厚度
     *
     * @return sliceThickness - 切片厚度
     */
    public Float getSlicethickness() {
        return slicethickness;
    }

    /**
     * 设置切片厚度
     *
     * @param slicethickness 切片厚度
     */
    public void setSlicethickness(Float slicethickness) {
        this.slicethickness = slicethickness;
    }

    /**
     * 获取sopClassUID
     *
     * @return sopClassUID - sopClassUID
     */
    public String getSopclassuid() {
        return sopclassuid;
    }

    /**
     * 设置sopClassUID
     *
     * @param sopclassuid sopClassUID
     */
    public void setSopclassuid(String sopclassuid) {
        this.sopclassuid = sopclassuid == null ? null : sopclassuid.trim();
    }

    /**
     * 获取sopInstanceUID
     *
     * @return sopInstanceUID - sopInstanceUID
     */
    public String getSopinstanceuid() {
        return sopinstanceuid;
    }

    /**
     * 设置sopInstanceUID
     *
     * @param sopinstanceuid sopInstanceUID
     */
    public void setSopinstanceuid(String sopinstanceuid) {
        this.sopinstanceuid = sopinstanceuid == null ? null : sopinstanceuid.trim();
    }

    /**
     * 获取transferSyntaxUID
     *
     * @return transferSyntaxUID - transferSyntaxUID
     */
    public String getTransfersyntaxuid() {
        return transfersyntaxuid;
    }

    /**
     * 设置transferSyntaxUID
     *
     * @param transfersyntaxuid transferSyntaxUID
     */
    public void setTransfersyntaxuid(String transfersyntaxuid) {
        this.transfersyntaxuid = transfersyntaxuid == null ? null : transfersyntaxuid.trim();
    }

    /**
     * 获取窗口中心
     *
     * @return windowCenter - 窗口中心
     */
    public String getWindowcenter() {
        return windowcenter;
    }

    /**
     * 设置窗口中心
     *
     * @param windowcenter 窗口中心
     */
    public void setWindowcenter(String windowcenter) {
        this.windowcenter = windowcenter == null ? null : windowcenter.trim();
    }

    /**
     * 获取窗口宽度
     *
     * @return windowWidth - 窗口宽度
     */
    public String getWindowwidth() {
        return windowwidth;
    }

    /**
     * 设置窗口宽度
     *
     * @param windowwidth 窗口宽度
     */
    public void setWindowwidth(String windowwidth) {
        this.windowwidth = windowwidth == null ? null : windowwidth.trim();
    }

    /**
     * 获取当前 x 射线管
     *
     * @return xrayTubeCurrent - 当前 x 射线管
     */
    public Integer getXraytubecurrent() {
        return xraytubecurrent;
    }

    /**
     * 设置当前 x 射线管
     *
     * @param xraytubecurrent 当前 x 射线管
     */
    public void setXraytubecurrent(Integer xraytubecurrent) {
        this.xraytubecurrent = xraytubecurrent;
    }

    /**
     * 获取序列id
     *
     * @return pkTBLSeriesID - 序列id
     */
    public Long getPktblseriesid() {
        return pktblseriesid;
    }

    /**
     * 设置序列id
     *
     * @param pktblseriesid 序列id
     */
    public void setPktblseriesid(Long pktblseriesid) {
        this.pktblseriesid = pktblseriesid;
    }

    /**
     * 获取切片间的距离
     *
     * @return spacingBetweenSlices - 切片间的距离
     */
    public Float getSpacingbetweenslices() {
        return spacingbetweenslices;
    }

    /**
     * 设置切片间的距离
     *
     * @param spacingbetweenslices 切片间的距离
     */
    public void setSpacingbetweenslices(Float spacingbetweenslices) {
        this.spacingbetweenslices = spacingbetweenslices;
    }

    /**
     * 获取心脏容积

     *
     * @return heartVolume - 心脏容积

     */
    public Float getHeartvolume() {
        return heartvolume;
    }

    /**
     * 设置心脏容积

     *
     * @param heartvolume 心脏容积

     */
    public void setHeartvolume(Float heartvolume) {
        this.heartvolume = heartvolume;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        modifieddate = new Date();
        if (createddate == null) {
            createddate = new Date();
        }
    }

    @Override
    public int compareTo(Instance o) {
        return this.num.compareTo(o.getNum());
    }
}