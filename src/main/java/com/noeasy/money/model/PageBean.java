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

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import com.noeasy.money.constant.Constants;
import com.noeasy.money.util.PropertiesUtils;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 21, 2014
 */

public class PageBean {

    private static final int FIRST_PAGE = 1;

    private int              mPageNum   = FIRST_PAGE;

    private int              mPageSize;

    private int              mRowTotal;

    private String           mQueryString;



    public PageBean() {
        mPageSize = Integer.valueOf(PropertiesUtils.getConfigurableProperty(Constants.CONFIG_PATH,
                Constants.CONFIG_DEFAULT_PAGE_SIZE));
    }



    public PageBean(int pRowTotal) {
        mPageSize = Integer.valueOf(PropertiesUtils.getConfigurableProperty(Constants.CONFIG_PATH,
                Constants.CONFIG_DEFAULT_PAGE_SIZE));
        mRowTotal = pRowTotal;
    }



    public boolean isFirstPage() {
        return getPageNum() == FIRST_PAGE;
    }



    public boolean isLastPage() {
        return getPageNum() == getMaxPageNum();
    }



    public int getNextPage() {
        if (getPageNum() >= getMaxPageNum()) {
            return getMaxPageNum();
        }
        return getPageNum() + 1;
    }



    public int getPrePage() {
        if (getPageNum() <= FIRST_PAGE) {
            return FIRST_PAGE;
        }
        return getPageNum() - 1;
    }



    public int getPageStartIndex() {
        return (mPageNum - 1) * mPageSize;
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
        if (pPageNum < FIRST_PAGE) {
            mPageNum = FIRST_PAGE;
            return;
        }
        if (pPageNum > getMaxPageNum()) {
            mPageNum = getMaxPageNum();
            return;
        }
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
        return (getRowTotal() / getPageSize()) + (0 == getRowTotal() % getPageSize() ? 0 : 1);
    }



    public int getRowTotal() {
        return mRowTotal;
    }



    public void setRowTotal(int pRowTotal) {
        mRowTotal = pRowTotal;
    }



    public String getQueryString() {
        if (StringUtils.isBlank(mQueryString)) {
            return "";
        }
        Map<String, String> param = new HashMap<String, String>();
        String[] nvps = mQueryString.split("&");
        for (String nvp : nvps) {
            if (StringUtils.isBlank(nvp)) {
                continue;
            }
            String[] paramPair = nvp.split("=");
            if (null != paramPair && 2 == paramPair.length) {
                param.put(paramPair[0], paramPair[1]);
            }
        }
        if (MapUtils.isEmpty(param)) {
            return "";
        }
        param.remove(Constants.PARAM_CURRENT_PAGE);
        param.remove(Constants.PARAM_PAGE_SIZE);
        String queryString = "";
        int count = 0;
        for (Map.Entry<String, String> entry : param.entrySet()) {
            queryString += entry.getKey() + "=" + entry.getValue();
            if (count != param.size()) {
                queryString += "&";
            }
        }

        return queryString;
    }



    public void setQueryString(String pQueryString) {
        mQueryString = pQueryString;
    }

}
