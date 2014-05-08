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
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.noeasy.money.repository.INavigationRepository;
import com.noeasy.money.service.INavigationService;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Feb 10, 2014
 */
@Service(value = "navigationService")
public class NavigationService implements INavigationService {

    @Resource(name = "navigationRepository")
    INavigationRepository navigationRepository;



    /**
     * @return the navigationRepository
     */
    public INavigationRepository getNavigationRepository() {
        return navigationRepository;
    }



    /**
     * @see com.noeasy.money.service.INavigationService#queryCities()
     */
    @Override
    public List<Map<String, Object>> queryCities() {
        return navigationRepository.queryCities();
    }



    /**
     * @see com.noeasy.money.service.INavigationService#queryCities(java.lang.Integer)
     */
    @Override
    public List<Map<String, Object>> queryCities(final Integer pCountryId) {
        return navigationRepository.queryCities(pCountryId);
    }



    /**
     * @see com.noeasy.money.service.INavigationService#queryCitiesInSameCountry(java.lang.Integer)
     */
    @Override
    public List<Map<String, Object>> queryCitiesInSameCountry(final Integer pCityId) {
        return navigationRepository.queryCitiesInSameCountry(pCityId);
    }



    /**
     * @see com.noeasy.money.service.INavigationService#queryCityById(java.lang.Integer,
     *      java.lang.Integer)
     */
    @Override
    public Map<String, Object> queryCityById(final Integer pCityId, final Integer pCountryId) {
        return navigationRepository.queryCityById(pCityId, pCountryId);
    }



    /**
     * @see com.noeasy.money.service.INavigationService#queryCityCollegeByCityId(java.lang.Integer)
     */
    @Override
    public List<Map<String, Object>> queryCityCollegeByCityId(final Integer pCityId) {
        return navigationRepository.queryCityCollegeByCityId(pCityId);
    }



    /**
     * @see com.noeasy.money.service.INavigationService#queryCityCollegeByCountryId(java.lang.Integer)
     */
    @Override
    public List<Map<String, Object>> queryCityCollegeByCountryId(final Integer pCountryId) {
        return navigationRepository.queryCityCollegeByCityId(pCountryId);
    }



    /**
     * @see com.noeasy.money.service.INavigationService#queryCollegeById(java.lang.Integer,
     *      java.lang.Integer)
     */
    @Override
    public Map<String, Object> queryCollegeById(final Integer pCollegeId, final Integer pCityId) {
        return navigationRepository.queryCollegeById(pCollegeId, pCityId);
    }



    /**
     * @see com.noeasy.money.service.INavigationService#queryColleges()
     */
    @Override
    public List<Map<String, Object>> queryColleges() {
        return navigationRepository.queryColleges();
    }



    /**
     * @see com.noeasy.money.service.INavigationService#queryColleges(java.lang.Integer)
     */
    @Override
    public List<Map<String, Object>> queryColleges(final Integer pCityId) {
        return navigationRepository.queryColleges(pCityId);
    }



    /**
     * @see com.noeasy.money.service.INavigationService#queryCountries()
     */
    @Override
    public List<Map<String, Object>> queryCountries() {
        return navigationRepository.queryCountries();
    }



    /**
     * @see com.noeasy.money.service.INavigationService#queryCountryByCityId(java.lang.Integer)
     */
    @Override
    public Map<String, Object> queryCountryByCityId(final Integer pCityId) {
        return navigationRepository.queryCountryByCityId(pCityId);
    }



    /**
     * @see com.noeasy.money.service.INavigationService#queryCountryById(java.lang.Integer)
     */
    @Override
    public Map<String, Object> queryCountryById(final Integer pCountryId) {
        return navigationRepository.queryCountryById(pCountryId);
    }

    @Override
    public Map<String, Object> queryAirprotById(final Integer pCountryId) {
        return navigationRepository.queryAirprotById(pCountryId);
    }
    

    /**
     * @see com.noeasy.money.service.INavigationService#queryFlightByConditions(java.lang.Integer,
     *      java.lang.Integer, String)
     */
    @Override
    public List<Map<String, Object>> queryFlightByConditions(final Integer pCountryId, final Integer pCityId,
            final String pFlightNum) {
        return navigationRepository.queryFlightByConditions(pCountryId, pCityId, pFlightNum);
    }



    /**
     * @param pNavigationRepository
     *            the navigationRepository to set
     */
    public void setNavigationRepository(final INavigationRepository pNavigationRepository) {
        navigationRepository = pNavigationRepository;
    }



    @Override
    public List<Map<String, Object>> queryAirports(int pCountryId) {
        return navigationRepository.queryAirports(pCountryId);
    }

}
