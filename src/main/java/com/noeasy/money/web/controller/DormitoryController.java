package com.noeasy.money.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noeasy.money.service.IDormitoryService;

@Controller
@RequestMapping ( "/dormitory" )  
public class DormitoryController {

	@Resource(name = "dormitoryService")
	IDormitoryService dormitoryService;
	
	@RequestMapping(value = "/initalDistance.html")
	public String indexPage(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		this.dormitoryService.calculateDistance();
		return "dormitory/sucess";
	}
}
