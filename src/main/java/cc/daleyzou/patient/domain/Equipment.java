package cc.daleyzou.patient.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


import java.util.Date;
import javax.persistence.*;


@Table(name = "tbl_equipment")
public class Equipment {
    /**
     * 主键
     */
    @Id
    @Column(name = "pkTBLEquipmentID")
    private Long pktblequipmentid;

    /**
     * 转变类型
     */
    @Column(name = "conversionType")
    private String conversiontype;

    /**
     * 创建时间
     */
    @CreatedDate
    @Column(name = "createdDate")
    private Date createddate;

    /**
     * 设备串行数
     */
    @Column(name = "deviceSerialNumber")
    private String deviceserialnumber;

    /**
     * 机构地址
     */
    @Column(name = "institutionAddress")
    private String institutionaddress;

    /**
     * 机构名称
     */
    @Column(name = "institutionName")
    private String institutionname;

    /**
     * 机构部门名称
     */
    @Column(name = "institutionalDepartmentName")
    private String institutionaldepartmentname;

    /**
     * 生产厂家
     */
    private String manufacturer;

    /**
     * 生产型号名称
     */
    @Column(name = "manufacturerModelName")
    private String manufacturermodelname;

    /**
     * 形态
     */
    private String modality;

    /**
     * 修改时间
     */
    @LastModifiedDate
    @Column(name = "modifiedDate")
    private Date modifieddate;

    /**
     * 软件版本
     */
    @Column(name = "softwareVersion")
    private String softwareversion;

    /**
     * 站名
     */
    @Column(name = "stationName")
    private String stationname;

    /**
     * 序列id
     */
    @Column(name = "pkTBLSeriesID")
    private Long pktblseriesid;

    /**
     * 获取主键
     *
     * @return pkTBLEquipmentID - 主键
     */
    public Long getPktblequipmentid() {
        return pktblequipmentid;
    }

    /**
     * 设置主键
     *
     * @param pktblequipmentid 主键
     */
    public void setPktblequipmentid(Long pktblequipmentid) {
        this.pktblequipmentid = pktblequipmentid;
    }

    /**
     * 获取转变类型
     *
     * @return conversionType - 转变类型
     */
    public String getConversiontype() {
        return conversiontype;
    }

    /**
     * 设置转变类型
     *
     * @param conversiontype 转变类型
     */
    public void setConversiontype(String conversiontype) {
        this.conversiontype = conversiontype == null ? null : conversiontype.trim();
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
     * 获取设备串行数
     *
     * @return deviceSerialNumber - 设备串行数
     */
    public String getDeviceserialnumber() {
        return deviceserialnumber;
    }

    /**
     * 设置设备串行数
     *
     * @param deviceserialnumber 设备串行数
     */
    public void setDeviceserialnumber(String deviceserialnumber) {
        this.deviceserialnumber = deviceserialnumber == null ? null : deviceserialnumber.trim();
    }

    /**
     * 获取机构地址
     *
     * @return institutionAddress - 机构地址
     */
    public String getInstitutionaddress() {
        return institutionaddress;
    }

    /**
     * 设置机构地址
     *
     * @param institutionaddress 机构地址
     */
    public void setInstitutionaddress(String institutionaddress) {
        this.institutionaddress = institutionaddress == null ? null : institutionaddress.trim();
    }

    /**
     * 获取机构名称
     *
     * @return institutionName - 机构名称
     */
    public String getInstitutionname() {
        return institutionname;
    }

    /**
     * 设置机构名称
     *
     * @param institutionname 机构名称
     */
    public void setInstitutionname(String institutionname) {
        this.institutionname = institutionname == null ? null : institutionname.trim();
    }

    /**
     * 获取机构部门名称
     *
     * @return institutionalDepartmentName - 机构部门名称
     */
    public String getInstitutionaldepartmentname() {
        return institutionaldepartmentname;
    }

    /**
     * 设置机构部门名称
     *
     * @param institutionaldepartmentname 机构部门名称
     */
    public void setInstitutionaldepartmentname(String institutionaldepartmentname) {
        this.institutionaldepartmentname = institutionaldepartmentname == null ? null : institutionaldepartmentname.trim();
    }

    /**
     * 获取生产厂家
     *
     * @return manufacturer - 生产厂家
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * 设置生产厂家
     *
     * @param manufacturer 生产厂家
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    /**
     * 获取生产型号名称
     *
     * @return manufacturerModelName - 生产型号名称
     */
    public String getManufacturermodelname() {
        return manufacturermodelname;
    }

    /**
     * 设置生产型号名称
     *
     * @param manufacturermodelname 生产型号名称
     */
    public void setManufacturermodelname(String manufacturermodelname) {
        this.manufacturermodelname = manufacturermodelname == null ? null : manufacturermodelname.trim();
    }

    /**
     * 获取形态
     *
     * @return modality - 形态
     */
    public String getModality() {
        return modality;
    }

    /**
     * 设置形态
     *
     * @param modality 形态
     */
    public void setModality(String modality) {
        this.modality = modality == null ? null : modality.trim();
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
     * 获取软件版本
     *
     * @return softwareVersion - 软件版本
     */
    public String getSoftwareversion() {
        return softwareversion;
    }

    /**
     * 设置软件版本
     *
     * @param softwareversion 软件版本
     */
    public void setSoftwareversion(String softwareversion) {
        this.softwareversion = softwareversion == null ? null : softwareversion.trim();
    }

    /**
     * 获取站名
     *
     * @return stationName - 站名
     */
    public String getStationname() {
        return stationname;
    }

    /**
     * 设置站名
     *
     * @param stationname 站名
     */
    public void setStationname(String stationname) {
        this.stationname = stationname == null ? null : stationname.trim();
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

    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        modifieddate = new Date();
        if (createddate == null) {
            createddate = new Date();
        }
    }

}