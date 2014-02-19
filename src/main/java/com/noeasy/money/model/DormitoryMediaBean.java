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
 * @version: 1.0, Feb 19, 2014
 */

public class DormitoryMediaBean extends BaseBean implements Comparable<DormitoryMediaBean> {

    private Integer mId;
    private Integer mDormitoryId;
    private boolean mMediaType;
    private String  mMediaPath;
    private Integer mIndex;



    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(final DormitoryMediaBean pTarger) {
        return mIndex < pTarger.getIndex() ? -1 : (mIndex == pTarger.getIndex() ? 0 : 1);
    }



    /**
     * @return the dormitoryId
     */
    public Integer getDormitoryId() {
        return mDormitoryId;
    }



    /**
     * @return the id
     */
    public Integer getId() {
        return mId;
    }



    /**
     * @return the index
     */
    public Integer getIndex() {
        return mIndex;
    }



    /**
     * @return the mediaPath
     */
    public String getMediaPath() {
        return mMediaPath;
    }



    /**
     * @return the mediaType
     */
    public boolean isMediaType() {
        return mMediaType;
    }



    /**
     * @param pDormitoryId
     *            the dormitoryId to set
     */
    public void setDormitoryId(final Integer pDormitoryId) {
        mDormitoryId = pDormitoryId;
    }



    /**
     * @param pId
     *            the id to set
     */
    public void setId(final Integer pId) {
        mId = pId;
    }



    /**
     * @param pIndex
     *            the index to set
     */
    public void setIndex(final Integer pIndex) {
        mIndex = pIndex;
    }



    /**
     * @param pMediaPath
     *            the mediaPath to set
     */
    public void setMediaPath(final String pMediaPath) {
        mMediaPath = pMediaPath;
    }



    /**
     * @param pMediaType
     *            the mediaType to set
     */
    public void setMediaType(final boolean pMediaType) {
        mMediaType = pMediaType;
    }

}
