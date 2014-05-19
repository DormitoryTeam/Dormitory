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

import java.util.List;

import com.noeasy.money.enumeration.DormitoryStatus;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 21, 2014
 */

public class DormitoryBean extends BaseBean {

    private int                mId;

    private String             mName;

    private String             mAddress;

    private String             mPostcode;

    private Double             mSalePrice;

    private Double             mWeekPrice;

    private Double             mAdditionalPrice;

    private String             mPromotion;

    private String             mCurrency;

    private Double             mDistance;

    private Double             mRating;

    private String             mDescription;

    private int                mCityId;

    private String             mCity;

    private int                mCollegeId;

    private String             mCollege;

    private List<String>       mPicPath;

    private List<String>       mVideoPath;

    private Double             mLatitude;

    private Double             mLongitude;

    private DormitoryStatus    mStatus;

    private DormitoryRateBean  mRate;

    private List<RoomInfoBean> mRooms;

    private String             mService;

    private String             mEquipment;

    private String             mRefund;

    private String             mQuestion;

    private String             mFeature;

    private String             mCompanyId;

    private String             mCompany;

    private Integer            mDisplayOrder;



    /**
     * @return the additionalPrice
     */
    public Double getAdditionalPrice() {
        return mAdditionalPrice;
    }



    /**
     * @return the address
     */
    public String getAddress() {
        return mAddress;
    }



    /**
     * @return the city
     */
    public String getCity() {
        return mCity;
    }



    /**
     * @return the cityId
     */
    public int getCityId() {
        return mCityId;
    }



    /**
     * @return the college
     */
    public String getCollege() {
        return mCollege;
    }



    /**
     * @return the collegeId
     */
    public int getCollegeId() {
        return mCollegeId;
    }



    /**
     * @return the company
     */
    public String getCompany() {
        return mCompany;
    }



    /**
     * @return the companyId
     */
    public String getCompanyId() {
        return mCompanyId;
    }



    /**
     * @return the currency
     */
    public String getCurrency() {
        return mCurrency;
    }



    /**
     * @return the description
     */
    public String getDescription() {
        return mDescription;
    }



    /**
     * @return the distance
     */
    public Double getDistance() {
        return mDistance;
    }



    /**
     * @return the equipment
     */
    public String getEquipment() {
        return mEquipment;
    }



    /**
     * @return the feature
     */
    public String getFeature() {
        return mFeature;
    }



    /**
     * @return the id
     */
    public int getId() {
        return mId;
    }



    /**
     * @return the latitude
     */
    public Double getLatitude() {
        return mLatitude;
    }



    /**
     * @return the longitude
     */
    public Double getLongitude() {
        return mLongitude;
    }



    /**
     * @return the name
     */
    public String getName() {
        return mName;
    }



    /**
     * @return the picPath
     */
    public List<String> getPicPath() {
        return mPicPath;
    }



    /**
     * @return the postcode
     */
    public String getPostcode() {
        return mPostcode;
    }



    /**
     * @return the promotion
     */
    public String getPromotion() {
        return mPromotion;
    }



    /**
     * @return the question
     */
    public String getQuestion() {
        return mQuestion;
    }



    /**
     * @return the rate
     */
    public DormitoryRateBean getRate() {
        return mRate;
    }



    /**
     * @return the rating
     */
    public Double getRating() {
        return mRating;
    }



    /**
     * @return the refund
     */
    public String getRefund() {
        return mRefund;
    }



    /**
     * @return the rooms
     */
    public List<RoomInfoBean> getRooms() {
        return mRooms;
    }



    /**
     * @return the salePrice
     */
    public Double getSalePrice() {
        return mSalePrice;
    }



    /**
     * @return the service
     */
    public String getService() {
        return mService;
    }



    /**
     * @return the status
     */
    public DormitoryStatus getStatus() {
        return mStatus;
    }



    /**
     * @return the videoPath
     */
    public List<String> getVideoPath() {
        return mVideoPath;
    }



    /**
     * @return the weekPrice
     */
    public Double getWeekPrice() {
        return mWeekPrice;
    }



    /**
     * @param pAdditionalPrice
     *            the additionalPrice to set
     */
    public void setAdditionalPrice(final Double pAdditionalPrice) {
        mAdditionalPrice = pAdditionalPrice;
    }



    /**
     * @param pAddress
     *            the address to set
     */
    public void setAddress(final String pAddress) {
        mAddress = pAddress;
    }



