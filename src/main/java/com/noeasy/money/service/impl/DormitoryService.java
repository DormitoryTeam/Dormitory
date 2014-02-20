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
package com.noeasy.money.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.noeasy.money.model.DormitoryBean;
import com.noeasy.money.model.DormitoryRateBean;
import com.noeasy.money.model.DormitorySearchBean;
import com.noeasy.money.repository.IDormitoryRepository;
import com.noeasy.money.service.IDormitoryService;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Jan 21, 2014
 */
@Service(value = "dormitoryService")
public class DormitoryService implements IDormitoryService {

    @Resource(name = "dormitoryRepository")
    private IDormitoryRepository dormitoryRepository;



    /**
     * @see com.noeasy.money.service.IDormitoryService#calculateDistance()
     */
    @Override
    public Boolean calculateDistance() {
        if (dormitoryRepository.clearDistanceResult()) {
            return dormitoryRepository.initialDistanceResult();
        }
        return false;
    }



    /**
     * @see com.noeasy.money.service.IDormitoryService#calculateDistance4City(int)
     */
    @Override
    public Boolean calculateDistance4City(final int pCityId) {
        if (dormitoryRepository.clearDistanceResult4City(pCityId)) {
            return dormitoryRepository.calculateDistance4City(pCityId);
        }
        return false;
    }



    /**
     * @see com.noeasy.money.service.IDormitoryService#calculateDistance4College(int)
     */
    @Override
    public Boolean calculateDistance4College(final int pCollegeId) {
        if (dormitoryRepository.clearDistanceResult4College(pCollegeId)) {
            return dormitoryRepository.calculateDistance4College(pCollegeId);
        }
        return false;
    }



    @Override
    public Boolean calculateDistance4Dormitory(final int pDormitoryId) {
        if (dormitoryRepository.clearDistanceResult4Dormitory(pDormitoryId)) {
            return dormitoryRepository.calculateDistance4Dormitory(pDormitoryId);
        }
        return false;
    }



    /**
     * @see com.noeasy.money.service.IDormitoryService#queryContractTypes()
     */
    @Override
    public List<Map<String, Object>> queryContractTypes() {
        return dormitoryRepository.queryContractTypes();
    }



    /**
     * @see com.noeasy.money.service.IDormitoryService#queryDormitory(com.noeasy.money.model.DormitorySearchBean)
     */
    @Override
    public DormitoryBean queryDormitory(final DormitorySearchBean pSearchBean) {
        return dormitoryRepository.queryDormitory(pSearchBean);
    }



    @Override
    public Integer queryDormitoryCount(final DormitorySearchBean pSearchBean) {
        return dormitoryRepository.queryDormitoryCount(pSearchBean);
    }



    /**
     * @see com.noeasy.money.service.IDormitoryService#queryDormitoryPage(com.noeasy.money.model.DormitorySearchBean)
     */
    @Override
    public List<DormitoryBean> queryDormitoryPage(final DormitorySearchBean pSearchBean) {
        List<DormitoryBean> queryResult = dormitoryRepository.queryDormitoryPage(pSearchBean);
        return CollectionUtils.isEmpty(queryResult) ? Collections.EMPTY_LIST : queryResult;
    }



    /**
     * @see com.noeasy.money.service.IDormitoryService#queryDormitoryTypes()
     */
    @Override
    public List<Map<String, Object>> queryDormitoryTypes() {
        return dormitoryRepository.queryDormitoryTypes();
    }



    /**
     * @see com.noeasy.money.service.IDormitoryService#rateDormitory(int, int,
     *      int, boolean)
     */
    @Override
    public Double rateDormitory(final int pDormitoryId, final int pUserId, final int pPoint, final boolean pGetAvg) {
        DormitoryRateBean rate = new DormitoryRateBean(pDormitoryId, pUserId, pPoint);
        dormitoryRepository.rateDormitory(rate);
        if (!pGetAvg) {
            return 0D;
        }
        return dormitoryRepository.queryDormitoryAvgRate(pDormitoryId);
    }



    /**
     * @see com.noeasy.money.service.IDormitoryService#saveOrUpdateDormitory(com.noeasy.money.model.DormitoryBean)
     */
    @Override
    public Boolean saveOrUpdateDormitory(final DormitoryBean pDormitory) {
        if (pDormitory != null) {
            if (pDormitory.getId() > 0) {
                int updatedResult = dormitoryRepository.updateDormitory(pDormitory);
                return updatedResult == 1;
            } else {
                int saveResult = dormitoryRepository.saveDormitory(pDormitory);
                return saveResult == 1;
            }
        }
        return false;
    }

}
