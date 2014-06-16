package com.noeasy.money.admin.controller;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Mar 31, 2014
 */

public class AdminDormitoryParamVector {

    private String[] mImageNames;

    private String   mCoverImageName;



    /**
     * @return the coverImageName
     */
    public String getCoverImageName() {
        return mCoverImageName;
    }



    /**
     * @return the imageNames
     */
    public String[] getImageNames() {
        return mImageNames;
    }



    /**
     * @param pCoverImageName
     *            the coverImageName to set
     */
    public void setCoverImageName(final String pCoverImageName) {
        mCoverImageName = pCoverImageName;
    }



    /**
     * @param pImageNames
     *            the imageNames to set
     */
    public void setImageNames(final String[] pImageNames) {
        mImageNames = pImageNames;
    }

}
