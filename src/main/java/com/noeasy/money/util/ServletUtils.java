package com.noeasy.money.util;

import javax.servlet.http.HttpServletRequest;

public class ServletUtils {
    public static boolean isGet(HttpServletRequest pRequest) {
        return "GET".equalsIgnoreCase(pRequest.getMethod());
    }
    
    public static boolean isPost(HttpServletRequest pRequest) {
        return "POST".equalsIgnoreCase(pRequest.getMethod());
    }
}
