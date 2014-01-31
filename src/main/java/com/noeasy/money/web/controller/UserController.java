package com.noeasy.money.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noeasy.money.constant.SessionConstants;
import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserSearchBean;
import com.noeasy.money.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    IUserService userService;



    @RequestMapping(value = "/register.html")
    public String register(ModelMap model, HttpServletRequest request, HttpServletResponse response, String login,
            String password) {
        // TODO check precondition
        UserBean user = userService.register(login, password);
        request.getSession().setAttribute(SessionConstants.SESSION_KEY_USER_ID, user.getId());

        return "dormitory/sucess";
    }

    
    @RequestMapping(value = "/login.html")
    public String login(ModelMap model, HttpServletRequest request, HttpServletResponse response, String pLogin,
            String pPassword) {
        // TODO check precondition
        UserSearchBean bean = new UserSearchBean();
        bean.setLogin(pLogin);
        bean.setPassword(pPassword);
        List<UserBean> users = userService.queryUser(bean);
        if (CollectionUtils.isNotEmpty(users)) {
            UserBean user = users.get(0);
            request.getSession().setAttribute(SessionConstants.SESSION_KEY_USER_ID, user.getId());
            return "loginSucess";
        }
        return "userNotFound";
    }
    
}
