/*
 * File name: DormitoryService.java
 * 
 * Purpose:
 * 
 * Functions used and called: Name Purpose ... ...
 * 
 * Additional Information:
 * 
 * Development History: Revision No. Author Date 1.0 Yove Jan 21, 2014 ... ...
 * ...
 * 
 * *************************************************
 */

package com.noeasy.money.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.noeasy.money.model.DormitoryBean;
import com.noeasy.money.model.DormitorySearchBean;
import com.noeasy.money.service.IDormitoryService;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 21, 2014
 */
@Service(value = "dormitoryService")
public class DormitoryService implements IDormitoryService {

	@Resource(name = "sqlSession")
	private SqlSession	sqlSession;



	/**
	 * @see com.noeasy.money.service.IDormitoryService#queryDormitoryById(java.lang.String)
	 */
	public DormitoryBean queryDormitoryById(String pId) {
		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * @see com.noeasy.money.service.IDormitoryService#queryDormitoryByConditions(com.noeasy.money.model.DormitorySearchBean)
	 */
	public List<DormitoryBean> queryDormitoryByConditions(DormitorySearchBean pSearchBean) {
		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * @see com.noeasy.money.service.IDormitoryService#rateDormitory(java.lang.String,
	 *      java.lang.String, int)
	 */
	public Double rateDormitory(String pDormitoryId, String pUserId, int pPoint) {
		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * @see com.noeasy.money.service.IDormitoryService#calculateDistance()
	 */
	public Boolean calculateDistance() {
		// TODO Auto-generated method stub
		return null;
	}

}
