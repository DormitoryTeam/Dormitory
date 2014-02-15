package com.noeasy.money.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.noeasy.money.constant.Constants;
import com.noeasy.money.constant.SessionConstants;
import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserSearchBean;
import com.noeasy.money.service.IUserService;
import com.noeasy.money.util.DateUtils;
import com.noeasy.money.util.EmailUtils;
import com.noeasy.money.util.PropertiesUtils;
import com.noeasy.money.util.ServletUtils;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    IUserService userService;



    @RequestMapping(value = "/changePassword.html")
    public String changePassword(final ModelMap model, final HttpServletRequest request,
            final HttpServletResponse response, final String oldPassword, final String newPassword) {
        String login = (String) request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_LOGIN);
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



    @RequestMapping(value = "/editUserInfo.html")
    public String editUserInfo(final ModelMap model, final HttpServletRequest request,
            final HttpServletResponse response, final String name, final String gender, final String passport,
            final String birthday, final String address, final String phone, final String qq) {
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



    @RequestMapping(value = "/login.html")
    public String login(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
            final String login, final String password) {
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



    @RequestMapping("/queryUserInfoByEmail" + Constants.URL_SUFFIX)
    @ResponseBody
    public String queryUserInfoByEmail(final HttpServletRequest request, final HttpServletResponse response,
            final String email) {
        if (StringUtils.isNotBlank(email)) {
            UserSearchBean searchBean = new UserSearchBean();
            searchBean.setLogin(email);
            List<UserBean> result = userService.queryUser(searchBean);
            if (CollectionUtils.isNotEmpty(result)) {
                UserBean user = result.get(0);
                user.setPassword("");

                JSONObject userJson = JSONObject.fromObject(user);
                return userJson.toString();
            }
        }
        return "";
    }



    @RequestMapping(value = "/register.html")
    public String register(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
            final String login, final String password) {
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



    @RequestMapping(value = "/resetPassword.html")
    public String resetPassword(final ModelMap model, final HttpServletRequest request,
            final HttpServletResponse response, final String login, final String password, final String sign) {
        // TODO: validate date
        // String generateDateStr = sign.substring(0, 8);//yyyyMMdd+UUID
        UserSearchBean searchBean = new UserSearchBean();
        searchBean.setSign(sign);
        List<UserBean> users = userService.queryUser(searchBean);
        if (CollectionUtils.isEmpty(users)) {
            model.addAttribute("message", "Invalide sign");
            return "changePasswordMessage";
        }
        UserBean user = users.get(0);
        if (ServletUtils.isGet(request)) {
            model.addAttribute("sign", sign);
            model.addAttribute("user", user);
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



    @RequestMapping(value = "/sendResetPasswordEmail.html")
    public String sendResetPasswordEmail(final ModelMap model, final HttpServletRequest request,
            final HttpServletResponse response, final String login) {
        model.addAttribute("login", login);
        if (ServletUtils.isGet(request)) {
            return "user/sendResetPasswordEmailForm";
        }
        if (StringUtils.isBlank(login)) {
            model.addAttribute("message", "Username should not be blank");
            return "user/changePasswordMessage";
        }
        boolean isExist = userService.exist(login);
        if (!isExist) {
            model.addAttribute("message", "User not exist");
            return "user/changePasswordMessage";
        }
        UserBean user = userService.generateResetPasswordSign(login);
        String sign = user.getResetPasswordSign();
        String from = EmailUtils.getServiceEmail();
        String fromAlias = EmailUtils.getServiceAlias();
        String subject = EmailUtils.getSubject();
        String domain = PropertiesUtils.getConfigurableProperty(Constants.CONFIG_PATH, Constants.CONFIG_DOMAIN);
        String context = PropertiesUtils.getConfigurableProperty(Constants.CONFIG_PATH, Constants.CONFIG_CONTEXT);
        String resetPasswordURL = domain + Constants.SLASH + context + "/user/resetPassword.html?sign=" + sign;
        boolean sendSuccess = EmailUtils.sendEmail(from, fromAlias, user.getEmail(), user.getName(), subject, resetPasswordURL);
        String message = "Send reset password success.";
        if (!sendSuccess) {
            message = "Send reset password faild.";
        }
        model.addAttribute("message", message);
        return "user/changePasswordMessage";
    }



    @RequestMapping(value = "/signout.html")
    public String signout(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
        request.getSession().removeAttribute(SessionConstants.SESSION_KEY_USER_ID);

        return "redirect:/user/signoutSuccess";
    }
}