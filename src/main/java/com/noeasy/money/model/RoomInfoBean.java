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

import java.util.ArrayList;
import java.util.List;

import com.noeasy.money.enumeration.DormitoryStatus;
import com.noeasy.money.enumeration.Orientation;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Mar 22, 2014
 */

public class RoomInfoBean extends BaseBean {

    private int             mId;

    private String          name;

    private Integer         mDormitoryId;

    private Integer         mRoomTypeId;

    private String          mRoomType;

    private String          mDescription;

    private String          mCheckinDate;

    private List<RoomPrice> mContractPrice = new ArrayList<RoomPrice>();

    private Orientation     mOrientation;

    private String          mFloors;

    private String          mBedType;

    private String          mHouseArea;

    private boolean         mEnsuitBathroom;

    private String          mKitchenPeople;

    private boolean         mFloorArrange;

    private boolean         mOrientationArrange;

    private boolean         mRoomLanguageArrange;

    private String          mKitchenEquipment;

    private String          mBathroomEquipment;

    private String          mStatus;

    private String          mService;

    private String          mEquipment;



    public RoomInfoBean() {

    }



    /**
     * @return the bathroomEquipment
     */
    public String getBathroomEquipment() {
        return mBathroomEquipment;
    }



    /**
     * @return the bedType
     */
    public String getBedType() {
        return mBedType;
    }



    /**
     * @return the checkinDate
     */
    public String getCheckinDate() {
        return mCheckinDate;
    }



    /**
     * @return the contractPrice
     */
    public List<RoomPrice> getContractPrice() {
        return mContractPrice;
    }



    /**
     * @return the description
     */
    public String getDescription() {
        return mDescription;
    }



    /**
     * @return the dormitoryId
     */
    public Integer getDormitoryId() {
        return mDormitoryId;
    }



    /**
     * @return the equipment
     */
    public String getEquipment() {
        return mEquipment;
    }



    /**
     * @return the floors
     */
    public String getFloors() {
        return mFloors;
    }



    /**
     * @return the houseArea
     */
    public String getHouseArea() {
        return mHouseArea;
    }



    /**
     * @return the id
     */
    public int getId() {
        return mId;
    }



    /**
     * @return the kitchenEquipment
     */
    public String getKitchenEquipment() {
        return mKitchenEquipment;
    }



    /**
     * @return the name
     */
    public String getName() {
        return name;
    }



    /**
     * @return the orientation
     */
    public Orientation getOrientation() {
        return mOrientation;
    }



    /**
     * @return the roomType
     */
    public String getRoomType() {
        return mRoomType;
    }



    /**
     * @return the roomTypeId
     */
    public Integer getRoomTypeId() {
        return mRoomTypeId;
    }



    /**
     * @return the service
     */
    public String getService() {
        return mService;
    }



    /**
     * @return the ensuitBathroom
     */
    public boolean isEnsuitBathroom() {
        return mEnsuitBathroom;
    }



    /**
     * @return the floorArrange
     */
    public boolean isFloorArrange() {
        return mFloorArrange;
    }



    /**
     * @return the orientationArrange
     */
    public boolean isOrientationArrange() {
        return mOrientationArrange;
    }



    /**
     * @return the roomLanguageArrange
     */
    public boolean isRoomLanguageArrange() {
        return mRoomLanguageArrange;
    }



    /**
     * @param pBathroomEquipment
     *            the bathroomEquipment to set
     */
    public void setBathroomEquipment(final String pBathroomEquipment) {
        mBathroomEquipment = pBathroomEquipment;
    }



    /**
     * @param pBedType
     *            the bedType to set
     */
    public void setBedType(final String pBedType) {
        mBedType = pBedType;
    }



    /**
     * @param pCheckinDate
     *            the checkinDate to set
     */
    public void setCheckinDate(final String pCheckinDate) {
        mCheckinDate = pCheckinDate;
    }



    /**
     * @param pContractPrice
     *            the contractPrice to set
     */
    public void setContractPrice(final List<RoomPrice> pContractPrice) {
        mContractPrice = pContractPrice;
    }



    /**
     * @param pDescription
     *            the description to set
     */
    public void setDescription(final String pDescription) {
        mDescription = pDescription;
    }



    /**
     * @param pDormitoryId
     *            the dormitoryId to set
     */
    public void setDormitoryId(final Integer pDormitoryId) {
        mDormitoryId = pDormitoryId;
    }



    /**
     * @param pEnsuitBathroom
     *            the ensuitBathroom to set
     */
    public void setEnsuitBathroom(final boolean pEnsuitBathroom) {
        mEnsuitBathroom = pEnsuitBathroom;
    }



    /**
     * @param pEquipment
     *            the equipment to set
     */
    public void setEquipment(final String pEquipment) {
        mEquipment = pEquipment;
    }



    /**
     * @param pFloorArrange
     *            the floorArrange to set
     */
    public void setFloorArrange(final boolean pFloorArrange) {
        mFloorArrange = pFloorArrange;
    }



    /**
     * @param pFloors
     *            the floors to set
     */
    public void setFloors(final String pFloors) {
        mFloors = pFloors;
    }



    /**
     * @param pHouseArea
     *            the houseArea to set
     */
    public void setHouseArea(final String pHouseArea) {
        mHouseArea = pHouseArea;
    }



    /**
     * @param pId
     *            the id to set
     */
    public void setId(final int pId) {
        mId = pId;
    }



    /**
     * @param pKitchenEquipment
     *            the kitchenEquipment to set
     */
    public void setKitchenEquipment(final String pKitchenEquipment) {
        mKitchenEquipment = pKitchenEquipment;
    }



    public String getKitchenPeople() {
        return mKitchenPeople;
    }



    public void setKitchenPeople(String pKitchenPeople) {
        mKitchenPeople = pKitchenPeople;
    }



    /**
     * @param pName
     *            the name to set
     */
    public void setName(final String pName) {
        name = pName;
    }



    /**
     * @param pOrientation
     *            the orientation to set
     */
    public void setOrientation(final Orientation pOrientation) {
        mOrientation = pOrientation;
    }



    /**
     * @param pOrientationArrange
     *            the orientationArrange to set
     */
    public void setOrientationArrange(final boolean pOrientationArrange) {
        mOrientationArrange = pOrientationArrange;
    }



    /**
     * @param pRoomLanguageArrange
     *            the roomLanguageArrange to set
     */
    public void setRoomLanguageArrange(final boolean pRoomLanguageArrange) {
        mRoomLanguageArrange = pRoomLanguageArrange;
    }



    /**
     * @param pRoomType
     *            the roomType to set
     */
    public void setRoomType(final String pRoomType) {
        mRoomType = pRoomType;
    }



    /**
     * @param pRoomTypeId
     *            the roomTypeId to set
     */
    public void setRoomTypeId(final Integer pRoomTypeId) {
        mRoomTypeId = pRoomTypeId;
    }



    /**
     * @param pService
     *            the service to set
     */
    public void setService(final String pService) {
        mService = pService;
    }



    public String getStatus() {
        return mStatus;
    }



    public void setStatus(String pStatus) {
        mStatus = pStatus;
    }

}
