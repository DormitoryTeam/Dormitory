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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.noeasy.money.repository.INavigationRepository;
import com.noeasy.money.util.ParamUtils;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Feb 10, 2014
 */
@Repository("navigationRepository")
public class NavigationRepository extends BaseRepository implements INavigationRepository {

    private static final String ID         = "id";
    private static final String COUNTRY_ID = "countryId";
    private static final String CITY_ID    = "cityId";



    /**
     * @see com.noeasy.money.repository.INavigationRepository#queryCities(java.lang.Integer)
     */
    @Override
    public List<Map<String, Object>> queryCities(final Integer pCountryId) {
        if (ParamUtils.isValidIdField(pCountryId)) {
            Map<String, Integer> params = new HashMap<String, Integer>();
            params.put(COUNTRY_ID, pCountryId);
            return getSqlSession().selectList("queryCity", params);
        }
        return getSqlSession().selectList("queryCity");
    }



    /**
     * @see com.noeasy.money.repository.INavigationRepository#queryCityById(java.lang.Integer,
     *      java.lang.Integer)
     */
    @Override
    public Map<String, Object> queryCityById(final Integer pCityId, final Integer pCountryId) {
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put(ID, pCityId);
        params.put(COUNTRY_ID, pCountryId);
        return getSqlSession().selectOne("queryCity", params);
    }



    /**
     * @see com.noeasy.money.repository.INavigationRepository#queryCollegeById(java.lang.Integer,
     *      java.lang.Integer)
     */
    @Override
    public Map<String, Object> queryCollegeById(final Integer pCollegeId, final Integer pCityId) {
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put(ID, pCollegeId);
        params.put(CITY_ID, pCityId);
        return getSqlSession().selectOne("queryCollege", params);
    }



    /**
     * @see com.noeasy.money.repository.INavigationRepository#queryColleges(java.lang.Integer)
     */
    @Override
    public List<Map<String, Object>> queryColleges(final Integer pCityId) {
        if (ParamUtils.isValidIdField(pCityId)) {
            Map<String, Integer> params = new HashMap<String, Integer>();
            params.put(CITY_ID, pCityId);
            return getSqlSession().selectList("queryCollege", params);
        }
        return getSqlSession().selectList("queryCollege");
    }



    /**
     * @see com.noeasy.money.repository.INavigationRepository#queryCountries()
     */
    @Override
    public List<Map<String, Object>> queryCountries() {
        return getSqlSession().selectList("queryCountry");
    }



    /**
     * @see com.noeasy.money.repository.INavigationRepository#queryCountryById(java.lang.Integer)
     */
    @Override
    public Map<String, Object> queryCountryById(final Integer pCountryId) {
        return getSqlSession().selectOne("queryCountry", pCountryId);
    }

}
