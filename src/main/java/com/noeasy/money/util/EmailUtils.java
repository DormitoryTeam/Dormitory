package com.noeasy.money.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.noeasy.money.constant.Constants;

public class EmailUtils {

    private static final Logger logger               = LogManager.getLogger(PropertiesUtils.class);

    public static final String  CONFIG_PATH          = "/config/email/email.properties";
    public static final String  CONFIG_HOST_NAME     = "hostName";
    public static final String  CONFIG_USERNAME      = "username";
    public static final String  CONFIG_PASSWORD      = "password";
    public static final String  CONFIG_CHARSET       = "charset";
    public static final String  CONFIG_SERVICE_EMAIL = "servieEmail";
    public static final String  CONFIG_SERVICE_ALIAS = "serviceAlias";
    public static final String  CONFIG_SUBJECT       = "resetPasswordEmailSubject";



    public static final String generateTemplateEmail(final String pTemplateName, final Map<String, String> pParamMap) {
        String emailTemplate = getTemplate(pTemplateName);
        String placeHolder = null;
        for (Entry<String, String> entry : pParamMap.entrySet()) {
            placeHolder = "{" + entry.getKey() + "}";
            emailTemplate = emailTemplate.replace(placeHolder, entry.getValue());
        }
        return emailTemplate;
    }



    public static String getConfigurableProperty(final String pKey) {
        return PropertiesUtils.getConfigurableProperty(CONFIG_PATH, pKey);
    }



    public static final Map<String, String> getParamMap() {
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("now", DateUtils.getCurrentDate());
        String ip = PropertiesUtils.getConfigurableProperty(Constants.CONFIG_PATH, Constants.CONFIG_IP);
        String context = PropertiesUtils.getConfigurableProperty(Constants.CONFIG_PATH, Constants.CONFIG_CONTEXT);
        paramMap.put("ctx", ip + Constants.SLASH + context);
        return paramMap;
    }

    public static String getStringValue(String value) {
        return null == value ? "" : value;
    }
    


    public static String getServiceAlias() {
        return getConfigurableProperty(CONFIG_SERVICE_ALIAS);
    }



    public static String getServiceEmail() {
        return getConfigurableProperty(CONFIG_SERVICE_EMAIL);
    }



    public static String getSubject() {
        return getConfigurableProperty(CONFIG_SUBJECT);
    }



    public static String getTemplate(final String pTemplateName) {
        InputStream input = null;
        try {

            input = PropertiesUtils.class.getResourceAsStream("/config/email/" + pTemplateName);
            StringBuilder sb = new StringBuilder();
            if (input != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
        return "";
    }



    public static boolean sendEmail(final String pFrom, final String pFromAlias, final String pTo,
            final String pToAlias, final String pSubject, final String pMessage) {
        String hostName = getConfigurableProperty(CONFIG_HOST_NAME);
        String username = getConfigurableProperty(CONFIG_USERNAME);
        String password = getConfigurableProperty(CONFIG_PASSWORD);
        String charset = getConfigurableProperty(CONFIG_CHARSET);

        HtmlEmail email = new HtmlEmail();
        email.setHostName(hostName);
        email.setSmtpPort(25);
        email.setAuthentication(pFrom, password); // 用户名和密码
        email.setCharset(charset); // 设置字符集
        email.setSSL(true); // gmail邮箱必须设置为true
        try {
            email.setFrom(pFrom, pFromAlias); // 发件人
            email.addTo(pTo, pToAlias); // 收件人1
            // email.addTo("test@qq.com", "哈哈"); // 收件人2
            // email.addCc("test@gmail.com", "test"); // 抄送
            // email.addBcc("test@sina.com", "test"); // 密送
            email.setSubject(pSubject); // 主题
            email.setHtmlMsg(pMessage); // 发送内容
            email.send();
        } catch (EmailException e) {
            return false;
        }
        return true;
    }
}
