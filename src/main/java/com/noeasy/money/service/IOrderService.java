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
package com.noeasy.money.service;

import java.util.List;

import com.noeasy.money.enumeration.OrderStatus;
import com.noeasy.money.enumeration.OrderType;
import com.noeasy.money.model.OrderBean;
import com.noeasy.money.model.OrderSearchBean;
import com.noeasy.money.model.UserBean;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 27, 2014
 */

public interface IOrderService {

    boolean placeOrder(OrderBean pOrderBean);



    List<OrderBean> queryOrder(OrderSearchBean pOrderSearchBean);



    OrderBean queryOrder(Integer pOrderId, OrderType type);



    OrderStatus getNextStatus(Integer pOrderId, OrderType type);



    int updateOrderStatus(Integer pOrderId, String pStatus);



    int queryOrderCount(OrderSearchBean pSearchBean);



    int updateOrderPrice(OrderBean pOrder);



    OrderBean findOrderById(Integer pValueOf);



    void createOrder(OrderBean pOrder);



    void updateOrder(OrderBean pOrder);



    void updateLineItem(OrderBean pOrder);



    OrderBean findPickupOrderById(Integer pId);
    
//    boolean hasOrder(UserBean user, OrderType type);



    boolean belongsTo(UserBean pUser, OrderBean pOrder);



    void sendSaveEmail(OrderBean pOrder);



    void sendCommitEmail(OrderBean pOrder);
    
    void updateOrderCondition(Integer pId, String pCondition);
}
