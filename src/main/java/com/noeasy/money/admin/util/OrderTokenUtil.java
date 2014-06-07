package com.noeasy.money.admin.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author: Yove
 * @version: 1.0, May 29, 2014
 */

public class OrderTokenUtil {

    private static final int    ORDER_TOKEN_LENGTH = 10;

    private static final String PREFIX_ZERO        = "0";



    public static String getOrderId(final String orderToken) {
        if (StringUtils.isEmpty(orderToken)) {
            return "";
        }
        if (orderToken.length() != ORDER_TOKEN_LENGTH) {
            return "";
        }

        String orderId = orderToken.substring(2);
        orderId = orderId.replaceAll("^0*(?=[1,9])", "");

        return orderId;
    }



    public static String getOrderToken(final String orderId, final String prefix) {
        if (StringUtils.isEmpty(orderId)) {
            return "0";
        }

        StringBuffer orderTokenBuffer = new StringBuffer(prefix);
        for (int i = 0; i < ORDER_TOKEN_LENGTH - orderId.length(); i++) {
            orderTokenBuffer.append(PREFIX_ZERO);
        }
        orderTokenBuffer.append(orderId);
        return orderTokenBuffer.toString();
    }



    public static void main(final String[] args) {
        System.out.println(getOrderId("00001001"));
    }
}
