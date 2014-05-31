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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.noeasy.money.constant.Constants;
import com.noeasy.money.enumeration.OrderStatus;
import com.noeasy.money.enumeration.OrderType;
import com.noeasy.money.model.ContractType;
import com.noeasy.money.model.DormitoryBean;
import com.noeasy.money.model.DormitoryLineItem;
import com.noeasy.money.model.LineItem;
import com.noeasy.money.model.OrderBean;
import com.noeasy.money.model.OrderContactInfo;
import com.noeasy.money.model.PickupLineItem;
import com.noeasy.money.model.RoomInfoBean;
import com.noeasy.money.model.RoomPrice;
import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserInfoBean;
import com.noeasy.money.model.UserPreferBean;
import com.noeasy.money.service.IDormitoryService;
import com.noeasy.money.service.INavigationService;
import com.noeasy.money.service.IOrderService;
import com.noeasy.money.service.IUserService;
import com.noeasy.money.service.IUserService.INFO_TYPE;
import com.noeasy.money.util.DateUtils;
import com.noeasy.money.util.EmailUtils;
import com.noeasy.money.util.PropertiesUtils;
import com.noeasy.money.util.ServletUtils;

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



    private void ensureOrderSession(final HttpServletRequest pRequest, final Model model) {
        // 1. if no order in session
        // 1.1 if no orderId parameter, just create an new orderBean and set it
        // to session.
        // 1.2 if orderId is not blank, use id to find order and set it to
        // session.

        // 2. if has order in session
        // 2.1 if has orderId parameter and orderId neq order.id user id find
        // order and set it to session.
        String orderId = pRequest.getParameter(Constants.PARAM_ORDER_ID);
        OrderBean order = null;
        if (StringUtils.isNotBlank(orderId)) {
            Integer id = Integer.valueOf(orderId);
            if (isDormitoryOrder(pRequest)) {
                // Check placer and belongs to
                // check order status
                if (!ServletUtils.isLogin(pRequest)) {
                    throw new RuntimeException("Not login");
                }
                Integer userId = ServletUtils.getUserId(pRequest);
                order = orderService.findOrderById(id);
                if (!userId.equals(order.getUser().getId()) && !userId.equals(order.getBelongsTo().getId())) {
                    throw new RuntimeException("no authortication to view this order");
                }
                if (OrderStatus.REVIEWDE.getValue() <= order.getOrderType().getValue()) {
                    throw new RuntimeException("Order can not change.");
                }
                if (null != order) {
                    // FIXME check this line is need nor not.
                    model.addAttribute("user", order.getUser());
                    List<LineItem> items = order.getLineItems();
                    if (CollectionUtils.isNotEmpty(items)) {
                        DormitoryLineItem dormtiroyItem = (DormitoryLineItem) items.get(0);
                        if (null != dormtiroyItem) {
                            model.addAttribute("dormitory", dormtiroyItem.getDormitory());
                            model.addAttribute("roomInfo", dormtiroyItem.getRoomInfo());
                            if (null != dormtiroyItem.getContractType() && null != dormtiroyItem.getRoomInfo()) {
                                RoomPrice price = dormitoryService.findRoomPrice(dormtiroyItem.getRoomInfo().getId(),
                                        dormtiroyItem.getContractType().getId());
                                model.addAttribute("price", price);
                            }
                        }
                    }
                }
            } else {
                order = orderService.findPickupOrderById(id);
                PickupLineItem item = getPickupItemFromOrder(order);
                item.analyzeLuggage();
                model.addAttribute("item", item);
            }
            model.addAttribute("order", order);
        } else {
            // make sure use has one order.
            if (ServletUtils.isLogin(pRequest)) {
                Integer userId = ServletUtils.getUserId(pRequest);
                UserBean user = new UserBean();
                user.setId(userId);
                // boolean hasOrder = false;
                // if (isDormitoryOrder(pRequest)) {
                // hasOrder = orderService.hasOrder(user, OrderType.DORMITORY);
                // } else {
                // hasOrder = orderService.hasOrder(user, OrderType.PICKUP);
                // }
                // if (hasOrder) {
                // throw new RuntimeException("One user One order.");
                // }
            }

            order = new OrderBean();
            order.setOrderContact(new OrderContactInfo());
            order.setOrderStatus("INITIAL");
            maintainsOrderType(pRequest, order);

            maintainsOrderLineItem(pRequest, order, order.getOrderType());
            priceOrder(pRequest, order);

        }
        ServletUtils.setOrder2Session(pRequest, order);
    }



    private String[] getForwrdURLs(final HttpServletRequest request) {
        if (isDormitoryOrder(request)) {
            return new String[] { "order/userInfoForm", "order/preferForm", "order/guaranteeForm",
                    "order/contactPersonForm", "order/notesForm" };
        }
        return new String[] { "order/pickupUserInfoForm", "order/flightInfoForm", "order/destinationInfoForm",
                "order/luggageInfoForm" };
    }



    private PickupLineItem getPickupItemFromOrder(final OrderBean order) {
        if (null == order) {
            throw new RuntimeException("no order in session");
        }
        if (OrderType.PICKUP != order.getOrderType()) {
            throw new RuntimeException("not pick up order");
        }
        List<LineItem> items = order.getLineItems();
        if (CollectionUtils.isEmpty(items)) {
            throw new RuntimeException("not pick up item in order");
        }
        return (PickupLineItem) items.get(0);
    }



    private PickupLineItem getPickupItemFromSesssion(final HttpServletRequest pRequest) {
        OrderBean order = ServletUtils.getOrderFromSession(pRequest);
        return getPickupItemFromOrder(order);
    }



    private String[] getViewOrdeForwardURL(final HttpServletRequest request) {
        if (isDormitoryOrder(request)) {
            return new String[] { "order/display/userInfoForm", "order/display/preferForm",
                    "order/display/guaranteeForm", "order/display/contactPersonForm", "order/display/notesForm" };
        } else {
            return new String[] { "order/display/pickupUserInfoForm", "order/display/flightInfoForm",
                    "order/display/destinationInfoForm", "order/display/luggageInfoForm" };
        }
    }



    @RequestMapping("/hasOrder" + Constants.URL_SUFFIX)
    @ResponseBody
    public String hasOrder(final HttpServletRequest request, final HttpServletResponse response, final String login) {
        UserBean user = userService.findUserByLogin(login);
        // if (null != user) {
        // if (isDormitoryOrder(request)) {
        // if (orderService.hasOrder(user, OrderType.DORMITORY)) {
        // return "{\"result\": true}";
        // }
        // } else {
        // if (orderService.hasOrder(user, OrderType.PICKUP)) {
        // return "{\"result\": true}";
        // }
        // }
        // }
        return "{\"result\": false}";
    }



    private boolean isDormitoryOrder(final HttpServletRequest pRequest) {
        String orderTypeStr = pRequest.getParameter(Constants.PARMA_ORDER_TYPE);
        if (OrderType.PICKUP.toString().equalsIgnoreCase(orderTypeStr)) {
            return false;
        }
        return true;
    }



    private boolean isExpired(final HttpServletRequest pRequest) {
        OrderBean order = ServletUtils.getOrderFromSession(pRequest);
        return null == order;
    }



    private void maintainDestinationInfo(final HttpServletRequest pRequest) {
        PickupLineItem item = getPickupItemFromSesssion(pRequest);
        item.setPickup2City(pRequest.getParameter("pickup2City"));
        item.setPickup2Address(pRequest.getParameter("pickup2Address"));
        item.setPickup2Dormitory(pRequest.getParameter("pickup2Dormitory"));
        item.setPickup2Postalcode(pRequest.getParameter("pickup2Postalcode"));
        orderService.updateLineItem(ServletUtils.getOrderFromSession(pRequest));
    }



    private void maintainFlightInfo(final HttpServletRequest pRequest) {
        PickupLineItem item = getPickupItemFromSesssion(pRequest);
        String takeOffDateStr = pRequest.getParameter("takeOffDate");
        if (StringUtils.isNotBlank(takeOffDateStr)) {
            item.setTakeOffDate(DateUtils.stringToDate(takeOffDateStr));
        }
        item.setTakeOffCity(pRequest.getParameter("takeOffCity"));
        String pickupDateStr = pRequest.getParameter("pickupDate");
        if (StringUtils.isNotBlank(pickupDateStr)) {
            item.setPickupDate(DateUtils.stringToDate(pickupDateStr, "yyyy-MM-dd HH:mm"));
        }
        item.setArrivalCity(pRequest.getParameter("arrivalCity"));
        item.setArrivalCountry(pRequest.getParameter("arrivalCountry"));
        item.setArrivalAirport(pRequest.getParameter("arrivalAirport"));
        item.setFlightCompany(pRequest.getParameter("flightCompany"));
        item.setFlightNum(pRequest.getParameter("flightNumber"));
        orderService.updateLineItem(ServletUtils.getOrderFromSession(pRequest));

    }



    private void maintainLuggage(final HttpServletRequest pRequest) {
        PickupLineItem item = getPickupItemFromSesssion(pRequest);

        String luggageSizeStr = "";
        String luggageAmountStr = "";
        String luggageSize1 = pRequest.getParameter("luggageSize1");
        String luggageAmount1 = pRequest.getParameter("luggageAmount1");
        if (StringUtils.isNotBlank(luggageSize1) && StringUtils.isNotBlank(luggageAmount1)) {
            Double size = Double.valueOf(luggageSize1);
            Integer amount = Integer.valueOf(luggageAmount1);
            if (size > 0 && amount > 0) {
                luggageSizeStr += size.toString();
                luggageAmountStr += amount.toString();
            }
        }

        String luggageSize2 = pRequest.getParameter("luggageSize2");
        String luggageAmount2 = pRequest.getParameter("luggageAmount2");
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

        String luggageSize3 = pRequest.getParameter("luggageSize3");
        String luggageAmount3 = pRequest.getParameter("luggageAmount3");
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

        String luggageSize4 = pRequest.getParameter("luggageSize4");
        String luggageAmount4 = pRequest.getParameter("luggageAmount4");
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

        String luggageSize5 = pRequest.getParameter("luggageSize5");
        String luggageAmount5 = pRequest.getParameter("luggageAmount5");
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
        item.analyzeLuggage();
        orderService.updateLineItem(ServletUtils.getOrderFromSession(pRequest));
    }



    private void maintainsContactPersonInfo(final HttpServletRequest pRequest) {
        OrderBean order = ServletUtils.getOrderFromSession(pRequest);
        UserInfoBean info = ServletUtils.getUserInfoFromRequest(pRequest);
        order.getOrderContact().setContactPersonInfo(info);
        userService.saveUserInfo(order.getOrderContact(), INFO_TYPE.CONTACT_PERSON_INFO);
    }



    private void maintainSessionOrder(final HttpServletRequest pRequest, final Integer pStep) {
        if (isDormitoryOrder(pRequest)) {
            maitainSissionDormitoryOrder(pRequest, pStep);
        } else {
            maintainSessionPickUpOrder(pRequest, pStep);
        }

    }



    private void maintainSessionPickUpOrder(final HttpServletRequest pRequest, final Integer pStep) {
        switch (pStep) {
        case 0:
            // 1. persistance orderContact(persistence order, order contact,
            // lineItem)
            persistenceOrder(pRequest);
            // 2. maintain contact info.(userInfo)
            maintainsUserInfo(pRequest);
            // 3. maintain line item,placer and belongTo,
            maintainsOrder(pRequest);
            break;
        case 1:
            // flight
            maintainFlightInfo(pRequest);
            break;
        case 2:
            // destination
            maintainDestinationInfo(pRequest);
            break;
        case 3:
            maintainLuggage(pRequest);
            setOrderCommit(pRequest);
            sendPickupOrderCommitEmail(pRequest);
            break;
        }

    }



    private void maintainsGuaranteeInfo(final HttpServletRequest pRequest) {
        OrderBean order = ServletUtils.getOrderFromSession(pRequest);
        UserInfoBean info = ServletUtils.getUserInfoFromRequest(pRequest);
        order.getOrderContact().setGuaranteeInfo(info);
        userService.saveUserInfo(order.getOrderContact(), INFO_TYPE.GUARANTEE_INFO);
    }



    private void maintainsModel(final HttpServletRequest request, final Model model) {
        String orderType = request.getParameter("orderType");
        model.addAttribute("orderType", orderType);
        Integer userId = ServletUtils.getUserId(request);
        if (null != userId) {
            UserBean user = userService.findUserById(userId);
            model.addAttribute("user", user);
        }
        String dormitoryIdStr = request.getParameter(Constants.PARAM_DORMITORY_ID);
        if (StringUtils.isNotBlank(dormitoryIdStr)) {
            Integer dormitoryId = Integer.valueOf(dormitoryIdStr);
            DormitoryBean dormitory = dormitoryService.findDormitoryById(dormitoryId);
            model.addAttribute("dormitory", dormitory);
        }

        String roomInfoIdStr = request.getParameter(Constants.PARAM_ROOM_INFO_ID);
        if (StringUtils.isNotBlank(roomInfoIdStr)) {
            Integer roomInfoId = Integer.valueOf(roomInfoIdStr);
            RoomInfoBean roomInfo = dormitoryService.findRoomInfoById(roomInfoId);
            model.addAttribute("roomInfo", roomInfo);

            String contractIdStr = request.getParameter(Constants.PARAM_CONTRACT_ID);
            if (StringUtils.isNotBlank(contractIdStr)) {
                Integer contractId = Integer.valueOf(contractIdStr);
                RoomPrice price = dormitoryService.findRoomPrice(roomInfoId, contractId);
                model.addAttribute("price", price);
            }
        }
    }



    private void maintainsOrder(final HttpServletRequest pRequest) {
        OrderBean order = ServletUtils.getOrderFromSession(pRequest);
        OrderType orderType = order.getOrderType();
        // maintains order line item
        // maintainsOrderLineItem(pRequest, order, orderType);
        UserBean belongsTo = null;
        UserBean placer = null;
        String email = order.getOrderContact().getBelongsToInfo().getEmail();
        if (StringUtils.isBlank(email)) {
            throw new RuntimeException("email is blank");
        }
        if (ServletUtils.isLogin(pRequest)) {
            String login = ServletUtils.getLoign(pRequest);
            placer = userService.findUserByLogin(login);
            if (null == placer) {
                throw new RuntimeException("login in session not exist");
            }

            // only login allow to place an order for other person.
            if (email.equals(placer.getLogin())) {
                belongsTo = placer;
            } else {
                belongsTo = userService.findUserByLogin(email);
                if (null == belongsTo) {
                    belongsTo = userService.register(email, "");
                    // TODO send email.
                    // should not be here.
                }

            }

        } else {
            // anonymous user try to place an order
            // 1. use login to check user is already exist or not
            // 2. if not exist use email to create a new user, and use the new
            // user to place an order
            // 3. if exist, use the exist user to place an order
            UserBean user = userService.findUserByLogin(email);
            if (null == user) {
                String password = RandomStringUtils.randomAlphanumeric(8);
                user = userService.register(email, password);
                String from = EmailUtils.getServiceEmail();
                String fromAlias = EmailUtils.getServiceAlias();
                String subject = EmailUtils.getSubject();
                String domain = PropertiesUtils.getConfigurableProperty(Constants.CONFIG_PATH, Constants.CONFIG_DOMAIN);
                String context = PropertiesUtils.getConfigurableProperty(Constants.CONFIG_PATH,
                        Constants.CONFIG_CONTEXT);
                EmailUtils.sendEmail(from, fromAlias, email, email, subject, "你在留学生活注册了新用户， 用户名：" + email + " / 密码: "
                        + password + "请访问 www.liuxuelife.com 登录后修改密码。");
                // send email.
            }
            belongsTo = user;
            placer = user;
            // if (orderService.hasOrder(user, orderType)) {
            // if (!orderService.belongsTo(user, order)) {
            // throw new RuntimeException("One user One orde");
            // }
            // }
            ServletUtils.setUser2Session(pRequest, user);
            // TODO: rollback
        }
        order.setBelongsTo(belongsTo);
        order.setUser(placer);
        // create lineItem and related to order.
        orderService.updateLineItem(order);
        // update order(price, type, belongsTo, user)
        orderService.updateOrder(order);
    }



    private void maintainsOrderLineItem(final HttpServletRequest pRequest, final OrderBean order,
            final OrderType orderType) {
        List<LineItem> lineItems = new ArrayList<LineItem>();
        order.setLineItems(lineItems);
        LineItem item = null;
        if (OrderType.DORMITORY == order.getOrderType()) {
            item = new DormitoryLineItem();
        } else {
            item = new PickupLineItem();
        }
        order.getLineItems().add(item);

        List<LineItem> items = order.getLineItems();
        if (CollectionUtils.isEmpty(items)) {
            throw new RuntimeException("no line item on order.");
        }
        // item = items.get(0);
        item.setOrderId(order.getId());
        // collection item information
        if (orderType == OrderType.DORMITORY) {
            // (room_info, contract, dormitory).

            // dormitory
            DormitoryLineItem dormitoryItem = (DormitoryLineItem) item;
            String dormitoryIdStr = pRequest.getParameter(Constants.PARAM_DORMITORY_ID);
            if (StringUtils.isBlank(dormitoryIdStr)) {
                throw new RuntimeException("dormitoryId is blank.");
            }
            DormitoryBean dormitory = dormitoryService.findDormitoryById(Integer.valueOf(dormitoryIdStr));
            dormitoryItem.setDormitory(dormitory);

            // contract
            String contractIdStr = pRequest.getParameter(Constants.PARAM_CONTRACT_ID);
            if (StringUtils.isBlank(contractIdStr)) {
                throw new RuntimeException("contractId is blank");
            }
            ContractType contractType = dormitoryService.findContractTypeById(Integer.valueOf(contractIdStr));
            dormitoryItem.setContractType(contractType);

            // roomInfo
            String roomInfoIdStr = pRequest.getParameter(Constants.PARAM_ROOM_INFO_ID);
            if (StringUtils.isBlank(roomInfoIdStr)) {
                throw new RuntimeException("roomInfoId is blank");
            }
            RoomInfoBean roomInfo = dormitoryService.findRoomInfoById(Integer.valueOf(roomInfoIdStr));
            dormitoryItem.setRoomInfo(roomInfo);

        } else {
            PickupLineItem pickupItem = (PickupLineItem) item;
            String countryId = pRequest.getParameter("countryId");
            String airprotId = pRequest.getParameter("airportId");
            if (StringUtils.isNotBlank(countryId)) {
                Map<String, Object> country = navigationService.queryCountryById(Integer.valueOf(countryId));
                if (null != country) {
                    pickupItem.setArrivalCountry((String) country.get("name"));
                }
            }
            if (StringUtils.isNotBlank(airprotId)) {
                Map<String, Object> airport = navigationService.queryAirprotById(Integer.valueOf(airprotId));
                if (null != airport) {
                    pickupItem.setArrivalAirport((String) airport.get("name"));
                }
            }
        }
    }



    private OrderType maintainsOrderType(final HttpServletRequest pRequest, final OrderBean order) {

        OrderType orderType = OrderType.DORMITORY;
        if (!isDormitoryOrder(pRequest)) {
            orderType = OrderType.PICKUP;
        }
        order.setOrderType(orderType);
        return orderType;
    }



    private void maintainsPrefer(final HttpServletRequest pRequest) {
        OrderBean order = ServletUtils.getOrderFromSession(pRequest);
        UserPreferBean userPrefer = ServletUtils.getUserPerferFromRequest(pRequest);
        order.getOrderContact().setPrefer(userPrefer);
        userService.saveUserPrder(order.getOrderContact());
    }



    private void maintainsUserInfo(final HttpServletRequest pRequest) {
        OrderBean order = ServletUtils.getOrderFromSession(pRequest);
        UserInfoBean info = ServletUtils.getUserInfoFromRequest(pRequest);
        order.getOrderContact().setBelongsToInfo(info);
        userService.saveUserInfo(order.getOrderContact(), INFO_TYPE.USER_INFO);
    }



    private void maitainSissionDormitoryOrder(final HttpServletRequest pRequest, final int step) {

        switch (step) {
        case 0:
            // 1. persistance orderContact(persistence order, order contact,
            // lineItem)
            persistenceOrder(pRequest);
            // 2. maintain contact info.(userInfo)
            maintainsUserInfo(pRequest);
            // 3. maintain order type, line item,placer and belongTo,
            maintainsOrder(pRequest);

            break;
        case 1:
            // 1. check session expired.
            isExpired(pRequest);
            // 2. maintain prefer.
            maintainsPrefer(pRequest);
            break;
        case 2:
            // 1. check session expired.
            isExpired(pRequest);
            // 2. maintain contact info(guaranteeInfo)
            maintainsGuaranteeInfo(pRequest);
            break;
        case 3:
            // 1. check session expired.
            isExpired(pRequest);
            // 2. maintain contact info(contactPersonInfo)
            maintainsContactPersonInfo(pRequest);
            break;
        case 4:
            // 1. check session expired.
            isExpired(pRequest);
            // 2. maintain prefer.
            maintainsPrefer(pRequest);
            setOrderCommit(pRequest);
            break;
        default:
            break;
        }
    }



    private void persistenceOrder(final HttpServletRequest pRequest) {
        OrderBean order = ServletUtils.getOrderFromSession(pRequest);
        if (null == order) {
            throw new RuntimeException("order is null in orderBean");
        }
        if (null == order.getId()) {
            orderService.createOrder(order);
        }

    }



    @RequestMapping("/dormitory-place-order" + Constants.URL_SUFFIX)
    public String placeOrder(final HttpServletRequest request, final HttpServletResponse response, final Model model) {
        String[] forwrdURLs = getForwrdURLs(request);
        int maxStep = forwrdURLs.length - 1;
        String pageStep = request.getParameter(Constants.PARAM_PAGE_STEP);
        Integer step = Integer.valueOf(0);
        if (StringUtils.isNotBlank(pageStep)) {
            step = Integer.valueOf(pageStep);
            if (step < 0) {
                step = Integer.valueOf(0);
            }
            if (step > maxStep) {
                step = Integer.valueOf(maxStep);
            }
        }
        maintainsModel(request, model);
        if (ServletUtils.isGet(request)) {
            switch (step) {
            case 0:
                ensureOrderSession(request, model);
                break;
            default:
                if (isExpired(request)) {
                    // TODO: message
                    return forwrdURLs[0];
                }
                break;
            }
            OrderBean order = ServletUtils.getOrderFromSession(request);
            model.addAttribute("order", order);
            if (OrderType.PICKUP == order.getOrderType()) {
                model.addAttribute("item", getPickupItemFromSesssion(request));
            }
            return forwrdURLs[step];
        } else {
            OrderBean order = ServletUtils.getOrderFromSession(request);
            model.addAttribute("order", order);
            if (OrderType.PICKUP == order.getOrderType()) {
                model.addAttribute("item", getPickupItemFromSesssion(request));
            }
            String command = request.getParameter(Constants.PARAM_COMMAND);
            if (Constants.PARAM_VALUE_COMMAND_SAVE.equalsIgnoreCase(command)) {
                if (null == order) {
                    // TODO: session expired. redirect to place order page. show
                    // error message.
                    return "";
                }
                maintainSessionOrder(request, step);

                return forwrdURLs[step];
            } else {
                maintainSessionOrder(request, step);
                if (step + 1 > maxStep) {
                    if (isDormitoryOrder(request)) {
                        return "order/dormtiroyOrderSuccess";
                    } else {
                        return "order/pickupOrderSuccess";
                    }
                }
                return forwrdURLs[step + 1];
            }
        }
    }



    private void priceOrder(final HttpServletRequest pRequest, final OrderBean pOrder) {
        if (OrderType.DORMITORY == pOrder.getOrderType()) {
            DormitoryLineItem dormitoryItem = (DormitoryLineItem) pOrder.getLineItems().get(0);
            RoomPrice price = dormitoryService.findRoomPrice(dormitoryItem.getRoomInfo().getId(), dormitoryItem
                    .getContractType().getId());
            DormitoryBean dormitory = dormitoryItem.getDormitory();
            BigDecimal amount = null;
            if (-1 == price.getSalePrice() || -1 == dormitory.getAdditionalPrice()) {
                amount = new BigDecimal("-1");
            } else {
                amount = new BigDecimal(price.getSalePrice());
                amount = amount.add(new BigDecimal(dormitory.getAdditionalPrice()));
            }

            dormitoryItem.setAmount(amount);
            // week price
            dormitoryItem.setListPrice(new BigDecimal(price.getWeekPrice()));
            // FIXME: get currentcy from price, if needed
            dormitoryItem.setCurrency("GBP");
            pOrder.setAmount(amount);
            pOrder.setCurrency("GBP");
        } else {
            // FIXME: change default price, if needed
            PickupLineItem pickupItem = (PickupLineItem) pOrder.getLineItems().get(0);
            pickupItem.setAmount(new BigDecimal("0.00"));
            pickupItem.setListPrice(new BigDecimal("0.00"));
            pickupItem.setCurrency("CNY");
            pOrder.setAmount(new BigDecimal("0.00"));
            pOrder.setCurrency("CNY");
        }

    }



    private void sendPickupOrderCommitEmail(final HttpServletRequest pRequest) {
        Map<String, String> paramMap = EmailUtils.getParamMap();
        OrderBean order = ServletUtils.getOrderFromSession(pRequest);
        PickupLineItem pickupLineItem = new PickupLineItem();
        if (order.getLineItems().get(0) instanceof PickupLineItem) {
            pickupLineItem = (PickupLineItem) order.getLineItems().get(0);
        }
        UserInfoBean userInfo = ServletUtils.getUserInfoFromRequest(pRequest);
        String login = ServletUtils.getLoign(pRequest);

        paramMap.put("orderId", String.valueOf(order.getId()));
        paramMap.put("userName", userInfo.getName() == null ? "" : userInfo.getName());
        paramMap.put("userToken", "???");

        paramMap.put("address", userInfo.getAddress() == null ? "" : userInfo.getAddress());
        paramMap.put("phone", "???");
        paramMap.put("telephone", userInfo.getPhone() == null ? "" : userInfo.getPhone());
        paramMap.put("email", login);
        paramMap.put("dormitoryName", pickupLineItem.getPickup2Dormitory());
        paramMap.put("dormitoryAddress", pickupLineItem.getPickup2Address());
        paramMap.put("postcode", pickupLineItem.getPickup2Postalcode());
        paramMap.put("flightCompany", pickupLineItem.getFlightCompany());
        paramMap.put("flightNum", pickupLineItem.getFlightNum());
        paramMap.put("startTime", DateUtils.dateToString(pickupLineItem.getTakeOffDate()));
        paramMap.put("transferTime", "???");
        paramMap.put("arriveTime",
                DateUtils.dateToString(pickupLineItem.getPickupDate(), DateUtils.DATE_TIME_FORAMT_RULE));
        paramMap.put("comment", "???");
        paramMap.put("city", pickupLineItem.getArrivalCity());

        String from = EmailUtils.getServiceEmail();
        String fromAlias = EmailUtils.getServiceAlias();
        String subject = EmailUtils.getSubject();
        String template = EmailUtils.generateTemplateEmail("template10.html", paramMap);
        boolean sendSuccess = EmailUtils.sendEmail(from, fromAlias, login, login, subject, template);
    }



    private void setOrderCommit(final HttpServletRequest pRequest) {
        OrderBean order = ServletUtils.getOrderFromSession(pRequest);
        if (null == order) {
            throw new RuntimeException("order is null in orderBean");
        }
        orderService.updateOrderStatus(order.getId(), "COMMIT");
    }



    @RequestMapping("/view-order" + Constants.URL_SUFFIX)
    public String viewOrder(final HttpServletRequest request, final HttpServletResponse response, final Model model) {
        if (!ServletUtils.isLogin(request)) {
            throw new RuntimeException("User not login");
        }
        String[] forwrdURLs = getViewOrdeForwardURL(request);
        int maxStep = forwrdURLs.length - 1;
        String pageStep = request.getParameter(Constants.PARAM_PAGE_STEP);
        Integer step = Integer.valueOf(0);
        if (StringUtils.isNotBlank(pageStep)) {
            step = Integer.valueOf(pageStep);
            if (step < 0) {
                step = Integer.valueOf(0);
            }
            if (step > maxStep) {
                step = Integer.valueOf(maxStep);
            }
        }
        String orderId = request.getParameter(Constants.PARAM_ORDER_ID);
        if (StringUtils.isBlank(orderId)) {
            throw new IllegalArgumentException("orderId is blank");
        }
        Integer id = Integer.valueOf(orderId);
        OrderBean order = null;
        if (isDormitoryOrder(request)) {
            order = orderService.findOrderById(Integer.valueOf(orderId));
        } else {
            order = orderService.findPickupOrderById(id);
        }
        if (null == order) {
            throw new RuntimeException("No order find. orderId: " + orderId);
        }
        Integer userId = ServletUtils.getUserId(request);
        if (!userId.equals(order.getUser().getId()) && !userId.equals(order.getBelongsTo().getId())) {
            throw new RuntimeException("no authortication to view this order");
        }
        LineItem item = null;
        if (CollectionUtils.isNotEmpty(order.getLineItems())) {
            item = order.getLineItems().get(0);
        }
        if (item instanceof PickupLineItem) {
            ((PickupLineItem) item).analyzeLuggage();
        }
        model.addAttribute("item", item);
        model.addAttribute("order", order);
        return forwrdURLs[step];
    }

    // @RequestMapping("/dormitory-order-place" + Constants.URL_SUFFIX)
    // public String placeDormitoryOrder(final HttpServletRequest request, final
    // HttpServletResponse response,
    // final Model model, final UserBean user, final boolean orderFor) {
    // DormitoryBean dormitory = (DormitoryBean)
    // request.getSession().getAttribute("dormitory");
    // if (dormitory != null) {
    // OrderBean orderBean = new OrderBean();
    // if (user.getId() == null || user.getId() <= 0) {
    // user.setPassword(System.currentTimeMillis() + "");
    // user.setLogin(user.getEmail());
    // userService.saveOrUpdate(user);
    // orderBean.setBelongsTo(user);
    // } else {
    // UserBean newLitigantUser = new UserBean();
    // // newLitigantUser.setName(request.getParameter("othername"));
    // //
    // newLitigantUser.setGender(request.getParameter("othergender").equals("1"));
    // // newLitigantUser.setQq(request.getParameter("otherqq"));
    // // newLitigantUser.setPhone(request.getParameter("otherphone"));
    // // newLitigantUser.setAddress(request.getParameter("otheraddress"));
    // if (StringUtils.isNoneBlank(request.getParameter("otherid")) || orderFor)
    // {
    // newLitigantUser.setId(user.getId());
    // newLitigantUser.setLogin(user.getLogin());
    // newLitigantUser.setEmail(user.getEmail());
    // } else {
    // newLitigantUser.setLogin(request.getParameter("otheremail"));
    // newLitigantUser.setEmail(request.getParameter("otheremail"));
    // newLitigantUser.setPassword(System.currentTimeMillis() + "");
    // userService.saveOrUpdate(newLitigantUser);
    // }
    // orderBean.setBelongsTo(newLitigantUser);
    // }
    // orderBean.setUser(user);
    //
    // OrderContactInfo contact = new OrderContactInfo();
    // UserBean litigantUser = orderBean.getBelongsTo();
    // // contact.setName(litigantUser.getName());
    // // contact.setGender(litigantUser.isGender());
    // // contact.setPhone(litigantUser.getPhone());
    // // contact.setQQ(litigantUser.getQq());
    // // contact.setAddress(litigantUser.getAddress());
    // orderBean.setOrderContact(contact);
    //
    // OrderTail createOrderRecord = new OrderTail();
    // createOrderRecord.setOperation(Operation.CREATE);
    // createOrderRecord.setOperator(user);
    // List<OrderTail> orderRecords = new ArrayList<OrderTail>();
    // orderRecords.add(createOrderRecord);
    // orderBean.setTails(orderRecords);
    //
    // DormitoryLineItem dormitoryLineItem = new DormitoryLineItem();
    // dormitoryLineItem.setDormitory(dormitory);
    // dormitoryLineItem.setAmount(new BigDecimal(dormitory.getSalePrice()));
    // dormitoryLineItem.setCurrency(dormitory.getCurrency());
    // dormitoryLineItem.setListPrice(new BigDecimal(dormitory.getWeekPrice()));
    // List<LineItem> lineItems = new ArrayList<LineItem>();
    // lineItems.add(dormitoryLineItem);
    // orderBean.setLineItems(lineItems);
    //
    // orderBean.setOrderType(OrderType.DORMITORY);
    // orderBean.setAmount(new BigDecimal(dormitory.getSalePrice()));
    // orderBean.setCurrency(dormitory.getCurrency());
    // orderBean.setOrderStatus(OrderStatus.COMMIT);
    //
    // boolean placeOrderResult = orderService.placeOrder(orderBean);
    // model.addAttribute("result", placeOrderResult);
    // }
    // return "order/dormitory-order-place-result";
    // }
    //
    //
    //
    // @RequestMapping("/pickup-order-place" + Constants.URL_SUFFIX)
    // public String placePickupOrder(final HttpServletRequest request, final
    // HttpServletResponse response,
    // final Model model, final UserBean user, final boolean orderFor) throws
    // ParseException {
    // String flightNum = request.getParameter("flightNum");
    // if (StringUtils.isNoneBlank(flightNum)) {
    // Integer countryId = NumberUtils.toInt(request.getParameter("countryId"));
    // Integer cityId = NumberUtils.toInt(request.getParameter("cityId"));
    // List<Map<String, Object>> flights =
    // navigationService.queryFlightByConditions(countryId, cityId, flightNum);
    // PickupLineItem pickupLineItem = new PickupLineItem();
    // pickupLineItem.setCityId(cityId);
    // if (CollectionUtils.isNotEmpty(flights)) {
    // pickupLineItem.setFlightNum(flights.get(0).get("flightNum").toString());
    // pickupLineItem.setCityId(cityId);
    // String pickupDateStr = request.getParameter("pickupDate");
    // if (StringUtils.isNoneBlank(pickupDateStr)) {
    // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // Date pickupDate = dateFormat.parse(pickupDateStr);
    // pickupLineItem.setPickupDate(pickupDate);
    // }
    // pickupLineItem.setPickupType(PickupType.valueOf(request.getParameter("pickupType")));
    // pickupLineItem.setLuggageAmount(NumberUtils.toInt(request.getParameter("luggageAmount")));
    // pickupLineItem.setLuggageSize(NumberUtils.toDouble(request.getParameter("luggageSize")));
    // pickupLineItem.setCurrency("USD");
    // pickupLineItem.setAmount(new BigDecimal(0));
    //
    // OrderBean orderBean = new OrderBean();
    // if (user.getId() == null || user.getId() <= 0) {
    // user.setPassword(System.currentTimeMillis() + "");
    // user.setLogin(user.getEmail());
    // userService.saveOrUpdate(user);
    // orderBean.setBelongsTo(user);
    // } else {
    // UserBean newLitigantUser = new UserBean();
    // // newLitigantUser.setName(request.getParameter("othername"));
    // //
    // newLitigantUser.setGender(request.getParameter("othergender").equals("1"));
    // // newLitigantUser.setQq(request.getParameter("otherqq"));
    // // newLitigantUser.setPhone(request.getParameter("otherphone"));
    // // newLitigantUser.setAddress(request.getParameter("otheraddress"));
    // if (StringUtils.isNoneBlank(request.getParameter("otherid")) || orderFor)
    // {
    // newLitigantUser.setId(user.getId());
    // newLitigantUser.setLogin(user.getLogin());
    // newLitigantUser.setEmail(user.getEmail());
    // } else {
    // newLitigantUser.setLogin(request.getParameter("otheremail"));
    // newLitigantUser.setEmail(request.getParameter("otheremail"));
    // newLitigantUser.setPassword(System.currentTimeMillis() + "");
    // userService.saveOrUpdate(newLitigantUser);
    // }
    // orderBean.setBelongsTo(newLitigantUser);
    // }
    // orderBean.setUser(user);
    //
    // OrderContactInfo contact = new OrderContactInfo();
    // UserBean litigantUser = orderBean.getBelongsTo();
    // // contact.setName(litigantUser.getName());
    // // contact.setGender(litigantUser.isGender());
    // // contact.setPhone(litigantUser.getPhone());
    // // contact.setQQ(litigantUser.getQq());
    // // contact.setAddress(litigantUser.getAddress());
    // orderBean.setOrderContact(contact);
    //
    // OrderTail createOrderRecord = new OrderTail();
    // createOrderRecord.setOperation(Operation.CREATE);
    // createOrderRecord.setOperator(user);
    // List<OrderTail> orderRecords = new ArrayList<OrderTail>();
    // orderRecords.add(createOrderRecord);
    // orderBean.setTails(orderRecords);
    //
    // List<LineItem> lineItems = new ArrayList<LineItem>();
    // lineItems.add(pickupLineItem);
    // orderBean.setLineItems(lineItems);
    //
    // orderBean.setCurrency("CNY");
    // orderBean.setAmount(new BigDecimal(0));
    // orderBean.setOrderType(OrderType.PICKUP);
    // orderBean.setOrderStatus(OrderStatus.COMMIT);
    //
    // boolean placeOrderResult = orderService.placeOrder(orderBean);
    // model.addAttribute("result", placeOrderResult);
    // }
    // }
    // return "order/dormitory-order-place-result";
    // }

    // @RequestMapping("/dormitory-order-fill" + Constants.URL_SUFFIX)
    // public String toDormitoryOrderFill(final HttpServletRequest request,
    // final HttpServletResponse response,
    // final Model model, final String dormitoryId) {
    // if (StringUtils.isNoneBlank(dormitoryId)) {
    // DormitorySearchBean dormitorySearchBean = new DormitorySearchBean();
    // dormitorySearchBean.setId(NumberUtils.toInt(dormitoryId));
    // DormitoryBean dormitory =
    // dormitoryService.queryDormitory(dormitorySearchBean);
    //
    // Integer userId = (Integer)
    // request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
    // UserSearchBean userSearchBean = new UserSearchBean();
    // userSearchBean.setId(userId != null ? userId : 0);
    //
    // List<UserBean> result = userService.queryUser(userSearchBean);
    // if (CollectionUtils.isNotEmpty(result)) {
    // UserBean user = result.get(0);
    //
    // model.addAttribute("user", user);
    // }
    // request.getSession().setAttribute("dormitory", dormitory);
    // }
    // return "order/dormitory-order-fill";
    // }
    //
    //
    //
    // @RequestMapping("/pickup-order-fill" + Constants.URL_SUFFIX)
    // public String toPickupOrderFill(final HttpServletRequest request, final
    // HttpServletResponse response,
    // final Model model) {
    // Integer userId = (Integer)
    // request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
    // UserSearchBean userSearchBean = new UserSearchBean();
    // userSearchBean.setId(userId != null ? userId : 0);
    //
    // List<UserBean> result = userService.queryUser(userSearchBean);
    // if (CollectionUtils.isNotEmpty(result)) {
    // UserBean user = result.get(0);
    //
    // model.addAttribute("user", user);
    // }
    //
    // List<Map<String, Object>> countries = navigationService.queryCountries();
    // if (CollectionUtils.isNotEmpty(countries)) {
    // Integer firstCountryId = (Integer) countries.get(0).get("id");
    // List<Map<String, Object>> cities =
    // navigationService.queryCities(firstCountryId);
    // Integer firstCityId =
    // NumberUtils.toInt(cities.get(0).get("id").toString());
    // List<Map<String, Object>> flights =
    // navigationService.queryFlightByConditions(firstCountryId, firstCityId,
    // null);
    //
    // model.addAttribute("countries", countries);
    // model.addAttribute("cities", cities);
    // model.addAttribute("flights", flights);
    // }
    //
    // return "order/pickup-order-fill";
    // }

}
