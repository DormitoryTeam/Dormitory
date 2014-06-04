package com.noeasy.money.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.noeasy.money.model.OrderContactInfo;
import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserInfoBean;
import com.noeasy.money.model.UserPreferBean;
import com.noeasy.money.model.UserSearchBean;
import com.noeasy.money.repository.IUserRepository;
import com.noeasy.money.util.MD5Util;

@Repository("userRepository")
public class UserRepository extends BaseRepository implements IUserRepository {

    @Override
    public Integer createUserInfo(final UserInfoBean pUserInfo) {
        return getSqlSession().insert("com.noeasy.money.model.User.createUserInfo", pUserInfo);
    }



    @Override
    public Integer createUserPrefer(final UserPreferBean pUserPrefer) {
        return getSqlSession().insert("com.noeasy.money.model.User.createUserPrefer", pUserPrefer);
    }



    @Override
    public List<UserBean> queryUser(final UserSearchBean pSearchBean) {
        return getSqlSession().selectList("com.noeasy.money.model.User.queryUser", pSearchBean);
    }



    @Override
    public Integer queryUserCount(final UserSearchBean pSearchBean) {
        return getSqlSession().selectOne("com.noeasy.money.model.User.queryUserCount", pSearchBean);
    }



    @Override
    public int register(final UserBean pBean) {
        getSqlSession().insert("com.noeasy.money.model.User.register", pBean);
        pBean.setCode(MD5Util.md5(pBean.getId().toString()));
        return getSqlSession().update("com.noeasy.money.model.User.updateUserToken", pBean);
    }



    @Override
    public int resetPassword(final UserBean pUser) {
        return getSqlSession().update("com.noeasy.money.model.User.resetPassword", pUser);
    }



    @Override
    public int saveUser(final UserBean pBean) {
        return getSqlSession().insert("com.noeasy.money.model.User.saveUser", pBean);
    }



    @Override
    public void setContactPersonInfo2Order(final OrderContactInfo pContactInfo) {
        getSqlSession().update("com.noeasy.money.model.User.setContactPersonInfo2Order", pContactInfo);
    }



    @Override
    public void setContactPersonInfo2User(final UserBean pUser) {
        getSqlSession().update("com.noeasy.money.model.User.setContactPersonInfo2User", pUser);
    }



    @Override
    public void setGuaranteeInfo2Order(final OrderContactInfo pContactInfo) {
        getSqlSession().update("com.noeasy.money.model.User.setGuaranteeInfo2Order", pContactInfo);

    }



    @Override
    public void setGuaranteeInfo2User(final UserBean pUser) {
        getSqlSession().update("com.noeasy.money.model.User.setGuaranteeInfo2User", pUser);
    }



    @Override
    public void setInfo2Order(final OrderContactInfo pContactInfo) {
        getSqlSession().update("com.noeasy.money.model.User.setInfo2Order", pContactInfo);

    }



    @Override
    public void setInfo2User(final UserBean pUser) {
        getSqlSession().update("com.noeasy.money.model.User.setInfo2User", pUser);

    }



    @Override
    public void setPrefer2Order(final OrderContactInfo pContactInfo) {
        getSqlSession().update("com.noeasy.money.model.User.setPrefer2Order", pContactInfo);
    }



    @Override
    public void setPrefer2User(final UserBean pUser) {
        getSqlSession().update("com.noeasy.money.model.User.setPrefer2User", pUser);
    }



    @Override
    public int updateResetPasswordSign(final UserBean pUser) {
        return getSqlSession().update("com.noeasy.money.model.User.updateResetPasswordSign", pUser);
    }



    @Override
    public int updateUser(final UserBean pBean) {
        return getSqlSession().update("com.noeasy.money.model.User.updateUser", pBean);
    }



    @Override
    public void updateUserInfo(final UserInfoBean pUserInfo) {
        getSqlSession().update("com.noeasy.money.model.User.updateUserInfo", pUserInfo);
    }



    @Override
    public void updateUserPrefer(final UserPreferBean pUserPrefer) {
        getSqlSession().update("com.noeasy.money.model.User.updateUserPrefer", pUserPrefer);

    }

}
