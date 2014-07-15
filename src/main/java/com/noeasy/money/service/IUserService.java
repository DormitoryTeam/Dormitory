package com.noeasy.money.service;

import java.util.List;

import com.noeasy.money.model.OrderContactInfo;
import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserPreferBean;
import com.noeasy.money.model.UserSearchBean;

public interface IUserService {

    public static final int PASSWORD_NOT_MATCH      = 0;
    public static final int PASSWORD_CHANGE_SUCCESS = 1;

    enum INFO_TYPE {
        USER_INFO, GUARANTEE_INFO, CONTACT_PERSON_INFO;
    }

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



    void saveUserInfo(UserBean pUser);



    void saveUserPrefer(UserBean pUser);



    void saveUserInfo(OrderContactInfo contactInfo, INFO_TYPE infoType);
    
    
    void saveUserPrder(OrderContactInfo contactInfo);

    UserPreferBean findUserPreferById(Integer pId);


    UserBean findUserById(Integer pUserId);
    
    UserBean findUserByLogin(String pLogin);
}
