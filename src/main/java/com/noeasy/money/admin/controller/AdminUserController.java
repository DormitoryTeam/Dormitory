package com.noeasy.money.admin.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noeasy.money.constant.SessionConstants;
import com.noeasy.money.model.PageBean;
import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserSearchBean;
import com.noeasy.money.service.IAuthenticationService;
import com.noeasy.money.service.IUserService;
import com.noeasy.money.util.ServletUtils;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    @Resource(name = "userService")
    IUserService           userService;
    @Resource(name = "authenticationService")
    IAuthenticationService authenService;



    @RequestMapping(value = "/userList.html")
    public String getUserList(final ModelMap model, final HttpServletRequest request,
            final HttpServletResponse response, String searchKey, String token, final String currentPage,
            final String pageSize) {
        // List<Map<String, String>> allGroups = authenService.getAllGroups();
        // model.addAttribute("allGroups", allGroups);
        model.addAttribute("searchKey", searchKey);
        model.addAttribute("token", token);

        UserSearchBean searchBean = new UserSearchBean();
        if (StringUtils.isNotBlank(searchKey)) {
            searchBean.setSearchKey(searchKey);
        }
        if (StringUtils.isNotBlank(token)) {
            searchBean.setToken((token));
        }

        int rowTotal = userService.queryUserCount(searchBean);
        PageBean page = new PageBean(rowTotal);
        if (StringUtils.isNotBlank(pageSize)) {
            page.setPageSize(Integer.valueOf(pageSize));
        }
        if (StringUtils.isNotBlank(currentPage)) {
            page.setPageNum(Integer.valueOf(currentPage));
        }

        page.setQueryString(request.getQueryString());
        searchBean.setPage(page);
        List<UserBean> users = userService.queryUser(searchBean);
        model.addAttribute("users", users);
        model.addAttribute("page", page);
        return "admin/user/userList";
    }



    @RequestMapping(value = "/changePassword.html")
    public String changePassword(final ModelMap model, final HttpServletRequest request,
            final HttpServletResponse response, final String login, final String oldPassword, final String newPassword,
            String token, String searchKey, String currentPage, String pageSize) {
        if (null == token) {
            token = "";
        }
        if (null == searchKey) {
            searchKey = "";
        }
        if (null == currentPage) {
            currentPage = "";
        }
        if (null == pageSize) {
            pageSize = "";
        }
 
        int result = userService.changePassword(login, oldPassword, newPassword);
        return "redirect:/admin/user/userList.html?searchKey=" + searchKey +"&token=" + token +"&currentPage=" +currentPage + "&pageSize=" + pageSize;
    }
}
