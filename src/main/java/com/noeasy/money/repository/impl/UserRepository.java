package com.noeasy.money.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserSearchBean;
import com.noeasy.money.repository.IUserRepository;

@Repository("userRepository")
public class UserRepository extends BaseRepository implements IUserRepository {

    public int register(UserBean pBean) {
        return getSqlSession().insert("com.noeasy.money.model.User.register", pBean);
    }



    @Override
    public List<UserBean> queryUser(UserSearchBean pSearchBean) {
        return getSqlSession().selectList("com.noeasy.money.model.User.queryUser", pSearchBean);
    }



    @Override
    public int saveUser(UserBean pBean) {
        return getSqlSession().insert("com.noeasy.money.model.User.saveUser", pBean);
    }



    @Override
    public int updateUser(UserBean pBean) {
        return getSqlSession().update("com.noeasy.money.model.User.updateUser", pBean);
    }



    @Override
    public int resetPassword(UserBean pUser) {
        return getSqlSession().update("com.noeasy.money.model.User.resetPassword", pUser);
    }



    @Override
    public int updateResetPasswordSign(UserBean pUser) {
        return getSqlSession().update("com.noeasy.money.model.User.updateResetPasswordSign", pUser);
    }

}
