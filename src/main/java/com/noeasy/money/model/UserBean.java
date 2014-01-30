package com.noeasy.money.model;

import java.util.Calendar;
import java.util.Date;

public class UserBean extends BaseBean {

    private Integer  id;
    private String  login;
    private String  password;
    private String  email;
    private boolean genter;
    private String  passport;
    private Date    birthday;
    private String  address;
    private String  phone;
    private String  qq;



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



    public String getEmail() {
        return email;
    }



    public void setEmail(String pEmail) {
        email = pEmail;
    }



    public boolean isGenter() {
        return genter;
    }



    public void setGenter(boolean pGenter) {
        genter = pGenter;
    }



    public String getPassport() {
        return passport;
    }



    public void setPassport(String pPassport) {
        passport = pPassport;
    }



    public Date getBirthday() {
        return birthday;
    }



    public void setBirthday(Date pBirthday) {
        birthday = pBirthday;
    }



    public String getAddress() {
        return address;
    }



    public void setAddress(String pAddress) {
        address = pAddress;
    }



    public String getPhone() {
        return phone;
    }



    public void setPhone(String pPhone) {
        phone = pPhone;
    }



    public String getQq() {
        return qq;
    }



    public void setQq(String pQq) {
        qq = pQq;
    }

    
    public int getAge() {
        if (null == getBirthday()) {
            return 0;
        }
        Calendar birth = Calendar.getInstance();
        birth.setTime(this.getBirthday());
        Calendar today = Calendar.getInstance();
        today.setTime(new Date());
        return today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
    }
}
