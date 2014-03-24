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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.noeasy.money.enumeration.Orientation;
import com.noeasy.money.enumeration.RoomStatus;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Mar 22, 2014
 */

public class RoomInfoBean extends DormitoryRoomBean {

    private int             mId;

    private int             mDormitoryId;

    private int             mRoomTypeId;

    private String          mRoomType;

    private String          mDescription;

    private Date            mCheckinDate;

    private String          mCheckinDateString;

    private List<RoomPrice> mContractPrice;

    private Orientation     mOrientation;

    private String          mFloors;

    private String          mBedType;

    private String          mHouseArea;

    private boolean         mEnsuitBathroom;

    private int             mKitchenPeople;

    private boolean         mFloorArrange;

    private boolean         mOrientationArrange;

    private boolean         mRoomLanguageArrange;

    private String          mKitchenEquipment;

    private String          mBathroomEquipment;

    private RoomStatus      mStatus;



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
    public Date getCheckinDate() {
        return mCheckinDate;
    }



    /**
     * @return the checkinDateString
     */
    public String getCheckinDateString() {
        return mCheckinDateString;
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
    public int getDormitoryId() {
        return mDormitoryId;
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
     * @return the kitchenPeople
     */
    public int getKitchenPeople() {
        return mKitchenPeople;
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
    public int getRoomTypeId() {
        return mRoomTypeId;
    }



    /**
     * @return the status
     */
    public RoomStatus getStatus() {
        return mStatus;
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
    public void setCheckinDate(final Date pCheckinDate) {
        mCheckinDate = pCheckinDate;
        if (mCheckinDate != null) {
            setCheckinDateString((new SimpleDateFormat("yyyy-MM-dd")).format(mCheckinDate));
        }
    }



    /**
     * @param pCheckinDateString
     *            the checkinDateString to set
     */
    public void setCheckinDateString(final String pCheckinDateString) {
        mCheckinDateString = pCheckinDateString;
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
    public void setDormitoryId(final int pDormitoryId) {
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



    /**
     * @param pKitchenPeople
     *            the kitchenPeople to set
     */
    public void setKitchenPeople(final int pKitchenPeople) {
        mKitchenPeople = pKitchenPeople;
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
    public void setRoomTypeId(final int pRoomTypeId) {
        mRoomTypeId = pRoomTypeId;
    }



    /**
     * @param pStatus
     *            the status to set
     */
    public void setStatus(final RoomStatus pStatus) {
        mStatus = pStatus;
    }

}
