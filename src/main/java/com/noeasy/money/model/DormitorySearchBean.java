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
import org.apache.commons.lang3.tuple.Pair;

import com.noeasy.money.enumeration.DormitoryStatus;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 21, 2014
 */

public class DormitorySearchBean {

    private Integer              mId;



    private String               mDormitoryName;



    private Integer              mCityId;

    private String               mCityName;

    private Integer              mCollegeId;

    private String               mKeyword;

    private Pair<Double, Double> mPriceRange;

    private Integer              mContractTypeId;

    private Integer              mDormitoryTypeId;

    private String               mSortType;

    private String               mSortField;

    private PageBean             mPageBean;

    private DormitoryStatus      mStatus;

    private DormitoryStatus      mExcludeStatus;

    private DormitoryStatus      mRoomStatus;

    private DormitoryStatus      mExcludeRoomStatus;

    private Integer              mExcludeRoomPriceStatus;

    /**
     * @return the cityId
     */
    public Integer getCityId() {
        return mCityId;
    }

    /**
     * @return the cityName
     */
    public String getCityName() {
        return mCityName;
    }


    /**
     * @return the collegeId
     */
    public Integer getCollegeId() {
        return mCollegeId;
    }



    /**
     * @return the contractTypeId
     */
    public Integer getContractTypeId() {
        return mContractTypeId;
    }



    /**
     * @return the dormitoryName
     */
    public String getDormitoryName() {
        return mDormitoryName;
    }



    /**
     * @return the dormitoryTypeId
     */
    public Integer getDormitoryTypeId() {
        return mDormitoryTypeId;
    }



    /**
     * @return the excludeRoomPriceStatus
     */
    public Integer getExcludeRoomPriceStatus() {
        return mExcludeRoomPriceStatus;
    }



    /**
     * @return the excludeRoomStatus
     */
    public DormitoryStatus getExcludeRoomStatus() {
        return mExcludeRoomStatus;
    }



    /**
     * @return the excludeStatus
     */
    public DormitoryStatus getExcludeStatus() {
        return mExcludeStatus;
    }



    /**
     * @return the id
     */
    public Integer getId() {
        return mId;
    }



    /**
     * @return the keyword
     */
    public String getKeyword() {
        return mKeyword;
    }



    /**
     * @return the pageBean
     */
    public PageBean getPageBean() {
        return mPageBean;
    }



    /**
     * @return the priceRange
     */
    public Pair<Double, Double> getPriceRange() {
        return mPriceRange;
    }



    /**
     * @return the roomStatus
     */
    public DormitoryStatus getRoomStatus() {
        return mRoomStatus;
    }



    /**
     * @return the sortBy
     */
    public String getSortBy() {
        String orderByConditon = null;
        if (StringUtils.isNoneBlank(mSortField)) {
            orderByConditon = mSortField;
            if (StringUtils.isNoneBlank(mSortType)) {
                orderByConditon += " " + mSortType;
            } else {
                orderByConditon += " ASC";
            }
        }
        return orderByConditon;
    }



    /**
     * @return the sortField
     */
    public String getSortField() {
        return mSortField;
    }



    /**
     * @return the sortType
     */
    public String getSortType() {
        return mSortType;
    }



    /**
     * @return the status
     */
    public DormitoryStatus getStatus() {
        return mStatus;
    }



    /**
     * @param pCityId
     *            the cityId to set
     */
    public void setCityId(final Integer pCityId) {
        mCityId = pCityId;
    }



    /**
     * @param pCityName
     *            the cityName to set
     */
    public void setCityName(final String pCityName) {
        mCityName = pCityName;
    }



    /**
     * @param pCollegeId
     *            the collegeId to set
     */
    public void setCollegeId(final Integer pCollegeId) {
        mCollegeId = pCollegeId;
    }



    /**
     * @param pContractTypeId
     *            the contractTypeId to set
     */
    public void setContractTypeId(final Integer pContractTypeId) {
        mContractTypeId = pContractTypeId;
    }



    /**
     * @param pDormitoryName
     *            the dormitoryName to set
     */
    public void setDormitoryName(final String pDormitoryName) {
        mDormitoryName = pDormitoryName;
    }



    /**
     * @param pDormitoryTypeId
     *            the dormitoryTypeId to set
     */
    public void setDormitoryTypeId(final Integer pDormitoryTypeId) {
        mDormitoryTypeId = pDormitoryTypeId;
    }



    /**
     * @param pExcludeRoomPriceStatus the excludeRoomPriceStatus to set
     */
    public void setExcludeRoomPriceStatus(final Integer pExcludeRoomPriceStatus) {
        mExcludeRoomPriceStatus = pExcludeRoomPriceStatus;
    }



    /**
     * /**
     * 
     * @param pExcludeRoomStatus
     *            the excludeRoomStatus to set
     */
    public void setExcludeRoomStatus(final DormitoryStatus pExcludeRoomStatus) {
        mExcludeRoomStatus = pExcludeRoomStatus;
    }



    /**
     * @param pExcludeStatus
     *            the excludeStatus to set
     */
    public void setExcludeStatus(final DormitoryStatus pExcludeStatus) {
        mExcludeStatus = pExcludeStatus;
    }



    /**
     * @param pId
     *            the id to set
     */
    public void setId(final Integer pId) {
        mId = pId;
    }



    /**
     * @param pKeyword
     *            the keyword to set
     */
    public void setKeyword(final String pKeyword) {
        mKeyword = pKeyword;
    }



    /**
     * @param pPageBean
     *            the pageBean to set
     */
    public void setPageBean(final PageBean pPageBean) {
        mPageBean = pPageBean;
    }



    /**
     * @param pPriceRange
     *            the priceRange to set
     */
    public void setPriceRange(final Pair<Double, Double> pPriceRange) {
        mPriceRange = pPriceRange;
    }



    /**
     * @param pRoomStatus
     *            the roomStatus to set
     */
    public void setRoomStatus(final DormitoryStatus pRoomStatus) {
        mRoomStatus = pRoomStatus;
    }



    /**
     * @param pSortField
     *            the sortField to set
     */
    public void setSortField(final String pSortField) {
        mSortField = pSortField;
    }



    /**
     * @param pSortType
     *            the sortType to set
     */
    public void setSortType(final String pSortType) {
        mSortType = pSortType;
    }



    /**
     * @param pStatus
     *            the status to set
     */
    public void setStatus(final DormitoryStatus pStatus) {
        mStatus = pStatus;
    }

}
