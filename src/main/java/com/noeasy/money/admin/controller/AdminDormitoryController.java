/*
 * This code is provided solely for the use of the licensee subject to the terms
 * and conditions of the Master Service Agreement. Redistribution and use in
 * source and binary forms, with or without modification, are prohibited.
 * 
 * DISCLAIMER.THIS SOFTWARE IS PROVIDED BY AAXIS GROUP CORPORATION "AS IS."
 * EXCEPT AS SPECIFICALLY SET FORTH IN THE MASTER SERVICES AGREEMENT, ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS, AND WARRANTIES INCLUDING,
 * WITHOUT LIMITATION, ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, NONINFRINGEMENT OR ARISING FROM A COURSE OF DEALING,
 * USAGE, OR TRADE PRACTICE, ARE HEREBY EXCLUDED TO THE EXTENT ALLOWED BY
 * APPLICABLE LAW.
 * 
 * IN NO EVENT WILL AAXIS GROUP CORPORATION, THE COPYRIGHT OWNER OR CONTRIBUTORS
 * BE LIABLE FOR ANY LOST REVENUE, PROFIT, OR DATA, OR FOR SPECIAL, INDIRECT,
 * CONSEQUENTIAL, INCIDENTAL, EXEMPLARY OR PUNITIVE DAMAGESINCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND REGARDLESS OF THE
 * THEORY OF LIABILITY ARISING OUT OF THE USE OF OR INABILITY TO USE THE
 * SOFTWARE EVEN IF AAXIS GROUP CORPORATION HAS BEEN ADVISED OF THE POSSIBILITY
 * OF SUCH DAMAGES.
 * 
 * IN NO EVENT SHALL AAXIS GROUP CORPORATION'S LIABILITY TO THE CUSTOMER OR USER
 * OF THIS SOFTWARE, WHETHER IN CONTRACT, TORT (INCLUDING NEGLIGENCE), OR
 * OTHERWISE, EXCEED THE PRICE PAID BY THE CUSTOMER OR USER FOR THIS SOFTWARE.
 * THE FOREGOING LIMITATIONS SHALL APPLY EVEN IF THE ANY WARRANTY PROVIDED IN
 * THE MASTER SERVICE AGREEMENT FAILS OF ITS ESSENTIAL PURPOSE.
 */
package com.noeasy.money.admin.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noeasy.money.constant.Constants;
import com.noeasy.money.model.DormitoryBean;
import com.noeasy.money.model.DormitorySearchBean;
import com.noeasy.money.model.PageBean;
import com.noeasy.money.service.IDormitoryService;
import com.noeasy.money.service.INavigationService;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Feb 16, 2014
 */
@Controller
@RequestMapping("/admin/dormitory")
public class AdminDormitoryController {

    @Resource(name = "dormitoryService")
    IDormitoryService  dormitoryService;

    @Resource(name = "navigationService")
    INavigationService navigationService;



    @RequestMapping("dormitory-update" + Constants.URL_SUFFIX)
    public String dormitoryUpdate(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final DormitoryBean dormitory) {
        if (dormitory.getId() > 0) {
            boolean result = dormitoryService.updateDormitory(dormitory);
            if (result) {
                // TODO need add logic to flush distance
            }
            model.addAttribute("result", result);
        }
        return "admin/dormitory/dormitory-edit-result";
    }



    @RequestMapping("dormitory-edit" + Constants.URL_SUFFIX)
    public String toDormitoryEdit(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final Integer dormitoryId, final String backURL) {
        if (dormitoryId != null) {
            DormitorySearchBean searchBean = new DormitorySearchBean();
            searchBean.setId(dormitoryId);
            DormitoryBean dormitory = dormitoryService.queryDormitory(searchBean);

            List<Map<String, Object>> cities = navigationService.queryCitiesInSameCountry(dormitory.getCityId());
            List<Map<String, Object>> colleges = navigationService.queryColleges(dormitory.getCityId());
            List<Map<String, Object>> contractTypes = dormitoryService.queryContractTypes();
            List<Map<String, Object>> dormitoryTypes = dormitoryService.queryDormitoryTypes();

            model.addAttribute("dormitory", dormitory);
            model.addAttribute("backURL", backURL);
            model.addAttribute("cities", cities);
            model.addAttribute("colleges", colleges);
            model.addAttribute("contractTypes", contractTypes);
            model.addAttribute("dormitoryTypes", dormitoryTypes);
        }
        return "admin/dormitory/dormitory-edit";
    }



    @RequestMapping("dormitory-management" + Constants.URL_SUFFIX)
    public String toDormitoryList(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final String dormitoryName, final String cityName, final String sortField,
            final String sortType, final String currentPage, final String pageSize) {
        DormitorySearchBean searchBean = new DormitorySearchBean();
        searchBean.setCollegeId(null);

        if (StringUtils.isNotBlank(dormitoryName)) {
            searchBean.setDormitoryName(dormitoryName);
        }
        if (StringUtils.isNoneBlank(cityName)) {
            searchBean.setCityName(cityName);
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

        model.addAttribute("sortField", sortField);
        model.addAttribute("dormitories", dormitories);
        model.addAttribute("page", page);
        model.addAttribute("cityName", searchBean.getCityName());
        model.addAttribute("dormitoryName", searchBean.getDormitoryName());

        return "admin/dormitory/dormitory-management";
    }
}
