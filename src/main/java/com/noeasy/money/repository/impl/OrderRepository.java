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
package com.noeasy.money.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.noeasy.money.enumeration.OrderStatus;
import com.noeasy.money.model.DormitoryLineItem;
import com.noeasy.money.model.LineItem;
import com.noeasy.money.model.OrderBean;
import com.noeasy.money.model.OrderContactInfo;
import com.noeasy.money.model.OrderSearchBean;
import com.noeasy.money.model.OrderTail;
import com.noeasy.money.model.PickupLineItem;
import com.noeasy.money.repository.IOrderRepository;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 28, 2014
 */
@Repository("orderRepository")
public class OrderRepository extends BaseRepository implements IOrderRepository {

    @Override
    public boolean placeOrder(final OrderBean pOrderBean) {
        boolean saveResult = this.saveOrder(pOrderBean);
        if (!saveResult) {
            return saveResult;
        }

        OrderContactInfo contact = pOrderBean.getOrderContact();
        contact.setOrderId(pOrderBean.getId());
        saveResult = this.saveOrderContactInfo(contact);
        if (!saveResult) {
            return saveResult;
        }

        for (LineItem lineItem : pOrderBean.getLineItems()) {
            lineItem.setOrderId(pOrderBean.getId());
            if (lineItem instanceof DormitoryLineItem) {
                saveResult = this.saveDormitoryLineItem(lineItem);
            } else if (lineItem instanceof PickupLineItem) {
                saveResult = this.savePickupLineItem(lineItem);
            }
            if (!saveResult) {
                break;
            }
        }
        if (!saveResult) {
            return saveResult;
        }

        OrderTail lastOpertation = pOrderBean.getTails().get(pOrderBean.getTails().size() - 1);
        lastOpertation.setOrderId(pOrderBean.getId());
        saveResult = this.saveOrderRecord(lastOpertation);

        return saveResult;
    }



    @Override
    public OrderBean queryDormitoryOrder(final OrderSearchBean pOrderSearchBean) {
        pOrderSearchBean.setPageBean(null);
        return getSqlSession().selectOne("com.noeasy.money.model.Order.queryDormitoryOrder", pOrderSearchBean);
    }



    @Override
    public List<OrderBean> queryDormitoryOrderPage(final OrderSearchBean pOrderSearchBean) {
        return getSqlSession().selectList("com.noeasy.money.model.Order.queryDormitoryOrder", pOrderSearchBean);
    }



    @Override
    public OrderBean queryPickupOrder(final OrderSearchBean pOrderSearchBean) {
        pOrderSearchBean.setPageBean(null);
        return getSqlSession().selectOne("com.noeasy.money.model.Order.queryPickupOrder", pOrderSearchBean);
    }



    @Override
    public List<OrderBean> queryPickupOrderPage(final OrderSearchBean pOrderSearchBean) {
        return getSqlSession().selectList("com.noeasy.money.model.Order.queryPickupOrder", pOrderSearchBean);
    }



    @Override
    public boolean saveDormitoryLineItem(final LineItem pLineItem) {
        getSqlSession().insert("com.noeasy.money.model.Order.saveDormitoryLineItem", pLineItem);
        return true;
    }



    @Override
    public boolean saveOrder(final OrderBean pOrderBean) {
        getSqlSession().insert("com.noeasy.money.model.Order.saveOrder", pOrderBean);
        return true;
    }



    @Override
    public boolean saveOrderContactInfo(final OrderContactInfo pContactInfo) {
        getSqlSession().insert("com.noeasy.money.model.Order.saveOrderContactInfo", pContactInfo);
        return true;
    }



    @Override
    public boolean saveOrderRecord(final OrderTail pOrderTail) {
        getSqlSession().insert("com.noeasy.money.model.Order.saveOrderHistory", pOrderTail);
        return true;
    }



    @Override
    public boolean savePickupLineItem(final LineItem pLineItem) {
        getSqlSession().insert("com.noeasy.money.model.Order.savePickupLineItem", pLineItem);
        return true;
    }



    @Override
    public int updateOrderStatus(Integer pOrderId, OrderStatus pStatus) {
        OrderBean order = new OrderBean();
        order.setId(pOrderId);
        order.setOrderStatus(pStatus);
        return getSqlSession().update("com.noeasy.money.model.Order.updateOrderStatus", order);
    }



    @Override
    public boolean isPaymentDone(Integer pOrderId) {
        return getPaymentDoneCount(pOrderId) > 0;
    }



    private Integer getPaymentDoneCount(Integer pOrderId) {
        Integer count = getSqlSession().selectOne("com.noeasy.money.model.Order.isPaymentDone", pOrderId);
        return count;
    }



    @Override
    public Integer queryDormitoryOrderCount(OrderSearchBean pSearchBean) {
        return getSqlSession().selectOne("com.noeasy.money.model.Order.queryDormitoryOrderCount", pSearchBean);
    }



    @Override
    public Integer queryPickupOrderCount(OrderSearchBean pSearchBean) {
        return getSqlSession().selectOne("com.noeasy.money.model.Order.queryPickupOrderCount", pSearchBean);
    }



    @Override
    public Integer updateOrderPrice(OrderBean pOrder) {
        return getSqlSession().update("com.noeasy.money.model.Order.updateOrderPrice", pOrder);
    }



    @Override
    public void updateOrder(OrderBean pOrder) {
        getSqlSession().update("com.noeasy.money.model.Order.updateOrder", pOrder);
        
    }



    @Override
    public OrderBean findOrderById(Integer pId) {
        return getSqlSession().selectOne("com.noeasy.money.model.Order.findOrderById", pId);
    }



    @Override
    public void updateDormitoryLineItem(DormitoryLineItem pDormitoryItem) {
        getSqlSession().update("com.noeasy.money.model.Order.updateDormitoryLineItem", pDormitoryItem);
        
    }



    @Override
    public void updatePickupLineItem(PickupLineItem pPickupItem) {
        getSqlSession().update("com.noeasy.money.model.Order.updatePickupLineItem", pPickupItem);
        
    }

}
