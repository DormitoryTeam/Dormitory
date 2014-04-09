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

import org.apache.commons.lang3.StringUtils;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 22, 2014
 */

public class DormitoryRateBean extends BaseBean {

    private int    mId;

    private int    mUserId;

    private int    mDormitoryId;

    private int    mPoint;

    private String mComment;

    private String mAlias;

    private String mStatus;



    public DormitoryRateBean() {

    }



    public DormitoryRateBean(final int pDormitoryId, final int pUserId, final int pPoint, final String pComment,
            final String pAlias) {
        super();
        mUserId = pUserId;
        mDormitoryId = pDormitoryId;
        mPoint = pPoint;
        mComment = pComment;
        mAlias = pAlias;
    }



    /**
     * @return the alias
     */
    public String getAlias() {
        return mAlias;
    }



    /**
     * @return the comment
     */
    public String getComment() {
        if (StringUtils.isNoneBlank(mComment)) {
            mComment = mComment.trim();
        }
        return mComment;
    }



    /**
     * @return the dormitoryId
     */
    public int getDormitoryId() {
        return mDormitoryId;
    }



    /**
     * @return the id
     */
    public int getId() {
        return mId;
    }



    /**
     * @return the point
     */
    public int getPoint() {
        return mPoint;
    }



    /**
     * @return the status
     */
    public String getStatus() {
        return mStatus;
    }



    /**
     * @return the userId
     */
    public int getUserId() {
        return mUserId;
    }



    //

    /**
     * @param pAlias
     *            the alias to set
     */
    public void setAlias(final String pAlias) {
        mAlias = pAlias;
    }



    /**
     * @param pComment
     *            the comment to set
     */
    public void setComment(final String pComment) {
        mComment = pComment;
        if (StringUtils.isNoneBlank(mComment)) {
            mComment = mComment.trim();
        }
    }



    /**
     * @param pDormitoryId
     *            the dormitoryId to set
     */
    public void setDormitoryId(final int pDormitoryId) {
        mDormitoryId = pDormitoryId;
    }



    /**
     * @param pId
     *            the id to set
     */
    public void setId(final int pId) {
        mId = pId;
    }



    /**
     * @param pPoint
     *            the point to set
     */
    public void setPoint(final int pPoint) {
        mPoint = pPoint;
    }



    /**
     * @param pStatus
     *            the status to set
     */
    public void setStatus(final String pStatus) {
        mStatus = pStatus;
    }



    /**
     * @param pUserId
     *            the userId to set
     */
    public void setUserId(final int pUserId) {
        mUserId = pUserId;
    }



    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DormitoryRateBean [mId=" + mId + ", mUserId=" + mUserId + ", mDormitoryId=" + mDormitoryId
                + ", mPoint=" + mPoint + ", mComment=" + mComment + ", mAlias=" + mAlias + "]";
    }

}
