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

import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserSearchBean;
import com.noeasy.money.service.IAuthenticationService;
import com.noeasy.money.service.IUserService;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    @Resource(name = "userService")
    IUserService  userService;
    @Resource(name = "authenticationService")
    IAuthenticationService authenService;
    
    @RequestMapping(value = "/userList.html")
    public String getUserList(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response, String searchKey, String groupId) {
        List<Map<String, String>> allGroups = authenService.getAllGroups();
        model.addAttribute("allGroups", allGroups);
        model.addAttribute("searchKey", searchKey);
        model.addAttribute("groupId", groupId);
        
        UserSearchBean searchBean = new UserSearchBean();
        if(StringUtils.isNotBlank(searchKey)) {
            searchBean.setSearchKey(searchKey);
        }
        if (StringUtils.isNotBlank(groupId)) {
            searchBean.setGroupId(groupId);
        }
        List<UserBean> users = userService.queryUser(searchBean);
        model.addAttribute("users", users);
        return "admin/user/userList";
    }
}
