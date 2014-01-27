package com.noeasy.money.repository.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import com.noeasy.money.repository.IBaseRepository;

public class BaseRepository implements IBaseRepository {

    @Resource(name = "sqlSession")
    private SqlSession sqlSession;
    
    
    public SqlSession getSqlSession() {
        return this.sqlSession;
    }

}
