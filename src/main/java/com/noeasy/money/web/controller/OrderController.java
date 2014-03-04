/*
 * This code is provided solely for the use of the licensee subject to the terms
 * and conditions of the Master Service Agreement. Redistribution and use in
 * source and binary forms, with or without modification, are prohibited.
 * 
 * DISCLAIMER.THIS SOFTWARE IS PROVIDED BY AAXIS GROUP CORPORATION "AS IS."
 * EXCEPT AS SPECIFICALLY SET FORTH IN THE MASTER SERVICES AGREEMENT, ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS, AND WARRANTIES INCLUDING,
 * WITHOUT LIMITATION, ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, NONINFRINGEMENT OR ARISING FROM A COURSE OF DEALING,
 * USAGE, OR TRADE PRACTICE, ARE HEREBY EXCLUDED TO THE EXTENT ALLOWED BY
 * APPLICABLE LAW.
 * 
 * IN NO EVENT WILL AAXIS GROUP CORPORATION, THE COPYRIGHT OWNER OR CONTRIBUTORS
 * BE LIABLE FOR ANY LOST REVENUE, PROFIT, OR DATA, OR FOR SPECIAL, INDIRECT,
 * CONSEQUENTIAL, INCIDENTAL, EXEMPLARY OR PUNITIVE DAMAGESINCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND REGARDLESS OF THE
 * THEORY OF LIABILITY ARISING OUT OF THE USE OF OR INABILITY TO USE THE
 * SOFTWARE EVEN IF AAXIS GROUP CORPORATION HAS BEEN ADVISED OF THE POSSIBILITY
 * OF SUCH DAMAGES.
 * 
 * IN NO EVENT SHALL AAXIS GROUP CORPORATION'S LIABILITY TO THE CUSTOMER OR USER
 * OF THIS SOFTWARE, WHETHER IN CONTRACT, TORT (INCLUDING NEGLIGENCE), OR
 * OTHERWISE, EXCEED THE PRICE PAID BY THE CUSTOMER OR USER FOR THIS SOFTWARE.
 * THE FOREGOING LIMITATIONS SHALL APPLY EVEN IF THE ANY WARRANTY PROVIDED IN
 * THE MASTER SERVICE AGREEMENT FAILS OF ITS ESSENTIAL PURPOSE.
 */
