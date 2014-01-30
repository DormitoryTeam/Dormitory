/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package com.noeasy.money.repository;

import org.apache.ibatis.session.SqlSession;

/**
 * 
 * @author acer
 */
public interface IBaseRepository {

    SqlSession getSqlSession();
}
