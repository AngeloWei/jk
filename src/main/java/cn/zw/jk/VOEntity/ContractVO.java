package cn.zw.jk.VOEntity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ContractVO {

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

}
