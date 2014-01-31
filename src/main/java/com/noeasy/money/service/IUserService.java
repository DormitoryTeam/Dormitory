package com.noeasy.money.service;

import java.util.List;

import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserSearchBean;

public interface IUserService {

    UserBean register(String login, String password);



    boolean saveOrUpdate(UserBean bean);



    List<UserBean> queryUser(UserSearchBean searchBean);



    boolean exist(String pLogin);



    boolean exist(String pLogin, String pPassword);
}
