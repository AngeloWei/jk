package cn.zw.jk.VOEntity;

import cn.zw.jk.entity.Contract;
import cn.zw.jk.entity.ContractProduct;
import cn.zw.jk.entity.ExtCProduct;
import cn.zw.jk.entity.Factory;

import java.util.List;

public class ContractProductOV {
    private String contractProductId;
    //private Contract contract;		//将复杂的关联关系变成单表操作
    private ContractProduct contractProduct;			//关联关系的表（外键），都成为普通字段
    private Factory factory;
    private List<ExtCProductOV> extCProducts; //附件list
    private String factoryName;
    private String productNo;
    private String productImage;
    private String productDesc;
    private Integer cnumber;
    private Integer outNumber;
    private String loadingRate;			//装率
    private Integer boxNum;				//箱数
    private String packingUnit;			//包装单位
    private Float price;
    private Float amount;
    private Integer finished;
    private String exts;
    private Integer orderNo;


    public ContractProduct getContractProduct() {
        return contractProduct;
    }

    public void setContractProduct(ContractProduct contractProduct) {
        this.contractProduct = contractProduct;
    }

    public List<ExtCProductOV> getExtCProducts() {
        return extCProducts;
    }

    public void setExtCProducts(List<ExtCProductOV> extCProducts) {
        this.extCProducts = extCProducts;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public String getContractProductId() {
        return contractProductId;
    }

    public void setContractProductId(String contractProductId) {
        this.contractProductId = contractProductId;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getCnumber() {
        return cnumber;
    }

    public void setCnumber(Integer cnumber) {
        this.cnumber = cnumber;
    }

    public Integer getOutNumber() {
        return outNumber;
    }

    public void setOutNumber(Integer outNumber) {
        this.outNumber = outNumber;
    }

    public String getLoadingRate() {
        return loadingRate;
    }

    public void setLoadingRate(String loadingRate) {
        this.loadingRate = loadingRate;
    }

    public Integer getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(Integer boxNum) {
        this.boxNum = boxNum;
    }

    public String getPackingUnit() {
        return packingUnit;
    }

    public void setPackingUnit(String packingUnit) {
        this.packingUnit = packingUnit;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

    public String getExts() {
        return exts;
    }

    public void setExts(String exts) {
        this.exts = exts;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
}
