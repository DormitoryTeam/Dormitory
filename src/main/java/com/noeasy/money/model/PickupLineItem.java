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

import org.apache.commons.lang3.StringUtils;

import com.noeasy.money.enumeration.PickupType;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 27, 2014
 */

public class PickupLineItem extends LineItem {

    private String     flightNum;

    private Integer    cityId;

    private String     landingCity;

    private Date       pickupDate;

    private PickupType pickupType;

    private String     luggageAmount;

    private String     luggageSize;

    private Date       takeOffDate;

    private String     takeOffCity;

    private String     arrivalCity;

    private String     arrivalCountry;

    private String     arrivalAirport;

    private String     flightCompany;

    private String     pickup2City;

    private String     pickup2Address;

    private String     pickup2Dormitory;

    private String     pickup2Postalcode;
    
    private String     luggageAmount1;

    private String     luggageSize1;
    
    private String     luggageAmount2;

    private String     luggageSize2;
    
    private String     luggageAmount3;

    private String     luggageSize3;
    
    private String     luggageAmount4;

    private String     luggageSize4;
    
    private String     luggageAmount5;

    private String     luggageSize5;



    public void analyzeLuggage() {
        if (StringUtils.isNotBlank(luggageAmount)) {
            String[] tempAmounts = luggageAmount.split(":");
            int i = 0;
            while(i < tempAmounts.length) {
                switch (i) {
                case 0:
                    this.setLuggageAmount1(tempAmounts[i]);
                    break;
                case 1:
                    this.setLuggageAmount2(tempAmounts[i]);
                    break;
                case 2:
                    this.setLuggageAmount3(tempAmounts[i]);
                    break;
                case 3:
                    this.setLuggageAmount4(tempAmounts[i]);
                    break;
                case 4:
                    this.setLuggageAmount5(tempAmounts[i]);
                    break;
                }
                i++;
            }
        }
        
        if (StringUtils.isNotBlank(luggageSize)) {
            String[] tempSizes = luggageSize.split(":");
            int i = 0;
            while(i < tempSizes.length) {
                switch (i) {
                case 0:
                    this.setLuggageSize1(tempSizes[i]);
                    break;
                case 1:
                    this.setLuggageSize2(tempSizes[i]);
                    break;
                case 2:
                    this.setLuggageSize3(tempSizes[i]);
                    break;
                case 3:
                    this.setLuggageSize4(tempSizes[i]);
                    break;
                case 4:
                    this.setLuggageSize5(tempSizes[i]);
                    break;
                }
                i++;
            }
        }
    }
    
    public String getFlightNum() {
        return flightNum;
    }



    public void setFlightNum(String pFlightNum) {
        flightNum = pFlightNum;
    }



    public Integer getCityId() {
        return cityId;
    }



    public void setCityId(Integer pCityId) {
        cityId = pCityId;
    }



    public String getLandingCity() {
        return landingCity;
    }



    public void setLandingCity(String pLandingCity) {
        landingCity = pLandingCity;
    }



    public Date getPickupDate() {
        return pickupDate;
    }



    public void setPickupDate(Date pPickupDate) {
        pickupDate = pPickupDate;
    }



    public PickupType getPickupType() {
        return pickupType;
    }



    public void setPickupType(PickupType pPickupType) {
        pickupType = pPickupType;
    }



    public String getLuggageAmount() {
        return luggageAmount;
    }



    public void setLuggageAmount(String pLuggageAmount) {
        luggageAmount = pLuggageAmount;
    }



    public String getLuggageSize() {
        return luggageSize;
    }



    public void setLuggageSize(String pLuggageSize) {
        luggageSize = pLuggageSize;
    }



    public Date getTakeOffDate() {
        return takeOffDate;
    }



    public void setTakeOffDate(Date pTakeOffDate) {
        takeOffDate = pTakeOffDate;
    }



    public String getTakeOffCity() {
        return takeOffCity;
    }



    public void setTakeOffCity(String pTakeOffCity) {
        takeOffCity = pTakeOffCity;
    }



    public String getArrivalCity() {
        return arrivalCity;
    }



    public void setArrivalCity(String pArrivalCity) {
        arrivalCity = pArrivalCity;
    }



    public String getArrivalCountry() {
        return arrivalCountry;
    }



    public void setArrivalCountry(String pArrivalCountry) {
        arrivalCountry = pArrivalCountry;
    }



    public String getArrivalAirport() {
        return arrivalAirport;
    }



    public void setArrivalAirport(String pArrivalAirport) {
        arrivalAirport = pArrivalAirport;
    }



    public String getFlightCompany() {
        return flightCompany;
    }



    public void setFlightCompany(String pFlightCompany) {
        flightCompany = pFlightCompany;
    }



    public String getPickup2City() {
        return pickup2City;
    }



    public void setPickup2City(String pPickup2City) {
        pickup2City = pPickup2City;
    }



    public String getPickup2Address() {
        return pickup2Address;
    }



    public void setPickup2Address(String pPickup2Address) {
        pickup2Address = pPickup2Address;
    }



    public String getPickup2Dormitory() {
        return pickup2Dormitory;
    }



    public void setPickup2Dormitory(String pPickup2Dormitory) {
        pickup2Dormitory = pPickup2Dormitory;
    }



    public String getPickup2Postalcode() {
        return pickup2Postalcode;
    }



    public void setPickup2Postalcode(String pPickup2Postalcode) {
        pickup2Postalcode = pPickup2Postalcode;
    }



    public String getLuggageAmount1() {
        return luggageAmount1;
    }



    public void setLuggageAmount1(String pLuggageAmount1) {
        luggageAmount1 = pLuggageAmount1;
    }



    public String getLuggageSize1() {
        return luggageSize1;
    }



    public void setLuggageSize1(String pLuggageSize1) {
        luggageSize1 = pLuggageSize1;
    }



    public String getLuggageAmount2() {
        return luggageAmount2;
    }



    public void setLuggageAmount2(String pLuggageAmount2) {
        luggageAmount2 = pLuggageAmount2;
    }



    public String getLuggageSize2() {
        return luggageSize2;
    }



    public void setLuggageSize2(String pLuggageSize2) {
        luggageSize2 = pLuggageSize2;
    }



    public String getLuggageAmount3() {
        return luggageAmount3;
    }



    public void setLuggageAmount3(String pLuggageAmount3) {
        luggageAmount3 = pLuggageAmount3;
    }



    public String getLuggageSize3() {
        return luggageSize3;
    }



    public void setLuggageSize3(String pLuggageSize3) {
        luggageSize3 = pLuggageSize3;
    }



    public String getLuggageAmount4() {
        return luggageAmount4;
    }



    public void setLuggageAmount4(String pLuggageAmount4) {
        luggageAmount4 = pLuggageAmount4;
    }



    public String getLuggageSize4() {
        return luggageSize4;
    }



    public void setLuggageSize4(String pLuggageSize4) {
        luggageSize4 = pLuggageSize4;
    }



    public String getLuggageAmount5() {
        return luggageAmount5;
    }



    public void setLuggageAmount5(String pLuggageAmount5) {
        luggageAmount5 = pLuggageAmount5;
    }



    public String getLuggageSize5() {
        return luggageSize5;
    }



    public void setLuggageSize5(String pLuggageSize5) {
        luggageSize5 = pLuggageSize5;
    }

}