    /**
     * @param pCity
     *            the city to set
     */
    public void setCity(final String pCity) {
        mCity = pCity;
    }



    /**
     * @param pCityId
     *            the cityId to set
     */
    public void setCityId(final int pCityId) {
        mCityId = pCityId;
    }



    /**
     * @param pCollege
     *            the college to set
     */
    public void setCollege(final String pCollege) {
        mCollege = pCollege;
    }



    /**
     * @param pCollegeId
     *            the collegeId to set
     */
    public void setCollegeId(final int pCollegeId) {
        mCollegeId = pCollegeId;
    }



    /**
     * @param pCompany
     *            the company to set
     */
    public void setCompany(final String pCompany) {
        mCompany = pCompany;
    }



    /**
     * @param pCompanyId
     *            the companyId to set
     */
    public void setCompanyId(final String pCompanyId) {
        mCompanyId = pCompanyId;
    }



    /**
     * @param pCurrency
     *            the currency to set
     */
    public void setCurrency(final String pCurrency) {
        mCurrency = pCurrency;
    }



    /**
     * @param pDescription
     *            the description to set
     */
    public void setDescription(final String pDescription) {
        mDescription = pDescription;
    }



    /**
     * @param pDistance
     *            the distance to set
     */
    public void setDistance(final Double pDistance) {
        mDistance = pDistance;
    }



    /**
     * @param pEquipment
     *            the equipment to set
     */
    public void setEquipment(final String pEquipment) {
        mEquipment = pEquipment;
    }



    /**
     * @param pFeature
     *            the feature to set
     */
    public void setFeature(final String pFeature) {
        mFeature = pFeature;
    }



    /**
     * @param pId
     *            the id to set
     */
    public void setId(final int pId) {
        mId = pId;
    }



    /**
     * @param pLatitude
     *            the latitude to set
     */
    public void setLatitude(final Double pLatitude) {
        mLatitude = pLatitude;
    }



    /**
     * @param pLongitude
     *            the longitude to set
     */
    public void setLongitude(final Double pLongitude) {
        mLongitude = pLongitude;
    }



    /**
     * @param pName
     *            the name to set
     */
    public void setName(final String pName) {
        mName = pName;
    }



    /**
     * @param pPicPath
     *            the picPath to set
     */
    public void setPicPath(final List<String> pPicPath) {
        mPicPath = pPicPath;
    }



    /**
     * @param pPostcode
     *            the postcode to set
     */
    public void setPostcode(final String pPostcode) {
        mPostcode = pPostcode;
    }



    /**
     * @param pPromotion
     *            the promotion to set
     */
    public void setPromotion(final String pPromotion) {
        mPromotion = pPromotion;
    }



    /**
     * @param pQuestion
     *            the question to set
     */
    public void setQuestion(final String pQuestion) {
        mQuestion = pQuestion;
    }



    /**
     * @param pRate
     *            the rate to set
     */
    public void setRate(final DormitoryRateBean pRate) {
        mRate = pRate;
    }



    /**
     * @param pRating
     *            the rating to set
     */
    public void setRating(final Double pRating) {
        mRating = pRating;
    }



    /**
     * @param pRefund
     *            the refund to set
     */
    public void setRefund(final String pRefund) {
        mRefund = pRefund;
    }



    /**
     * @param pRooms
     *            the rooms to set
     */
    public void setRooms(final List<RoomInfoBean> pRooms) {
        mRooms = pRooms;
    }



    /**
     * @param pSalePrice
     *            the salePrice to set
     */
    public void setSalePrice(final Double pSalePrice) {
        mSalePrice = pSalePrice;
    }



    /**
     * @param pService
     *            the service to set
     */
    public void setService(final String pService) {
        mService = pService;
    }



    /**
     * @param pStatus
     *            the status to set
     */
    public void setStatus(final DormitoryStatus pStatus) {
        mStatus = pStatus;
    }



    /**
     * @param pVideoPath
     *            the videoPath to set
     */
    public void setVideoPath(final List<String> pVideoPath) {
        mVideoPath = pVideoPath;
    }



    /**
     * @param pWeekPrice
     *            the weekPrice to set
     */
    public void setWeekPrice(final Double pWeekPrice) {
        mWeekPrice = pWeekPrice;
    }



    public Integer getDisplayOrder() {
        return mDisplayOrder;
    }



    public void setDisplayOrder(Integer pDisplayOrder) {
        mDisplayOrder = pDisplayOrder;
    }

}