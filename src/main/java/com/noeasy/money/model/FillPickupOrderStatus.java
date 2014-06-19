package com.noeasy.money.model;

import org.apache.commons.lang3.StringUtils;

public class FillPickupOrderStatus {

    private boolean   mFillUserInfo;

    private boolean   mFillFlightInfo;

    private boolean   mFillDestinationInfo;

    private boolean   mFillLuggageInfo;

    private OrderBean mOrder;



    public FillPickupOrderStatus() {

    }



    public FillPickupOrderStatus(OrderBean pOrder) {
        this.mOrder = pOrder;
        this.anaylze();
    }



    public void anaylze() {
        setFillUserInfo(isFillUserInfo(this.mOrder));
        setFillFlightInfo(isFillFlightInfo(this.mOrder));
        setFillDestinationInfo(isFillDestinationInfo(this.mOrder));
        setFillLuggageInfo(isFillLuggageInfo(this.mOrder));
    }



    private boolean isFillLuggageInfo(OrderBean pOrder) {
        if (null == pOrder) {
            return false;
        }
        if (null == pOrder.getLineItems() || pOrder.getLineItems().isEmpty()) {
            return false;
        }
        if (!(pOrder.getLineItems().get(0) instanceof PickupLineItem)) {
            return false;
        }
        PickupLineItem item = (PickupLineItem) pOrder.getLineItems().get(0);
        item.analyzeLuggage();
        if (StringUtils.isNotBlank(item.getLuggageSize1())) {
            return true;
        }
        if (StringUtils.isNotBlank(item.getLuggageSize2())) {
            return true;
        }
        if (StringUtils.isNotBlank(item.getLuggageSize3())) {
            return true;
        }
        if (StringUtils.isNotBlank(item.getLuggageSize4())) {
            return true;
        }
        if (StringUtils.isNotBlank(item.getLuggageSize5())) {
            return true;
        }
            
        return false;
    }



    private boolean isFillDestinationInfo(OrderBean pOrder) {
        if (null == pOrder) {
            return false;
        }
        if (null == pOrder.getLineItems() || pOrder.getLineItems().isEmpty()) {
            return false;
        }
        if (!(pOrder.getLineItems().get(0) instanceof PickupLineItem)) {
            return false;
        }
        PickupLineItem item = (PickupLineItem) pOrder.getLineItems().get(0);
        if (StringUtils.isBlank(item.getPickup2City())) {
            return false;
        }
        if (StringUtils.isBlank(item.getPickup2Address())) {
            return false;
        }
        if (StringUtils.isBlank(item.getPickup2Dormitory())) {
            return false;
        }
        if (StringUtils.isBlank(item.getPickup2Postalcode())) {
            return false;
        }
        return true;
    }



    private boolean isFillFlightInfo(OrderBean pOrder) {
        if (null == pOrder) {
            return false;
        }
        if (null == pOrder.getLineItems() || pOrder.getLineItems().isEmpty()) {
            return false;
        }
        if (!(pOrder.getLineItems().get(0) instanceof PickupLineItem)) {
            return false;
        }
        PickupLineItem item = (PickupLineItem) pOrder.getLineItems().get(0);
        if (null == item.getTakeOffDate()) {
            return false;
        }
        if (null == item.getPickupDate()) {
            return false;
        }
        if (StringUtils.isBlank(item.getTakeOffCity())) {
            return false;
        }
        if (StringUtils.isBlank(item.getArrivalCity())) {
            return false;
        }
        if (StringUtils.isBlank(item.getArrivalCountry())) {
            return false;
        }
        if (StringUtils.isBlank(item.getArrivalAirport())) {
            return false;
        }
        if (StringUtils.isBlank(item.getFlightCompany())) {
            return false;
        }
        if (StringUtils.isBlank(item.getFlightNum())) {
            return false;
        }
        return true;
    }



    private boolean isFillUserInfo(OrderBean pOrder) {
        if (null == pOrder) {
            return false;
        }
        if (null == pOrder.getOrderContact()) {
            return false;
        }
        if (null == pOrder.getOrderContact().getBelongsToInfo()) {
            return false;
        }
        UserInfoBean userInfo = pOrder.getOrderContact().getBelongsToInfo();
        if (StringUtils.isBlank(userInfo.getName())) {
            return false;
        }
        if (StringUtils.isBlank(userInfo.getLastName())) {
            return false;
        }
        if (StringUtils.isBlank(userInfo.getNationality())) {
            return false;
        }
        if (StringUtils.isBlank(userInfo.getEmail())) {
            return false;
        }
        if (StringUtils.isBlank(userInfo.getQq())) {
            return false;
        }
        if (StringUtils.isBlank(userInfo.getWechat())) {
            return false;
        }
        if (StringUtils.isBlank(userInfo.getPhone())) {
            return false;
        }
        if (StringUtils.isBlank(userInfo.getCountry())) {
            return false;
        }
        if (StringUtils.isBlank(userInfo.getProvince())) {
            return false;
        }
        if (StringUtils.isBlank(userInfo.getCity())) {
            return false;
        }
        if (StringUtils.isBlank(userInfo.getAddress())) {
            return false;
        }
        if (null == userInfo.getBirthday()) {
            return false;
        }
        if (userInfo.getGender() < 0) {
            return false;
        }
        if (StringUtils.isBlank(userInfo.getCounty())) {
            return false;
        }
        if (StringUtils.isBlank(userInfo.getPostalcode())) {
            return false;
        }
        return true;
    }



    public boolean isFillUserInfo() {
        return mFillUserInfo;
    }



    public void setFillUserInfo(boolean pFillUserInfo) {
        mFillUserInfo = pFillUserInfo;
    }



    public boolean isFillFlightInfo() {
        return mFillFlightInfo;
    }



    public void setFillFlightInfo(boolean pFillFlightInfo) {
        mFillFlightInfo = pFillFlightInfo;
    }



    public boolean isFillDestinationInfo() {
        return mFillDestinationInfo;
    }



    public void setFillDestinationInfo(boolean pFillDestinationInfo) {
        mFillDestinationInfo = pFillDestinationInfo;
    }



    public boolean isFillLuggageInfo() {
        return mFillLuggageInfo;
    }



    public void setFillLuggageInfo(boolean pFillLuggageInfo) {
        mFillLuggageInfo = pFillLuggageInfo;
    }

}
