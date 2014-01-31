package com.noeasy.money.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.noeasy.money.exception.BaseException;
import com.noeasy.money.exception.UserErrorMetadata;
import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserSearchBean;
import com.noeasy.money.repository.IAuthenticationRepository;
import com.noeasy.money.repository.IUserRepository;
import com.noeasy.money.service.IAuthenticationService;
import com.noeasy.money.service.IUserService;


@Service(value = "userService")
public class UserService implements IUserService {

    @Resource(name = "userRepository")
    private IUserRepository           userRepository;
    
    @Resource(name = "authenticationRepository")
    private IAuthenticationRepository authenticationRepository;



    @Override
    public UserBean register(String pLogin, String pPassword) {
        // check user exit or not.
        if (exist(pLogin)) {
            throw new BaseException(UserErrorMetadata.USER_EXIST);
        }
        UserBean bean = new UserBean();
        bean.setLogin(pLogin);
        bean.setPassword(pPassword);
        // save register information.
        int userId = userRepository.register(bean);
        bean.setId(userId);
        // assign front user group to current user.
        authenticationRepository.addUser2Group(userId, IAuthenticationRepository.FRONT_USER_GROUP_ID);
        return bean;
    }


    @Override
    public boolean exist(String pLogin) {
        UserSearchBean searchBean = new UserSearchBean();
        searchBean.setLogin(pLogin);
        List<UserBean> matchUsers = userRepository.queryUser(searchBean);
        return CollectionUtils.isNotEmpty(matchUsers);
    }



    @Override
    public boolean saveOrUpdate(UserBean pBean) {
        if (null == pBean) {
            throw new BaseException(UserErrorMetadata.NULL_USER_BEAN);
        }
        if (null == pBean) {
            userRepository.saveUser(pBean);
            return true;
        }
        userRepository.updateUser(pBean);
        return true;
    }



    @Override
    public List<UserBean> queryUser(UserSearchBean pSearchBean) {
        List<UserBean> result = userRepository.queryUser(pSearchBean);
        if (CollectionUtils.isEmpty(result)) {
            return Collections.EMPTY_LIST;
        }
        return result;
    }


    @Override
    public boolean exist(String pLogin, String pPassword) {
        UserSearchBean searchBean = new UserSearchBean();
        searchBean.setLogin(pLogin);
        searchBean.setPassword(pPassword);
        List<UserBean> matchUsers = userRepository.queryUser(searchBean);
        return CollectionUtils.isNotEmpty(matchUsers);
    }

}
