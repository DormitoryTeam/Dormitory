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

package com.noeasy.money.service;

import java.util.List;

import com.noeasy.money.model.DormitoryBean;
import com.noeasy.money.model.DormitorySearchBean;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 21, 2014
 */

public interface IDormitoryService {

	DormitoryBean queryDormitoryById(String pId);



	List<DormitoryBean> queryDormitoryByConditions(DormitorySearchBean pSearchBean);



	/**
	 * 
	 * Rate dormitory and return the average rating
	 * 
	 * @param pDormitoryId
	 * @param pUserId
	 * @param point
	 * @return
	 */
	Double rateDormitory(String pDormitoryId, String pUserId, int point);



	Boolean calculateDistance();

}
