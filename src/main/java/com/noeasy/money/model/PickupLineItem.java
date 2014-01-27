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

    private String mFlightNum;

    private String mLandingCity;

    private Date   mPickupDate;

    private int    mPickupType;

    private int    mLuggageAmount;

    private double mLuggageSize;



    /**
     * @return the flightNum
     */
    public String getFlightNum() {
        return mFlightNum;
    }



    /**
     * @param pFlightNum
     *            the flightNum to set
     */
    public void setFlightNum(String pFlightNum) {
        mFlightNum = pFlightNum;
    }



    /**
     * @return the landingCity
     */
    public String getLandingCity() {
        return mLandingCity;
    }



    /**
     * @param pLandingCity
     *            the landingCity to set
     */
    public void setLandingCity(String pLandingCity) {
        mLandingCity = pLandingCity;
    }



    /**
     * @return the pickupDate
     */
    public Date getPickupDate() {
        return mPickupDate;
    }



    /**
     * @param pPickupDate
     *            the pickupDate to set
     */
    public void setPickupDate(Date pPickupDate) {
        mPickupDate = pPickupDate;
    }



    /**
     * @return the pickupType
     */
    public int getPickupType() {
        return mPickupType;
    }



    /**
     * @param pPickupType
     *            the pickupType to set
     */
    public void setPickupType(int pPickupType) {
        mPickupType = pPickupType;
    }



    /**
     * @return the luggageAmount
     */
    public int getLuggageAmount() {
        return mLuggageAmount;
    }



    /**
     * @param pLuggageAmount
     *            the luggageAmount to set
     */
    public void setLuggageAmount(int pLuggageAmount) {
        mLuggageAmount = pLuggageAmount;
    }



    /**
     * @return the luggageSize
     */
    public double getLuggageSize() {
        return mLuggageSize;
    }



    /**
     * @param pLuggageSize
     *            the luggageSize to set
     */
    public void setLuggageSize(double pLuggageSize) {
        mLuggageSize = pLuggageSize;
    }
}
