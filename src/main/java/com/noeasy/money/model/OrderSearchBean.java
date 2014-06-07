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

import java.util.Date;

import com.noeasy.money.enumeration.OrderStatus;
import com.noeasy.money.enumeration.OrderType;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 27, 2014
 */

public class OrderSearchBean {
    
    private UserBean    mUser;

    private OrderType   mOrderType;

    private Integer     mOrderNumber;

    private Date        mDateFrom;

    private Date        mDateTo;

    private String      mCondition;

    private PageBean    mPageBean;



    /**
     * @return the dateFrom
     */
    public Date getDateFrom() {
        return mDateFrom;
    }



    /**
     * @return the dateTo
     */
    public Date getDateTo() {
        return mDateTo;
    }



    /**
     * @return the orderNumber
     */
    public Integer getOrderNumber() {
        return mOrderNumber;
    }




    /**
     * @return the orderType
     */
    public OrderType getOrderType() {
        return mOrderType;
    }



    /**
     * @return the pageBean
     */
    public PageBean getPageBean() {
        return mPageBean;
    }



    /**
     * @return the user
     */
    public UserBean getUser() {
        return mUser;
    }



    /**
     * @param pDateFrom
     *            the dateFrom to set
     */
    public void setDateFrom(final Date pDateFrom) {
        mDateFrom = pDateFrom;
    }



    /**
     * @param pDateTo
     *            the dateTo to set
     */
    public void setDateTo(final Date pDateTo) {
        mDateTo = pDateTo;
    }



    /**
     * @param pOrderNumber
     *            the orderNumber to set
     */
    public void setOrderNumber(final Integer pOrderNumber) {
        mOrderNumber = pOrderNumber;
    }



    /**
     * @param pOrderType
     *            the orderType to set
     */
    public void setOrderType(final OrderType pOrderType) {
        mOrderType = pOrderType;
    }



    /**
     * @param pPageBean
     *            the pageBean to set
     */
    public void setPageBean(final PageBean pPageBean) {
        mPageBean = pPageBean;
    }



    /**
     * @param pUser
     *            the user to set
     */
    public void setUser(final UserBean pUser) {
        mUser = pUser;
    }



    public String getCondition() {
        return mCondition;
    }



    public void setCondition(String pCondition) {
        mCondition = pCondition;
    }

}
