package com.noeasy.money.web.controller;

import java.util.ArrayList;
import java.util.List;

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
    public String calculateDistance(final ModelMap model, final HttpServletRequest request,
            final HttpServletResponse response, final String cityId, final String collegeId) {
        if (StringUtils.isNotBlank(cityId)) {
            dormitoryService.calculateDistance4City(Integer.parseInt(cityId));
        } else if (StringUtils.isNotBlank(collegeId)) {
            dormitoryService.calculateDistance4College(Integer.parseInt(collegeId));
        } else {
            dormitoryService.calculateDistance();
        }

        return "dormitory/sucess";
    }



    @RequestMapping("/unit-test/rate")
    public String testRate(final HttpServletRequest request, final HttpServletResponse response, final Model model,
            final String dormitoryId, final String userId, final String point) {
        int iDormitoryId = Integer.parseInt(dormitoryId);
        int iUserId = Integer.parseInt(userId);
        int iPoint = Integer.parseInt(point);
        Double tAvgRateResult = dormitoryService.rateDormitory(iDormitoryId, iUserId, iPoint, true);
        model.addAttribute("avgRate", tAvgRateResult);
        model.addAttribute("dormitoryId", dormitoryId);
        model.addAttribute("userId", userId);
        return "forward:/dormitory/unit-test/to-rate";
    }



    @RequestMapping("/unit-test/to-dormitory")
    public String toDormitory(final HttpServletRequest request, final HttpServletResponse response, final Model model) {
        DormitorySearchBean searchBean1 = new DormitorySearchBean();
        searchBean1.setId(3);
        DormitoryBean dormitoryBean1 = dormitoryService.queryDormitory(searchBean1);
        model.addAttribute("resultOfQueryById", ReflectionUtils.getFieldsValue(dormitoryBean1));

        DormitorySearchBean searchBean2 = new DormitorySearchBean();
        searchBean2.setCityId(1);
        List<DormitoryBean> dormitoryBeans2 = dormitoryService.queryDormitoryPage(searchBean2);
        List<List<String>> Results2 = new ArrayList<List<String>>();
        for (DormitoryBean bean : dormitoryBeans2) {
            Results2.add(ReflectionUtils.getFieldsValue(bean));
        }
        model.addAttribute("resultOfQueryByCityId", Results2);

        DormitorySearchBean searchBean3 = new DormitorySearchBean();
        searchBean3.setKeyword("London,");
        searchBean3.getPageBean().setPageNum(1);
        searchBean3.getPageBean().setPageSize(20);
        searchBean3.setSortField("rating");
        searchBean3.setSortType("desc");
        searchBean3.setCollegeId(1);
        List<DormitoryBean> dormitoryBeans3 = dormitoryService.queryDormitoryPage(searchBean3);
        List<List<String>> Results3 = new ArrayList<List<String>>();
        for (DormitoryBean bean : dormitoryBeans3) {
            Results3.add(ReflectionUtils.getFieldsValue(bean));
        }
        model.addAttribute("resultOfQueryByKeyword", Results3);

        DormitorySearchBean searchBean4 = new DormitorySearchBean();
        searchBean4.setContractTypeId(1);
        searchBean4.setDormitoryTypeId(1);
        searchBean4.setCollegeId(1);
        List<DormitoryBean> dormitoryBeans4 = dormitoryService.queryDormitoryPage(searchBean4);
        List<List<String>> Results4 = new ArrayList<List<String>>();
        for (DormitoryBean bean : dormitoryBeans4) {
            Results4.add(ReflectionUtils.getFieldsValue(bean));
        }
        model.addAttribute("resultOfQueryByDormitoryTypeAndContract", Results4);

        return "dormitory/dormitory";
    }



    @RequestMapping("/unit-test/to-rate")
    public String toRate(final HttpServletRequest request, final HttpServletResponse response) {
        return "dormitory/rate";
    }
}
