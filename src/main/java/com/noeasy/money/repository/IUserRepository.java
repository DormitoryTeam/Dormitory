package com.noeasy.money.repository;

import java.util.List;

import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserInfoBean;
import com.noeasy.money.model.UserPreferBean;
import com.noeasy.money.model.UserSearchBean;

public interface IUserRepository {
    int register(UserBean pBean);



    List<UserBean> queryUser(UserSearchBean pSearchBean);



    int saveUser(UserBean pBean);



    int updateUser(UserBean pBean);



    int resetPassword(UserBean pUser);



    int updateResetPasswordSign(UserBean pUser);



    Integer queryUserCount(UserSearchBean pSearchBean);



    void updateUserInfo(UserInfoBean pUserInfo);



    Integer createUserInfo(UserInfoBean pUserInfo);



    void setInfo2User(UserBean pUser);



    void setGuaranteeInfo2User(UserBean pUser);



    void setContactPersonInfo2User(UserBean pUser);



    void updateUserPrefer(UserPreferBean pUserPrefer);



    Integer createUserPrefer(UserPreferBean pUserPrefer);



    void setPrefer2User(UserBean pUser);



}
