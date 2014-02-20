package com.noeasy.money.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IAuthenticationService {

    boolean passAccess(Integer userId, String servletPathInfo, Map<String, Set<Integer>> authenData);



    int addUser2Group(Integer userId, Integer groupId);



    int removeUserFromGroup(Integer userId, Integer groupId);



    int addRole2Group(Integer roleId, Integer groupId);



    int removeRoleFromGroup(Integer roleId, Integer groupId);



    Map<String, Set<Integer>> getAuthenticationData();



    List<Map<String, String>> getAllGroups();
}
