package com.noeasy.money.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IAuthenticationRepository {

    int FRONT_USER_GROUP_ID = 1;



    Set<Integer> getRolesByUserId(Integer pUserId);



    Integer getUserGroupCount(Integer pUserId, Integer pGroupId);



    void addUser2Group(Integer pUserId, Integer pGroupId);



    int removeUserFromGroup(Integer pUserId, Integer pGroupId);



    Integer getRoleGroupCount(Integer pRoleId, Integer pGroupId);



    void addRole2Group(Integer pRoleId, Integer pGroupId);



    int removeRoleFromGroup(Integer pRoleId, Integer pGroupId);



    List<Map<String, String>> getAuthenticationData();

}
