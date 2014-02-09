package com.noeasy.money.constant;

public interface AlipayConstants {

    String CONFIG_PRIVATE_KEY          = "privateKey";
    String CONFIG_GATEWAY              = "gateway";

    String PARAM_NAME_SERVICE          = "service";
    String PARAM_NAME_PARTNER          = "partner";
    String PARAM_NAME_CHARSET          = "_input_charset";
    String PARAM_NAME_SIGN_TYPE        = "sign_type";
    String PARAM_NAME_SIGN             = "sign";
    String PARAM_NAME_NOTIFY_URL       = "notify_url";
    String PARAM_NAME_RETURN_URL       = "return_url";
    String PARAM_NAME_OUT_TRADE_NO     = "out_trade_no";
    String PARAM_NAME_SUBJECT          = "subject";
    String PARAM_NAME_PAYMENT_TYPE     = "payment_type";
    String PARAM_NAME_TOTAL_FEE        = "total_fee";
    String PARAM_NAME_BODY             = "body";
    String PARAM_NAME_SHOW_URL         = "show_url";
    String PARAM_NAME_TRADE_NO         = "trade_no";
    String PARAM_NAME_TRADE_STATUS     = "trade_status";
    String PARAM_NAME_TRADE_IS_SUCCESS = "is_success";
    String PARAM_NAME_NOTIFY_ID        = "notify_id";
    String PARAM_NAME_NOTIFY_TIME      = "notify_time";
    String VALUE_SERVICE               = "create_direct_pay_by_user";
    String VALUE_PAYMENT_TYPE          = "1";
    String VALUE_SIGN_TYPE             = "MD5";
    String VALUE_DEFAULT_CURRENCY      = "CNY";

    String VALUE_TRADE_STATUS_FINISH   = "TRADE_FINISHED";
    String VALUE_TRADE_STATUS_SUCCESS  = "TRADE_SUCCESS";
    String VALUE_TRADE_STATUS_CLOSED   = "TRADE_CLOSED";
    String VALUE_TRADE_STATUS_WAIT     = "WAIT_BUYER_PAY";
    String VALUE_TRADE_STATUS_PENDING  = "TRADE_PENDING";
    String VALUE_IS_SUCCESS_TRUE       = "T";
}
