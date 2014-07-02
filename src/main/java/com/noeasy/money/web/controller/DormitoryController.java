package com.noeasy.money.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
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
import com.noeasy.money.model.RoomInfoBean;
import com.noeasy.money.model.RoomPrice;
import com.noeasy.money.service.IDormitoryService;
import com.noeasy.money.service.INavigationService;
import com.noeasy.money.service.IOrderService;
import com.noeasy.money.util.ServletUtils;

@Controller
@RequestMapping("/dormitory")
public class DormitoryController {

    @Resource(name = "dormitoryService")
    IDormitoryService  dormitoryService;

    @Resource(name = "navigationService")
    INavigationService navigationService;

    @Resource(name = "orderService")
    IOrderService      orderService;



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
            dormitoryService.rateDormitory(id, dormitoryId, userId, point == null ? 0 : point, comment, alias, null);
        }
        return "redirect:/dormitory/dormitory-detail.html?id=" + dormitoryId;
    }



    @RequestMapping("/dormitory-detail" + Constants.URL_SUFFIX)
    public String toDormitoryDetail(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final String id, final String collegeId) {
        if (StringUtils.isNotBlank(id)) {
            DormitorySearchBean searchBean = new DormitorySearchBean();
            searchBean.setId(NumberUtils.toInt(id));
            searchBean.setExcludeStatus(DormitoryStatus.INVISIBILITY);
            searchBean.setExcludeRoomStatus(DormitoryStatus.INVISIBILITY);
            searchBean.setExcludeRoomPriceStatus(0);
            DormitoryBean dormitory = dormitoryService.queryDormitory(searchBean);

            if (dormitory.getId() > 0) {
                int dormitoryId = dormitory.getId();

                Integer userId = ServletUtils.getUserId(request);
                Object userNameObj = request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_LOGIN);
                String userName = "Guest";
                if (userNameObj != null) {
                    userName = String.valueOf(userNameObj);
                }
                List<DormitoryRateBean> rates = dormitoryService.queryDormitoryRates(dormitoryId, true);
                List<Map<String, String>> browsingHistory = null;
                model.addAttribute("curRate", new DormitoryRateBean());

                if (null == userId) {
                    browsingHistory = dormitoryService.queryDormitoryBrowseHistory(0, dormitoryId);
                    dormitoryService.saveDormitoryBrowseHistory(0, dormitory.getId());
                } else {
                    browsingHistory = dormitoryService.queryDormitoryBrowseHistory(userId, dormitoryId);
                    dormitoryService.saveDormitoryBrowseHistory(userId, dormitory.getId());

                    for (DormitoryRateBean rate : rates) {
                        if (rate.getUserId() == userId) {
                            model.addAttribute("curRate", rate);
                            break;
                        }
                    }
                }

                searchBean.setId(null);
                searchBean.setCityId(dormitory.getCityId());
                List<DormitoryBean> relatedDormitories = dormitoryService.queryDormitoryPage(searchBean);
                List<Map<String, Object>> colleges = navigationService.queryColleges(dormitory.getCityId());
                if (StringUtils.isNotBlank(collegeId)) {
                    Map<String, Object> college = navigationService
                            .queryCollegeById(NumberUtils.toInt(collegeId), null);
                    model.addAttribute("college", college);
                    if (null != college && null != college.get("cityId")) {
                        Map<String, Object> city = navigationService.queryCityById((Integer) college.get("cityId"),
                                null);
                        model.addAttribute("city", city);
                        if (null != city && null != city.get("countryId")) {
                            Map<String, Object> country = navigationService.queryCountryById((Integer) city
                                    .get("countryId"));
                            model.addAttribute("country", country);
                        }
                    }
                }
                // boolean hasOrder = false;
                // if (null != userId) {
                // UserBean user = new UserBean();
                // user.setId(userId);
                // hasOrder = orderService.hasOrder(user, OrderType.DORMITORY);
                //
                // }
                // model.addAttribute("hasOrder", hasOrder);
                List<Map<String, Object>> contractTypes = dormitoryService.queryContractTypes();
                Map<Integer, String> contracts = new HashMap<Integer, String>();
                Map<Integer, String> containsContract = new HashMap<Integer, String>();
                for (Map<String, Object> contractType : contractTypes) {
                    contracts.put((Integer) contractType.get("id"), (String) contractType.get("name"));
                }
                List<RoomInfoBean> rooms = dormitory.getRooms();
                if (!CollectionUtils.isEmpty(rooms)) {
                    for (RoomInfoBean room : rooms) {
                        List<RoomPrice> prices = room.getContractPrice();
                        if (CollectionUtils.isEmpty(prices)) {
                            continue;
                        }
                        for (RoomPrice price : prices) {
                            if (contracts.containsKey(Integer.valueOf(price.getContractId()))) {
                                containsContract.put(Integer.valueOf(price.getContractId()), price.getContract());
                            }
                        }
                    }
                }
                model.addAttribute("colleges", colleges);
                model.addAttribute("relatedDormitories", relatedDormitories);
                model.addAttribute("dormitory", dormitory);
                model.addAttribute("history", browsingHistory);
                model.addAttribute("rates", rates);
                model.addAttribute("cityId", dormitory.getCityId());
                model.addAttribute("userId", userId);
                model.addAttribute("userName", userName);
                model.addAttribute("contractTypes", containsContract);
            }
        }
        return "dormitory/dormitorydetail";
    }



    @RequestMapping("/dormitory-list" + Constants.URL_SUFFIX)
    public String toDormitoryList(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final String collegeId, final String cityId, final String keyword, String sortField,
            final String sortType, final String currentPage, final String pageSize) {

        if (StringUtils.isNotBlank(cityId)) {

            Map<String, Object> city = navigationService.queryCityById(NumberUtils.toInt(cityId), null);
            Map<String, Object> country = null;
            if (null != city) {
                Integer countryId = (Integer) city.get("countryId");
                country = navigationService.queryCountryById(countryId);
            }
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
                searchBean.setSortField(sortField.substring(0, sortField.length() - 1));
                if (sortField.endsWith("+")) {
                    searchBean.setSortType("ASC");
                } else {
                    searchBean.setSortType("DESC");
                }
            } else {
                sortField = "dor_displayOrder";
                searchBean.setSortField(sortField);
                searchBean.setSortType("DESC");
            }
            searchBean.setExcludeStatus(DormitoryStatus.INVISIBILITY);
            searchBean.setExcludeRoomStatus(DormitoryStatus.INVISIBILITY);
            searchBean.setExcludeRoomPriceStatus(0);
            int rowTotal = dormitoryService.queryDormitoryCount(searchBean);

            PageBean page = new PageBean(rowTotal);
            if (StringUtils.isNotBlank(pageSize)) {
                page.setPageSize(Integer.valueOf(pageSize));
            }
            if (StringUtils.isNotBlank(currentPage)) {
                page.setPageNum(Integer.valueOf(currentPage));
            }

            page.setQueryString(request.getQueryString());
            searchBean.setPageBean(page);
            List<DormitoryBean> dormitories = dormitoryService.queryDormitoryPage(searchBean);
            for (DormitoryBean dormitory : dormitories) {
                dormitory.setPicPath(dormitoryService.queryDormitoryImages(dormitory.getId()));
            }

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