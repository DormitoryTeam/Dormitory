package com.noeasy.money.service;

import java.util.List;

import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserSearchBean;

public interface IUserService {
    
    boolean register(String login, String password);



    boolean saveOrUpdate(UserBean bean);
    
    
    List<UserBean> queryUser(UserSearchBean searchBean);
    
}
