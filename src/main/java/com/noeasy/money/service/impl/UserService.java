package com.noeasy.money.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.noeasy.money.exception.BaseException;
import com.noeasy.money.exception.UserErrorMetadata;
import com.noeasy.money.model.OrderContactInfo;
import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserInfoBean;
import com.noeasy.money.model.UserPreferBean;
import com.noeasy.money.model.UserSearchBean;
import com.noeasy.money.repository.IAuthenticationRepository;
import com.noeasy.money.repository.IUserRepository;
import com.noeasy.money.service.IUserService;
import com.noeasy.money.util.DateUtils;

@Service(value = "userService")
public class UserService implements IUserService {

    @Resource(name = "userRepository")
    private IUserRepository           userRepository;

    @Resource(name = "authenticationRepository")
    private IAuthenticationRepository authenticationRepository;

   

    @Override
    public int changePassword(final String pLogin, final String pOldPassword, final String pNewPassword) {
        boolean isExist = exist(pLogin, pOldPassword);
        if (!isExist) {    
            return PASSWORD_NOT_MATCH;
        }
        UserBean user = new UserBean();
        user.setLogin(pLogin);
        user.setPassword(pNewPassword);
        userRepository.resetPassword(user);
        return 0;
    }



    @Override
    public boolean exist(final String pLogin) {
        UserSearchBean searchBean = new UserSearchBean();
        searchBean.setLogin(pLogin);
        List<UserBean> matchUsers = userRepository.queryUser(searchBean);
        return CollectionUtils.isNotEmpty(matchUsers);
    }



    @Override
    public boolean exist(final String pLogin, final String pPassword) {
        UserSearchBean searchBean = new UserSearchBean();
        searchBean.setLogin(pLogin);
        searchBean.setPassword(pPassword);
        List<UserBean> matchUsers = userRepository.queryUser(searchBean);
        return CollectionUtils.isNotEmpty(matchUsers);
    }



    @Override
    public UserBean generateResetPasswordSign(final String pLogin) {
        String sign = DateUtils.dateToString(new Date(), DateUtils.SIMPLE_DATE_FROMAT_RULE)
                + UUID.randomUUID().toString();
        UserSearchBean searchBean = new UserSearchBean();
        searchBean.setLogin(pLogin);
        UserBean user = userRepository.queryUser(searchBean).get(0);
        user.setResetPasswordSign(sign);
        userRepository.updateResetPasswordSign(user);
        return user;
    }



    @Override
    public List<UserBean> queryUser(final UserSearchBean pSearchBean) {
        List<UserBean> result = userRepository.queryUser(pSearchBean);
        if (CollectionUtils.isEmpty(result)) {
            return Collections.EMPTY_LIST;
        }
        return result;
    }
    
    
    @Override
    public UserBean  findUserById(Integer pUserId) {
        if (null == pUserId) {
            return null;
        }
        UserSearchBean searchBean = new UserSearchBean();
        searchBean.setId(pUserId);
        List<UserBean> users = queryUser(searchBean);
        if (CollectionUtils.isEmpty(users)) {
            return null;
        }
        return users.get(0);
    }



    @Override
    public UserBean register(final String pLogin, final String pPassword) {
        // check user exit or not.
        if (exist(pLogin)) {
            throw new BaseException(UserErrorMetadata.USER_EXIST);
        }
        UserBean bean = new UserBean();
        bean.setLogin(pLogin);
        bean.setPassword(pPassword);
        // save register information.
        userRepository.register(bean);
        // assign front user group to current user.
        authenticationRepository.addUser2Group(bean.getId(), IAuthenticationRepository.FRONT_USER_GROUP_ID);
        return bean;
    }



    @Override
    public boolean resetPassword(final String pLogin, final String pPassword) {
        UserBean user = new UserBean();
        user.setLogin(pLogin);
        user.setPassword(pPassword);
        userRepository.resetPassword(user);
        return true;
    }



    @Override
    public boolean saveOrUpdate(final UserBean pBean) {
        if (null == pBean) {
            throw new BaseException(UserErrorMetadata.NULL_USER_BEAN);
        }
        if (null == pBean.getId()) {
            userRepository.saveUser(pBean);
            return true;
        }
        userRepository.updateUser(pBean);
        return true;
    }



    @Override
    public int updateUser(final UserBean pUser) {
        return userRepository.updateUser(pUser);
    }



    @Override
    public Integer queryUserCount(UserSearchBean pSearchBean) {
        return userRepository.queryUserCount(pSearchBean);
    }



