package com.noeasy.money.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noeasy.money.model.DormitoryBean;
import com.noeasy.money.model.DormitorySearchBean;
import com.noeasy.money.service.IDormitoryService;
import com.noeasy.money.util.test.ReflectionUtils;

@Controller
@RequestMapping("/dormitory")
public class DormitoryController {

    @Resource(name = "dormitoryService")
    IDormitoryService dormitoryService;



    // TODO: move to backend controller.
    @RequestMapping(value = "/initialDistance.html")
    public String calculateDistance(ModelMap model, HttpServletRequest request, HttpServletResponse response,
            String cityId, String collegeId) {
        if (StringUtils.isNotBlank(cityId)) {
            this.dormitoryService.calculateDistance4City(Integer.parseInt(cityId));
        } else if (StringUtils.isNotBlank(collegeId)) {
            this.dormitoryService.calculateDistance4College(Integer.parseInt(collegeId));
        } else {
            this.dormitoryService.calculateDistance();
        }

        return "dormitory/sucess";
    }



    @RequestMapping("/unit-test/rate")
    public String testRate(HttpServletRequest request, HttpServletResponse response, Model model, String dormitoryId,
            String userId, String point) {
        int iDormitoryId = Integer.parseInt(dormitoryId);
        int iUserId = Integer.parseInt(userId);
        int iPoint = Integer.parseInt(point);
        Double tAvgRateResult = this.dormitoryService.rateDormitory(iDormitoryId, iUserId, iPoint, true);
        model.addAttribute("avgRate", tAvgRateResult);
        model.addAttribute("dormitoryId", dormitoryId);
        model.addAttribute("userId", userId);
        return "forward:/dormitory/unit-test/to-rate";
    }



    @RequestMapping("/unit-test/to-rate")
    public String toRate(HttpServletRequest request, HttpServletResponse response) {
        return "dormitory/rate";
    }



    @RequestMapping("/unit-test/to-dormitory")
    public String toDormitory(HttpServletRequest request, HttpServletResponse response, Model model) {
        DormitoryBean dormitoryBean1 = this.dormitoryService.queryDormitoryById(1);
        model.addAttribute("resultOfQueryById", ReflectionUtils.getFieldsValue(dormitoryBean1));

        DormitorySearchBean searchBean2 = new DormitorySearchBean();
        searchBean2.setCityId(1);
        List<DormitoryBean> dormitoryBeans2 = this.dormitoryService.queryDormitoryByConditions(searchBean2);
        List<Set<String>> Results2 = new ArrayList<Set<String>>();
        for (DormitoryBean bean : dormitoryBeans2) {
            Results2.add(ReflectionUtils.getFieldsValue(bean));
        }
        model.addAttribute("resultOfQueryByCityId", Results2);

        DormitorySearchBean searchBean3 = new DormitorySearchBean();
        searchBean3.setKeyword("House");
        searchBean3.getPageBean().setPageNum(1);
        searchBean3.getPageBean().setPageSize(20);
        searchBean3.setSortBy("name");
        List<DormitoryBean> dormitoryBeans3 = this.dormitoryService.queryDormitoryByConditions(searchBean3);
        List<Set<String>> Results3 = new ArrayList<Set<String>>();
        for (DormitoryBean bean : dormitoryBeans3) {
            Results3.add(ReflectionUtils.getFieldsValue(bean));
        }
        model.addAttribute("resultOfQueryByKeyword", Results3);

        DormitorySearchBean searchBean4 = new DormitorySearchBean();
        searchBean4.setContractTypeId(1);
        searchBean4.setDormitoryTypeId(1);
        List<DormitoryBean> dormitoryBeans4 = this.dormitoryService.queryDormitoryByConditions(searchBean4);
        List<Set<String>> Results4 = new ArrayList<Set<String>>();
        for (DormitoryBean bean : dormitoryBeans4) {
            Results4.add(ReflectionUtils.getFieldsValue(bean));
        }
        model.addAttribute("resultOfQueryByDormitoryTypeAndContract", Results4);

        return "dormitory/dormitory";
    }
}