package com.noeasy.money.web.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noeasy.money.constant.Constants;
import com.noeasy.money.constant.SessionConstants;
import com.noeasy.money.enumeration.Operation;
import com.noeasy.money.enumeration.OrderStatus;
import com.noeasy.money.enumeration.OrderType;
import com.noeasy.money.enumeration.PickupType;
import com.noeasy.money.model.DormitoryBean;
import com.noeasy.money.model.DormitoryLineItem;
import com.noeasy.money.model.DormitorySearchBean;
import com.noeasy.money.model.LineItem;
import com.noeasy.money.model.OrderBean;
import com.noeasy.money.model.OrderContactInfo;
import com.noeasy.money.model.OrderTail;
import com.noeasy.money.model.PickupLineItem;
import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserSearchBean;
import com.noeasy.money.service.IDormitoryService;
import com.noeasy.money.service.INavigationService;
import com.noeasy.money.service.IOrderService;
import com.noeasy.money.service.IUserService;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Feb 7, 2014
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource(name = "orderService")
    IOrderService      orderService;

    @Resource(name = "userService")
    IUserService       userService;

    @Resource(name = "dormitoryService")
    IDormitoryService  dormitoryService;

    @Resource(name = "navigationService")
    INavigationService navigationService;



    @RequestMapping("/dormitory-order-place" + Constants.URL_SUFFIX)
    public String placeDormitoryOrder(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final UserBean user, final boolean orderFor) {
        DormitoryBean dormitory = (DormitoryBean) request.getSession().getAttribute("dormitory");
        if (dormitory != null) {
            OrderBean orderBean = new OrderBean();
            if (user.getId() == null || user.getId() <= 0) {
                user.setPassword(System.currentTimeMillis() + "");
                user.setLogin(user.getEmail());
                userService.saveOrUpdate(user);
                orderBean.setBelongsTo(user);
            } else {
                UserBean newLitigantUser = new UserBean();
                newLitigantUser.setName(request.getParameter("othername"));
                newLitigantUser.setGender(request.getParameter("othergender").equals("1"));
                newLitigantUser.setQq(request.getParameter("otherqq"));
                newLitigantUser.setPhone(request.getParameter("otherphone"));
                newLitigantUser.setAddress(request.getParameter("otheraddress"));
                if (StringUtils.isNoneBlank(request.getParameter("otherid")) || orderFor) {
                    newLitigantUser.setId(user.getId());
                    newLitigantUser.setLogin(user.getLogin());
                    newLitigantUser.setEmail(user.getEmail());
                } else {
                    newLitigantUser.setLogin(request.getParameter("otheremail"));
                    newLitigantUser.setEmail(request.getParameter("otheremail"));
                    newLitigantUser.setPassword(System.currentTimeMillis() + "");
                    userService.saveOrUpdate(newLitigantUser);
                }
                orderBean.setBelongsTo(newLitigantUser);
            }
            orderBean.setUser(user);

            OrderContactInfo contact = new OrderContactInfo();
            UserBean litigantUser = orderBean.getBelongsTo();
            contact.setName(litigantUser.getName());
            contact.setGender(litigantUser.isGender());
            contact.setPhone(litigantUser.getPhone());
            contact.setQQ(litigantUser.getQq());
            contact.setAddress(litigantUser.getAddress());
            orderBean.setOrderContact(contact);

            OrderTail createOrderRecord = new OrderTail();
            createOrderRecord.setOperation(Operation.CREATE);
            createOrderRecord.setOperator(user);
            List<OrderTail> orderRecords = new ArrayList<OrderTail>();
            orderRecords.add(createOrderRecord);
            orderBean.setTails(orderRecords);

            DormitoryLineItem dormitoryLineItem = new DormitoryLineItem();
            dormitoryLineItem.setDormitory(dormitory);
            dormitoryLineItem.setAmount(new BigDecimal(dormitory.getSalePrice()));
            dormitoryLineItem.setCurrency(dormitory.getCurrency());
            dormitoryLineItem.setListPrice(new BigDecimal(dormitory.getListPrice()));
            List<LineItem> lineItems = new ArrayList<LineItem>();
            lineItems.add(dormitoryLineItem);
            orderBean.setLineItems(lineItems);

            orderBean.setOrderType(OrderType.DORMITORY);
            orderBean.setAmount(new BigDecimal(dormitory.getSalePrice()));
            orderBean.setCurrency(dormitory.getCurrency());
            orderBean.setOrderStatus(OrderStatus.SENDING_CONTACT);

            boolean placeOrderResult = orderService.placeOrder(orderBean);
            model.addAttribute("result", placeOrderResult);
        }
        return "order/dormitory-order-place-result";
    }



    @RequestMapping("/pickup-order-place" + Constants.URL_SUFFIX)
    public String placePickupOrder(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final UserBean user, final boolean orderFor) throws ParseException {
        String flightNum = request.getParameter("flightNum");
        if (StringUtils.isNoneBlank(flightNum)) {
            Integer countryId = NumberUtils.toInt(request.getParameter("countryId"));
            Integer cityId = NumberUtils.toInt(request.getParameter("cityId"));
            List<Map<String, Object>> flights = navigationService.queryFlightByConditions(countryId, cityId, flightNum);
            PickupLineItem pickupLineItem = new PickupLineItem();
            pickupLineItem.setCityId(cityId);
            if (CollectionUtils.isNotEmpty(flights)) {
                pickupLineItem.setFlightNum(flights.get(0).get("flightNum").toString());
                pickupLineItem.setCityId(cityId);
                String pickupDateStr = request.getParameter("pickupDate");
                if (StringUtils.isNoneBlank(pickupDateStr)) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date pickupDate = dateFormat.parse(pickupDateStr);
                    pickupLineItem.setPickupDate(pickupDate);
                }
                pickupLineItem.setPickupType(PickupType.valueOf(request.getParameter("pickupType")));
                pickupLineItem.setLuggageAmount(NumberUtils.toInt(request.getParameter("luggageAmount")));
                pickupLineItem.setLuggageSize(NumberUtils.toDouble(request.getParameter("luggageSize")));
                pickupLineItem.setCurrency("USD");
                pickupLineItem.setAmount(new BigDecimal(0));

                OrderBean orderBean = new OrderBean();
                if (user.getId() == null || user.getId() <= 0) {
                    user.setPassword(System.currentTimeMillis() + "");
                    user.setLogin(user.getEmail());
                    userService.saveOrUpdate(user);
                    orderBean.setBelongsTo(user);
                } else {
                    UserBean newLitigantUser = new UserBean();
                    newLitigantUser.setName(request.getParameter("othername"));
                    newLitigantUser.setGender(request.getParameter("othergender").equals("1"));
                    newLitigantUser.setQq(request.getParameter("otherqq"));
                    newLitigantUser.setPhone(request.getParameter("otherphone"));
                    newLitigantUser.setAddress(request.getParameter("otheraddress"));
                    if (StringUtils.isNoneBlank(request.getParameter("otherid")) || orderFor) {
                        newLitigantUser.setId(user.getId());
                        newLitigantUser.setLogin(user.getLogin());
                        newLitigantUser.setEmail(user.getEmail());
                    } else {
                        newLitigantUser.setLogin(request.getParameter("otheremail"));
                        newLitigantUser.setEmail(request.getParameter("otheremail"));
                        newLitigantUser.setPassword(System.currentTimeMillis() + "");
                        userService.saveOrUpdate(newLitigantUser);
                    }
                    orderBean.setBelongsTo(newLitigantUser);
                }
                orderBean.setUser(user);

                OrderContactInfo contact = new OrderContactInfo();
                UserBean litigantUser = orderBean.getBelongsTo();
                contact.setName(litigantUser.getName());
                contact.setGender(litigantUser.isGender());
                contact.setPhone(litigantUser.getPhone());
                contact.setQQ(litigantUser.getQq());
                contact.setAddress(litigantUser.getAddress());
                orderBean.setOrderContact(contact);

                OrderTail createOrderRecord = new OrderTail();
                createOrderRecord.setOperation(Operation.CREATE);
                createOrderRecord.setOperator(user);
                List<OrderTail> orderRecords = new ArrayList<OrderTail>();
                orderRecords.add(createOrderRecord);
                orderBean.setTails(orderRecords);

                List<LineItem> lineItems = new ArrayList<LineItem>();
                lineItems.add(pickupLineItem);
                orderBean.setLineItems(lineItems);

                orderBean.setCurrency("CNY");
                orderBean.setAmount(new BigDecimal(0));
                orderBean.setOrderType(OrderType.PICKUP);
                orderBean.setOrderStatus(OrderStatus.SENDING_CONTACT);

                boolean placeOrderResult = orderService.placeOrder(orderBean);
                model.addAttribute("result", placeOrderResult);
            }
        }
        return "order/dormitory-order-place-result";
    }



    @RequestMapping("/dormitory-order-fill" + Constants.URL_SUFFIX)
    public String toDormitoryOrderFill(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final String dormitoryId) {
        if (StringUtils.isNoneBlank(dormitoryId)) {
            DormitorySearchBean dormitorySearchBean = new DormitorySearchBean();
            dormitorySearchBean.setId(NumberUtils.toInt(dormitoryId));
            DormitoryBean dormitory = dormitoryService.queryDormitory(dormitorySearchBean);

            Integer userId = (Integer) request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
            UserSearchBean userSearchBean = new UserSearchBean();
            userSearchBean.setId(userId != null ? userId : 0);

            List<UserBean> result = userService.queryUser(userSearchBean);
            if (CollectionUtils.isNotEmpty(result)) {
                UserBean user = result.get(0);

                model.addAttribute("user", user);
            }
            request.getSession().setAttribute("dormitory", dormitory);
        }
        return "order/dormitory-order-fill";
    }



    @RequestMapping("/pickup-order-fill" + Constants.URL_SUFFIX)
    public String toPickupOrderFill(final HttpServletRequest request, final HttpServletResponse response,
            final Model model) {
        Integer userId = (Integer) request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        UserSearchBean userSearchBean = new UserSearchBean();
        userSearchBean.setId(userId != null ? userId : 0);

        List<UserBean> result = userService.queryUser(userSearchBean);
        if (CollectionUtils.isNotEmpty(result)) {
            UserBean user = result.get(0);

            model.addAttribute("user", user);
        }

        List<Map<String, Object>> countries = navigationService.queryCountries();
        if (CollectionUtils.isNotEmpty(countries)) {
            Integer firstCountryId = (Integer) countries.get(0).get("id");
            List<Map<String, Object>> cities = navigationService.queryCities(firstCountryId);
            Integer firstCityId = NumberUtils.toInt(cities.get(0).get("id").toString());
            List<Map<String, Object>> flights = navigationService.queryFlightByConditions(firstCountryId, firstCityId,
                    null);

            model.addAttribute("countries", countries);
            model.addAttribute("cities", cities);
            model.addAttribute("flights", flights);
        }

        return "order/pickup-order-fill";
    }
}
