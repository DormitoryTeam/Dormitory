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

import java.util.Date;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 27, 2014
 */

public class PickupLineItem extends LineItem {

    private String  mFlightNum;

    private Integer mCityId;

    private String  mLandingCity;

    private Date    mPickupDate;

    private int     mPickupType;

    private int     mLuggageAmount;

    private double  mLuggageSize;



    public Integer getCityId() {
        return mCityId;
    }



    /**
     * @return the flightNum
     */
    public String getFlightNum() {
        return mFlightNum;
    }



    /**
     * @return the landingCity
     */
    public String getLandingCity() {
        return mLandingCity;
    }



    /**
     * @return the luggageAmount
     */
    public int getLuggageAmount() {
        return mLuggageAmount;
    }



    /**
     * @return the luggageSize
     */
    public double getLuggageSize() {
        return mLuggageSize;
    }



    /**
     * @return the pickupDate
     */
    public Date getPickupDate() {
        return mPickupDate;
    }



    /**
     * @return the pickupType
     */
    public int getPickupType() {
        return mPickupType;
    }



    public void setCityId(final Integer pCityId) {
        mCityId = pCityId;
    }



    /**
     * @param pFlightNum
     *            the flightNum to set
     */
    public void setFlightNum(final String pFlightNum) {
        mFlightNum = pFlightNum;
    }



    /**
     * @param pLandingCity
     *            the landingCity to set
     */
    public void setLandingCity(final String pLandingCity) {
        mLandingCity = pLandingCity;
    }



    /**
     * @param pLuggageAmount
     *            the luggageAmount to set
     */
    public void setLuggageAmount(final int pLuggageAmount) {
        mLuggageAmount = pLuggageAmount;
    }



    /**
     * @param pLuggageSize
     *            the luggageSize to set
     */
    public void setLuggageSize(final double pLuggageSize) {
        mLuggageSize = pLuggageSize;
    }



    /**
     * @param pPickupDate
     *            the pickupDate to set
     */
    public void setPickupDate(final Date pPickupDate) {
        mPickupDate = pPickupDate;
    }



    /**
     * @param pPickupType
     *            the pickupType to set
     */
    public void setPickupType(final int pPickupType) {
        mPickupType = pPickupType;
    }
}
