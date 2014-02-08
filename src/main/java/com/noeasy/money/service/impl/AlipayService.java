package com.noeasy.money.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.noeasy.money.constant.AlipayConstants;
import com.noeasy.money.model.OrderBean;
import com.noeasy.money.model.OrderSearchBean;
import com.noeasy.money.repository.IOrderRepository;
import com.noeasy.money.service.IPaymentService;
import com.noeasy.money.util.payment.AlipayUtils;

public class AlipayService implements IPaymentService {

    IOrderRepository orderRepository;



    @Override
    public Map<String, String> generateOutboundParameters(String pOrderId) {
        OrderSearchBean searchBean = new OrderSearchBean();
        searchBean.setOrderNumber(pOrderId);
        OrderBean bean = orderRepository.queryPickupOrder(searchBean);
        // 1. service, partner, _input_charset, sign_type, sign, notify_url,
        // return_url
        // 2. out_trade_no, subject, payment_type, total_fee, show_url, body
        Map<String, String> nvp = new HashMap<String, String>();
        // service
        nvp.put(AlipayConstants.OUTBOUND_PARAM_NAME_SERVICE, AlipayConstants.VALUE_SERVICE);
        // partner
        String partner = AlipayUtils.getConfigurableProperty(AlipayConstants.OUTBOUND_PARAM_NAME_PARTNER);
        nvp.put(AlipayConstants.OUTBOUND_PARAM_NAME_PARTNER, partner);
        // _input_charset
        String charset = AlipayUtils.getConfigurableProperty(AlipayConstants.OUTBOUND_PARAM_NAME_CHARSET);
        nvp.put(AlipayConstants.OUTBOUND_PARAM_NAME_CHARSET, charset);
        // sign_type
        String signType = AlipayUtils.getConfigurableProperty(AlipayConstants.OUTBOUND_PARAM_NAME_SIGN_TYPE);
        nvp.put(AlipayConstants.OUTBOUND_PARAM_NAME_SIGN_TYPE, signType);
        // return_url
        String returnURL = AlipayUtils.getConfigurableProperty(AlipayConstants.OUTBOUND_PARAM_NAME_RETURN_URL);
        nvp.put(AlipayConstants.OUTBOUND_PARAM_NAME_RETURN_URL, returnURL);
        // notify_url
        String nofityURL = AlipayUtils.getConfigurableProperty(AlipayConstants.OUTBOUND_PARAM_NAME_NOTIFY_URL);
        nvp.put(AlipayConstants.OUTBOUND_PARAM_NAME_NOTIFY_URL, nofityURL);
        // out_trade_no
        nvp.put(AlipayConstants.OUTBOUND_PARAM_NAME_OUT_TRADE_NO, String.valueOf(bean.getId()));
        return nvp;
    }



    @Override
    public boolean handleInboundParameters(Map<String, String> pNvp, int pType) {
        if (ASYNC_NOFIFY == pType) {
            handleAsyncNofity(pNvp);
            return true;
        }
        if (SYNC_NOFITY == pType) {
            handleSyncNofity(pNvp);
            return true;
        }
        return false;
    }



    private void handleSyncNofity(Map<String, String> pNvp) {
        // TODO Auto-generated method stub

    }



    private void handleAsyncNofity(Map<String, String> pNvp) {
        // TODO Auto-generated method stub

    }

}
