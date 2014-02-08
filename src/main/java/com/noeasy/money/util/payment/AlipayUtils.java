package com.noeasy.money.util.payment;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.noeasy.money.constant.AlipayConstants;
import com.noeasy.money.exception.BaseException;
import com.noeasy.money.exception.PaymentErrorMetadata;

public class AlipayUtils {
    
    public static final String CONFIG_PATH ="/config/alipay/alipay.properties";
    private static final Logger logger = LogManager.getLogger(AlipayUtils.class);

    public static String getConfigurableProperty(String pKey) {
        Properties prop = new Properties();
        try {
            prop.load(AlipayUtils.class.getResourceAsStream(CONFIG_PATH));
            return (String) prop.get(pKey);
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new BaseException(PaymentErrorMetadata.EMPTY_PROPERTY);
        }
        
    }
    public static void main(String[] args) {
        String partner = getConfigurableProperty(AlipayConstants.OUTBOUND_PARAM_NAME_PARTNER);
        String charset = getConfigurableProperty(AlipayConstants.OUTBOUND_PARAM_NAME_CHARSET);
        System.out.println(partner);
        System.out.println(charset);
    }
}
