package com.noeasy.money.repository.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.noeasy.money.repository.IAuthenticationRepository;

@Repository("authenticationRepository")
public class AuthenticationRepository extends BaseRepository implements IAuthenticationRepository {

    public Set<Integer> getRolesByUserId(Integer pUserId) {
        List<Integer> roleIds = getSqlSession().selectList("com.noeasy.money.model.Authentication.getRolesByUserId",
                pUserId);
        if (CollectionUtils.isNotEmpty(roleIds)) {
            return new HashSet<Integer>(roleIds);
        }
        return Collections.EMPTY_SET;
    }



    public Integer getUserGroupCount(Integer pUserId, Integer pGroupId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", pUserId);
        param.put("groupId", pGroupId);
        return getSqlSession().selectOne("com.noeasy.money.model.Authentication.getUserGroupCount", param);
    }



    public void addUser2Group(Integer pUserId, Integer pGroupId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", pUserId);
        param.put("groupId", pGroupId);
        getSqlSession().insert("com.noeasy.money.model.Authentication.addUser2Group", param);

    }



    public int removeUserFromGroup(Integer pUserId, Integer pGroupId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", pUserId);
        param.put("groupId", pGroupId);
        return getSqlSession().delete("com.noeasy.money.model.Authentication.removeUserFromGroup", param);
    }



    public Integer getRoleGroupCount(Integer pRoleId, Integer pGroupId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("roleId", pRoleId);
        param.put("groupId", pGroupId);
        return getSqlSession().selectOne("com.noeasy.money.model.Authentication.getRoleGroupCount", param);
    }



    public void addRole2Group(Integer pRoleId, Integer pGroupId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("roleId", pRoleId);
        param.put("groupId", pGroupId);
        getSqlSession().insert("com.noeasy.money.model.Authentication.addRole2Group", param);
    }



    public int removeRoleFromGroup(Integer pRoleId, Integer pGroupId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("roleId", pRoleId);
        param.put("groupId", pGroupId);
        return getSqlSession().delete("com.noeasy.money.model.Authentication.removeRoleFromGroup", param);
    }



    @Override
    public List<Map<String, String>> getAuthenticationData() {
        return getSqlSession().selectList("com.noeasy.money.model.Authentication.getAuthenticationData");
    }

}
