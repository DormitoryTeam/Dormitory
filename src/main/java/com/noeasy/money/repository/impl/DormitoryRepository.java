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

import java.util.List;

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
     * @see com.noeasy.money.repository.IDormitoryRepository#queryDormitory(com.noeasy.money.model.DormitorySearchBean)
     */
    @Override
    public DormitoryBean queryDormitory(DormitorySearchBean pSearchBean) {
        return getSqlSession().selectOne("com.noeasy.money.model.Dormitory.queryDormitory", pSearchBean);
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#queryDormitoryPage(com.noeasy.money.model.DormitorySearchBean)
     */
    @Override
    public List<DormitoryBean> queryDormitoryPage(DormitorySearchBean pSearchBean) {
        return getSqlSession().selectList("com.noeasy.money.model.Dormitory.queryDormitoryPage", pSearchBean);
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#rateDormitory(com.noeasy.money.model.DormitoryRateBean)
     */
    @Override
    public Boolean rateDormitory(DormitoryRateBean pDormitoryRateBean) {
        getSqlSession().insert("com.noeasy.money.model.Dormitory.rate", pDormitoryRateBean);
        return true;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#queryDormitoryAvgRate(int)
     */
    @Override
    public Double queryDormitoryAvgRate(int pDormitoryId) {
        return getSqlSession().selectOne("com.noeasy.money.model.Dormitory.calculateAvgRating", pDormitoryId);
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
     * @see com.noeasy.money.repository.IDormitoryRepository#initialDistanceResult()
     */
    @Override
    public Boolean initialDistanceResult() {
        getSqlSession().insert("com.noeasy.money.model.Dormitory.initialDistanceResult");
        return true;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#clearDistanceResult4City(int)
     */
    @Override
    public Boolean clearDistanceResult4City(int pCityId) {
        getSqlSession().delete("com.noeasy.money.model.Dormitory.clearDistanceResult4City", pCityId);
        return true;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#calculateDistance4City(int)
     */
    @Override
    public Boolean calculateDistance4City(int pCityId) {
        getSqlSession().insert("com.noeasy.money.model.Dormitory.calculateDistance4City", pCityId);
        return true;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#clearDistanceResult4College(int)
     */
    @Override
    public Boolean clearDistanceResult4College(int pCollegeId) {
        getSqlSession().delete("com.noeasy.money.model.Dormitory.clearDistanceResult4College", pCollegeId);
        return true;
    }



    /**
     * @see com.noeasy.money.repository.IDormitoryRepository#calculateDistance4College(int)
     */
    @Override
    public Boolean calculateDistance4College(int pCollegeId) {
        getSqlSession().insert("com.noeasy.money.model.Dormitory.calculateDistance4College", pCollegeId);
        return true;
    }

}
