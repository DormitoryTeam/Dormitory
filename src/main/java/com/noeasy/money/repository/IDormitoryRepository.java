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
package com.noeasy.money.repository;

import java.util.List;
import java.util.Map;

import com.noeasy.money.model.DormitoryBean;
import com.noeasy.money.model.DormitoryRateBean;
import com.noeasy.money.model.DormitorySearchBean;
import com.noeasy.money.model.RoomInfoBean;
import com.noeasy.money.model.RoomPrice;
import com.noeasy.money.model.RoomPriceSearchBean;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 28, 2014
 */

public interface IDormitoryRepository {

    Boolean calculateDistance4City(int pCityId);



    Boolean calculateDistance4College(int pCollegeId);



    Boolean calculateDistance4Dormitory(int pDormitoryId);



    Boolean clearDistanceResult();



    Boolean clearDistanceResult4City(int pCityId);



    Boolean clearDistanceResult4College(int pCollegeId);



    Boolean clearDistanceResult4Dormitory(int pDormitoryId);



    Boolean deleteDormitoryMediaPath(Integer pDormitoryId);



    Boolean initialDistanceResult();



    List<Map<String, Object>> queryContractTypes();



    DormitoryBean queryDormitory(DormitorySearchBean pSearchBean);



    List<Map<String, String>> queryDormitoryBrowseHistory(int pUserId, int pCurrentDormitoryId);



    Integer queryDormitoryCount(DormitorySearchBean pSearchBean);



    List<DormitoryBean> queryDormitoryPage(DormitorySearchBean pSearchBean);



    List<DormitoryRateBean> queryDormitoryRates(int pDormitoryId);



    List<String> queryEquipment();



    List<String> queryImagePathByDormitoryId(Integer pDormitoryId);



    List<Map<String, Object>> queryRoomTypes();



    List<String> queryService();



    List<String> queryVideoPathByDormitoryId(Integer pDormitoryId);



    Boolean rateDormitory(DormitoryRateBean pDormitoryRateBean);



    Integer saveDormitory(DormitoryBean pDormitory);



    Integer saveDormitoryBrowseHistory(int pUserId, int pDormitoryId);



    Boolean saveDormitoryMediaPath(List<String> pMediaPath, Integer pDormitoryId, boolean pIsVideo);



    Integer saveRoomInfo(RoomInfoBean pRoom);



    Integer saveRoomPrice(RoomPrice pRoomPrice);



    Integer updateDormitory(DormitoryBean pDormitory);



    Integer updateRoomInfo(RoomInfoBean pRoom);



    Integer updateRoomPrice(RoomPrice pRoomPrice);



    RoomInfoBean findRoomInfoById(Integer pRoomInfoId);



    RoomPrice findRoomPrice(RoomPriceSearchBean seachBean);

}
