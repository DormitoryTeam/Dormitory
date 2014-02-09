package com.noeasy.money.model;

import java.util.Date;

import com.noeasy.money.enumeration.PaymentInfoType;

public class PaymentInfoBean {

    private Integer         mId;
    private Integer         mPaymentId;
    private PaymentInfoType mType;
    private String          mNvp;
    private String          mStatus;
    private Date            mNotifyTime;
    private String          mNotifyId;



    public Integer getId() {
        return mId;
    }



    public void setId(Integer pId) {
        mId = pId;
    }



    public Integer getPaymentId() {
        return mPaymentId;
    }



    public void setPaymentId(Integer pPaymentId) {
        mPaymentId = pPaymentId;
    }



    public PaymentInfoType getType() {
        return mType;
    }



    public void setType(PaymentInfoType pType) {
        mType = pType;
    }



    public String getNvp() {
        return mNvp;
    }



    public void setNvp(String pNvp) {
        mNvp = pNvp;
    }



    public Date getNotifyTime() {
        return mNotifyTime;
    }



    public void setNotifyTime(Date pNotifyTime) {
        mNotifyTime = pNotifyTime;
    }



    public String getNotifyId() {
        return mNotifyId;
    }



    public void setNotifyId(String pNotifyId) {
        mNotifyId = pNotifyId;
    }



    public String getStatus() {
        return mStatus;
    }



    public void setStatus(String pStatus) {
        mStatus = pStatus;
    }

}
