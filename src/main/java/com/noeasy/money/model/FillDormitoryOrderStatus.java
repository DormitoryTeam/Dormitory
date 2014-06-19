package com.noeasy.money.model;

import org.apache.commons.lang3.StringUtils;

public class FillDormitoryOrderStatus {

    private boolean   mFillUserInfo;

    private boolean   mFillPrefer;

    private boolean   mFillContactInfo;

    private boolean   mFillNote;

    private boolean   mFillGuaranteeInfo;

    private OrderBean mOrder;

    private boolean   mCommit;



    public FillDormitoryOrderStatus() {
    }



    public FillDormitoryOrderStatus(OrderBean pOrder) {
        this.mOrder = pOrder;
        this.anaylze();
    }



    public void anaylze() {
        setFillUserInfo(isFillUserInfo(this.mOrder));
        setFillPrefer(isFillPrefer(this.mOrder));
        setFillContactInfo(isFillContactInfo(this.mOrder));
        setFillGuaranteeInfo(isFillGuaranteeInfo(this.mOrder));
        setFillNote(isFillNote(this.mOrder));
        setCommit(isFillUserInfo() && isFillPrefer() && isFillContactInfo() && isFillGuaranteeInfo() && isFillNote());
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



    private boolean isFillPrefer(OrderBean pOrder) {
        if (null == pOrder || null == pOrder.getOrderContact() || null == pOrder.getOrderContact().getPrefer()) {
            return false;
        }
        UserPreferBean prefer = pOrder.getOrderContact().getPrefer();
        if (null == prefer.getSmoke()) {
            return false;
        }
        if (null == prefer.getVegetarianism()) {
            return false;
        }
        if (StringUtils.isBlank(prefer.getYourGrade())) {
            return false;
        }
        if (StringUtils.isBlank(prefer.getRoomMemberGrade())) {
            return false;
        }
        if (null == prefer.getRoomMemberGender()) {
            return false;
        }
        if (StringUtils.isBlank(prefer.getMajor())) {
            return false;
        }
        if (StringUtils.isBlank(prefer.getCollege())) {
            return false;
        }
        if (StringUtils.isBlank(prefer.getFloor())) {
            return false;
        }
        return true;
    }



    private boolean isFillContactInfo(OrderBean pOrder) {
        if (null == pOrder) {
            return false;
        }
        if (null == pOrder.getOrderContact()) {
            return false;
        }
        if (null == pOrder.getOrderContact().getContactPersonInfo()) {
            return false;
        }
        UserInfoBean userInfo = pOrder.getOrderContact().getContactPersonInfo();
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
        if (StringUtils.isBlank(userInfo.getRelationship())) {
            return false;
        }
        return true;
    }



    private boolean isFillGuaranteeInfo(OrderBean pOrder) {
        if (null == pOrder) {
            return false;
        }
        if (null == pOrder.getOrderContact()) {
            return false;
        }
        if (null == pOrder.getOrderContact().getGuaranteeInfo()) {
            return false;
        }
        UserInfoBean userInfo = pOrder.getOrderContact().getGuaranteeInfo();
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
        if (StringUtils.isBlank(userInfo.getRelationship())) {
            return false;
        }
        return true;
    }



    private boolean isFillNote(OrderBean pOrder) {
        if (null == pOrder || null == pOrder.getOrderContact() || null == pOrder.getOrderContact().getPrefer()) {
            return false;
        }
        UserPreferBean prefer = pOrder.getOrderContact().getPrefer();
        if (StringUtils.isBlank(prefer.getGraduateSchool())) {
            return false;
        }
        if (null == prefer.getNeedPush()) {
            return false;
        }
        if (null == prefer.getReadClause()) {
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



    public boolean isFillPrefer() {
        return mFillPrefer;
    }



    public void setFillPrefer(boolean pFillPrefer) {
        mFillPrefer = pFillPrefer;
    }



    public boolean isFillContactInfo() {
        return mFillContactInfo;
    }



    public void setFillContactInfo(boolean pFillContactInfo) {
        mFillContactInfo = pFillContactInfo;
    }



    public boolean isFillNote() {
        return mFillNote;
    }



    public void setFillNote(boolean pFillNote) {
        mFillNote = pFillNote;
    }



    public boolean isFillGuaranteeInfo() {
        return mFillGuaranteeInfo;
    }



    public void setFillGuaranteeInfo(boolean pFillGuaranteeInfo) {
        mFillGuaranteeInfo = pFillGuaranteeInfo;
    }



    public boolean isCommit() {
        return mCommit;
    }



    public void setCommit(boolean pCommit) {
        mCommit = pCommit;
    }

    
}
