package com.noeasy.money.model;

import java.util.Calendar;
import java.util.Date;

public class UserInfoBean extends BaseBean {
    private Integer id;
    private String  name;
    private String  nationality;
    private int     gender;
    private Date    birthday;
    private String  email;
    private String  qq;
    private String  wechat;
    private String  phone;
    private String  country;
    private String  province;
    private String  city;
    private String  address;



    public Integer getId() {
        return id;
    }



    public void setId(Integer pId) {
        id = pId;
    }



    public String getName() {
        return name;
    }



    public void setName(String pName) {
        name = pName;
    }



    public String getNationality() {
        return nationality;
    }



    public void setNationality(String pNationality) {
        nationality = pNationality;
    }



    public int getGender() {
        return gender;
    }



    public void setGender(int pGender) {
        gender = pGender;
    }



    public Date getBirthday() {
        return birthday;
    }



    public void setBirthday(Date pBirthday) {
        birthday = pBirthday;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String pEmail) {
        email = pEmail;
    }



    public String getQq() {
        return qq;
    }



    public void setQq(String pQq) {
        qq = pQq;
    }



    public String getWechat() {
        return wechat;
    }



    public void setWechat(String pWechat) {
        wechat = pWechat;
    }



    public String getPhone() {
        return phone;
    }



    public void setPhone(String pPhone) {
        phone = pPhone;
    }



    public String getCountry() {
        return country;
    }



    public void setCountry(String pCountry) {
        country = pCountry;
    }



    public String getProvince() {
        return province;
    }



    public void setProvince(String pProvince) {
        province = pProvince;
    }



    public String getCity() {
        return city;
    }



    public void setCity(String pCity) {
        city = pCity;
    }



    public String getAddress() {
        return address;
    }



    public void setAddress(String pAddress) {
        address = pAddress;
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
