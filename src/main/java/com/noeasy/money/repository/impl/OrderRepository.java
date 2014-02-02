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

import com.noeasy.money.enumeration.Operation;
import com.noeasy.money.model.LineItem;
import com.noeasy.money.model.OrderBean;
import com.noeasy.money.model.OrderContactInfo;
import com.noeasy.money.model.OrderSearchBean;
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
    public boolean placeDormitoryOrder(final OrderBean pOrderBean) {
        getSqlSession().insert("com.noeasy.money.model.Order.saveDormitoryOrder", pOrderBean);
        return true;
    }



    @Override
    public boolean placePickupOrder(final OrderBean pOrderBean) {
        getSqlSession().insert("com.noeasy.money.model.Order.savePickupOrder", pOrderBean);
        return true;
    }



    @Override
    public OrderBean queryDormitoryOrder(final OrderSearchBean pOrderSearchBean) {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public List<OrderBean> queryDormitoryOrderPage(final OrderSearchBean pOrderSearchBean) {
        return getSqlSession().selectList("com.noeasy.money.model.Order.queryDormitoryOrder", pOrderSearchBean);
    }



    @Override
    public OrderBean queryPickupOrder(final OrderSearchBean pOrderSearchBean) {
        // TODO Auto-generated method stub
        return null;
    }



    @Override
    public List<OrderBean> queryPickupOrderPage(final OrderSearchBean pOrderSearchBean) {
        return getSqlSession().selectList("com.noeasy.money.model.Order.queryPickupOrder", pOrderSearchBean);
    }



    @Override
    public boolean saveDormitoryLineItem(final LineItem pLineItem) {
        // TODO Auto-generated method stub
        return false;
    }



    @Override
    public boolean saveOrder(final OrderBean pOrderBean) {
        // TODO Auto-generated method stub
        return false;
    }



    @Override
    public boolean saveOrderContactInfo(final OrderContactInfo pContactInfo) {
        // TODO Auto-generated method stub
        return false;
    }



    @Override
    public boolean saveOrderRecord(final int pOrderId, final int pOperatorId, final Operation pOperation) {
        // TODO Auto-generated method stub
        return false;
    }



    @Override
    public boolean savePickupLineItem(final LineItem pLineItem) {
        // TODO Auto-generated method stub
        return false;
    }

}
