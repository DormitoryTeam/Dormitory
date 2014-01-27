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
 * @version: 1.0, Jan 21, 2014
 */

public class DormitoryBean extends BaseBean {

    private int    mId;
    private String mName;
    private String mAddress;
    private String mPostCode;
    private String mEquipment;
    private String mService;
    private Double mSalePrice;
    private Double mListPrice;
    private String mCurrency;
    private Double mDistance;
    private Double mRating;
    private String mDescription;

    private int    mCityId;
    private String mCity;
    private int    mCollegeId;
    private String mCollege;
    private int    mDormitoryTypeId;
    private String mDormitoryType;
    private int    mContractId;
    private String mContract;



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
     * @return the name
     */
    public String getName() {
        return mName;
    }



    /**
     * @param pName
     *            the name to set
     */
    public void setName(String pName) {
        mName = pName;
    }



    /**
     * @return the address
     */
    public String getAddress() {
        return mAddress;
    }



    /**
     * @param pAddress
     *            the address to set
     */
    public void setAddress(String pAddress) {
        mAddress = pAddress;
    }



    /**
     * @return the postCode
     */
    public String getPostCode() {
        return mPostCode;
    }



    /**
     * @param pPostCode
     *            the postCode to set
     */
    public void setPostCode(String pPostCode) {
        mPostCode = pPostCode;
    }



    /**
     * @return the equipment
     */
    public String getEquipment() {
        return mEquipment;
    }



    /**
     * @param pEquipment
     *            the equipment to set
     */
    public void setEquipment(String pEquipment) {
        mEquipment = pEquipment;
    }



    /**
     * @return the service
     */
    public String getService() {
        return mService;
    }



    /**
     * @param pService
     *            the service to set
     */
    public void setService(String pService) {
        mService = pService;
    }



    /**
     * @return the salePrice
     */
    public Double getSalePrice() {
        return mSalePrice;
    }



    /**
     * @param pSalePrice
     *            the salePrice to set
     */
    public void setSalePrice(Double pSalePrice) {
        mSalePrice = pSalePrice;
    }



    /**
     * @return the listPrice
     */
    public Double getListPrice() {
        return mListPrice;
    }



    /**
     * @param pListPrice
     *            the listPrice to set
     */
    public void setListPrice(Double pListPrice) {
        mListPrice = pListPrice;
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
     * @return the distance
     */
    public Double getDistance() {
        return mDistance;
    }



    /**
     * @param pDistance
     *            the distance to set
     */
    public void setDistance(Double pDistance) {
        mDistance = pDistance;
    }



    /**
     * @return the description
     */
    public String getDescription() {
        return mDescription;
    }



    /**
     * @param pDescription
     *            the description to set
     */
    public void setDescription(String pDescription) {
        mDescription = pDescription;
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
     * @return the city
     */
    public String getCity() {
        return mCity;
    }



    /**
     * @param pCity
     *            the city to set
     */
    public void setCity(String pCity) {
        mCity = pCity;
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
     * @return the college
     */
    public String getCollege() {
        return mCollege;
    }



    /**
     * @param pCollege
     *            the college to set
     */
    public void setCollege(String pCollege) {
        mCollege = pCollege;
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
     * @return the dormitoryType
     */
    public String getDormitoryType() {
        return mDormitoryType;
    }



    /**
     * @param pDormitoryType
     *            the dormitoryType to set
     */
    public void setDormitoryType(String pDormitoryType) {
        mDormitoryType = pDormitoryType;
    }



    /**
     * @return the contractId
     */
    public int getContractId() {
        return mContractId;
    }



    /**
     * @param pContractId
     *            the contractId to set
     */
    public void setContractId(int pContractId) {
        mContractId = pContractId;
    }



    /**
     * @return the contract
     */
    public String getContract() {
        return mContract;
    }



    /**
     * @param pContract
     *            the contract to set
     */
    public void setContract(String pContract) {
        mContract = pContract;
    }



    /**
     * @return the rating
     */
    public Double getRating() {
        return mRating;
    }



    /**
     * @param pRating
     *            the rating to set
     */
    public void setRating(Double pRating) {
        mRating = pRating;
    }

}
