package com.noeasy.money.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.noeasy.money.exception.BaseException;
import com.noeasy.money.exception.PaymentErrorMetadata;

public class PropertiesUtils {
    private static final Logger logger = LogManager.getLogger(PropertiesUtils.class);



    public static String getConfigurableProperty(String configPath, String pKey) {
        Properties prop = new Properties();
        InputStream input = null;
        try {

            input = PropertiesUtils.class.getResourceAsStream(configPath);
            prop.load(input);
            return (String) prop.get(pKey);
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new BaseException(PaymentErrorMetadata.EMPTY_PROPERTY);
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
