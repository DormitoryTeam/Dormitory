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
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noeasy.money.enumeration.Operation;
import com.noeasy.money.enumeration.OrderStatus;
import com.noeasy.money.enumeration.OrderType;
import com.noeasy.money.model.DormitoryBean;
import com.noeasy.money.model.DormitoryLineItem;
import com.noeasy.money.model.LineItem;
import com.noeasy.money.model.OrderBean;
import com.noeasy.money.model.OrderContactInfo;
import com.noeasy.money.model.OrderSearchBean;
import com.noeasy.money.model.OrderTail;
import com.noeasy.money.model.PageBean;
import com.noeasy.money.model.PickupLineItem;
import com.noeasy.money.model.UserBean;
import com.noeasy.money.service.IOrderService;
import com.noeasy.money.util.test.ReflectionUtils;

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
    IOrderService orderService;



    @RequestMapping("/unit-test/order")
    public String testOrder(final HttpServletRequest request, final HttpServletResponse response, final Model model,
            final String orderType) {
        if (StringUtils.isNoneBlank(orderType)) {
            UserBean user = new UserBean();
            user.setId(3);

            OrderBean ob = new OrderBean();
            ob.setUser(user);
            ob.setBelongsTo(user);
            ob.setAmount(new BigDecimal(500));
            String currency = "USD";
            ob.setCurrency(currency);
            ob.setOrderType(OrderType.valueOf(orderType));
            ob.setOrderStatus(OrderStatus.SENDING_CONTACT);

            OrderContactInfo oci = new OrderContactInfo();
            oci.setAddress("中和大道一段南 卡斯摩广场");
            oci.setGender(false);
            oci.setName("Zinder");
            oci.setPhone("1366666666");
            oci.setQQ("12345");

            ob.setOrderContact(oci);
            List<LineItem> li = new ArrayList<LineItem>();
            ob.setLineItems(li);
            if (OrderType.DORMITORY.equals(ob.getOrderType())) {
                DormitoryLineItem dli = new DormitoryLineItem();
                dli.setAmount(new BigDecimal(500));
                dli.setCurrency(currency);
                dli.setListPrice(new BigDecimal(500));
                DormitoryBean db = new DormitoryBean();
                db.setId(2);
                dli.setDormitory(db);
                li.add(dli);
            }

            if (OrderType.PICKUP.equals(ob.getOrderType())) {
                PickupLineItem pli = new PickupLineItem();
                pli.setAmount(new BigDecimal(500));
                pli.setCityId(1);
                pli.setCurrency(currency);
                pli.setFlightNum("PICK-UP007");
                pli.setLandingCity("London");
                pli.setListPrice(new BigDecimal(500));
                pli.setLuggageAmount(20);
                pli.setLuggageSize(0.2d);
                pli.setPickupType(2);
                pli.setPickupDate(new Date());
                li.add(pli);
            }

            OrderTail ot = new OrderTail();
            ot.setOperation(Operation.CREATE);
            ot.setOperator(user);
            ot.setOperationTime(new Date());

            List<OrderTail> otl = new ArrayList<OrderTail>();
            otl.add(ot);
            ob.setTails(otl);

            orderService.placeOrder(ob);

            OrderSearchBean osb = new OrderSearchBean();
            osb.setOrderNumber(ob.getId());
            osb.setOrderType(ob.getOrderType());
            List<OrderBean> orderList = orderService.queryOrder(osb);
            List<List<String>> result = new ArrayList<List<String>>();
            for (OrderBean bean : orderList) {
                result.add(ReflectionUtils.getFieldsValue(bean));
            }

            model.addAttribute("result", result);
        }

        OrderSearchBean osb = new OrderSearchBean();
        osb.setOrderType(OrderType.DORMITORY);
        PageBean pb = new PageBean();
        osb.setPageBean(pb);
        List<OrderBean> orderList = orderService.queryOrder(osb);
        List<List<String>> results = new ArrayList<List<String>>();
        for (OrderBean bean : orderList) {
            results.add(ReflectionUtils.getFieldsValue(bean));
        }

        model.addAttribute("results", results);
        return "order/order";
    }
}
