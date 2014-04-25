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
import com.noeasy.money.constant.SessionConstants;
import com.noeasy.money.enumeration.DormitoryStatus;
import com.noeasy.money.model.DormitoryBean;
import com.noeasy.money.model.DormitoryRateBean;
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



    @RequestMapping("/rate" + Constants.URL_SUFFIX)
    public String rate(final HttpServletRequest request, final HttpServletResponse response, final Model model,
            final int id, final Integer dormitoryId, final String alias, final String comment, final Integer point) {
        if (dormitoryId > 0 && StringUtils.isNoneBlank(comment)) {
            Object userIdObj = request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
            int userId = 0;
            if (userIdObj != null) {
                userId = NumberUtils.toInt(String.valueOf(userIdObj));
            }
            dormitoryService.rateDormitory(id, dormitoryId, userId, point == null ? 0 : point, comment, alias);
        }
        return "redirect:/dormitory/dormitory-detail.html?id=" + dormitoryId;
    }



    @RequestMapping("/dormitory-detail" + Constants.URL_SUFFIX)
    public String toDormitoryDetail(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final String id) {
        if (StringUtils.isNotBlank(id)) {
            DormitorySearchBean searchBean = new DormitorySearchBean();
            searchBean.setId(NumberUtils.toInt(id));
            searchBean.setExcludeStatus(DormitoryStatus.INVISIBILITY);
            searchBean.setExcludeRoomStatus(DormitoryStatus.INVISIBILITY);
            searchBean.setExcludeRoomPriceStatus(0);
            DormitoryBean dormitory = dormitoryService.queryDormitory(searchBean);

            if (dormitory.getId() > 0) {
                int dormitoryId = dormitory.getId();

                Object userIdObj = request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
                int userId = 0;
                if (userIdObj != null) {
                    userId = NumberUtils.toInt(String.valueOf(userIdObj));
                }
                Object userNameObj = request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_LOGIN);
                String userName = "Guest";
                if (userNameObj != null) {
                    userName = String.valueOf(userNameObj);
                }

                List<Map<String, String>> browsingHistory = dormitoryService.queryDormitoryBrowseHistory(userId,
                        dormitoryId);
                dormitoryService.saveDormitoryBrowseHistory(userId, dormitory.getId());

                model.addAttribute("curRate", new DormitoryRateBean());
                List<DormitoryRateBean> rates = dormitoryService.queryDormitoryRates(dormitoryId);
                for (DormitoryRateBean rate : rates) {
                    if (rate.getUserId() == userId) {
                        model.addAttribute("curRate", rate);
                        break;
                    }
                }

                searchBean.setId(null);
                searchBean.setCityId(dormitory.getCityId());
                List<DormitoryBean> relatedDormitories = dormitoryService.queryDormitoryPage(searchBean);
                List<Map<String, Object>> colleges = navigationService.queryColleges(dormitory.getCityId());

                model.addAttribute("colleges", colleges);
                model.addAttribute("relatedDormitories", relatedDormitories);
                model.addAttribute("dormitory", dormitory);
                model.addAttribute("history", browsingHistory);
                model.addAttribute("rates", rates);
                model.addAttribute("cityId", dormitory.getCityId());
                model.addAttribute("userId", userId);
                model.addAttribute("userName", userName);
            }
        }
        return "dormitory/dormitorydetail";
    }



    @RequestMapping("/dormitory-list" + Constants.URL_SUFFIX)
    public String toDormitoryList(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final String collegeId, final String cityId, final String keyword,
            final String sortField, final String sortType, final String currentPage, final String pageSize) {
        if (StringUtils.isNotBlank(cityId)) {

            Map<String, Object> city = navigationService.queryCityById(NumberUtils.toInt(cityId), null);
            Integer countryId = (Integer) city.get("countryId");
            Map<String, Object> country = navigationService.queryCountryById(countryId);
            Map<String, Object> college = navigationService.queryCollegeById(NumberUtils.toInt(collegeId), null);

            DormitorySearchBean searchBean = new DormitorySearchBean();
            searchBean.setCityId(NumberUtils.toInt(cityId));
            if (StringUtils.isNoneBlank(collegeId)) {
                searchBean.setCollegeId(NumberUtils.toInt(collegeId));
            }
            if (StringUtils.isNoneBlank(keyword)) {
                searchBean.setKeyword(keyword);
            }
            if (StringUtils.isNoneBlank(sortField)) {
                searchBean.setSortField(sortField);
                if (StringUtils.isNoneBlank(sortType)) {
                    searchBean.setSortType(sortType);
                }
            } else {
                searchBean.setSortField("distance");
            }
            searchBean.setExcludeStatus(DormitoryStatus.INVISIBILITY);
            searchBean.setExcludeRoomStatus(DormitoryStatus.INVISIBILITY);
            searchBean.setExcludeRoomPriceStatus(0);
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

            Object userIdObj = request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
            int userId = 0;
            if (userIdObj != null) {
                userId = NumberUtils.toInt(String.valueOf(userIdObj));
            }
            if (userId > 0) {
                List<Map<String, String>> browsingHistory = dormitoryService.queryDormitoryBrowseHistory(userId, 0);
                model.addAttribute("history", browsingHistory);
            }

            searchBean.setId(null);
            searchBean.setCityId(NumberUtils.toInt(cityId));
            List<DormitoryBean> relatedDormitories = dormitoryService.queryDormitoryPage(searchBean);
            List<Map<String, Object>> colleges = navigationService.queryColleges(NumberUtils.toInt(cityId));

            model.addAttribute("colleges", colleges);
            model.addAttribute("relatedDormitories", relatedDormitories);

            model.addAttribute("keyword", keyword);
            model.addAttribute("sortField", sortField);
            model.addAttribute("country", country);
            model.addAttribute("city", city);
            model.addAttribute("college", college);
            model.addAttribute("dormitories", dormitories);
            model.addAttribute("collegeId", collegeId);
            model.addAttribute("cityId", cityId);
            model.addAttribute("page", page);
        }
        return "dormitory/dormitorylist";
    }



    @RequestMapping("/dormitory-quik-book" + Constants.URL_SUFFIX)
    public String toDormitoryQuickBook(final HttpServletRequest request, final HttpServletResponse response,
            final Model model) {
        return "dormitory/include/dormitorydetail-book";
    }
}