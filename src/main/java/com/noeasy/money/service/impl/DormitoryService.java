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

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.noeasy.money.model.DormitoryBean;
import com.noeasy.money.model.DormitoryRateBean;
import com.noeasy.money.model.DormitorySearchBean;
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
    private SqlSession sqlSession;



    /**
     * @see com.noeasy.money.service.IDormitoryService#queryDormitoryById(int)
     */
    public DormitoryBean queryDormitoryById(int pId) {
        return this.sqlSession.selectOne("om.noeasy.money.model.Dormitory.queryDormitoryById", pId);
    }



    /**
     * @see com.noeasy.money.service.IDormitoryService#queryDormitoryByConditions(com.noeasy.money.model.DormitorySearchBean)
     */
    public List<DormitoryBean> queryDormitoryByConditions(DormitorySearchBean pSearchBean) {
        // TODO Auto-generated method stub
        return null;
    }



    /**
     * @see com.noeasy.money.service.IDormitoryService#rateDormitory(int, int,
     *      int)
     */
    public Double rateDormitory(int pDormitoryId, int pUserId, int pPoint) {
        DormitoryRateBean rate = new DormitoryRateBean(pDormitoryId, pUserId, pPoint);
        this.sqlSession.insert("com.noeasy.money.model.Dormitory.rate", rate);
        return this.sqlSession.selectOne("com.noeasy.money.model.Dormitory.calculateAvgRating", pDormitoryId);
    }



    /**
     * @see com.noeasy.money.service.IDormitoryService#calculateDistance()
     */
    public Boolean calculateDistance() {
        this.sqlSession.delete("com.noeasy.money.model.Dormitory.clearDistanceResult");
        this.sqlSession.insert("com.noeasy.money.model.Dormitory.initialDistanceResult");
        return true;
    }
}
