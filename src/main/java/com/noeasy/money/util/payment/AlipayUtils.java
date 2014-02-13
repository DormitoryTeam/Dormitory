package com.noeasy.money.util.payment;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.alipay.sign.MD5;
import com.alipay.util.AlipayCore;
import com.noeasy.money.constant.AlipayConstants;
import com.noeasy.money.exception.BaseException;
import com.noeasy.money.exception.PaymentErrorMetadata;
import com.noeasy.money.util.PropertiesUtils;

public class AlipayUtils {

    public static final String  CONFIG_PATH = "/config/alipay/alipay.properties";
    private static final Logger logger      = LogManager.getLogger(AlipayUtils.class);



    public static String getConfigurableProperty(String pKey) {
        return PropertiesUtils.getConfigurableProperty(CONFIG_PATH, pKey);
    }



    public static Map<String, String> setSign(Map<String, String> pNvp) {
        Map<String, String> result = AlipayCore.paraFilter(pNvp);
        String paramLink = AlipayCore.createLinkString(result);
        String privateKey = getConfigurableProperty(AlipayConstants.CONFIG_PRIVATE_KEY);
        String charset = getConfigurableProperty(AlipayConstants.PARAM_NAME_CHARSET);
        String sign = MD5.sign(paramLink, privateKey, charset);
        ;
        result.put(AlipayConstants.PARAM_NAME_SIGN, sign);
        result.put(AlipayConstants.PARAM_NAME_SIGN_TYPE, AlipayConstants.VALUE_SIGN_TYPE);
        return result;
    }


    public static boolean verifySign(Map<String, String> pNvp) {
        Map<String, String> filteredNvp = AlipayCore.paraFilter(pNvp);
        String paramLink = AlipayCore.createLinkString(filteredNvp);
        String returnSign = pNvp.get(AlipayConstants.PARAM_NAME_SIGN);
        String privateKey = getConfigurableProperty(AlipayConstants.CONFIG_PRIVATE_KEY);
        String charset = getConfigurableProperty(AlipayConstants.PARAM_NAME_CHARSET);
        return MD5.verify(paramLink, returnSign, privateKey, charset);
    }
    

    public static String generateQueryString(Map<String, String> pNvp) {
        return AlipayCore.createLinkString(pNvp);
    }



    public static void main(String[] args) {
        String partner = getConfigurableProperty(AlipayConstants.PARAM_NAME_PARTNER);
        String charset = getConfigurableProperty(AlipayConstants.PARAM_NAME_CHARSET);
        System.out.println(partner);
        System.out.println(charset);
    }
}
