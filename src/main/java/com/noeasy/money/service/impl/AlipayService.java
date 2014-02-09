package com.noeasy.money.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.noeasy.money.constant.AlipayConstants;
import com.noeasy.money.enumeration.PaymentInfoType;
import com.noeasy.money.enumeration.PaymentStatus;
import com.noeasy.money.model.OrderBean;
import com.noeasy.money.model.OrderSearchBean;
import com.noeasy.money.model.PaymentBean;
import com.noeasy.money.model.PaymentInfoBean;
import com.noeasy.money.repository.IOrderRepository;
import com.noeasy.money.repository.IPaymentRepository;
import com.noeasy.money.service.IAlipayService;
import com.noeasy.money.util.payment.AlipayUtils;

public class AlipayService implements IAlipayService {

    public static final String UNDERLINE = "_";

    IOrderRepository           orderRepository;
    IPaymentRepository         paymentRepository;



    @Override
    public String gengerateRedirectURL(Integer pOrderId) {
        // 1. get order by orderId;
        OrderSearchBean searchBean = new OrderSearchBean();
        searchBean.setOrderNumber(pOrderId);
        OrderBean bean = orderRepository.queryPickupOrder(searchBean);
        // 2. create payment
        PaymentBean payment = createPayment(pOrderId, bean.getAmount());
        // 3. generate outboundParameters
        Map<String, String> nvp = generateOutboundParameters(bean, payment);
        // 4. set sign information
        nvp = AlipayUtils.setSign(nvp);
        // 5. generate query string.
        String queryString = AlipayUtils.generateQueryString(nvp);
        // 6. create payment information
        createPaymentInfor(payment, PaymentInfoType.REQUEST, queryString);
        // 7. compose redirect url.
        String redirectURL = AlipayUtils.getConfigurableProperty(AlipayConstants.CONFIG_GATEWAY);
        redirectURL += queryString;
        return redirectURL;
    }



    private PaymentInfoBean createPaymentInfor(PaymentBean pPayment, PaymentInfoType pType, String pNvp) {
        PaymentInfoBean paymentInfo = new PaymentInfoBean();
        paymentInfo.setPaymentId(pPayment.getId());
        paymentInfo.setType(pType);
        paymentInfo.setNvp(pNvp);
        paymentRepository.savePaymentInfo(paymentInfo);
        return paymentInfo;
    }



    private PaymentBean createPayment(Integer pOrderId, BigDecimal pAmount) {
        PaymentBean payment = new PaymentBean();
        payment.setOrderId(pOrderId);
        payment.setStatus(PaymentStatus.SEND_REQUEST);
        payment.setCurrency(AlipayConstants.VALUE_DEFAULT_CURRENCY);
        payment.setAmount(pAmount);
        paymentRepository.savePayment(payment);
        return payment;
    }



    private Map<String, String> generateOutboundParameters(OrderBean pOrder, PaymentBean payment) {

        // 1. service, partner, _input_charset, sign_type, sign, notify_url,
        // return_url
        // 2. out_trade_no, subject, payment_type, total_fee, show_url, body
        Map<String, String> nvp = new HashMap<String, String>();
        // service(required)
        nvp.put(AlipayConstants.PARAM_NAME_SERVICE, AlipayConstants.VALUE_SERVICE);
        // partner(required)
        String partner = AlipayUtils.getConfigurableProperty(AlipayConstants.PARAM_NAME_PARTNER);
        nvp.put(AlipayConstants.PARAM_NAME_PARTNER, partner);
        // _input_charset(required)
        String charset = AlipayUtils.getConfigurableProperty(AlipayConstants.PARAM_NAME_CHARSET);
        nvp.put(AlipayConstants.PARAM_NAME_CHARSET, charset);
        // return_url
        String returnURL = AlipayUtils.getConfigurableProperty(AlipayConstants.PARAM_NAME_RETURN_URL);
        nvp.put(AlipayConstants.PARAM_NAME_RETURN_URL, returnURL);
        // notify_url
        String nofityURL = AlipayUtils.getConfigurableProperty(AlipayConstants.PARAM_NAME_NOTIFY_URL);
        nvp.put(AlipayConstants.PARAM_NAME_NOTIFY_URL, nofityURL);
        // out_trade_no(required)
        String outTradeNo = String.valueOf(pOrder.getId()) + UNDERLINE + String.valueOf(payment.getId());
        nvp.put(AlipayConstants.PARAM_NAME_OUT_TRADE_NO, outTradeNo);
        // payment_type(required)
        nvp.put(AlipayConstants.PARAM_NAME_PAYMENT_TYPE, AlipayConstants.VALUE_PAYMENT_TYPE);
        // subject(required)
        // TODO:
        nvp.put(AlipayConstants.PARAM_NAME_SUBJECT, "TODO");
        // total_fee
        nvp.put(AlipayConstants.PARAM_NAME_TOTAL_FEE, pOrder.getAmount().toString());
        // TODO: show_url, body
        return nvp;
    }



    @Override
    public boolean handleInboundParameters(Map<String, String> pNvp, int pType) {
        if (!AlipayUtils.verifySign(pNvp)) {
            return false;
        }

        return handleNofity(pNvp, pType);
    }



    private boolean handleNofity(Map<String, String> pNvp, int pType) {
        boolean isSync = SYNC_NOFITY == pType;
        
        return false;
    }



    private PaymentStatus getPaymentStatus(Map<String, String> pNvp, boolean isSync) {
        String tradeStatus = pNvp.get(AlipayConstants.PARAM_NAME_TRADE_STATUS);

        if (AlipayConstants.VALUE_TRADE_STATUS_SUCCESS.equals(tradeStatus)
                || AlipayConstants.VALUE_TRADE_STATUS_FINISH.equals(tradeStatus)) {
            return PaymentStatus.FINISH;
        }
        if (AlipayConstants.VALUE_TRADE_STATUS_PENDING.equals(tradeStatus)
                || AlipayConstants.VALUE_TRADE_STATUS_WAIT.equals(tradeStatus)) {
            return PaymentStatus.PENDING;
        }
        if (AlipayConstants.VALUE_TRADE_STATUS_CLOSED.equals(tradeStatus)) {
            return PaymentStatus.CANCELED;
        }

        if (isSync) {
            String isSucess = pNvp.get(AlipayConstants.PARAM_NAME_TRADE_IS_SUCCESS);
            if (AlipayConstants.VALUE_IS_SUCCESS_TRUE.equals(isSucess)) {
                return PaymentStatus.REQUEST_HANDLED;
            }
        }

        return PaymentStatus.ERRROR;
    }

}
