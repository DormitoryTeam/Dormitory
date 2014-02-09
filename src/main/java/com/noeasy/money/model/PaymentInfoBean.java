package com.noeasy.money.model;

import java.util.Date;

import com.noeasy.money.enumeration.PaymentInfoType;

public class PaymentInfoBean {

    private Integer         id;
    private Integer         paymentId;
    private PaymentInfoType type;
    private String          nvp;
    private Date            nofifyTime;
    private String          nofifyId;



    public Integer getId() {
        return id;
    }



    public void setId(Integer pId) {
        id = pId;
    }



    public Integer getPaymentId() {
        return paymentId;
    }



    public void setPaymentId(Integer pPaymentId) {
        paymentId = pPaymentId;
    }



    public PaymentInfoType getType() {
        return type;
    }



    public void setType(PaymentInfoType pType) {
        type = pType;
    }



    public String getNvp() {
        return nvp;
    }



    public void setNvp(String pNvp) {
        nvp = pNvp;
    }



    public Date getNofifyTime() {
        return nofifyTime;
    }



    public void setNofifyTime(Date pNofifyTime) {
        nofifyTime = pNofifyTime;
    }



    public String getNofifyId() {
        return nofifyId;
    }



    public void setNofifyId(String pNofifyId) {
        nofifyId = pNofifyId;
    }

}