    @Override
    public void saveUserInfo(UserBean pUser) {
        if (null == pUser) {
            return;
        }
        UserInfoBean userInfo = null;
        INFO_TYPE infoType = null;
        if (null != pUser.getInfo()) {
            userInfo = pUser.getInfo();
            infoType = INFO_TYPE.USER_INFO;
        }
        if (null != pUser.getGuaranteeInfo()) {
            userInfo = pUser.getGuaranteeInfo();
            infoType = INFO_TYPE.GUARANTEE_INFO;
        }
        if (null != pUser.getContactPersonInfo()) {
            userInfo = pUser.getContactPersonInfo();
            infoType = INFO_TYPE.CONTACT_PERSON_INFO;
        }
        if (null == userInfo || null == infoType) {
            return;
        }
        if (null == userInfo.getId()) {
            createUserInfo(pUser, userInfo, infoType);
        } else {
            updateUserInfo(userInfo);
        }
        
    }



    private void updateUserInfo(UserInfoBean pUserInfo) {
        userRepository.updateUserInfo(pUserInfo);
        
    }



    private void createUserInfo(UserBean pUser, UserInfoBean pUserInfo, INFO_TYPE pInfoType) {
        userRepository.createUserInfo(pUserInfo);
        switch (pInfoType.ordinal()) {
        case 0:
            pUser.setInfo(pUserInfo);
            userRepository.setInfo2User(pUser);
            break;
        case 1:
            pUser.setGuaranteeInfo(pUserInfo);
            userRepository.setGuaranteeInfo2User(pUser);
            break;
        case 2:
            pUser.setContactPersonInfo(pUserInfo);
            userRepository.setContactPersonInfo2User(pUser);
            break;
        default:
            assert false : "Not support this type of UserInfo";
        }
    }



    @Override
    public void saveUserPrefer(UserBean pUser) {
        if (null == pUser) {
            return;
        }
        UserPreferBean userPrefer = pUser.getPrefer();
        if (null == userPrefer) {
            return;
        }
        if (null == userPrefer.getId()) {
            createUserPrefer(userPrefer, pUser);
        } else {
            updateUserPrefer(userPrefer);
        }
        
    }



    private void updateUserPrefer(UserPreferBean pUserPrefer) {
        userRepository.updateUserPrefer(pUserPrefer);
    }



    private void createUserPrefer(UserPreferBean pUserPrefer, UserBean pUser) {
        userRepository.createUserPrefer(pUserPrefer);
        pUser.setPrefer(pUserPrefer);
        userRepository.setPrefer2User(pUser);
    }



    @Override
    public void saveUserInfo(OrderContactInfo contactInfo, INFO_TYPE infoType) {
        if (null == contactInfo) {
            return;
        }
        UserInfoBean userInfo = null;
        if (INFO_TYPE.USER_INFO == infoType) {
            userInfo = contactInfo.getBelongsToInfo();
        }
        if (INFO_TYPE.GUARANTEE_INFO == infoType) {
            userInfo = contactInfo.getGuaranteeInfo();
        }
        if (INFO_TYPE.CONTACT_PERSON_INFO == infoType) {
            userInfo = contactInfo.getContactPersonInfo();
            ;
        }
        if (null == userInfo) {
            return;
        }
        if (null == userInfo.getId()) {
            createUserInfo(contactInfo, userInfo, infoType);
        } else {
            updateUserInfo(userInfo);
        }
        
    }



    private void createUserInfo(OrderContactInfo pContactInfo, UserInfoBean pUserInfo, INFO_TYPE pInfoType) {
        userRepository.createUserInfo(pUserInfo);
        switch (pInfoType.ordinal()) {
        case 0:
            pContactInfo.setBelongsToInfo(pUserInfo);
            userRepository.setInfo2Order(pContactInfo);
            break;
        case 1:
            pContactInfo.setGuaranteeInfo(pUserInfo);
            userRepository.setGuaranteeInfo2Order(pContactInfo);
            break;
        case 2:
            pContactInfo.setContactPersonInfo(pUserInfo);
            userRepository.setContactPersonInfo2Order(pContactInfo);
            break;
        default:
            assert false : "Not support this type of UserInfo";
        }
        
    }



    @Override
    public void saveUserPrder(OrderContactInfo contactInfo) {
        if (null == contactInfo) {
            return;
        }
        UserPreferBean userPrefer = contactInfo.getPrefer();
        if (null == userPrefer) {
            return;
        }
        if (null == userPrefer.getId()) {
            createUserPrefer(userPrefer, contactInfo);
        } else {
            updateUserPrefer(userPrefer);
        }
        
    }



    private void createUserPrefer(UserPreferBean pUserPrefer, OrderContactInfo pContactInfo) {
        userRepository.createUserPrefer(pUserPrefer);
        pContactInfo.setPrefer(pUserPrefer);
        userRepository.setPrefer2Order(pContactInfo);
        
    }



    @Override
    public UserBean findUserByLogin(String pLogin) {
        UserSearchBean searchBean = new UserSearchBean();
        searchBean.setLogin(pLogin);
        List<UserBean> matchUsers = userRepository.queryUser(searchBean);
        if (CollectionUtils.isNotEmpty(matchUsers)) {
            return matchUsers.get(0); 
        }
        return null;
    }

    
}
