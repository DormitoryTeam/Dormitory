/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package com.noeasy.money.web.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * 
 * @author acer
 */
@Controller
public class HomepageController {

    Log                   logger = LogFactory.getLog(HomepageController.class);

    SessionLocaleResolver localeResolver;



    @Resource(name = "localeResolver")
    public void setLocaleResolver(SessionLocaleResolver localeResolver) {
        this.localeResolver = localeResolver;
    }

}
