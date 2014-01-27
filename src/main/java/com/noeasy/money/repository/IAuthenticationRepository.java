package com.noeasy.money.repository;

import java.util.Set;

public interface IAuthenticationRepository {

    Set<Integer> getRolesByUserId(Integer pUserId);



    int getUserGroupCount(Integer pUserId, Integer pGroupId);



    void addUser2Group(Integer pUserId, Integer pGroupId);



    int removeUserFromGroup(Integer pUserId, Integer pGroupId);



    int getRoleGroupCount(Integer pRoleId, Integer pGroupId);



    void addRole2Group(Integer pRoleId, Integer pGroupId);



    int removeRoleFromGroup(Integer pRoleId, Integer pGroupId);

}
