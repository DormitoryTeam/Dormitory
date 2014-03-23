package com.noeasy.money.model;


public class UserBean extends BaseBean {

    private Integer      id;

    private String       login;

    private String       password;

    private String       alias;

    private String       email;

    private String       resetPasswordSign;

    private UserInfoBean info;

    private UserInfoBean guaranteeInfo;

    private UserInfoBean contactPersonInfo;

    private UserPreferBean prefer;


    public Integer getId() {
        return id;
    }



    public void setId(Integer pId) {
        id = pId;
    }



    public String getLogin() {
        return login;
    }



    public void setLogin(String pLogin) {
        login = pLogin;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String pPassword) {
        password = pPassword;
    }



    public String getAlias() {
        return alias;
    }



    public void setAlias(String pAlias) {
        alias = pAlias;
    }



    public String getResetPasswordSign() {
        return resetPasswordSign;
    }



    public void setResetPasswordSign(String pResetPasswordSign) {
        resetPasswordSign = pResetPasswordSign;
    }



    public UserInfoBean getInfo() {
        return info;
    }



    public void setInfo(UserInfoBean pInfo) {
        info = pInfo;
    }



    public UserInfoBean getGuaranteeInfo() {
        return guaranteeInfo;
    }



    public void setGuaranteeInfo(UserInfoBean pGuaranteeInfo) {
        guaranteeInfo = pGuaranteeInfo;
    }



    public UserInfoBean getContactPersonInfo() {
        return contactPersonInfo;
    }



    public void setContactPersonInfo(UserInfoBean pContactPersonInfo) {
        contactPersonInfo = pContactPersonInfo;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String pEmail) {
        email = pEmail;
    }



    public UserPreferBean getPrefer() {
        return prefer;
    }



    public void setPrefer(UserPreferBean pPrefer) {
        prefer = pPrefer;
    }

    
}