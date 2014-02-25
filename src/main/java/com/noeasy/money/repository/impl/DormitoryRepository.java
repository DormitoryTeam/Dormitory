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
import com.noeasy.money.repository.IDormitoryRepository;

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
        return getSqlSession().delete("com.noeasy.money.model.Dormitory.remove-media-path", pDormitoryId) >= 0;
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
        return getSqlSession().selectOne("com.noeasy.money.model.Dormitory.queryDormitoryPage", pSearchBean);
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#queryDormitoryAvgRate(int)
     */
    @Override
    public Double queryDormitoryAvgRate(final int pDormitoryId) {
        return getSqlSession().selectOne("com.noeasy.money.model.Dormitory.calculateAvgRating", pDormitoryId);
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
        return getSqlSession().selectList("com.noeasy.money.model.Dormitory.queryDormitoryPage", pSearchBean);
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#queryDormitoryTypes()
     */
    @Override
    public List<Map<String, Object>> queryDormitoryTypes() {
        return getSqlSession().selectList("com.noeasy.money.model.Dormitory.queryDormitoryType");
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#queryImagePathByDormitoryId(java.lang.Integer)
     */
    @Override
    public List<String> queryImagePathByDormitoryId(final Integer pDormitoryId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("dormitoryId", pDormitoryId);
        params.put("mediaType", 1);
        return getSqlSession().selectList("com.noeasy.money.model.Dormitory.query-media-path", params);
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#queryVideoPathByDormitoryId(java.lang.Integer)
     */
    @Override
    public List<String> queryVideoPathByDormitoryId(final Integer pDormitoryId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("dormitoryId", pDormitoryId);
        params.put("mediaType", 2);
        return getSqlSession().selectList("com.noeasy.money.model.Dormitory.query-media-path", params);
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#rateDormitory(com.noeasy.money.model.DormitoryRateBean)
     */
    @Override
    public Boolean rateDormitory(final DormitoryRateBean pDormitoryRateBean) {
        getSqlSession().insert("com.noeasy.money.model.Dormitory.rate", pDormitoryRateBean);
        return true;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#saveDormitory(com.noeasy.money.model.DormitoryBean)
     */
    @Override
    public Integer saveDormitory(final DormitoryBean pDormitory) {
        int result = getSqlSession().insert("com.noeasy.money.model.Dormitory.save-dormitory", pDormitory);
        if (result > 0) {
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
            result = getSqlSession().insert("com.noeasy.money.model.Dormitory.insert-video-path", pMediaPathMapList);
        } else {
            result = getSqlSession().insert("com.noeasy.money.model.Dormitory.insert-image-path", pMediaPathMapList);
        }
        return result > 0;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#updateDormitory(com.noeasy.money.model.DormitoryBean)
     */
    @Override
    public Integer updateDormitory(final DormitoryBean pDormitory) {
        int result = getSqlSession().update("com.noeasy.money.model.Dormitory.update-dormitory", pDormitory);
        if (result > 0) {
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

}
