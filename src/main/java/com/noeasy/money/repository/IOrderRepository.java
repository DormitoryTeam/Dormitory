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
package com.noeasy.money.repository;

import java.util.List;

import com.noeasy.money.enumeration.OrderStatus;
import com.noeasy.money.enumeration.OrderType;
import com.noeasy.money.model.DormitoryLineItem;
import com.noeasy.money.model.LineItem;
import com.noeasy.money.model.OrderBean;
import com.noeasy.money.model.OrderContactInfo;
import com.noeasy.money.model.OrderSearchBean;
import com.noeasy.money.model.OrderTail;
import com.noeasy.money.model.PickupLineItem;
import com.noeasy.money.model.UserBean;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 28, 2014
 */

public interface IOrderRepository {

    boolean placeOrder(OrderBean pOrderBean);



    OrderBean queryDormitoryOrder(OrderSearchBean pOrderSearchBean);



    List<OrderBean> queryDormitoryOrderPage(OrderSearchBean pOrderSearchBean);



    OrderBean queryPickupOrder(OrderSearchBean pOrderSearchBean);



    List<OrderBean> queryPickupOrderPage(OrderSearchBean pOrderSearchBean);



    boolean saveDormitoryLineItem(LineItem pLineItem);



    boolean saveOrder(OrderBean pOrderBean);



    boolean saveOrderContactInfo(OrderContactInfo pContactInfo);



    boolean saveOrderRecord(OrderTail pOrderTail);



    boolean savePickupLineItem(LineItem pLineItem);



    int updateOrderStatus(Integer pOrderId, String pStatus);



    boolean isPaymentDone(Integer pOrderId);



    Integer queryDormitoryOrderCount(OrderSearchBean pSearchBean);



    Integer queryPickupOrderCount(OrderSearchBean pSearchBean);



    Integer updateOrderPrice(OrderBean pOrder);



    void updateOrder(OrderBean pOrder);



    OrderBean findOrderById(Integer pId);



    void updateDormitoryLineItem(DormitoryLineItem pDormitoryItem);



    void updatePickupLineItem(PickupLineItem pPickupItem);



    OrderBean findPickupOrderById(Integer pId);



    Integer queryUserOrderCount(UserBean pUser, OrderType pType);



    Integer belongsTo(OrderSearchBean pSearchBean);



    void sendSaveEmail(OrderBean pOrder);



    void sendCommitEmail(OrderBean pOrder);

    void updateOrderCondition(OrderBean pOrder);
}
