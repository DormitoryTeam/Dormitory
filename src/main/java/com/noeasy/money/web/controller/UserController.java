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
import com.noeasy.money.util.ServletUtils;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    IUserService userService;



    @RequestMapping(value = "/register.html")
    public String register(ModelMap model, HttpServletRequest request, HttpServletResponse response, String login,
            String password) {
        // TODO check precondition

        if (ServletUtils.isGet(request)) {
            return "user/registerFrom";
        }
        UserBean user = userService.register(login, password);
        request.getSession().setAttribute(SessionConstants.SESSION_KEY_USER_ID, user.getId());

        return "user/registerSucess";
    }



    @RequestMapping(value = "/login.html")
    public String login(ModelMap model, HttpServletRequest request, HttpServletResponse response, String login,
            String password) {
        // TODO check precondition
        if (ServletUtils.isGet(request)) {
            return "user/loginFrom";
        }
        UserSearchBean bean = new UserSearchBean();
        bean.setLogin(login);
        bean.setPassword(password);
        List<UserBean> users = userService.queryUser(bean);
        if (CollectionUtils.isNotEmpty(users)) {
            UserBean user = users.get(0);
            request.getSession().setAttribute(SessionConstants.SESSION_KEY_USER_ID, user.getId());
            return "user/loginSucess";
        }
        return "user/userNotFound";
    }



    @RequestMapping(value = "/changePassword.html")
    public String changePassword(ModelMap model, HttpServletRequest request, HttpServletResponse response,
            String login, String oldPassword, String newPassword) {
        if (ServletUtils.isGet(request)) {
            return "user/changePasswordForm";
        }
        
        int result = userService.changePassword(login, oldPassword, newPassword);
        String message = "Unkown Issue";
        if (IUserService.PASSWORD_NOT_MATCH == result) {
            message = "Password not match";

        }
        if (IUserService.PASSWORD_NOT_MATCH == result) {
            message = "Success";
        }
        model.addAttribute("message", message);
        return "user/changePasswordMessage";
    }



    @RequestMapping(value = "/resetPassword.html")
    public String resetPassword(ModelMap model, HttpServletRequest request, HttpServletResponse response, String login,
            String password) {
        if (ServletUtils.isGet(request)) {
            return "user/resetPasswordFrom";
        }
        boolean sucess = userService.resetPassword(login, password);
        String message = "Unkown Issue";
        if (sucess) {
            message = "Success";
        }
        model.addAttribute("message", message);
        return "user/changePasswordMessage";
    }

}
