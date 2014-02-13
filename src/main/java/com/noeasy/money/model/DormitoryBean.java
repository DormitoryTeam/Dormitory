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

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 21, 2014
 */

public class DormitoryBean extends BaseBean {

    private int          mId;
    private String       mName;
    private String       mAddress;
    private String       mPostCode;
    private String       mEquipment;
    private String       mService;
    private Double       mSalePrice;
    private Double       mListPrice;
    private String       mCurrency;
    private Double       mDistance;
    private Double       mRating;
    private String       mDescription;
    private int          mCityId;
    private String       mCity;
    private int          mCollegeId;
    private String       mCollege;
    private int          mDormitoryTypeId;

    private String       mDormitoryType;
    private int          mContractId;
    private String       mContract;
    private List<String> mPicPath;
    private List<String> mVideoPath;



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
     * @return the contract
     */
    public String getContract() {
        return mContract;
    }



    /**
     * @return the contractId
     */
    public int getContractId() {
        return mContractId;
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
     * @return the dormitoryType
     */
    public String getDormitoryType() {
        return mDormitoryType;
    }



    /**
     * @return the dormitoryTypeId
     */
    public int getDormitoryTypeId() {
        return mDormitoryTypeId;
    }



    /**
     * @return the equipment
     */
    public String getEquipment() {
        return mEquipment;
    }



    /**
     * @return the id
     */
    public int getId() {
        return mId;
    }



    /**
     * @return the listPrice
     */
    public Double getListPrice() {
        return mListPrice;
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
     * @return the postCode
     */
    public String getPostCode() {
        return mPostCode;
    }



    /**
     * @return the rating
     */
    public Double getRating() {
        return mRating;
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
     * @return the videoPath
     */
    public List<String> getVideoPath() {
        return mVideoPath;
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
     * @param pContract
     *            the contract to set
     */
    public void setContract(final String pContract) {
        mContract = pContract;
    }



    /**
     * @param pContractId
     *            the contractId to set
     */
    public void setContractId(final int pContractId) {
        mContractId = pContractId;
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
     * @param pDormitoryType
     *            the dormitoryType to set
     */
    public void setDormitoryType(final String pDormitoryType) {
        mDormitoryType = pDormitoryType;
    }



    /**
     * @param pDormitoryTypeId
     *            the dormitoryTypeId to set
     */
    public void setDormitoryTypeId(final int pDormitoryTypeId) {
        mDormitoryTypeId = pDormitoryTypeId;
    }



    /**
     * @param pEquipment
     *            the equipment to set
     */
    public void setEquipment(final String pEquipment) {
        mEquipment = pEquipment;
    }



    /**
     * @param pId
     *            the id to set
     */
    public void setId(final int pId) {
        mId = pId;
    }



    /**
     * @param pListPrice
     *            the listPrice to set
     */
    public void setListPrice(final Double pListPrice) {
        mListPrice = pListPrice;
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
     * @param pPostCode
     *            the postCode to set
     */
    public void setPostCode(final String pPostCode) {
        mPostCode = pPostCode;
    }



    /**
     * @param pRating
     *            the rating to set
     */
    public void setRating(final Double pRating) {
        mRating = pRating;
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
     * @param pVideoPath
     *            the videoPath to set
     */
    public void setVideoPath(final List<String> pVideoPath) {
        mVideoPath = pVideoPath;
    }

}
