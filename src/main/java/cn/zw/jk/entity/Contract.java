package cn.zw.jk.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Contract {

    private int productNum ;
    private int extNum;
    private String contractId;
    private String offeror;
    private String contractNo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date signingDate;
    private String checkBy;
    private String inputBy;
    private int printStyle;
    private String inspector;
    private double totalAmount;
    private String crequest;
    private String customName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date shipTime;
    private int importNum;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deliveryPeriod;
    private String remark;
    private int oldState;
    private int state;
    private int outState;
    private String tradeTerms;
    private String createBy;
    private String createDept;
    private Date createTime;

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public int getExtNum() {
        return extNum;
    }

    public void setExtNum(int extNum) {
        this.extNum = extNum;
    }

    public String getInputBy() {
        return inputBy;
    }

    public void setInputBy(String inputBy) {
        this.inputBy = inputBy;
    }

    public int getPrintStyle() {
        return printStyle;
    }

    public void setPrintStyle(int printStyle) {
        this.printStyle = printStyle;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getOfferor() {
        return offeror;
    }

    public void setOfferor(String offeror) {
        this.offeror = offeror;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Date getSigningDate() {
        return signingDate;
    }

    public void setSigningDate(Date signingDate) {
        this.signingDate = signingDate;
    }

    public String getCheckBy() {
        return checkBy;
    }

    public void setCheckBy(String checkBy) {
        this.checkBy = checkBy;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCrequest() {
        return crequest;
    }

    public void setCrequest(String crequest) {
        this.crequest = crequest;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }

    public int getImportNum() {
        return importNum;
    }

    public void setImportNum(int importNum) {
        this.importNum = importNum;
    }

    public Date getDeliveryPeriod() {
        return deliveryPeriod;
    }

    public void setDeliveryPeriod(Date deliveryPeriod) {
        this.deliveryPeriod = deliveryPeriod;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getOldState() {
        return oldState;
    }

    public void setOldState(int oldState) {
        this.oldState = oldState;
    }

    public int getOutState() {
        return outState;
    }

    public void setOutState(int outState) {
        this.outState = outState;
    }

    public String getTradeTerms() {
        return tradeTerms;
    }

    public void setTradeTerms(String tradeTerms) {
        this.tradeTerms = tradeTerms;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
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
}
