/*
 * File name: PageBean.java
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

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 21, 2014
 */

public class PageBean {

    private int mPageNum;

    private int mPageSize;

    private int mMaxPageNum;



    public boolean isFirstPage() {
        return getPageNum() == 0;
    }



    public boolean isLastPage() {
        return getPageNum() == getMaxPageNum();
    }



    /**
     * @return the pageNum
     */
    public int getPageNum() {
        return mPageNum;
    }



    /**
     * @param pPageNum
     *            the pageNum to set
     */
    public void setPageNum(int pPageNum) {
        mPageNum = pPageNum;
    }



    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return mPageSize;
    }



    /**
     * @param pPageSize
     *            the pageSize to set
     */
    public void setPageSize(int pPageSize) {
        mPageSize = pPageSize;
    }



    /**
     * @return the maxPageNum
     */
    public int getMaxPageNum() {
        return mMaxPageNum;
    }



    /**
     * @param pMaxPageNum
     *            the maxPageNum to set
     */
    public void setMaxPageNum(int pMaxPageNum) {
        mMaxPageNum = pMaxPageNum;
    }

}
