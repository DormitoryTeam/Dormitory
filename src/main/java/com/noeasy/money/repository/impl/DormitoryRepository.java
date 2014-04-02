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
package com.noeasy.money.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Repository;

import com.noeasy.money.model.DormitoryBean;
import com.noeasy.money.model.DormitoryRateBean;
import com.noeasy.money.model.DormitorySearchBean;
import com.noeasy.money.model.RoomInfoBean;
import com.noeasy.money.model.RoomPrice;
import com.noeasy.money.repository.IDormitoryRepository;
import com.noeasy.money.util.ParamUtils;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 28, 2014
 */
@Repository("dormitoryRepository")
public class DormitoryRepository extends BaseRepository implements IDormitoryRepository {

    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#calculateDistance4City(int)
     */
    @Override
    public Boolean calculateDistance4City(final int pCityId) {
        getSqlSession().insert("com.noeasy.money.model.Dormitory.calculateDistance4City", pCityId);
        return true;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#calculateDistance4College(int)
     */
    @Override
    public Boolean calculateDistance4College(final int pCollegeId) {
        getSqlSession().insert("com.noeasy.money.model.Dormitory.calculateDistance4College", pCollegeId);
        return true;
    }



    @Override
    public Boolean calculateDistance4Dormitory(final int pDormitoryId) {
        getSqlSession().insert("com.noeasy.money.model.Dormitory.calculateDistance4Dormitory", pDormitoryId);
        return true;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#clearDistanceResult()
     */
    @Override
    public Boolean clearDistanceResult() {
        getSqlSession().delete("com.noeasy.money.model.Dormitory.clearDistanceResult");
        return true;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#clearDistanceResult4City(int)
     */
    @Override
    public Boolean clearDistanceResult4City(final int pCityId) {
        getSqlSession().delete("com.noeasy.money.model.Dormitory.clearDistanceResult4City", pCityId);
        return true;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#clearDistanceResult4College(int)
     */
    @Override
    public Boolean clearDistanceResult4College(final int pCollegeId) {
        getSqlSession().delete("com.noeasy.money.model.Dormitory.clearDistanceResult4College", pCollegeId);
        return true;
    }



    @Override
    public Boolean clearDistanceResult4Dormitory(final int pDormitoryId) {
        getSqlSession().delete("com.noeasy.money.model.Dormitory.clearDistanceResult4Dormitory", pDormitoryId);
        return true;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#deleteDormitoryMediaPath(java.lang.Integer)
     */
    @Override
    public Boolean deleteDormitoryMediaPath(final Integer pDormitoryId) {
        return getSqlSession().delete("com.noeasy.money.model.Dormitory.removeMediaPath", pDormitoryId) >= 0;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#initialDistanceResult()
     */
    @Override
    public Boolean initialDistanceResult() {
        getSqlSession().insert("com.noeasy.money.model.Dormitory.initialDistanceResult");
        return true;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#queryContractTypes()
     */
    @Override
    public List<Map<String, Object>> queryContractTypes() {
        return getSqlSession().selectList("com.noeasy.money.model.Dormitory.queryContractType");
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#queryDormitory(com.noeasy.money.model.DormitorySearchBean)
     */
    @Override
    public DormitoryBean queryDormitory(final DormitorySearchBean pSearchBean) {
        return getSqlSession().selectOne("com.noeasy.money.model.Dormitory.queryDormitory", pSearchBean);
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#queryDormitoryBrowseHistory(int,
     *      int)
     */
    @Override
    public List<Map<String, String>> queryDormitoryBrowseHistory(final int pUserId, final int pCurrentDormitoryId) {
        if (ParamUtils.isValidIdField(pUserId)) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("userId", pUserId);
            params.put("id", pCurrentDormitoryId);

            return getSqlSession().selectList("com.noeasy.money.model.Dormitory.selectBrowseHistiory", params);
        }
        return null;
    }



    @Override
    public Integer queryDormitoryCount(final DormitorySearchBean pSearchBean) {
        return getSqlSession().selectOne("com.noeasy.money.model.Dormitory.queryDormitoryCount", pSearchBean);
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#queryDormitoryPage(com.noeasy.money.model.DormitorySearchBean)
     */
    @Override
    public List<DormitoryBean> queryDormitoryPage(final DormitorySearchBean pSearchBean) {
        List<DormitoryBean> dormitories = getSqlSession().selectList(
                "com.noeasy.money.model.Dormitory.queryDormitoryPage", pSearchBean);
        List<Integer> dormitoryIds = new ArrayList<Integer>();
        for (DormitoryBean dormitory : dormitories) {
            dormitoryIds.add(dormitory.getId());
        }
        List<RoomInfoBean> rooms = getSqlSession().selectList("com.noeasy.money.model.Dormitory.queryRoomInfos",
                dormitoryIds);
        for (RoomInfoBean room : rooms) {
            for (DormitoryBean dormitory : dormitories) {
                if (dormitory.getId() == room.getDormitoryId()) {
                    int roomCount = dormitory.getRooms().size();
                    if (roomCount < 2) {
                        dormitory.getRooms().add(room);
                    }
                    if (roomCount == 1) {
                        break;
                    }
                }
            }
        }
        return dormitories;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#queryDormitoryRates(int)
     */
    @Override
    public List<DormitoryRateBean> queryDormitoryRates(final int pDormitoryId) {
        return getSqlSession().selectList("com.noeasy.money.model.Dormitory.selectRates", pDormitoryId);
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#queryEquipment()
     */
    @Override
    public List<String> queryEquipment() {
        return getSqlSession().selectList("com.noeasy.money.model.Dormitory.selectEquipment");
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#queryImagePathByDormitoryId(java.lang.Integer)
     */
    @Override
    public List<String> queryImagePathByDormitoryId(final Integer pDormitoryId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("dormitoryId", pDormitoryId);
        params.put("mediaType", 1);
        params.put("sortField", "index");
        return getSqlSession().selectList("com.noeasy.money.model.Dormitory.queryMediaPath", params);
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#queryRoomTypes()
     */
    @Override
    public List<Map<String, Object>> queryRoomTypes() {
        return getSqlSession().selectList("com.noeasy.money.model.Dormitory.queryRoomType");
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#queryService()
     */
    @Override
    public List<String> queryService() {
        return getSqlSession().selectList("com.noeasy.money.model.Dormitory.selectService");
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#queryVideoPathByDormitoryId(java.lang.Integer)
     */
    @Override
    public List<String> queryVideoPathByDormitoryId(final Integer pDormitoryId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("dormitoryId", pDormitoryId);
        params.put("mediaType", 2);
        params.put("sortField", "index");
        return getSqlSession().selectList("com.noeasy.money.model.Dormitory.queryMediaPath", params);
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#rateDormitory(com.noeasy.money.model.DormitoryRateBean)
     */
    @Override
    public Boolean rateDormitory(final DormitoryRateBean pDormitoryRateBean) {
        if (pDormitoryRateBean.getId() > 0) {
            getSqlSession().update("com.noeasy.money.model.Dormitory.updateRate", pDormitoryRateBean);
        } else {
            getSqlSession().insert("com.noeasy.money.model.Dormitory.rate", pDormitoryRateBean);
        }
        return true;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#saveDormitory(com.noeasy.money.model.DormitoryBean)
     */
    @Override
    public Integer saveDormitory(final DormitoryBean pDormitory) {
        int result = getSqlSession().insert("com.noeasy.money.model.Dormitory.saveDormitory", pDormitory);
        if (result > 0) {
            for (RoomInfoBean room : pDormitory.getRooms()) {
                room.setDormitoryId(pDormitory.getId());
                saveRoomInfo(room);
            }
            deleteDormitoryMediaPath(pDormitory.getId());
            if (CollectionUtils.isNotEmpty(pDormitory.getPicPath())) {
                saveDormitoryMediaPath(pDormitory.getPicPath(), pDormitory.getId(), false);
            }
            if (CollectionUtils.isNotEmpty(pDormitory.getVideoPath())) {
                saveDormitoryMediaPath(pDormitory.getVideoPath(), pDormitory.getId(), true);
            }
        }
        return result;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#saveDormitoryBrowseHistory(int,
     *      int)
     */
    @Override
    public Integer saveDormitoryBrowseHistory(final int pUserId, final int pDormitoryId) {
        if (ParamUtils.isValidIdField(pUserId) && ParamUtils.isValidIdField(pDormitoryId)) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("userId", pUserId);
            params.put("dormitoryId", pDormitoryId);
            return getSqlSession().insert("com.noeasy.money.model.Dormitory.insertBrowseHistory", params);
        }
        return null;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#saveDormitoryMediaPath(java.util.List,
     *      java.lang.Integer, boolean)
     */
    @Override
    public Boolean saveDormitoryMediaPath(final List<String> pMediaPath, final Integer pDormitoryId,
            final boolean pIsVideo) {
        List<Map<String, Object>> pMediaPathMapList = new ArrayList<Map<String, Object>>();
        for (String path : pMediaPath) {
            Map<String, Object> pathMap = new HashMap<String, Object>();
            pathMap.put("dormitoryId", pDormitoryId);
            pathMap.put("path", path);
            pMediaPathMapList.add(pathMap);
        }
        int result = 0;
        if (pIsVideo) {
            result = getSqlSession().insert("com.noeasy.money.model.Dormitory.insertVideoPath", pMediaPathMapList);
        } else {
            result = getSqlSession().insert("com.noeasy.money.model.Dormitory.insertImagePath", pMediaPathMapList);
        }
        return result > 0;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#saveRoomInfo(com.noeasy.money.model.RoomInfoBean)
     */
    @Override
    public Integer saveRoomInfo(final RoomInfoBean pRoom) {
        int result = getSqlSession().insert("com.noeasy.money.model.Dormitory.saveRoomInfo", pRoom);
        if (result > 0) {
            for (RoomPrice roomPrice : pRoom.getContractPrice()) {
                roomPrice.setRoomInfoId(pRoom.getId());
                saveRoomPrice(roomPrice);
            }
        }
        return result;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#saveRoomPrice(com.noeasy.money.model.RoomPrice)
     */
    @Override
    public Integer saveRoomPrice(final RoomPrice pRoomPrice) {
        return getSqlSession().insert("com.noeasy.money.model.Dormitory.saveRoomPrice", pRoomPrice);
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#updateDormitory(com.noeasy.money.model.DormitoryBean)
     */
    @Override
    public Integer updateDormitory(final DormitoryBean pDormitory) {
        int result = getSqlSession().update("com.noeasy.money.model.Dormitory.updateDormitory", pDormitory);
        if (result > 0) {
            for (RoomInfoBean room : pDormitory.getRooms()) {
                updateRoomInfo(room);
            }
            // update the media path
            deleteDormitoryMediaPath(pDormitory.getId());
            if (CollectionUtils.isNotEmpty(pDormitory.getPicPath())) {
                saveDormitoryMediaPath(pDormitory.getPicPath(), pDormitory.getId(), false);
            }
            if (CollectionUtils.isNotEmpty(pDormitory.getVideoPath())) {
                saveDormitoryMediaPath(pDormitory.getVideoPath(), pDormitory.getId(), true);
            }
        }
        return result;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#updateRoomInfo(com.noeasy.money.model.RoomInfoBean)
     */
    @Override
    public Integer updateRoomInfo(final RoomInfoBean pRoom) {
        int result = getSqlSession().update("com.noeasy.money.model.Dormitory.updateRoomInfo", pRoom);
        if (result > 0) {
            for (RoomPrice roomPrice : pRoom.getContractPrice()) {
                updateRoomPrice(roomPrice);
            }
        }
        return result;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#updateRoomPrice(com.noeasy.money.model.RoomPrice)
     */
    @Override
    public Integer updateRoomPrice(final RoomPrice pRoomPrice) {
        return getSqlSession().update("com.noeasy.money.model.Dormitory.updateRoomPrice", pRoomPrice);
    }

}
