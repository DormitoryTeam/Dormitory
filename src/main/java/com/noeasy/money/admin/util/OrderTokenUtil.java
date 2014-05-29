package com.noeasy.money.admin.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author: Yove
 * @version: 1.0, May 29, 2014
 */

public class OrderTokenUtil {

    private static final int    ORDER_TOKEN_LENGTH = 9;

    private static final String PREFIX_ZERO        = "0";



    public static String getOrderId(final String orderToken) {
        if (StringUtils.isEmpty(orderToken)) {
            return "";
        }
        if (orderToken.length() != 9) {
            return "";
        }

        String orderId = orderToken;
        orderId = orderId.replaceAll("^0*(?=[1,9])", "");

        return orderId;
    }



    public static String getOrderToken(final String orderId) {
        if (StringUtils.isEmpty(orderId)) {
            return "0";
        }

        StringBuffer orderTokenBuffer = new StringBuffer();
        for (int i = 0; i < ORDER_TOKEN_LENGTH - orderId.length(); i++) {
            orderTokenBuffer.append(PREFIX_ZERO);
        }
        orderTokenBuffer.append(orderId);
        return orderTokenBuffer.toString();
    }



    public static void main(final String[] args) {
        System.out.println(getOrderId("001001"));
    }
}