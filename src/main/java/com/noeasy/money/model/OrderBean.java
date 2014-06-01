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
import java.util.Date;
import java.util.List;

import com.noeasy.money.enumeration.OrderStatus;
import com.noeasy.money.enumeration.OrderType;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 27, 2014
 */

public class OrderBean extends BaseBean {

    private Integer          mId;

    private String           mCurrency;

    private BigDecimal       mAmount;

    private UserBean         mUser;

    private UserBean         mBelongsTo;

    private String           mOrderStatus;

    private OrderContactInfo mOrderContact;

    private List<LineItem>   mLineItems;

    private List<OrderTail>  mTails;

    private OrderType        mOrderType;

    private Date             mCreateTime;

    private boolean          mSendSaveEmail;

    private boolean          mSendCommitEmail;



    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return mAmount;
    }



    public UserBean getBelongsTo() {
        return mBelongsTo;
    }



    /**
     * @return the currency
     */
    public String getCurrency() {
        return mCurrency;
    }



    /**
     * @return the id
     */
    public Integer getId() {
        return mId;
    }



    /**
     * @return the lineItems
     */
    public List<LineItem> getLineItems() {
        return mLineItems;
    }



    /**
     * @return the orderContact
     */
    public OrderContactInfo getOrderContact() {
        return mOrderContact;
    }



    public OrderType getOrderType() {
        return mOrderType;
    }



    /**
     * @return the tails
     */
    public List<OrderTail> getTails() {
        return mTails;
    }



    /**
     * @return the user
     */
    public UserBean getUser() {
        return mUser;
    }



    /**
     * @param pAmount
     *            the amount to set
     */
    public void setAmount(final BigDecimal pAmount) {
        mAmount = pAmount;
    }



    public void setBelongsTo(final UserBean pBelongsTo) {
        mBelongsTo = pBelongsTo;
    }



    /**
     * @param pCurrency
     *            the currency to set
     */
    public void setCurrency(final String pCurrency) {
        mCurrency = pCurrency;
    }



    /**
     * @param pId
     *            the id to set
     */
    public void setId(final Integer pId) {
        mId = pId;
    }



    /**
     * @param pLineItems
     *            the lineItems to set
     */
    public void setLineItems(final List<LineItem> pLineItems) {
        mLineItems = pLineItems;
    }



    /**
     * @param pOrderContact
     *            the orderContact to set
     */
    public void setOrderContact(final OrderContactInfo pOrderContact) {
        mOrderContact = pOrderContact;
    }



    public void setOrderType(final OrderType pOrderType) {
        mOrderType = pOrderType;
    }



    /**
     * @param pTails
     *            the tails to set
     */
    public void setTails(final List<OrderTail> pTails) {
        mTails = pTails;
    }



    /**
     * @param pUser
     *            the user to set
     */
    public void setUser(final UserBean pUser) {
        mUser = pUser;
    }



    public String getOrderStatus() {
        return mOrderStatus;
    }



    public void setOrderStatus(String pOrderStatus) {
        mOrderStatus = pOrderStatus;
    }



    public boolean isSendSaveEmail() {
        return mSendSaveEmail;
    }



    public void setSendSaveEmail(boolean pSendSaveEmail) {
        mSendSaveEmail = pSendSaveEmail;
    }



    public boolean isSendCommitEmail() {
        return mSendCommitEmail;
    }



    public void setSendCommitEmail(boolean pSendCommitEmail) {
        mSendCommitEmail = pSendCommitEmail;
    }

}
