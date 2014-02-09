package com.noeasy.money.model;

import java.math.BigDecimal;
import java.util.Date;

import com.noeasy.money.enumeration.PaymentStatus;

public class PaymentBean {

    private Integer       mId;
    private Integer       mOrderId;
    private BigDecimal    mAmount;
    private String        mCurrency;
    private PaymentStatus mStatus;
    private Date          mCreateDate;
    private Date          mUpdateDate;



    public Integer getId() {
        return mId;
    }



    public void setId(Integer pId) {
        mId = pId;
    }



    public Integer getOrderId() {
        return mOrderId;
    }



    public void setOrderId(Integer pOrderId) {
        mOrderId = pOrderId;
    }



    public BigDecimal getAmount() {
        return mAmount;
    }



    public void setAmount(BigDecimal pAmount) {
        mAmount = pAmount;
    }



    public String getCurrency() {
        return mCurrency;
    }



    public void setCurrency(String pCurrency) {
        mCurrency = pCurrency;
    }



    public PaymentStatus getStatus() {
        return mStatus;
    }



    public void setStatus(PaymentStatus pStatus) {
        mStatus = pStatus;
    }



    public Date getCreateDate() {
        return mCreateDate;
    }



    public void setCreateDate(Date pCreateDate) {
        mCreateDate = pCreateDate;
    }



    public Date getUpdateDate() {
        return mUpdateDate;
    }



    public void setUpdateDate(Date pUpdateDate) {
        mUpdateDate = pUpdateDate;
    }

}
