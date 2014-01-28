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

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Resource(name = "sqlSession")
    private SqlSession           sqlSession;

    @Resource(name = "dormitoryRepository")
    private IDormitoryRepository dormitoryRepository;



    /**
     * @see com.noeasy.money.service.IDormitoryService#queryDormitoryById(int)
     */
    public DormitoryBean queryDormitoryById(int pId) {
        return this.sqlSession.selectOne("com.noeasy.money.model.Dormitory.queryDormitoryById", pId);
    }



    /**
     * @see com.noeasy.money.service.IDormitoryService#queryDormitoryByConditions(com.noeasy.money.model.DormitorySearchBean)
     */
    public List<DormitoryBean> queryDormitoryByConditions(DormitorySearchBean pSearchBean) {
        List<DormitoryBean> queryResult = null;
        if (StringUtils.isNoneBlank(pSearchBean.getKeyword())) {
            queryResult = dormitoryRepository.queryDormitoryPageByKeywordOrderByField(pSearchBean);
        } else if (pSearchBean.getCityId() > 0) {
            queryResult = dormitoryRepository.queryDormitoryByCityId(pSearchBean);
        } else if (pSearchBean.getContractTypeId() > 0 && pSearchBean.getDormitoryTypeId() > 0) {
            queryResult = dormitoryRepository.queryDormitoryByDormitoryTypeAndContract(pSearchBean);
        }
        return CollectionUtils.isEmpty(queryResult) ? Collections.EMPTY_LIST : queryResult;
    }



    /**
     * @see com.noeasy.money.service.IDormitoryService#rateDormitory(int, int,
     *      int, boolean)
     */
    public Double rateDormitory(int pDormitoryId, int pUserId, int pPoint, boolean pGetAvg) {
        DormitoryRateBean rate = new DormitoryRateBean(pDormitoryId, pUserId, pPoint);
        dormitoryRepository.rateDormitory(rate);
        if (!pGetAvg) {
            return 0D;
        }
        return dormitoryRepository.queryDormitoryAvgRate(pDormitoryId);
    }



    /**
     * @see com.noeasy.money.service.IDormitoryService#calculateDistance()
     */
    public Boolean calculateDistance() {
        if (dormitoryRepository.clearDistanceResult()) {
            return dormitoryRepository.initialDistanceResult();
        }
        return false;
    }



    /**
     * @see com.noeasy.money.service.IDormitoryService#calculateDistance4City(int)
     */
    public Boolean calculateDistance4City(int pCityId) {
        if (dormitoryRepository.clearDistanceResult4City(pCityId)) {
            return dormitoryRepository.calculateDistance4City(pCityId);
        }
        return false;
    }



    /**
     * @see com.noeasy.money.service.IDormitoryService#calculateDistance4College(int)
     */
    public Boolean calculateDistance4College(int pCollegeId) {
        if (dormitoryRepository.clearDistanceResult4College(pCollegeId)) {
            return dormitoryRepository.calculateDistance4College(pCollegeId);
        }
        return false;
    }

}
