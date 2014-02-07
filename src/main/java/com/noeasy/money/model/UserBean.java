package com.noeasy.money.model;

import java.util.Calendar;
import java.util.Date;

public class UserBean extends BaseBean {

    private Integer id;

    private String  login;

    private String  name;

    private String  password;
    private String  email;
    private boolean gender;
    private String  passport;
    private Date    birthday;
    private String  address;
    private String  phone;
    private String  qq;



    public String getAddress() {
        return address;
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



    public Date getBirthday() {
        return birthday;
    }



    public String getEmail() {
        return email;
    }



    public Integer getId() {
        return id;
    }



    public String getLogin() {
        return login;
    }



    /**
     * @return the name
     */
    public String getName() {
        return name;
    }



    public String getPassport() {
        return passport;
    }



    public String getPassword() {
        return password;
    }



    public String getPhone() {
        return phone;
    }



    public String getQq() {
        return qq;
    }



    public boolean isGender() {
        return gender;
    }



    public void setAddress(final String pAddress) {
        address = pAddress;
    }



    public void setBirthday(final Date pBirthday) {
        birthday = pBirthday;
    }



    public void setEmail(final String pEmail) {
        email = pEmail;
    }



    public void setGender(final boolean pGender) {
        gender = pGender;
    }



    public void setId(final Integer pId) {
        id = pId;
    }



    public void setLogin(final String pLogin) {
        login = pLogin;
    }



    /**
     * @param pName
     *            the name to set
     */
    public void setName(final String pName) {
        name = pName;
    }



    public void setPassport(final String pPassport) {
        passport = pPassport;
    }



    public void setPassword(final String pPassword) {
        password = pPassword;
    }



    public void setPhone(final String pPhone) {
        phone = pPhone;
    }



    public void setQq(final String pQq) {
        qq = pQq;
    }

}
