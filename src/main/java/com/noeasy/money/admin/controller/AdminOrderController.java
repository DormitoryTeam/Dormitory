package com.noeasy.money.admin.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noeasy.money.constant.SessionConstants;
import com.noeasy.money.enumeration.OrderType;
import com.noeasy.money.model.OrderBean;
import com.noeasy.money.model.OrderSearchBean;
import com.noeasy.money.model.UserBean;
import com.noeasy.money.service.IOrderService;
import com.noeasy.money.util.DateUtils;

@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {

    @Resource(name = "orderService")
    IOrderService orderService;



    @RequestMapping(value = "/home.html")
    public String home(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {

        return "/home.html";
    }



    @RequestMapping(value = "/orderList.html")
    public String getOrderList(final ModelMap model, final HttpServletRequest request,
            final HttpServletResponse response, String orderType, String orderId, String login, String dateFrom,
            String dateTo) {
        OrderType type = OrderType.getType(orderType);// "D" means dormitory
        OrderSearchBean searchBean = new OrderSearchBean();
        searchBean.setOrderType(type);
        if (StringUtils.isNotBlank(login)) {
            UserBean user = new UserBean();
            user.setLogin(login);
            ;
            searchBean.setUser(user);
        }
        if (StringUtils.isNoneBlank(orderId)) {
            searchBean.setOrderNumber(Integer.valueOf(orderId));
        }
        if (StringUtils.isNotBlank(dateFrom)) {
            Date tDateFrom = DateUtils.stringToDate(dateFrom);
            searchBean.setDateFrom(tDateFrom);
        }
        if (StringUtils.isNotBlank(dateTo)) {
            Date tDateTo= DateUtils.stringToDate(dateTo);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(tDateTo);
            calendar.add(Calendar.DATE, 1);
            searchBean.setDateTo(calendar.getTime());
        }
        List<OrderBean> orders = orderService.queryOrder(searchBean);
        model.addAttribute("orders", orders);
        model.addAttribute("type", orderType);
        model.addAttribute("orderId", orderId);
        model.addAttribute("login", login);
        model.addAttribute("dateFrom", dateFrom);
        model.addAttribute("dateTo", dateTo);
        return "admin/order/orderList";
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
        if (StringUtils.isBlank(orderType)) {
            message = "orderType is blank";
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
