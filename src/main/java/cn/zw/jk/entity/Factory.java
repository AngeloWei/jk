package cn.zw.jk.entity;

import java.util.Date;

public class Factory {
    private int factoryId;
    private String fullName;
    private String factoryName;
    private String contacts;
    private String phone;
    private String mobile;
    private String fax;
    private String cnote;
    private String inspector;
    private String orderNo;
    private String createName;
    private String createDept;
    private Date createTime;
    private int state;

    @Override
    public String toString() {
        return "Factory{" +
                "factoryID=" + factoryId +
                ", fullName='" + fullName + '\'' +
                ", factoryName='" + factoryName + '\'' +
                ", contacts='" + contacts + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", fax='" + fax + '\'' +
                ", cnote='" + cnote + '\'' +
                ", inspector='" + inspector + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", createName='" + createName + '\'' +
                ", createDept='" + createDept + '\'' +
                ", createTime=" + createTime +
                ", state=" + state +
                '}';
    }

    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryID) {
        this.factoryId = factoryID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCnote() {
        return cnote;
    }

    public void setCnote(String cnote) {
        this.cnote = cnote;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateDept() {
        return createDept;
    }

    public void setCreateDept(String createDept) {
        this.createDept = createDept;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
