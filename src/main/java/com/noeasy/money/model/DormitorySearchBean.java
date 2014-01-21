/*
 * File name: DormitorySearchBean.java
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

package com.noeasy.money.model;

import org.apache.commons.lang3.tuple.Pair;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 21, 2014
 */

public class DormitorySearchBean {

	private String					mDormitoryName;

	private String					mCityId;

	private String					mCollegeId;

	private String					mKeyword;

	private Pair<Double, Double>	mPriceRange;

	private String					mContractTypeId;

	private String					mDormitoryTypeId;

	private String					mSortBy;

	private PageBean				mPageBean;



	/**
	 * @return the dormitoryName
	 */
	public String getDormitoryName() {
		return mDormitoryName;
	}



	/**
	 * @param pDormitoryName
	 *            the dormitoryName to set
	 */
	public void setDormitoryName(String pDormitoryName) {
		mDormitoryName = pDormitoryName;
	}



	/**
	 * @return the cityId
	 */
	public String getCityId() {
		return mCityId;
	}



	/**
	 * @param pCityId
	 *            the cityId to set
	 */
	public void setCityId(String pCityId) {
		mCityId = pCityId;
	}



	/**
	 * @return the collegeId
	 */
	public String getCollegeId() {
		return mCollegeId;
	}



	/**
	 * @param pCollegeId
	 *            the collegeId to set
	 */
	public void setCollegeId(String pCollegeId) {
		mCollegeId = pCollegeId;
	}



	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return mKeyword;
	}



	/**
	 * @param pKeyword
	 *            the keyword to set
	 */
	public void setKeyword(String pKeyword) {
		mKeyword = pKeyword;
	}



	/**
	 * @return the priceRange
	 */
	public Pair<Double, Double> getPriceRange() {
		return mPriceRange;
	}



	/**
	 * @param pPriceRange
	 *            the priceRange to set
	 */
	public void setPriceRange(Pair<Double, Double> pPriceRange) {
		mPriceRange = pPriceRange;
	}



	/**
	 * @return the contractTypeId
	 */
	public String getContractTypeId() {
		return mContractTypeId;
	}



	/**
	 * @param pContractTypeId
	 *            the contractTypeId to set
	 */
	public void setContractTypeId(String pContractTypeId) {
		mContractTypeId = pContractTypeId;
	}



	/**
	 * @return the dormitoryTypeId
	 */
	public String getDormitoryTypeId() {
		return mDormitoryTypeId;
	}



	/**
	 * @param pDormitoryTypeId
	 *            the dormitoryTypeId to set
	 */
	public void setDormitoryTypeId(String pDormitoryTypeId) {
		mDormitoryTypeId = pDormitoryTypeId;
	}



	/**
	 * @return the sortBy
	 */
	public String getSortBy() {
		return mSortBy;
	}



	/**
	 * @param pSortBy
	 *            the sortBy to set
	 */
	public void setSortBy(String pSortBy) {
		mSortBy = pSortBy;
	}



	/**
	 * @return the pageBean
	 */
	public PageBean getPageBean() {
		return mPageBean;
	}



	/**
	 * @param pPageBean
	 *            the pageBean to set
	 */
	public void setPageBean(PageBean pPageBean) {
		mPageBean = pPageBean;
	}
}
