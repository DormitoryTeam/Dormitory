package com.noeasy.money.admin.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

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

    private List<Integer>   mInputService;

    private List<Integer>   mInputEquipment;



    public String getEquipment(final int pCount) {
        return parseToDigitNumber(getInputEquipment(), pCount);
    }



    /**
     * @return the imageNames
     */
    public String[] getImageNames() {
        return mImageNames;
    }



    /**
     * @return the inputEquipment
     */
    public List<Integer> getInputEquipment() {
        return mInputEquipment;
    }



    /**
     * @return the inputService
     */
    public List<Integer> getInputService() {
        return mInputService;
    }



    /**
     * @return the prices
     */
    public List<RoomPrice> getPrices() {
        return mPrices;
    }



    public String getService(final int pCount) {
        return parseToDigitNumber(getInputService(), pCount);
    }



    private String parseToDigitNumber(final List<Integer> pInputList, final int pCount) {
        if (CollectionUtils.isEmpty(pInputList)) {
            return "0";
        }
        StringBuffer digitNumber = new StringBuffer();

        for (int i = 0; i < pCount; i++) {
            digitNumber.append(pInputList.contains(i) ? "1" : "0");
        }
        return digitNumber.toString();
    }



    /**
     * @param pImageNames
     *            the imageNames to set
     */
    public void setImageNames(final String[] pImageNames) {
        mImageNames = pImageNames;
    }



    /**
     * @param pInputEquipment
     *            the inputEquipment to set
     */
    public void setInputEquipment(final List<Integer> pInputEquipment) {
        mInputEquipment = pInputEquipment;
    }



    /**
     * @param pInputService
     *            the inputService to set
     */
    public void setInputService(final List<Integer> pInputService) {
        mInputService = pInputService;
    }



    /**
     * @param pPrices
     *            the prices to set
     */
    public void setPrices(final List<RoomPrice> pPrices) {
        mPrices = pPrices;
    }
}
