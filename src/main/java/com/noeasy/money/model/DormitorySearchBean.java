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

import org.apache.commons.lang3.tuple.Pair;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 21, 2014
 */

public class DormitorySearchBean {

    private String               mDormitoryName;

    private int                  mCityId;

    private int                  mCollegeId;

    private String               mKeyword;

    private Pair<Double, Double> mPriceRange;

    private int                  mContractTypeId;

    private int                  mDormitoryTypeId;

    private String               mSortType;

    private String               mSortField;

    private PageBean             mPageBean;



    public DormitorySearchBean() {
        mPageBean = new PageBean();
    }



    /**
     * @return the dormitoryName
     */
    public String getDormitoryName() {
        return mDormitoryName;
    }



    /**
     * @param pDormitoryName
     *            the dormitoryName to set
     */
    public void setDormitoryName(String pDormitoryName) {
        mDormitoryName = pDormitoryName;
    }



    /**
     * @return the cityId
     */
    public int getCityId() {
        return mCityId;
    }



    /**
     * @param pCityId
     *            the cityId to set
     */
    public void setCityId(int pCityId) {
        mCityId = pCityId;
    }



    /**
     * @return the collegeId
     */
    public int getCollegeId() {
        return mCollegeId;
    }



    /**
     * @param pCollegeId
     *            the collegeId to set
     */
    public void setCollegeId(int pCollegeId) {
        mCollegeId = pCollegeId;
    }



    /**
     * @return the keyword
     */
    public String getKeyword() {
        return mKeyword;
    }



    /**
     * @param pKeyword
     *            the keyword to set
     */
    public void setKeyword(String pKeyword) {
        mKeyword = pKeyword;
    }



    /**
     * @return the priceRange
     */
    public Pair<Double, Double> getPriceRange() {
        return mPriceRange;
    }



    /**
     * @param pPriceRange
     *            the priceRange to set
     */
    public void setPriceRange(Pair<Double, Double> pPriceRange) {
        mPriceRange = pPriceRange;
    }



    /**
     * @return the contractTypeId
     */
    public int getContractTypeId() {
        return mContractTypeId;
    }



    /**
     * @param pContractTypeId
     *            the contractTypeId to set
     */
    public void setContractTypeId(int pContractTypeId) {
        mContractTypeId = pContractTypeId;
    }



    /**
     * @return the dormitoryTypeId
     */
    public int getDormitoryTypeId() {
        return mDormitoryTypeId;
    }



    /**
     * @param pDormitoryTypeId
     *            the dormitoryTypeId to set
     */
    public void setDormitoryTypeId(int pDormitoryTypeId) {
        mDormitoryTypeId = pDormitoryTypeId;
    }



    /**
     * @return the sortBy
     */
    public String getSortBy() {
        String orderByConditon = null;
        if (mSortField != null) {
            orderByConditon = mSortField;
            if (mSortType != null) {
                orderByConditon += " " + mSortType;
            }
        }
        return orderByConditon;
    }



    /**
     * @return the pageBean
     */
    public PageBean getPageBean() {
        return mPageBean;
    }



    /**
     * @param pPageBean
     *            the pageBean to set
     */
    public void setPageBean(PageBean pPageBean) {
        mPageBean = pPageBean;
    }



    /**
     * @return the sortType
     */
    public String getSortType() {
        return mSortType;
    }



    /**
     * @param pSortType
     *            the sortType to set
     */
    public void setSortType(String pSortType) {
        mSortType = pSortType;
    }



    /**
     * @return the sortField
     */
    public String getSortField() {
        return mSortField;
    }



    /**
     * @param pSortField
     *            the sortField to set
     */
    public void setSortField(String pSortField) {
        mSortField = pSortField;
    }

}
