package com.noeasy.money.repository;

import java.util.List;

import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserSearchBean;

public interface IUserRepository {
    int register(UserBean pBean);



    List<UserBean> queryUser(UserSearchBean pSearchBean);



    int saveUser(UserBean pBean);



    int updateUser(UserBean pBean);



    int resetPassword(UserBean pUser);



    int updateResetPasswordSign(UserBean pUser);



    Integer queryUserCount(UserSearchBean pSearchBean);

}
