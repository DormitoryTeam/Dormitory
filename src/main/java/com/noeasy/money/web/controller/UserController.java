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
import com.noeasy.money.util.DateUtils;
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



    @RequestMapping(value = "/home.html")
    public String home(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
        Integer userId = (Integer) request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        String login = (String) request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_LOGIN);
        model.addAttribute("userId", userId);
        model.addAttribute("login", login);
        return "user/home";
    }



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
            final HttpServletResponse response) {
        Integer userId = (Integer) request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        String[] forwrdURLs = new String[] { "user/userInfoForm", "user/preferForm", "user/guaranteeForm",
                "user/contactPersonForm", "user/notesForm" };
        if (null == userId) {
            return "redirect:/user/login.html";
        }
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
        UserSearchBean searchBean = new UserSearchBean();
        searchBean.setId(userId);
        UserBean user = userService.queryUser(searchBean).get(0);
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
        Integer nextStep = step + 1;
        if (nextStep > 4) {
            return "user/editUserSuccess";
        } else {
            return forwrdURLs[nextStep];
        }

    }



    private UserInfoBean getUserInfoFromRequest(HttpServletRequest pRequest) {
        UserInfoBean userInfo = new UserInfoBean();
        userInfo.setName(pRequest.getParameter("name"));
        userInfo.setNationality(pRequest.getParameter("nationality"));
        userInfo.setEmail(pRequest.getParameter("email"));
        userInfo.setQq(pRequest.getParameter("qq"));
        userInfo.setWechat(pRequest.getParameter("wechat"));
        userInfo.setPhone(pRequest.getParameter("phone"));
        userInfo.setCountry(pRequest.getParameter("country"));
        userInfo.setProvince(pRequest.getParameter("province"));
        userInfo.setCity(pRequest.getParameter("city"));
        userInfo.setAddress(pRequest.getParameter("address"));
        String birthdayStr = pRequest.getParameter("birthday");
        if (StringUtils.isNotBlank(birthdayStr)) {
            userInfo.setBirthday(DateUtils.stringToDate(birthdayStr));
        }
        String genderStr = pRequest.getParameter("gender");
        if (StringUtils.isNotBlank(genderStr)) {
            userInfo.setGender(Integer.valueOf(genderStr));
        }
        String idStr = pRequest.getParameter("infoId");
        if (StringUtils.isNotBlank(idStr)) {
            userInfo.setId(Integer.valueOf(idStr));
        }
        return userInfo;
    }



    private void maintainsUserInfo(HttpServletRequest pRequest, HttpServletResponse pResponse) {
        Integer userId = (Integer) pRequest.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        UserBean user = new UserBean();
        user.setId(userId);
        UserInfoBean info = getUserInfoFromRequest(pRequest);
        user.setInfo(info);
        userService.saveUserInfo(user);
    }



    private void maintainsNotes(HttpServletRequest pRequest, HttpServletResponse pResponse) {
        UserPreferBean userPrefer = getUserPerferFromRequest(pRequest, pResponse);
        Integer userId = (Integer) pRequest.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        UserBean user = new UserBean();
        user.setId(userId);
        user.setPrefer(userPrefer);
        userService.saveUserPrefer(user);
    }



    private void maintainContactPersonInfo(HttpServletRequest pRequest, HttpServletResponse pResponse) {
        Integer userId = (Integer) pRequest.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        UserBean user = new UserBean();
        user.setId(userId);
        UserInfoBean contactPersonInfo = getUserInfoFromRequest(pRequest);
        user.setContactPersonInfo(contactPersonInfo);
        userService.saveUserInfo(user);

    }



    private void maintainGuarantee(HttpServletRequest pRequest, HttpServletResponse pResponse) {
        Integer userId = (Integer) pRequest.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        UserBean user = new UserBean();
        user.setId(userId);
        UserInfoBean guaranteeInfo = getUserInfoFromRequest(pRequest);
        user.setGuaranteeInfo(guaranteeInfo);
        userService.saveUserInfo(user);

    }



    private void maintainUserPerfer(HttpServletRequest pRequest, HttpServletResponse pResponse) {
        UserPreferBean userPrefer = getUserPerferFromRequest(pRequest, pResponse);
        Integer userId = (Integer) pRequest.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        UserBean user = new UserBean();
        user.setId(userId);
        user.setPrefer(userPrefer);
        userService.saveUserPrefer(user);
    }



    private UserPreferBean getUserPerferFromRequest(HttpServletRequest pRequest, HttpServletResponse pResponse) {
        UserPreferBean userPrefer = new UserPreferBean();

        String preferIdStr = pRequest.getParameter("preferId");
        if (StringUtils.isNotBlank(preferIdStr)) {
            userPrefer.setId(Integer.valueOf(preferIdStr));
        }
        String smokeStr = pRequest.getParameter("smoke");
        if (StringUtils.isNotBlank(smokeStr)) {
            if ("Y".equalsIgnoreCase(smokeStr)) {
                userPrefer.setSmoke(Boolean.TRUE);
            } else {
                userPrefer.setSmoke(Boolean.FALSE);
            }
        }

        String vegetarianismStr = pRequest.getParameter("vegetarianism");
        if (StringUtils.isNotBlank(vegetarianismStr)) {
            if ("Y".equalsIgnoreCase(vegetarianismStr)) {
                userPrefer.setVegetarianism(Boolean.TRUE);
            } else {
                userPrefer.setVegetarianism(Boolean.FALSE);
            }
        }

        userPrefer.setYourGrade(pRequest.getParameter("yourGrade"));
        userPrefer.setRoomMemberGrade(pRequest.getParameter("roomMemberGrade"));
        String roomMemberGenderStr = pRequest.getParameter("roomMemberGender");
        if (StringUtils.isBlank(roomMemberGenderStr)) {
            userPrefer.setRoomMemberGender(Integer.valueOf(0));
        } else {
            userPrefer.setRoomMemberGender(Integer.valueOf(roomMemberGenderStr));
        }
        userPrefer.setMajor(pRequest.getParameter("major"));
        userPrefer.setCollege(pRequest.getParameter("college"));
        userPrefer.setFloor(pRequest.getParameter("floor"));
        String orientationStr = pRequest.getParameter("orientation");
        if (StringUtils.isBlank(orientationStr)) {
            userPrefer.setOrientation(Integer.valueOf(0));
        } else {
            userPrefer.setOrientation(Integer.valueOf(orientationStr));
        }

        userPrefer.setGraduateSchool(pRequest.getParameter("graduateSchool"));

        String needPushStr = pRequest.getParameter("needPush");
        if (StringUtils.isNotBlank(needPushStr)) {
            if ("Y".equalsIgnoreCase(needPushStr)) {
                userPrefer.setNeedPush(Boolean.TRUE);
            } else {
                userPrefer.setNeedPush(Boolean.FALSE);
            }
        }

        String readClause = pRequest.getParameter("readClause");
        if (StringUtils.isNotBlank(readClause)) {
            if ("Y".equalsIgnoreCase(readClause)) {
                userPrefer.setReadClause(Boolean.TRUE);
            } else {
                userPrefer.setReadClause(Boolean.FALSE);
            }
        }
        return userPrefer;
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
            return "redirect:/navigation/home.html";
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



    @RequestMapping(value = "/orderList.html")
    public String getOrderList(final ModelMap model, final HttpServletRequest request,
            final HttpServletResponse response, String orderType, final String currentPage, final String pageSize) {
        Integer userId = (Integer) request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        OrderType type = OrderType.getType(orderType);// "D" means dormitory
        OrderSearchBean searchBean = new OrderSearchBean();
        searchBean.setOrderType(type);
        UserBean user = new UserBean();
        user.setId(userId);
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
        return "user/orderList";
    }



    @RequestMapping(value = "/orderDetails.html")
    public String getOrderDetails(final ModelMap model, final HttpServletRequest request,
            final HttpServletResponse response, String orderId, String orderType) {
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
}
