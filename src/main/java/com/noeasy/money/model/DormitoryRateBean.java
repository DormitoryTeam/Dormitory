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


/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 22, 2014
 */

public class DormitoryRateBean extends BaseBean {

    private int mId;

    private int mUserId;

    private int mDormitoryId;

    private int mPoint;



    public DormitoryRateBean() {

    }



    /**
     * @param pUserId
     * @param pDormitoryId
     * @param pPoint
     */
    public DormitoryRateBean(int pDormitoryId, int pUserId, int pPoint) {
        super();
        mUserId = pUserId;
        mDormitoryId = pDormitoryId;
        mPoint = pPoint;
    }



    //

    /**
     * @return the id
     */
    public int getId() {
        return mId;
    }



    /**
     * @param pId
     *            the id to set
     */
    public void setId(int pId) {
        mId = pId;
    }



    /**
     * @return the userId
     */
    public int getUserId() {
        return mUserId;
    }



    /**
     * @param pUserId
     *            the userId to set
     */
    public void setUserId(int pUserId) {
        mUserId = pUserId;
    }



    /**
     * @return the dormitoryId
     */
    public int getDormitoryId() {
        return mDormitoryId;
    }



    /**
     * @param pDormitoryId
     *            the dormitoryId to set
     */
    public void setDormitoryId(int pDormitoryId) {
        mDormitoryId = pDormitoryId;
    }



    /**
     * @return the point
     */
    public int getPoint() {
        return mPoint;
    }



    /**
     * @param pPoint
     *            the point to set
     */
    public void setPoint(int pPoint) {
        mPoint = pPoint;
    }

}
