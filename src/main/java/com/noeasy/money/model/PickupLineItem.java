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

    private int        luggageAmount;

    private double     luggageSize;

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



    public int getLuggageAmount() {
        return luggageAmount;
    }



    public void setLuggageAmount(int pLuggageAmount) {
        luggageAmount = pLuggageAmount;
    }



    public double getLuggageSize() {
        return luggageSize;
    }



    public void setLuggageSize(double pLuggageSize) {
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

}
