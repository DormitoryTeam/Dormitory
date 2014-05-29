package com.noeasy.money.admin.controller;

import java.math.BigDecimal;
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

import com.noeasy.money.admin.util.OrderTokenUtil;
import com.noeasy.money.constant.SessionConstants;
import com.noeasy.money.enumeration.OrderType;
import com.noeasy.money.model.LineItem;
import com.noeasy.money.model.OrderBean;
import com.noeasy.money.model.OrderContactInfo;
import com.noeasy.money.model.OrderSearchBean;
import com.noeasy.money.model.PageBean;
import com.noeasy.money.model.PickupLineItem;
import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserInfoBean;
import com.noeasy.money.service.IOrderService;
import com.noeasy.money.service.IUserService;
import com.noeasy.money.service.IUserService.INFO_TYPE;
import com.noeasy.money.util.DateUtils;
import com.noeasy.money.util.ServletUtils;

@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {

    @Resource(name = "orderService")
    IOrderService orderService;

    @Resource(name = "userService")
    IUserService  userService;



    @RequestMapping(value = "/editDormitoryOrder.html")
    public String editDormitoryOrder(final ModelMap model, final HttpServletRequest request,
            final HttpServletResponse response, final String orderId) {
        if (StringUtils.isBlank(orderId)) {
            return "admin/order/orderList";
        }
        OrderBean order = orderService.findOrderById(Integer.valueOf(orderId));
        model.addAttribute("order", order);
        if (ServletUtils.isGet(request)) {
            return "admin/order/editDormitoryOrder";
        } else {
            // update orderInfo;
        }

        return "admin/order/editDormitoryOrder";
    }



    @RequestMapping(value = "/editPickupOrder.html")
    public String editPickupOrder(final ModelMap model, final HttpServletRequest request,
            final HttpServletResponse response, final String orderId) {
        if (StringUtils.isBlank(orderId)) {
            return "admin/order/orderList";
        }
        OrderBean order = orderService.findPickupOrderById(Integer.valueOf(orderId));
        if (CollectionUtils.isNotEmpty(order.getLineItems())) {
            PickupLineItem item = (PickupLineItem) order.getLineItems().get(0);
            item.analyzeLuggage();
            model.addAttribute("item", item);
        }
        model.addAttribute("order", order);
        if (ServletUtils.isGet(request)) {
            return "admin/order/editPickupOrder";
        } else {
            // update orderInfo;
            OrderContactInfo info = order.getOrderContact();
            if (null != info) {
                UserInfoBean userInfo = info.getBelongsToInfo();
                if (null != userInfo) {
                    userInfo.setGender(Integer.valueOf(request.getParameter("gender")));
                    userInfo.setLastName(request.getParameter("lastName"));
                    userInfo.setName(request.getParameter("name"));
                    userInfo.setNationality(request.getParameter("nationality"));
                    userInfo.setEmail(request.getParameter("email"));
                    userInfo.setQq(request.getParameter("qq"));
                    userInfo.setWechat(request.getParameter("wechat"));
                    userInfo.setPhone(request.getParameter("phone"));
                    userInfo.setCountry(request.getParameter("country"));
                    userInfo.setProvince(request.getParameter("province"));
                    userInfo.setCity(request.getParameter("city"));
                    userInfo.setCounty(request.getParameter("county"));
                    userInfo.setAddress(request.getParameter("address"));
                    userInfo.setPostalcode(request.getParameter("postalcode"));
                    if (StringUtils.isNotBlank(request.getParameter("birthday"))) {
                        userInfo.setBirthday(DateUtils.stringToDate(request.getParameter("birthday")));
                    }
                }
            }
            if (CollectionUtils.isNotEmpty(order.getLineItems())) {
                LineItem lineItem = order.getLineItems().get(0);
                if (lineItem instanceof PickupLineItem) {
                    PickupLineItem item = (PickupLineItem) lineItem;
                    if (StringUtils.isNotBlank(request.getParameter("takeOffDate"))) {
                        item.setTakeOffDate(DateUtils.stringToDate(request.getParameter("takeOffDate")));
                    }
                    item.setTakeOffCity(request.getParameter("takeOffCity"));
                    item.setArrivalCity(request.getParameter("arrivalCity"));
                    item.setArrivalCountry(request.getParameter("arrivalCountry"));
                    item.setArrivalAirport(request.getParameter("arrivalAirport"));

                    if (StringUtils.isNotBlank(request.getParameter("pickupDate"))) {
                        item.setPickupDate(DateUtils.stringToDate(request.getParameter("pickupDate"),
                                "yyyy-MM-dd HH:mm"));
                    }
                    item.setFlightCompany(request.getParameter("flightCompany"));
                    item.setFlightNum(request.getParameter("flightNumber"));
                    item.setPickup2City(request.getParameter("pickup2City"));
                    item.setPickup2Address(request.getParameter("pickup2Address"));
                    item.setPickup2Dormitory(request.getParameter("pickup2Dormitory"));
                    item.setPickup2Postalcode(request.getParameter("pickup2Postalcode"));
                    item.setPaymentUrl(request.getParameter("paymentUrl"));

                    String luggageSizeStr = "";
                    String luggageAmountStr = "";
                    String luggageSize1 = request.getParameter("luggageSize1");
                    String luggageAmount1 = request.getParameter("luggageAmount1");
                    if (StringUtils.isNotBlank(luggageSize1) && StringUtils.isNotBlank(luggageAmount1)) {
                        Double size = Double.valueOf(luggageSize1);
                        Integer amount = Integer.valueOf(luggageAmount1);
                        if (size > 0 && amount > 0) {
                            luggageSizeStr += size.toString();
                            luggageAmountStr += amount.toString();
                        }
                    }

                    String luggageSize2 = request.getParameter("luggageSize2");
                    String luggageAmount2 = request.getParameter("luggageAmount2");
                    if (StringUtils.isNotBlank(luggageSize2) && StringUtils.isNotBlank(luggageAmount2)) {
                        Double size = Double.valueOf(luggageSize2);
                        Integer amount = Integer.valueOf(luggageAmount2);
                        if (size > 0 && amount > 0) {
                            if (StringUtils.isNotBlank(luggageSizeStr)) {
                                luggageSizeStr += ":";
                            }
                            luggageSizeStr += size.toString();
                            if (StringUtils.isNotBlank(luggageAmountStr)) {
                                luggageAmountStr += ":";
                            }
                            luggageAmountStr += amount.toString();
                        }
                    }

                    String luggageSize3 = request.getParameter("luggageSize3");
                    String luggageAmount3 = request.getParameter("luggageAmount3");
                    if (StringUtils.isNotBlank(luggageSize3) && StringUtils.isNotBlank(luggageAmount3)) {
                        Double size = Double.valueOf(luggageSize3);
                        Integer amount = Integer.valueOf(luggageAmount3);
                        if (size > 0 && amount > 0) {
                            if (StringUtils.isNotBlank(luggageSizeStr)) {
                                luggageSizeStr += ":";
                            }
                            luggageSizeStr += size.toString();
                            if (StringUtils.isNotBlank(luggageAmountStr)) {
                                luggageAmountStr += ":";
                            }
                            luggageAmountStr += amount.toString();
                        }
                    }

                    String luggageSize4 = request.getParameter("luggageSize4");
                    String luggageAmount4 = request.getParameter("luggageAmount4");
                    if (StringUtils.isNotBlank(luggageSize4) && StringUtils.isNotBlank(luggageAmount4)) {
                        Double size = Double.valueOf(luggageSize4);
                        Integer amount = Integer.valueOf(luggageAmount4);
                        if (size > 0 && amount > 0) {
                            if (StringUtils.isNotBlank(luggageSizeStr)) {
                                luggageSizeStr += ":";
                            }
                            luggageSizeStr += size.toString();
                            if (StringUtils.isNotBlank(luggageAmountStr)) {
                                luggageAmountStr += ":";
                            }
                            luggageAmountStr += amount.toString();
                        }
                    }

                    String luggageSize5 = request.getParameter("luggageSize5");
                    String luggageAmount5 = request.getParameter("luggageAmount5");
                    if (StringUtils.isNotBlank(luggageSize5) && StringUtils.isNotBlank(luggageAmount5)) {
                        Double size = Double.valueOf(luggageSize5);
                        Integer amount = Integer.valueOf(luggageAmount5);
                        if (size > 0 && amount > 0) {
                            if (StringUtils.isNotBlank(luggageSizeStr)) {
                                luggageSizeStr += ":";
                            }
                            luggageSizeStr += size.toString();
                            if (StringUtils.isNotBlank(luggageAmountStr)) {
                                luggageAmountStr += ":";
                            }
                            luggageAmountStr += amount.toString();
                        }
                    }
                    item.setLuggageSize(luggageSizeStr);
                    item.setLuggageAmount(luggageAmountStr);
                    if (StringUtils.isNotBlank(request.getParameter("price"))) {
                        BigDecimal price = new BigDecimal(request.getParameter("price"));
                        item.setListPrice(price);
                        item.setAmount(price);
                        order.setAmount(price);
                    }
                }
            }
            userService.saveUserInfo(order.getOrderContact(), INFO_TYPE.USER_INFO);
            orderService.updateLineItem(order);
            orderService.updateOrder(order);
        }
        return "redirect:/admin/order/editPickupOrder.html?orderId=" + orderId;
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
            return "admin/order/orderDetails";
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
            return "admin/order/orderDetails";
        }
        model.addAttribute("order", orders.get(0));
        model.addAttribute("message", message);
        return "admin/order/orderDetails";
    }



    @RequestMapping(value = "/orderList.html")
    public String getOrderList(final ModelMap model, final HttpServletRequest request,
            final HttpServletResponse response, final String orderType, final String orderId, final String login,
            final String dateFrom, final String dateTo, final String currentPage, final String pageSize) {
        OrderType type = OrderType.getType(orderType);// "D" means dormitory
        OrderSearchBean searchBean = new OrderSearchBean();
        searchBean.setOrderType(type);
        if (StringUtils.isNotBlank(login)) {
            UserBean user = new UserBean();
            user.setLogin(login);
            ;
            searchBean.setUser(user);
        }
        if (StringUtils.isNoneBlank(OrderTokenUtil.getOrderId(orderId))) {
            searchBean.setOrderNumber(Integer.valueOf(OrderTokenUtil.getOrderId(orderId)));
            if (StringUtils.isNotBlank(dateFrom)) {
                Date tDateFrom = DateUtils.stringToDate(dateFrom);
                searchBean.setDateFrom(tDateFrom);
            }
            if (StringUtils.isNotBlank(dateTo)) {
                Date tDateTo = DateUtils.stringToDate(dateTo);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(tDateTo);
                calendar.add(Calendar.DATE, 1);
                searchBean.setDateTo(calendar.getTime());
            }
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
            model.addAttribute("page", page);
        } else {
            model.addAttribute("message", "请输入正确的订单编号！");
        }

        model.addAttribute("type", orderType);
        model.addAttribute("orderId", orderId);
        model.addAttribute("login", login);
        model.addAttribute("dateFrom", dateFrom);
        model.addAttribute("dateTo", dateTo);
        return "admin/order/orderList";
    }



    @RequestMapping(value = "/home.html")
    public String home(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {

        return "/home.html";
    }



    @RequestMapping(value = "/updateOrderPrice.html")
    public String updateOrderPrice(final ModelMap model, final HttpServletRequest request,
            final HttpServletResponse response, final String orderId, final String price, final String orderType) {
        String message = "Sucess";
        model.addAttribute("type", orderType);
        if (StringUtils.isBlank(orderId) || StringUtils.isBlank(price)) {
            message = "Failed";
            model.addAttribute("message", message);
            return "error";
        }
        OrderBean order = orderService.queryOrder(Integer.valueOf(orderId), OrderType.getType(orderType));
        if (null == order) {
            message = "no such order.";
            model.addAttribute("message", message);
            return "error";
        }
        BigDecimal amount = new BigDecimal(price);
        order.setAmount(amount);
        orderService.updateOrderPrice(order);
        model.addAttribute("message", message);
        return "redirect:/admin/order/orderDetails.html?orderId=" + orderId + "&orderType=" + orderType;
    }



    @RequestMapping(value = "/updateOrderStatus.html")
    public String updateOrderStatus(final ModelMap model, final HttpServletRequest request,
            final HttpServletResponse response, final String orderId, final String nextStatusValue,
            final String orderType) {
        String message = "Sucess";
        model.addAttribute("type", orderType);
        if (StringUtils.isBlank(orderId) || StringUtils.isBlank(nextStatusValue)) {
            message = "Failed";
            model.addAttribute("message", message);
            return "error";
        }
        OrderBean order = orderService.queryOrder(Integer.valueOf(orderId), OrderType.getType(orderType));
        if (null == order) {
            message = "no such order.";
            model.addAttribute("message", message);
            return "error";
        }

        // if (null == order.getOrderStatus().getNextStatus()) {
        // message = "Order status is null";
        // model.addAttribute("message", message);
        // return "error";
        // }
        // if (Integer.valueOf(nextStatusValue) !=
        // order.getOrderStatus().getNextStatus().getValue()) {
        // message = "Invalid order status";
        // model.addAttribute("message", message);
        // return "error";
        // }
        // TODO SENDING CONTRACT EMAIL
        // FIXME
        // orderService.updateOrderStatus(Integer.valueOf(orderId),
        // OrderStatus.valueOf(Integer.valueOf(nextStatusValue)));
        model.addAttribute("message", message);
        return "redirect:/admin/order/orderDetails.html?orderId=" + orderId + "&orderType=" + orderType;
    }
}
