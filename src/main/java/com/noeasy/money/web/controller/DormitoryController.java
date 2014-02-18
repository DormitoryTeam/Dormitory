package com.noeasy.money.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noeasy.money.constant.Constants;
import com.noeasy.money.model.DormitoryBean;
import com.noeasy.money.model.DormitorySearchBean;
import com.noeasy.money.model.PageBean;
import com.noeasy.money.service.IDormitoryService;
import com.noeasy.money.service.INavigationService;

@Controller
@RequestMapping("/dormitory")
public class DormitoryController {

    @Resource(name = "dormitoryService")
    IDormitoryService  dormitoryService;

    @Resource(name = "navigationService")
    INavigationService navigationService;



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



    @RequestMapping("/dormitory-detail" + Constants.URL_SUFFIX)
    public String toDormitoryDetail(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final String id) {
        if (StringUtils.isNotBlank(id)) {
            DormitorySearchBean searchBean = new DormitorySearchBean();
            searchBean.setId(NumberUtils.toInt(id));
            DormitoryBean dormitory = dormitoryService.queryDormitory(searchBean);

            if (dormitory.getId() > 0) {
                model.addAttribute("dormitory", dormitory);
            }
        }
        return "dormitory/dormitory-detail";
    }



    @RequestMapping("/dormitory-list" + Constants.URL_SUFFIX)
    public String toDormitoryList(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final String collegeId, final String cityId, final String keyword,
            final String sortField, final String sortType, final String currentPage, final String pageSize) {
        if (StringUtils.isNotBlank(collegeId) && StringUtils.isNotBlank(cityId)) {

            Map<String, Object> city = navigationService.queryCityById(NumberUtils.toInt(cityId), null);
            Integer countryId = (Integer) city.get("countryId");
            Map<String, Object> country = navigationService.queryCountryById(countryId);
            Map<String, Object> college = navigationService.queryCollegeById(NumberUtils.toInt(collegeId), null);

            DormitorySearchBean searchBean = new DormitorySearchBean();
            searchBean.setCityId(NumberUtils.toInt(cityId));
            searchBean.setCollegeId(NumberUtils.toInt(collegeId));
            if (StringUtils.isNoneBlank(keyword)) {
                searchBean.setKeyword(keyword);
            }
            if (StringUtils.isNoneBlank(sortField)) {
                searchBean.setSortField(sortField);
                if (StringUtils.isNoneBlank(sortType)) {
                    searchBean.setSortType(sortType);
                }
            }
            int rowTotal = dormitoryService.queryDormitoryCount(searchBean);

            PageBean page = new PageBean(rowTotal);
            if (StringUtils.isNotBlank(currentPage)) {
                page.setPageNum(Integer.valueOf(currentPage));
            }
            if (StringUtils.isNotBlank(pageSize)) {
                page.setPageSize(Integer.valueOf(pageSize));
            }
            page.setQueryString(request.getQueryString());
            searchBean.setPageBean(page);
            List<DormitoryBean> dormitories = dormitoryService.queryDormitoryPage(searchBean);

            model.addAttribute("keyword", keyword);
            model.addAttribute("sortField", sortField);
            model.addAttribute("country", country);
            model.addAttribute("city", city);
            model.addAttribute("college", college);
            model.addAttribute("dormitories", dormitories);
            model.addAttribute("page", page);
        }
        return "dormitory/dormitory-list";
    }



    @RequestMapping("/unit-test/to-rate")
    public String toRate(final HttpServletRequest request, final HttpServletResponse response) {
        return "dormitory/rate";
    }
}
