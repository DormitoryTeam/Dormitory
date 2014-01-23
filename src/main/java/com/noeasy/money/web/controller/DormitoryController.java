package com.noeasy.money.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noeasy.money.service.IDormitoryService;

@Controller
@RequestMapping("/dormitory")
public class DormitoryController {

    @Resource(name = "dormitoryService")
    IDormitoryService dormitoryService;



    @RequestMapping(value = "/initialDistance.html")
    public String indexPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        this.dormitoryService.calculateDistance();
        return "dormitory/sucess";
    }
    
    @RequestMapping("/unit-test/rate")
    public String testRate(HttpServletRequest request, HttpServletResponse response, Model model, String dormitoryId,
            String userId, String point) {
        int iDormitoryId = Integer.parseInt(dormitoryId);
        int iUserId = Integer.parseInt(userId);
        int iPoint = Integer.parseInt(point);
        Double tAvgRateResult = this.dormitoryService.rateDormitory(iDormitoryId, iUserId, iPoint, true);
        System.out.println("==============================>avg" + tAvgRateResult);
        model.addAttribute("avgRate", tAvgRateResult);
        model.addAttribute("dormitoryId", dormitoryId);
        model.addAttribute("userId", userId);
        return "forward:/dormitory/unit-test/to-rate";
    }



    @RequestMapping("/unit-test/to-rate")
    public String toRate(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        return "dormitory/rate";
    }
}
