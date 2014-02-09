package com.noeasy.money.repository;

import com.noeasy.money.model.PaymentBean;
import com.noeasy.money.model.PaymentInfoBean;

public interface IPaymentRepository {

    void savePayment(PaymentBean pPayment);

    void savePaymentInfo(PaymentInfoBean pPaymentInfo);

}
