package com.noeasy.money.web.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noeasy.money.service.IAlipayService;


@Controller
@RequestMapping("/payment")
public class PaymentController {
    
    @Resource(name = "alipayService")
    IAlipayService alipayService;
    
    @RequestMapping(value = "/jump2alipy.html")
    public String register(ModelMap model, HttpServletRequest request, HttpServletResponse response, String orderId) {
        Integer id = Integer.valueOf(orderId);
        String redirectURL = alipayService.gengerateRedirectURL(id);
        return redirectURL;
    }
    
    @RequestMapping(value = "/syncNotify.html")
    public String syncNotify(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> nvp = extractParam(request);
        alipayService.handleInboundParameters(nvp, IAlipayService.SYNC_NOFITY);
        return null;
    }
    
    @RequestMapping(value = "/asyncNotify.html")
    public String asyncNotify(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> nvp = extractParam(request);
        alipayService.handleInboundParameters(nvp, IAlipayService.ASYNC_NOFIFY);
        return null;
    }
    
    private Map<String, String> extractParam(HttpServletRequest request) {
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
            params.put(name, valueStr);
        }
        return params;
    }
    
}
