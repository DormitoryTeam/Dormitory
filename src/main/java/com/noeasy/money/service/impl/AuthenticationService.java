package com.noeasy.money.service.impl;

import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import com.noeasy.money.repository.IAuthenticationRepository;
import com.noeasy.money.service.IAuthenticationService;

public class AuthenticationService implements IAuthenticationService {

    
    @Resource(name = "authenticationRepository")
    IAuthenticationRepository repository;
    
    public boolean hasAccess(Integer pUserId, Integer pServletPathInfo, Map<Integer, Set<Integer>> authenData) {
        if (null == authenData) {
            return true;
        }
        if (MapUtils.isEmpty(authenData)) {
            return true;
        }
        // if roleIds is not empty, it contains roles that has authentication to access current servletPathInfo.
        // if role is empty means any role can access this servletPathInfo
        Set<Integer > roleIds = authenData.get(pServletPathInfo);
        if (CollectionUtils.isEmpty(roleIds)) {
            return true;
        }
        Set<Integer> roleIdOnUser = repository.getRolesByUserId(pUserId);
        return CollectionUtils.containsAny(roleIds, roleIdOnUser);
    }



    public int addUser2Group(Integer pUserId, Integer pGroupId) {
        int record = repository.getUserGroupCount(pUserId, pGroupId);
        if (record<=0) {
            return 0;
        }
        repository.addUser2Group(pUserId, pGroupId);
        return 1;
        
    }



    public int removeUserFromGroup(Integer pUserId, Integer pGroupId) {
        return repository.removeUserFromGroup(pUserId, pGroupId);
    }



    public int addRole2Group(Integer pRoleId, Integer pGroupId) {
        int record = repository.getRoleGroupCount(pRoleId, pGroupId);
        if (record<=0) {
            return 0;
        }
        repository.addRole2Group(pRoleId, pGroupId);
        return 1;
    }



    public int removeRoleFromGroup(Integer pRoleId, Integer pGroupId) {
        return repository.removeRoleFromGroup(pRoleId, pGroupId);
    }

}
