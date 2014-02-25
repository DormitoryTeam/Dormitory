package com.noeasy.money.service;

import java.util.List;

import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserSearchBean;

public interface IUserService {

    public static final int PASSWORD_NOT_MATCH      = 0;
    public static final int PASSWORD_CHANGE_SUCCESS = 1;



    UserBean register(String login, String password);



    boolean saveOrUpdate(UserBean bean);



    List<UserBean> queryUser(UserSearchBean searchBean);



    boolean exist(String pLogin);



    boolean exist(String pLogin, String pPassword);



    int changePassword(String pLogin, String pOldPassword, String pNewPassword);



    boolean resetPassword(String pLogin, String pPassword);



    int updateUser(UserBean pUser);



    UserBean generateResetPasswordSign(String pLogin);



    Integer queryUserCount(UserSearchBean pSearchBean);
}
