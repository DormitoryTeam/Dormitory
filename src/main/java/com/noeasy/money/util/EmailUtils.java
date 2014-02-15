package com.noeasy.money.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailUtils {

    public static final String CONFIG_PATH          = "/config/email/email.properties";
    public static final String CONFIG_HOST_NAME     = "hostName";
    public static final String CONFIG_USERNAME      = "username";
    public static final String CONFIG_PASSWORD      = "password";
    public static final String CONFIG_CHARSET       = "charset";
    public static final String CONFIG_SERVICE_EMAIL = "servieEmail";
    public static final String CONFIG_SERVICE_ALIAS = "serviceAlias";
    public static final String CONFIG_SUBJECT       = "resetPasswordEmailSubject";



    public static String getConfigurableProperty(String pKey) {
        return PropertiesUtils.getConfigurableProperty(CONFIG_PATH, pKey);
    }



    public static String getServiceEmail() {
        return getConfigurableProperty(CONFIG_SERVICE_EMAIL);
    }



    public static String getServiceAlias() {
        return getConfigurableProperty(CONFIG_SERVICE_ALIAS);
    }

    
    public static String getSubject() {
        return getConfigurableProperty(CONFIG_SUBJECT);
    }


    public static boolean sendEmail(String pFrom, String pFromAlias, String pTo, String pToAlias, String pSubject,
            String pMessage) {
        String hostName = getConfigurableProperty(CONFIG_HOST_NAME);
        String username = getConfigurableProperty(CONFIG_USERNAME);
        String password = getConfigurableProperty(CONFIG_PASSWORD);
        String charset = getConfigurableProperty(CONFIG_CHARSET);

        SimpleEmail email = new SimpleEmail();
        email.setHostName(hostName);
        email.setAuthentication(username, password); // 用户名和密码
        email.setCharset(charset); // 设置字符集
        email.setSSL(true); // gmail邮箱必须设置为true
        try {
            email.setFrom(pFrom, pFromAlias); // 发件人
            email.addTo(pTo, pToAlias); // 收件人1
            // email.addTo("test@qq.com", "哈哈"); // 收件人2
            // email.addCc("test@gmail.com", "test"); // 抄送
            // email.addBcc("test@sina.com", "test"); // 密送
            email.setSubject(pSubject); // 主题
            email.setMsg(pMessage); // 发送内容
            email.send();
        } catch (EmailException e) {
            return false;
        }
        return true;
    }
}