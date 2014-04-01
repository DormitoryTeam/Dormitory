package com.noeasy.money.admin.controller;

import java.util.List;

import com.noeasy.money.model.RoomPrice;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Mar 31, 2014
 */

public class AdminDormitoryParamVector {

    private String[]        mImageNames;

    private List<RoomPrice> mPrices;



    /**
     * @return the imageNames
     */
    public String[] getImageNames() {
        return mImageNames;
    }



    /**
     * @return the prices
     */
    public List<RoomPrice> getPrices() {
        return mPrices;
    }



    /**
     * @param pImageNames
     *            the imageNames to set
     */
    public void setImageNames(final String[] pImageNames) {
        mImageNames = pImageNames;
    }



    /**
     * @param pPrices
     *            the prices to set
     */
    public void setPrices(final List<RoomPrice> pPrices) {
        mPrices = pPrices;
    }
}
