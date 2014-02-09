package com.noeasy.money.model;

import java.math.BigDecimal;
import java.util.Date;

import com.noeasy.money.enumeration.PaymentStatus;

public class PaymentBean {

    private Integer       id;
    private Integer       orderId;
    private BigDecimal    mAmount;
    private String        currency;
    private PaymentStatus status;
    private Date          createDate;
    private Date          updateDate;



    public Integer getId() {
        return id;
    }



    public void setId(Integer pId) {
        id = pId;
    }



    public Integer getOrderId() {
        return orderId;
    }



    public void setOrderId(Integer pOrderId) {
        orderId = pOrderId;
    }



    public BigDecimal getAmount() {
        return mAmount;
    }



    public void setAmount(BigDecimal pAmount) {
        mAmount = pAmount;
    }



    public String getCurrency() {
        return currency;
    }



    public void setCurrency(String pCurrency) {
        currency = pCurrency;
    }



    public PaymentStatus getStatus() {
        return status;
    }



    public void setStatus(PaymentStatus pStatus) {
        status = pStatus;
    }



    public Date getCreateDate() {
        return createDate;
    }



    public void setCreateDate(Date pCreateDate) {
        createDate = pCreateDate;
    }



    public Date getUpdateDate() {
        return updateDate;
    }



    public void setUpdateDate(Date pUpdateDate) {
        updateDate = pUpdateDate;
    }

}
