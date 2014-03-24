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

import com.noeasy.money.util.ParamUtils;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Mar 23, 2014
 */

public class DormitoryRoomBean extends BaseBean {

    private String     mBinaryService;

    private int        mService;

    private String     mBinaryEquipment;

    private int        mEquipment;

    private static int serviceCount   = 0;

    private static int equipmentCount = 0;



    public static String FilledDigital(final String pString, final int pSize) {
        int count = pSize - pString.length();
        StringBuffer frontFilledDigitalStr = new StringBuffer();
        for (int i = 0; i < count; i++) {
            frontFilledDigitalStr.append(0);
        }
        return frontFilledDigitalStr.append(pString).toString();
    }



    /**
     * @return the equipmentCount
     */
    public static int getEquipmentCount() {
        return equipmentCount;
    }



    /**
     * @return the serviceCount
     */
    public static int getServiceCount() {
        return serviceCount;
    }



    /**
     * @param pEquipmentCount
     *            the equipmentCount to set
     */
    public static void setEquipmentCount(final int pEquipmentCount) {
        equipmentCount = pEquipmentCount;
    }



    /**
     * @param pServiceCount
     *            the serviceCount to set
     */
    public static void setServiceCount(final int pServiceCount) {
        serviceCount = pServiceCount;
    }



    /**
     * @return the binaryEquipment
     */
    public String getBinaryEquipment() {
        return mBinaryEquipment;
    }



    public char[] getBinaryEquipmentArray() {
        return mBinaryEquipment.toCharArray();
    }



    /**
     * @return the binaryService
     */
    public String getBinaryService() {
        return mBinaryService;
    }



    public char[] getBinaryServiceArray() {
        return mBinaryService.toCharArray();
    }



    /**
     * @return the equipment
     */
    public int getEquipment() {
        return mEquipment;
    }



    /**
     * @return the service
     */
    public int getService() {
        return mService;
    }



    /**
     * @param pBinaryEquipment
     *            the binaryEquipment to set
     */
    public void setBinaryEquipment(final String pBinaryEquipment) {
        mEquipment = ParamUtils.binaryToDecimal(pBinaryEquipment);
        mBinaryEquipment = pBinaryEquipment;
    }



    /**
     * @param pBinaryService
     *            the binaryService to set
     */
    public void setBinaryService(final String pBinaryService) {
        mService = ParamUtils.binaryToDecimal(pBinaryService);
        mBinaryService = pBinaryService;
    }



    /**
     * @param pEquipment
     *            the equipment to set
     */
    public void setEquipment(final int pEquipment) {
        mBinaryEquipment = FilledDigital(ParamUtils.decimalToBinary(pEquipment), getEquipmentCount());
        mEquipment = pEquipment;
    }



    /**
     * @param pService
     *            the service to set
     */
    public void setService(final int pService) {
        mBinaryService = FilledDigital(ParamUtils.decimalToBinary(pService), getServiceCount());
        mService = pService;
    }

}
