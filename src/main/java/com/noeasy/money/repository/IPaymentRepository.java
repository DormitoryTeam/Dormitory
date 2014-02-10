package com.noeasy.money.repository;

import com.noeasy.money.enumeration.PaymentStatus;
import com.noeasy.money.model.PaymentBean;
import com.noeasy.money.model.PaymentInfoBean;

public interface IPaymentRepository {

    void savePayment(PaymentBean pPayment);

    void savePaymentInfo(PaymentInfoBean pPaymentInfo);

    boolean isExistNotify(Integer pPaymentId, String pNotifyId);

    int updatePaymentStatus(Integer pPaymentId, PaymentStatus pStatus);

    int updatePayment(PaymentBean pPayment);

}
