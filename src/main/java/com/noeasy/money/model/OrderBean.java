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
package com.noeasy.money.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 27, 2014
 */

public class OrderBean extends BaseBean {

    private Integer              mId;

    private String           mCurrency;

    private BigDecimal       mAmount;

    private UserBean             mUser;

    private OrderStatus      mOrderStatus;

    private OrderContactInfo mOrderContact;

    private List<LineItem>   mLineItems;

    private List<OrderTail>  mTails;



    /**
     * @return the id
     */
    public Integer getId() {
        return mId;
    }



    /**
     * @param pId
     *            the id to set
     */
    public void setId(Integer pId) {
        mId = pId;
    }



    /**
     * @return the currency
     */
    public String getCurrency() {
        return mCurrency;
    }



    /**
     * @param pCurrency
     *            the currency to set
     */
    public void setCurrency(String pCurrency) {
        mCurrency = pCurrency;
    }



    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return mAmount;
    }



    /**
     * @param pAmount
     *            the amount to set
     */
    public void setAmount(BigDecimal pAmount) {
        mAmount = pAmount;
    }



    /**
     * @return the user
     */
    public UserBean getUser() {
        return mUser;
    }



    /**
     * @param pUser
     *            the user to set
     */
    public void setUser(UserBean pUser) {
        mUser = pUser;
    }



    /**
     * @return the orderStatus
     */
    public OrderStatus getOrderStatus() {
        return mOrderStatus;
    }



    /**
     * @param pOrderStatus
     *            the orderStatus to set
     */
    public void setOrderStatus(OrderStatus pOrderStatus) {
        mOrderStatus = pOrderStatus;
    }



    /**
     * @return the orderContact
     */
    public OrderContactInfo getOrderContact() {
        return mOrderContact;
    }



    /**
     * @param pOrderContact
     *            the orderContact to set
     */
    public void setOrderContact(OrderContactInfo pOrderContact) {
        mOrderContact = pOrderContact;
    }



    /**
     * @return the lineItems
     */
    public List<LineItem> getLineItems() {
        return mLineItems;
    }



    /**
     * @param pLineItems
     *            the lineItems to set
     */
    public void setLineItems(List<LineItem> pLineItems) {
        mLineItems = pLineItems;
    }



    /**
     * @return the tails
     */
    public List<OrderTail> getTails() {
        return mTails;
    }



    /**
     * @param pTails
     *            the tails to set
     */
    public void setTails(List<OrderTail> pTails) {
        mTails = pTails;
    }
}
