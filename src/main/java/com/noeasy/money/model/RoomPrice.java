/*
 * This code is provided solely for the use of the licensee subject to the terms
 * and conditions of the Master Service Agreement. Redistribution and use in
 * source and binary forms, with or without modification, are prohibited.
 * 
 * DISCLAIMER.THIS SOFTWARE IS PROVIDED BY AAXIS GROUP CORPORATION "AS IS."
 * EXCEPT AS SPECIFICALLY SET FORTH IN THE MASTER SERVICES AGREEMENT, ALL
 * EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS, AND WARRANTIES INCLUDING,
 * WITHOUT LIMITATION, ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, NONINFRINGEMENT OR ARISING FROM A COURSE OF DEALING,
 * USAGE, OR TRADE PRACTICE, ARE HEREBY EXCLUDED TO THE EXTENT ALLOWED BY
 * APPLICABLE LAW.
 * 
 * IN NO EVENT WILL AAXIS GROUP CORPORATION, THE COPYRIGHT OWNER OR CONTRIBUTORS
 * BE LIABLE FOR ANY LOST REVENUE, PROFIT, OR DATA, OR FOR SPECIAL, INDIRECT,
 * CONSEQUENTIAL, INCIDENTAL, EXEMPLARY OR PUNITIVE DAMAGESINCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND REGARDLESS OF THE
 * THEORY OF LIABILITY ARISING OUT OF THE USE OF OR INABILITY TO USE THE
 * SOFTWARE EVEN IF AAXIS GROUP CORPORATION HAS BEEN ADVISED OF THE POSSIBILITY
 * OF SUCH DAMAGES.
 * 
 * IN NO EVENT SHALL AAXIS GROUP CORPORATION'S LIABILITY TO THE CUSTOMER OR USER
 * OF THIS SOFTWARE, WHETHER IN CONTRACT, TORT (INCLUDING NEGLIGENCE), OR
 * OTHERWISE, EXCEED THE PRICE PAID BY THE CUSTOMER OR USER FOR THIS SOFTWARE.
 * THE FOREGOING LIMITATIONS SHALL APPLY EVEN IF THE ANY WARRANTY PROVIDED IN
 * THE MASTER SERVICE AGREEMENT FAILS OF ITS ESSENTIAL PURPOSE.
 */
package com.noeasy.money.model;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Mar 22, 2014
 */

public class RoomPrice {

    private int    mId;

    private int    mRoomInfoId;

    private String mCurrency;

    private Double mListPrice;

    private Double mSalePrice;

    private int    mContractId;

    private String mContract;



    /**
     * @return the contract
     */
    public String getContract() {
        return mContract;
    }



    /**
     * @return the contractId
     */
    public int getContractId() {
        return mContractId;
    }



    /**
     * @return the currency
     */
    public String getCurrency() {
        return mCurrency;
    }



    /**
     * @return the id
     */
    public int getId() {
        return mId;
    }



    /**
     * @return the listPrice
     */
    public Double getListPrice() {
        return mListPrice;
    }



    /**
     * @return the roomInfoId
     */
    public int getRoomInfoId() {
        return mRoomInfoId;
    }



    /**
     * @return the salePrice
     */
    public Double getSalePrice() {
        return mSalePrice;
    }



    /**
     * @param pContract
     *            the contract to set
     */
    public void setContract(final String pContract) {
        mContract = pContract;
    }



    /**
     * @param pContractId
     *            the contractId to set
     */
    public void setContractId(final int pContractId) {
        mContractId = pContractId;
    }



    /**
     * @param pCurrency
     *            the currency to set
     */
    public void setCurrency(final String pCurrency) {
        mCurrency = pCurrency;
    }



    /**
     * @param pId
     *            the id to set
     */
    public void setId(final int pId) {
        mId = pId;
    }



    /**
     * @param pListPrice
     *            the listPrice to set
     */
    public void setListPrice(final Double pListPrice) {
        mListPrice = pListPrice;
    }



    /**
     * @param pRoomInfoId
     *            the roomInfoId to set
     */
    public void setRoomInfoId(final int pRoomInfoId) {
        mRoomInfoId = pRoomInfoId;
    }



    /**
     * @param pSalePrice
     *            the salePrice to set
     */
    public void setSalePrice(final Double pSalePrice) {
        mSalePrice = pSalePrice;
    }

}
