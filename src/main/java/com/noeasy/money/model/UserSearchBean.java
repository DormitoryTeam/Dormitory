package com.noeasy.money.model;

public class UserSearchBean {
    private Integer id;
    private String  login;
    private String  password;
    private String  name;
    private String  groupId;
    private String  sign;
    private String  searchKey;
    private PageBean page;
    private String  token;


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



    public String getName() {
        return name;
    }



    public void setName(String pName) {
        name = pName;
    }



    public String getGroupId() {
        return groupId;
    }



    public void setGroupId(String pGroupId) {
        groupId = pGroupId;
    }



    public String getSign() {
        return sign;
    }



    public void setSign(String pSign) {
        sign = pSign;
    }



    public String getSearchKey() {
        return searchKey;
    }



    public void setSearchKey(String pSearchKey) {
        searchKey = pSearchKey;
    }



    public PageBean getPage() {
        return page;
    }



    public void setPage(PageBean pPage) {
        page = pPage;
    }



    public String getToken() {
        return token;
    }



    public void setToken(String pToken) {
        token = pToken;
    }
    

}
