package com.noeasy.money.repository.impl;

import org.springframework.stereotype.Repository;

import com.noeasy.money.enumeration.PaymentStatus;
import com.noeasy.money.model.PaymentBean;
import com.noeasy.money.model.PaymentInfoBean;
import com.noeasy.money.repository.IPaymentRepository;


@Repository("paymentRepository")
public class PaymentRepository extends BaseRepository implements IPaymentRepository {

    @Override
    public void savePayment(PaymentBean pPayment) {
        int id = getSqlSession().insert("com.noeasy.money.model.Payment.savePayment", pPayment);
        pPayment.setId(id);
    }



    @Override
    public void savePaymentInfo(PaymentInfoBean pPaymentInfo) {
        int id = getSqlSession().insert("com.noeasy.money.model.Payment.savePaymentInfo", pPaymentInfo);
        pPaymentInfo.setId(id);
    }



    @Override
    public boolean isExistNotify(Integer pPaymentId, String pNotifyId) {
        return getExistNofityCount(pPaymentId, pNotifyId) > 0;
    }

    private Integer getExistNofityCount(Integer pPaymentId, String pNotifyId) {
        PaymentInfoBean paymentInfo = new PaymentInfoBean();
        paymentInfo.setPaymentId(pPaymentId);
        paymentInfo.setNotifyId(pNotifyId);
        Integer count = getSqlSession().selectOne("com.noeasy.money.model.Payment.isExistNotify", paymentInfo);
        return count;
    }



    @Override
    public int updatePaymentStatus(Integer pPaymentId, PaymentStatus pStatus) {
        PaymentBean payment = new PaymentBean();
        payment.setId(pPaymentId);
        payment.setStatus(pStatus);
        return getSqlSession().update("com.noeasy.money.model.Payment.updatePaymentStatus", payment);
    }

}
