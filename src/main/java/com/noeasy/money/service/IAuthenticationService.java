package com.noeasy.money.service;

import java.util.Map;
import java.util.Set;

public interface IAuthenticationService {

    boolean hasAccess(Integer userId, Integer servletPathInfo, Map<Integer, Set<Integer>> authenData);
    
    int addUser2Group(Integer userId, Integer groupId);
    
    int removeUserFromGroup(Integer userId, Integer groupId);
    
    int addRole2Group(Integer roleId, Integer groupId);
    
    int removeRoleFromGroup(Integer roleId, Integer groupId);
}
