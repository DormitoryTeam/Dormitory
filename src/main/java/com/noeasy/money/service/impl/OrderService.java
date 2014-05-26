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
package com.noeasy.money.service.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.noeasy.money.enumeration.OrderStatus;
import com.noeasy.money.enumeration.OrderType;
import com.noeasy.money.model.DormitoryLineItem;
import com.noeasy.money.model.LineItem;
import com.noeasy.money.model.OrderBean;
import com.noeasy.money.model.OrderContactInfo;
import com.noeasy.money.model.OrderSearchBean;
import com.noeasy.money.model.PickupLineItem;
import com.noeasy.money.model.UserBean;
import com.noeasy.money.repository.IDormitoryRepository;
import com.noeasy.money.repository.IOrderRepository;
import com.noeasy.money.service.IOrderService;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 28, 2014
 */
@Service(value = "orderService")
public class OrderService implements IOrderService {

    @Resource(name = "orderRepository")
    private IOrderRepository orderRepository;
    
    private IDormitoryRepository dormitoryRepository;



    /**
     * @see com.noeasy.money.service.IOrderService#placeOrder(com.noeasy.money.model.OrderBean)
     */
    @Override
    public boolean placeOrder(final OrderBean pOrderBean) {
        boolean saveResult = false;

        saveResult = orderRepository.placeOrder(pOrderBean);
        return saveResult;
    }



    /**
     * @see com.noeasy.money.service.IOrderService#queryOrder(com.noeasy.money.model.OrderSearchBean)
     */
    @Override
    public List<OrderBean> queryOrder(final OrderSearchBean pOrderSearchBean) {
        List<OrderBean> queryResult = Collections.emptyList();
        if (pOrderSearchBean.getOrderType().equals(OrderType.DORMITORY)) {
            queryResult = orderRepository.queryDormitoryOrderPage(pOrderSearchBean);
        } else if (pOrderSearchBean.getOrderType().equals(OrderType.PICKUP)) {
            queryResult = orderRepository.queryPickupOrderPage(pOrderSearchBean);
        }
        return queryResult;
    }



    @Override
    public OrderBean queryOrder(Integer pOrderId, OrderType pType) {
        OrderSearchBean searchBean = new OrderSearchBean();
        searchBean.setOrderNumber(Integer.valueOf(pOrderId));
        searchBean.setOrderType(pType);
        List<OrderBean> orders = queryOrder(searchBean);
        if (CollectionUtils.isNotEmpty(orders)) {
            return orders.get(0);
        }
        return null;
    }



    @Override
    public OrderStatus getNextStatus(Integer pOrderId, OrderType pType) {
//        OrderBean order = queryOrder(pOrderId, pType);
//        if (null != order && null != order.getOrderStatus()) {
//            return order.getOrderStatus().getNextStatus();
//        }
        return null;
    }



    @Override
    public int updateOrderStatus(Integer pOrderId, String pStatus) {
        return orderRepository.updateOrderStatus(pOrderId, pStatus);

    }



    @Override
    public int updateOrderPrice(OrderBean order) {
        return orderRepository.updateOrderPrice(order);

    }



    @Override
    public int queryOrderCount(OrderSearchBean pSearchBean) {
        if (pSearchBean.getOrderType().equals(OrderType.DORMITORY)) {
            return orderRepository.queryDormitoryOrderCount(pSearchBean);
        } else if (pSearchBean.getOrderType().equals(OrderType.PICKUP)) {
            return orderRepository.queryPickupOrderCount(pSearchBean);
        }
        return 0;
    }



    @Override
    public OrderBean findOrderById(Integer id) {
        return orderRepository.findOrderById(id);
    }



    @Override
    public void createOrder(OrderBean pOrder) {
        // create Order
        orderRepository.saveOrder(pOrder);
        OrderContactInfo contactInfo = pOrder.getOrderContact();
        contactInfo.setOrderId(pOrder.getId());
        // create orderContact and related to order
        orderRepository.saveOrderContactInfo(contactInfo);
        List<LineItem> items = pOrder.getLineItems();
        if (CollectionUtils.isEmpty(items)) {
            throw new RuntimeException("no line item on order.");
        }
        LineItem item = items.get(0);
        item.setOrderId(pOrder.getId());
        if (OrderType.DORMITORY == pOrder.getOrderType()) {
            orderRepository.saveDormitoryLineItem(item);
        } else {
            orderRepository.savePickupLineItem(item);
        }
    }



    @Override
    public void updateOrder(OrderBean pOrder) {
        List<LineItem> items = pOrder.getLineItems();
        BigDecimal amount = new BigDecimal("0.00");
        BigDecimal listPrice = new BigDecimal("0.00");
        if(CollectionUtils.isNotEmpty(items)) {
            for (LineItem item : items) {
                amount = amount.add(item.getAmount());
            }
        }
        pOrder.setAmount(amount);
        // calculate order price
        orderRepository.updateOrder(pOrder);
        // update order(price, type, belongsTo, user)

    }



    @Override
    public void updateLineItem(OrderBean pOrder) {
        // create lineItem and related to order.
        List<LineItem> items = pOrder.getLineItems();
        if (CollectionUtils.isEmpty(items)) {
            return;
        }
        LineItem item = items.get(0);
        item.setOrderId(pOrder.getId());
        if (null != item && null != item.getId()) {
            item.setCurrency(pOrder.getCurrency());
            if (OrderType.DORMITORY == pOrder.getOrderType()) {
                DormitoryLineItem dormitoryItem = (DormitoryLineItem)item;
                //TODO: FIX BUG. update Dormitory item.
                orderRepository.updateDormitoryLineItem(dormitoryItem);
            } else {
                PickupLineItem pickupItem = (PickupLineItem)item;
             // TODO Use pick up default price.
                pickupItem.setAmount(BigDecimal.valueOf(0));
                pickupItem.setListPrice(BigDecimal.valueOf(0));
                orderRepository.updatePickupLineItem(pickupItem);
            }
        }
        
    }



    @Override
    public OrderBean findPickupOrderById(Integer pId) {
        return orderRepository.findPickupOrderById(pId);
    }
    
//    @Override
//    public boolean hasOrder(UserBean user, OrderType type) {
//        Integer amount = orderRepository.queryUserOrderCount(user, type);
//        return amount >= 1;
//    }



    @Override
    public boolean belongsTo(UserBean pUser, OrderBean pOrder) {
        OrderSearchBean searchBean = new OrderSearchBean();
        Integer amount = orderRepository.belongsTo(searchBean);
        return amount >= 1;
    }
    
    
}
