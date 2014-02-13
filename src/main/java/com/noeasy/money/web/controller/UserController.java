package com.noeasy.money.web.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noeasy.money.constant.SessionConstants;
import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserSearchBean;
import com.noeasy.money.service.IUserService;
import com.noeasy.money.util.DateUtils;
import com.noeasy.money.util.ServletUtils;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    IUserService userService;



    @RequestMapping(value = "/register.html")
    public String register(ModelMap model, HttpServletRequest request, HttpServletResponse response, String login,
            String password) {
        if (ServletUtils.isGet(request)) {
            return "user/registerForm";
        }
        if (StringUtils.isBlank(login)) {
            model.addAttribute("message", "username should not be blank");
            return "user/registerForm";
        }
        if (StringUtils.isBlank(password)) {
            model.addAttribute("message", "password should not be blank");
            return "user/registerForm";
        }
        model.addAttribute("login", login);
        UserBean user = userService.register(login, password);
        request.getSession().setAttribute(SessionConstants.SESSION_KEY_USER_ID, user.getId());
        request.getSession().setAttribute(SessionConstants.SESSION_KEY_USER_LOGIN, user.getLogin());

        return "redirect:/user/registerSucess";
    }



    @RequestMapping(value = "/login.html")
    public String login(ModelMap model, HttpServletRequest request, HttpServletResponse response, String login,
            String password) {
        if (ServletUtils.isGet(request)) {
            return "user/loginForm";
        }
        if (StringUtils.isBlank(login)) {
            model.addAttribute("message", "username should not be blank");
            return "user/loginForm";
        }
        if (StringUtils.isBlank(password)) {
            model.addAttribute("message", "password should not be blank");
            return "user/loginForm";
        }
        model.addAttribute("login", login);
        UserSearchBean bean = new UserSearchBean();
        bean.setLogin(login);
        bean.setPassword(password);
        List<UserBean> users = userService.queryUser(bean);
        if (CollectionUtils.isNotEmpty(users)) {
            UserBean user = users.get(0);
            request.getSession().setAttribute(SessionConstants.SESSION_KEY_USER_ID, user.getId());
            request.getSession().setAttribute(SessionConstants.SESSION_KEY_USER_LOGIN, user.getLogin());
            return "redirect:/user/loginSucess.jsp";
        }
        model.addAttribute("message", "username and passowrd not match");
        return "user/loginForm";
    }



    @RequestMapping(value = "/signout.html")
    public String signout(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute(SessionConstants.SESSION_KEY_USER_ID);

        return "redirect:/user/signoutSuccess";
    }



    @RequestMapping(value = "/editUserInfo.html")
    public String editUserInfo(ModelMap model, HttpServletRequest request, HttpServletResponse response, String name,
            String gender, String passport, String birthday, String address, String phone, String qq) {
        Integer userId = (Integer) request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        if (null == userId) {
            return "redirect:/user/login.html";
        }
        if (ServletUtils.isGet(request)) {
            UserSearchBean searchBean = new UserSearchBean();
            searchBean.setId(userId);
            UserBean user = userService.queryUser(searchBean).get(0);
            model.addAttribute("user", user);
            return "user/userInfoForm";
        }
        UserBean user = new UserBean();
        user.setId(userId);
        user.setName(name);
        user.setGender("T".equalsIgnoreCase(gender));
        user.setPassport(passport);
        user.setBirthday(DateUtils.stringToDate(birthday));
        user.setAddress(address);
        user.setPhone(phone);
        user.setPassport(passport);
        user.setQq(qq);
        userService.updateUser(user);
        return "user/editUserSuccess";
    }



    @RequestMapping(value = "/changePassword.html")
    public String changePassword(ModelMap model, HttpServletRequest request, HttpServletResponse response,
            String oldPassword, String newPassword) {
        String login = (String)request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_LOGIN);
        if (null == login) {
            return "redirect:/user/login.html";
        }
        
        if (ServletUtils.isGet(request)) {
            return "user/changePasswordForm";
        }
        
        int result = userService.changePassword(login, oldPassword, newPassword);
        String message = "Unkown Issue";
        if (IUserService.PASSWORD_NOT_MATCH == result) {
            message = "Password not match";

        }
        if (IUserService.PASSWORD_CHANGE_SUCCESS == result) {
            message = "Success";
        }
        model.addAttribute("message", message);
        return "user/changePasswordMessage";
    }



    @RequestMapping(value = "/resetPassword.html")
    public String resetPassword(ModelMap model, HttpServletRequest request, HttpServletResponse response, String login,
            String password, String sign) {
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
    
    public String sendResetPasswordEmail(ModelMap model, HttpServletRequest request, HttpServletResponse response, String login) {
        UUID.randomUUID().toString();
        return null;
    }

}
