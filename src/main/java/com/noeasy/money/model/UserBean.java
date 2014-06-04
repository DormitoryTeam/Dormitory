package com.noeasy.money.model;

public class UserBean extends BaseBean {

    private Integer        id;

    private String         login;

    private String         password;

    private String         alias;

    private String         email;

    private String         resetPasswordSign;

    private UserInfoBean   info;

    private UserInfoBean   guaranteeInfo;

    private UserInfoBean   contactPersonInfo;

    private UserPreferBean prefer;

    private String         code;

    private String         token;



    public String getAlias() {
        return alias;
    }



    public String getCode() {
        return code;
    }



    public UserInfoBean getContactPersonInfo() {
        return contactPersonInfo;
    }



    public String getEmail() {
        return email;
    }



    public UserInfoBean getGuaranteeInfo() {
        return guaranteeInfo;
    }



    public Integer getId() {
        return id;
    }



    public UserInfoBean getInfo() {
        return info;
    }



    public String getLogin() {
        return login;
    }



    public String getNewCode() {
        String idStr = getId().toString();
        String result = getCode().substring(0, 10 - idStr.length()) + idStr;
        result = result.replace("0", "x");
        result = result.replace("o", "x");
        result = result.replace("O", "x");
        result = result.replace("1", "X");
        result = result.replace("l", "X");
        result = result.replace("L", "X");
        return result;
    }



    public String getPassword() {
        return password;
    }



    public UserPreferBean getPrefer() {
        return prefer;
    }



    public String getResetPasswordSign() {
        return resetPasswordSign;
    }



    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }



    public void setAlias(final String pAlias) {
        alias = pAlias;
    }



    public void setCode(final String pCode) {
        code = pCode;
    }



    public void setContactPersonInfo(final UserInfoBean pContactPersonInfo) {
        contactPersonInfo = pContactPersonInfo;
    }



    public void setEmail(final String pEmail) {
        email = pEmail;
    }



    public void setGuaranteeInfo(final UserInfoBean pGuaranteeInfo) {
        guaranteeInfo = pGuaranteeInfo;
    }



    public void setId(final Integer pId) {
        id = pId;
    }



    public void setInfo(final UserInfoBean pInfo) {
        info = pInfo;
    }



    public void setLogin(final String pLogin) {
        login = pLogin;
    }



    public void setPassword(final String pPassword) {
        password = pPassword;
    }



    public void setPrefer(final UserPreferBean pPrefer) {
        prefer = pPrefer;
    }



    public void setResetPasswordSign(final String pResetPasswordSign) {
        resetPasswordSign = pResetPasswordSign;
    }



    // public void setNewCode() {
    //
    // }

    /**
     * @param pToken
     *            the token to set
     */
    public void setToken(final String pToken) {
        token = pToken;
    }
}