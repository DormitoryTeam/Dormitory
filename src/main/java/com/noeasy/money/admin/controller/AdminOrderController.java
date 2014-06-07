package com.noeasy.money.admin.controller;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import com.noeasy.money.model.UserPreferBean;
import com.noeasy.money.service.IOrderService;
import com.noeasy.money.service.IUserService;
import com.noeasy.money.service.IUserService.INFO_TYPE;
import com.noeasy.money.util.DateUtils;
import com.noeasy.money.util.EmailUtils;
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
            final HttpServletResponse response, final String orderId, final OrderBean order) {
        if (StringUtils.isBlank(orderId)) {
            return "admin/order/orderList";
        }
        OrderBean curOrder = orderService.findOrderById(Integer.valueOf(orderId));
        model.addAttribute("order", curOrder);
        if (ServletUtils.isGet(request)) {
            return "admin/order/editDormitoryOrder";
        } else {
            // update orderInfo;
            OrderContactInfo info = curOrder.getOrderContact();
            if (null != info) {
                UserInfoBean userInfo = info.getBelongsToInfo();
                if (null != userInfo) {
                    userInfo.setGender(Integer.valueOf(request.getParameter("order.orderContact.belongsToInfo.gender")));
                    userInfo.setLastName(request.getParameter("order.orderContact.belongsToInfo.lastName"));
                    userInfo.setName(request.getParameter("order.orderContact.belongsToInfo.name"));
                    userInfo.setNationality(request.getParameter("order.orderContact.belongsToInfo.nationality"));
                    userInfo.setEmail(request.getParameter("order.orderContact.belongsToInfo.email"));
                    userInfo.setQq(request.getParameter("order.orderContact.belongsToInfo.qq"));
                    userInfo.setWechat(request.getParameter("order.orderContact.belongsToInfo.wechat"));
                    userInfo.setPhone(request.getParameter("order.orderContact.belongsToInfo.phone"));
                    userInfo.setCountry(request.getParameter("order.orderContact.belongsToInfo.country"));
                    userInfo.setProvince(request.getParameter("order.orderContact.belongsToInfo.province"));
                    userInfo.setCity(request.getParameter("order.orderContact.belongsToInfo.city"));
                    userInfo.setCounty(request.getParameter("order.orderContact.belongsToInfo.county"));
                    userInfo.setAddress(request.getParameter("order.orderContact.belongsToInfo.address"));
                    userInfo.setPostalcode(request.getParameter("order.orderContact.belongsToInfo.postalcode"));
                    if (StringUtils.isNotBlank(request.getParameter("order.orderContact.belongsToInfo.birthday"))) {
                        userInfo.setBirthday(DateUtils.stringToDate(request
                                .getParameter("order.orderContact.belongsToInfo.birthday")));
                    }
                }
                UserInfoBean guranteeInfo = info.getGuaranteeInfo();
                if (null != guranteeInfo) {
                    guranteeInfo.setGender(Integer.valueOf(request
                            .getParameter("order.orderContact.guaranteeInfo.gender")));
                    guranteeInfo.setRelationship(request.getParameter("order.orderContact.guaranteeInfo.relationship"));
                    guranteeInfo.setLastName(request.getParameter("order.orderContact.guaranteeInfo.lastName"));
                    guranteeInfo.setName(request.getParameter("order.orderContact.guaranteeInfo.name"));
                    guranteeInfo.setNationality(request.getParameter("order.orderContact.guaranteeInfo.nationality"));
                    guranteeInfo.setEmail(request.getParameter("order.orderContact.guaranteeInfo.email"));
                    guranteeInfo.setQq(request.getParameter("order.orderContact.guaranteeInfo.qq"));
                    guranteeInfo.setWechat(request.getParameter("order.orderContact.guaranteeInfo.wechat"));
                    guranteeInfo.setPhone(request.getParameter("order.orderContact.guaranteeInfo.phone"));
                    guranteeInfo.setCountry(request.getParameter("order.orderContact.guaranteeInfo.country"));
                    guranteeInfo.setProvince(request.getParameter("order.orderContact.guaranteeInfo.province"));
                    guranteeInfo.setCity(request.getParameter("order.orderContact.guaranteeInfo.city"));
                    guranteeInfo.setCounty(request.getParameter("order.orderContact.guaranteeInfo.county"));
                    guranteeInfo.setAddress(request.getParameter("order.orderContact.guaranteeInfo.address"));
                    guranteeInfo.setPostalcode(request.getParameter("order.orderContact.guaranteeInfo.postalcode"));
                    if (StringUtils.isNotBlank(request.getParameter("order.orderContact.guaranteeInfo.birthday"))) {
                        guranteeInfo.setBirthday(DateUtils.stringToDate(request
                                .getParameter("order.orderContact.guaranteeInfo.birthday")));
                    }
                }
                UserInfoBean contactPersonInfo = info.getContactPersonInfo();
                if (null != guranteeInfo) {
                    contactPersonInfo.setGender(Integer.valueOf(request
                            .getParameter("order.orderContact.contactPersonInfo.gender")));
                    contactPersonInfo.setRelationship(request
                            .getParameter("order.orderContact.contactPersonInfo.relationship"));
                    contactPersonInfo
                            .setLastName(request.getParameter("order.orderContact.contactPersonInfo.lastName"));
                    contactPersonInfo.setName(request.getParameter("order.orderContact.contactPersonInfo.name"));
                    contactPersonInfo.setNationality(request
                            .getParameter("order.orderContact.contactPersonInfo.nationality"));
                    contactPersonInfo.setEmail(request.getParameter("order.orderContact.contactPersonInfo.email"));
                    contactPersonInfo.setQq(request.getParameter("order.orderContact.contactPersonInfo.qq"));
                    contactPersonInfo.setWechat(request.getParameter("order.orderContact.contactPersonInfo.wechat"));
                    contactPersonInfo.setPhone(request.getParameter("order.orderContact.contactPersonInfo.phone"));
                    contactPersonInfo.setCountry(request.getParameter("order.orderContact.contactPersonInfo.country"));
                    contactPersonInfo
                            .setProvince(request.getParameter("order.orderContact.contactPersonInfo.province"));
                    contactPersonInfo.setCity(request.getParameter("order.orderContact.contactPersonInfo.city"));
                    contactPersonInfo.setCounty(request.getParameter("order.orderContact.contactPersonInfo.county"));
                    contactPersonInfo.setAddress(request.getParameter("order.orderContact.contactPersonInfo.address"));
                    contactPersonInfo.setPostalcode(request
                            .getParameter("order.orderContact.contactPersonInfo.postalcode"));
                    if (StringUtils.isNotBlank(request.getParameter("order.orderContact.contactPersonInfo.birthday"))) {
                        contactPersonInfo.setBirthday(DateUtils.stringToDate(request
                                .getParameter("order.orderContact.contactPersonInfo.birthday")));
                    }
                }
                UserPreferBean userPrefer = ServletUtils.getUserPerferFromRequest(request);
                curOrder.getOrderContact().setPrefer(userPrefer);
                userService.saveUserInfo(curOrder.getOrderContact(), INFO_TYPE.CONTACT_PERSON_INFO);
                userService.saveUserInfo(curOrder.getOrderContact(), INFO_TYPE.GUARANTEE_INFO);
                userService.saveUserInfo(curOrder.getOrderContact(), INFO_TYPE.USER_INFO);
                userService.saveUserPrder(curOrder.getOrderContact());
            }
            if (StringUtils.isNotBlank(request.getParameter("price"))) {
                BigDecimal price = new BigDecimal(request.getParameter("price"));
                curOrder.setAmount(price);
                curOrder.getLineItems().get(0).setAmount(price);
                curOrder.getLineItems().get(0).setListPrice(price);
            }
            orderService.updateOrder(curOrder);
        }

        return "redirect:/admin/order/editDormitoryOrder.html?orderId=" + orderId;
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
            String operation = request.getParameter("operation");
            if (!StringUtils.isBlank(operation)) {
                order.setOrderStatus(operation);
            }
            orderService.updateOrder(order);
            // TODO send email
            if (!StringUtils.isBlank(operation)) {
                sendPickupOrder(order, operation);
            }
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
            final String userToken, final String dateFrom, final String dateTo, final String currentPage,
            final String pageSize) {
        OrderType type = OrderType.getType(orderType);// "D" means dormitory
        OrderSearchBean searchBean = new OrderSearchBean();
        searchBean.setOrderType(type);
        if (StringUtils.isNotBlank(login) || StringUtils.isNotBlank(userToken)) {
            UserBean user = new UserBean();
            if (StringUtils.isNotBlank(login)) {
                user.setLogin(login);
            }
            if (StringUtils.isNotBlank(userToken)) {
                user.setToken(userToken);
            }
            searchBean.setUser(user);
        }

        if (StringUtils.isBlank(orderId) || StringUtils.isNotBlank(OrderTokenUtil.getOrderId(orderId))) {
            if (StringUtils.isNotBlank(orderId)) {
                searchBean.setOrderNumber(Integer.valueOf(OrderTokenUtil.getOrderId(orderId)));
            }
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
        model.addAttribute("userToken", userToken);
        model.addAttribute("dateFrom", dateFrom);
        model.addAttribute("dateTo", dateTo);
        return "admin/order/orderList";
    }



    @RequestMapping(value = "/home.html")
    public String home(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {

        return "/home.html";
    }



    private void sendPickupOrder(final OrderBean order, final String operation) {
        String from = "pickup@liuxuelife.com";
        String fromAlias = EmailUtils.getServiceAlias();
        String login = "";
        if (null != order && null != order.getOrderContact() && null != order.getOrderContact().getBelongsToInfo()) {
            login = order.getOrderContact().getBelongsToInfo().getEmail();
        }
        PickupLineItem item = null;
        if (CollectionUtils.isNotEmpty(order.getLineItems())) {
            LineItem lineItem = order.getLineItems().get(0);
            if (lineItem instanceof PickupLineItem) {
                item = (PickupLineItem) lineItem;
            }
        }
        if ("REVIEWDE".equals(operation)) {

            // send template 4
            Map<String, String> paramMap = EmailUtils.getParamMap();
            paramMap.put("totalPrice", order.getAmount().toString());
            if (null != item) {
                paramMap.put("payLink", item.getPaymentUrl());
            } else {
                paramMap.put("payLink", "");
            }

            String subject = "请支付您的接机订单-留学生活网-您身边的留学生活专家";
            String template = EmailUtils.generateTemplateEmail("template4.html", paramMap);
            boolean sendSuccess = EmailUtils.sendEmail(from, fromAlias, login, login, subject, template);
        }
        if ("PAYMENT_DONE".equals(operation) || "PAYMENT_NOT_DONE".equals(operation)) {
            // send template 5
            Map<String, String> paramMap = EmailUtils.getParamMap();
            paramMap.put("orderId", OrderTokenUtil.getOrderToken(order.getId().toString(), "PU"));
            paramMap.put("userName", order.getOrderContact().getBelongsToInfo().getLastName() + " "
                    + order.getOrderContact().getBelongsToInfo().getName());
            paramMap.put("userToken", order.getBelongsTo().getNewCode());
            String gender = "";
            if (0 == order.getOrderContact().getBelongsToInfo().getGender()) {
                gender = "先生";
            }
            if (1 == order.getOrderContact().getBelongsToInfo().getGender()) {
                gender = "女士";
            }
            if (2 == order.getOrderContact().getBelongsToInfo().getGender()) {
                gender = "女士";
            }

            paramMap.put("gender", gender);
            if (null != item) {
                if (null != item.getTakeOffDate()) {
                    paramMap.put("takeoffTime", DateUtils.dateToString(item.getTakeOffDate(), "yyyy-MM-dd HH:mm"));
                } else {
                    paramMap.put("takeoffTime", "");
                }
                item.analyzeLuggage();
                String luggage = "";
                if (null != item.getLuggageSize1()) {
                    luggage += item.getLuggageSize1() + "寸X" + item.getLuggageAmount1() + "个";
                }
                if (null != item.getLuggageSize2()) {
                    luggage += item.getLuggageSize2() + "寸X" + item.getLuggageAmount2() + "个";
                }
                if (null != item.getLuggageSize3()) {
                    luggage += item.getLuggageSize3() + "寸X" + item.getLuggageAmount3() + "个";
                }

                if (null != item.getLuggageSize4()) {
                    luggage += item.getLuggageSize4() + "寸X" + item.getLuggageAmount4() + "个";
                }

                if (null != item.getLuggageSize5()) {
                    luggage += item.getLuggageSize5() + "寸X" + item.getLuggageAmount5() + "个";
                }

                paramMap.put("luggage", luggage);

                paramMap.put("landingCity", EmailUtils.getStringValue(item.getArrivalCity()));
                paramMap.put("landingAirport", EmailUtils.getStringValue(item.getArrivalAirport()));
                paramMap.put("pickup2City", EmailUtils.getStringValue(item.getPickup2City()));
                paramMap.put("dormitoryAddress", EmailUtils.getStringValue(item.getPickup2Address()));
                paramMap.put("postcode", EmailUtils.getStringValue(item.getPickup2Postalcode()));
                paramMap.put("takeoffCity", EmailUtils.getStringValue( item.getTakeOffCity()));
                paramMap.put("takeoffAirport", "");
                paramMap.put("toCity", EmailUtils.getStringValue( item.getArrivalCity()));
                
                
                paramMap.put("totalPrice", order.getAmount().toString());
                paramMap.put("orderStatus", "");
                paramMap.put("flightNum", item.getFlightNum());
                if (null != item.getPickupDate()) {
                    paramMap.put("arriveTime", DateUtils.dateToString(item.getPickupDate(), "yyyy-MM-dd HH:mm"));
                } else {
                    paramMap.put("arriveTime", "");
                }
                paramMap.put("toCity", EmailUtils.getStringValue(item.getPickup2City()));
                paramMap.put("toAirport", EmailUtils.getStringValue(item.getArrivalAirport()));

            }
            String subject = "您的接机车票（请打印后，在接机现场出示）-留学生活网-您身边的留学生活专家";
            String templateHtml = "template5.html";
            if ("PAYMENT_NOT_DONE".equals(operation)) {
                templateHtml = "template5_1.html";
            }
            String template = EmailUtils.generateTemplateEmail(templateHtml, paramMap);
            boolean sendSuccess = EmailUtils.sendEmail(from, fromAlias, login, login, subject, template);
        }
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
