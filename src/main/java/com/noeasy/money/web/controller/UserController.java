package com.noeasy.money.web.controller;

import java.util.HashMap;
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
import com.noeasy.money.enumeration.OrderType;
import com.noeasy.money.model.OrderBean;
import com.noeasy.money.model.OrderSearchBean;
import com.noeasy.money.model.PageBean;
import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserInfoBean;
import com.noeasy.money.model.UserPreferBean;
import com.noeasy.money.model.UserSearchBean;
import com.noeasy.money.service.IOrderService;
import com.noeasy.money.service.IUserService;
import com.noeasy.money.util.EmailUtils;
import com.noeasy.money.util.PropertiesUtils;
import com.noeasy.money.util.ServletUtils;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    IUserService  userService;

    @Resource(name = "orderService")
    IOrderService orderService;



    @RequestMapping("/asynLogin" + Constants.URL_SUFFIX)
    @ResponseBody
    public String asynLogin(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
            final String login, final String password) {
        JSONObject json = null;
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("result", false);

        if (StringUtils.isBlank(login)) {
            resultMap.put("message", "用户名不能为空。");
        } else if (StringUtils.isBlank(password)) {
            resultMap.put("message", "密码不能为空。");
        } else {
            UserSearchBean bean = new UserSearchBean();
            bean.setLogin(login);
            bean.setPassword(password);
            List<UserBean> users = userService.queryUser(bean);
            if (CollectionUtils.isNotEmpty(users)) {
                UserBean user = users.get(0);
                request.getSession().setAttribute(SessionConstants.SESSION_KEY_USER_ID, user.getId());
                request.getSession().setAttribute(SessionConstants.SESSION_KEY_USER_LOGIN, user.getLogin());
                resultMap.put("login", user.getLogin());
                resultMap.put("result", true);
            } else {
                resultMap.put("message", "用户名和密码不匹配。");
            }
        }

        json = JSONObject.fromObject(resultMap);
        return json.toString();
    }



    @RequestMapping(value = "/asynRegister" + Constants.URL_SUFFIX)
    @ResponseBody
    public String asynRegister(final ModelMap model, final HttpServletRequest request,
            final HttpServletResponse response, final String login, final String password) {
        JSONObject json = null;
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("result", false);

        if (StringUtils.isBlank(login)) {
            resultMap.put("message", "用户名不能为空。");
        } else if (StringUtils.isBlank(password)) {
            resultMap.put("message", "密码不能为空。");
        } else {
            model.addAttribute("result", login);
            UserBean user = userService.register(login, password);
            if (user == null) {
                resultMap.put("message", "该用户名已存在。");
            } else {
                request.getSession().setAttribute(SessionConstants.SESSION_KEY_USER_ID, user.getId());
                request.getSession().setAttribute(SessionConstants.SESSION_KEY_USER_LOGIN, user.getLogin());
                resultMap.put("login", user.getLogin());
                resultMap.put("result", true);
            }
        }

        json = JSONObject.fromObject(resultMap);
        return json.toString();
    }



    @RequestMapping(value = "/changePassword.html")
    public String changePassword(final ModelMap model, final HttpServletRequest request,
            final HttpServletResponse response, final String oldPassword, final String newPassword) {
        String login = (String) request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_LOGIN);
        if (!ServletUtils.isLogin(request)) {
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
            final HttpServletResponse response) {
        if (!ServletUtils.isLogin(request)) {
            return "redirect:/user/login.html";
        }
        String command = request.getParameter("command");
        model.put("command", command);
        Integer userId = (Integer) request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        String[] forwrdURLs = new String[] { "user/userInfoForm", "user/preferForm", "user/guaranteeForm",
                "user/contactPersonForm", "user/notesForm" };
        String pageStep = request.getParameter(Constants.PARAM_PAGE_STEP);
        Integer step = Integer.valueOf(0);
        if (StringUtils.isNotBlank(pageStep)) {
            step = Integer.valueOf(pageStep);
            if (step < 0) {
                step = Integer.valueOf(0);
            }
            if (step > 4) {
                step = Integer.valueOf(4);
            }
        }
        UserBean user = userService.findUserById(userId);
        model.addAttribute("user", user);
        if (ServletUtils.isGet(request)) {
            String forwordURL = forwrdURLs[step];
            return forwordURL;
        }

        switch (step) {
        case 1:
            // edit user prefer.
            maintainUserPerfer(request, response);
            break;
        case 2:
            // edit guarantee info.
            maintainGuarantee(request, response);
            break;
        case 3:
            // edit contact person info.
            maintainContactPersonInfo(request, response);
            break;
        case 4:
            // edit notes.
            maintainsNotes(request, response);
            break;
        default:
            // user info.
            maintainsUserInfo(request, response);
            break;
        }
        // Integer nextStep = step + 1;
        user = userService.findUserById(userId);
        model.addAttribute("user", user);
        Integer nextStep = step;
        if (nextStep > 4) {
            return "user/editUserSuccess";
        } else {
            return forwrdURLs[nextStep];
        }

    }



    @RequestMapping(value = "/orderDetails.html")
    public String getOrderDetails(final ModelMap model, final HttpServletRequest request,
            final HttpServletResponse response, final String orderId, final String orderType) {
        Integer userId = (Integer) request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        String message = null;
        model.addAttribute("type", orderType);
        if (StringUtils.isBlank(orderId)) {
            message = "orderId is blank";
            model.addAttribute("message", message);
            return "user/orderDetails";
        }
        OrderSearchBean searchBean = new OrderSearchBean();
        UserBean user = new UserBean();
        user.setId(userId);
        searchBean.setUser(user);
        searchBean.setOrderNumber(Integer.valueOf(orderId));
        searchBean.setOrderType(OrderType.getType(orderType));
        List<OrderBean> orders = orderService.queryOrder(searchBean);
        if (CollectionUtils.isEmpty(orders)) {
            message = "no such order";
            return "user/orderDetails";
        }
        model.addAttribute("order", orders.get(0));
        model.addAttribute("message", message);
        return "user/orderDetails";
    }



    @RequestMapping(value = "/orderList.html")
    public String getOrderList(final ModelMap model, final HttpServletRequest request,
            final HttpServletResponse response, final String orderType, final String currentPage, final String pageSize) {
        Integer userId = (Integer) request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        UserBean user = userService.findUserById(userId);

        OrderType type = OrderType.getType(orderType);// "D" means dormitory
        OrderSearchBean searchBean = new OrderSearchBean();
        searchBean.setOrderType(type);
        searchBean.setUser(user);
        int rowTotal = orderService.queryOrderCount(searchBean);
        PageBean page = new PageBean(rowTotal);
        if (StringUtils.isNotBlank(currentPage)) {
            page.setPageNum(Integer.valueOf(currentPage));
        }
        if (StringUtils.isNotBlank(pageSize)) {
            page.setPageSize(Integer.valueOf(pageSize));
        }
        page.setQueryString(request.getQueryString());
        searchBean.setPageBean(page);
        List<OrderBean> orders = orderService.queryOrder(searchBean);
        model.addAttribute("orders", orders);
        model.addAttribute("type", orderType);
        model.addAttribute("page", page);
        model.addAttribute("user", user);
        return "user/orderList";
    }



    @RequestMapping(value = "/home.html")
    public String home(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
        Integer userId = (Integer) request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        String login = (String) request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_LOGIN);
        model.addAttribute("userId", userId);
        model.addAttribute("login", login);
        return "user/home";
    }



    @RequestMapping("/loadLogin" + Constants.URL_SUFFIX)
    public String loadLoginPage(final HttpServletRequest request, final HttpServletResponse response) {
        return "include/homepage-login";
    }



    @RequestMapping("/loadRegister" + Constants.URL_SUFFIX)
    public String loadRegisterPage(final HttpServletRequest request, final HttpServletResponse response) {
        return "include/homepage-register";
    }



    @RequestMapping(value = "/login.html")
    public String login(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
            final String login, final String password) {
        if (ServletUtils.isGet(request)) {
            return "user/loginForm";
        }
        if (StringUtils.isBlank(login)) {
            model.addAttribute("message", "用户名不能为空。");
            return "user/loginForm";
        }
        if (StringUtils.isBlank(password)) {
            model.addAttribute("message", "密码不能为空。");
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
            return "redirect:/navigation/home.html";
        }
        model.addAttribute("message", "用户名和密码不匹配。");
        return "user/loginForm";
    }



    private void maintainContactPersonInfo(final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
        Integer userId = (Integer) pRequest.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        UserBean user = new UserBean();
        user.setId(userId);
        UserInfoBean contactPersonInfo = ServletUtils.getUserInfoFromRequest(pRequest);
        user.setContactPersonInfo(contactPersonInfo);
        userService.saveUserInfo(user);

    }



    private void maintainGuarantee(final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
        Integer userId = (Integer) pRequest.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        UserBean user = new UserBean();
        user.setId(userId);
        UserInfoBean guaranteeInfo = ServletUtils.getUserInfoFromRequest(pRequest);
        user.setGuaranteeInfo(guaranteeInfo);
        userService.saveUserInfo(user);

    }



    private void maintainsNotes(final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
        UserPreferBean userPrefer = ServletUtils.getUserPerferFromRequest(pRequest);
        Integer userId = (Integer) pRequest.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        UserBean user = new UserBean();
        user.setId(userId);
        user.setPrefer(userPrefer);
        userService.saveUserPrefer(user);
    }



    private void maintainsUserInfo(final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
        Integer userId = (Integer) pRequest.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        UserBean user = new UserBean();
        user.setId(userId);
        UserInfoBean info = ServletUtils.getUserInfoFromRequest(pRequest);
        user.setInfo(info);
        userService.saveUserInfo(user);
    }



    private void maintainUserPerfer(final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
        UserPreferBean userPrefer = ServletUtils.getUserPerferFromRequest(pRequest);
        Integer userId = (Integer) pRequest.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        UserBean user = new UserBean();
        user.setId(userId);
        user.setPrefer(userPrefer);
        userService.saveUserPrefer(user);
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
            model.addAttribute("message", "用户名不能为空。");
            return "user/registerForm";
        }
        if (StringUtils.isBlank(password)) {
            model.addAttribute("message", "密码不能为空。");
            return "user/registerForm";
        }
        model.addAttribute("login", login);
        UserBean user = userService.register(login, password);
        if (user == null) {
            model.addAttribute("message", "该用户名已存在。");
            return "user/registerForm";
        }
        request.getSession().setAttribute(SessionConstants.SESSION_KEY_USER_ID, user.getId());
        request.getSession().setAttribute(SessionConstants.SESSION_KEY_USER_LOGIN, user.getLogin());

        return "redirect:/user/home.html";
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
            model.addAttribute("message", "用户名不能为空。");
            return "user/changePasswordMessage";
        }
        boolean isExist = userService.exist(login);
        if (!isExist) {
            model.addAttribute("message", "用户名不存在。");
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
        boolean sendSuccess = EmailUtils.sendEmail(from, fromAlias, user.getEmail(), user.getAlias(), subject,
                resetPasswordURL);
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

        return "redirect:/navigation/home.html";
    }



    @RequestMapping("/toLogin" + Constants.URL_SUFFIX)
    public String toLoginPage(final HttpServletRequest request, final HttpServletResponse response) {
        return "login";
    }



    @RequestMapping("/toRegister" + Constants.URL_SUFFIX)
    public String toRegisterPage(final HttpServletRequest request, final HttpServletResponse response) {
        return "register";
    }
}
