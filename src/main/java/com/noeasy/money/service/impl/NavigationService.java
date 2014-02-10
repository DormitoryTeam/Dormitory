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
     * @see com.noeasy.money.service.INavigationService#queryCities(java.lang.Integer)
     */
    @Override
    public List<Map<String, String>> queryCities(final Integer pCountryId) {
        return navigationRepository.queryCities(pCountryId);
    }



    /**
     * @see com.noeasy.money.service.INavigationService#queryCityById(java.lang.Integer,
     *      java.lang.Integer)
     */
    @Override
    public Map<String, String> queryCityById(final Integer pCityId, final Integer pCountryId) {
        return navigationRepository.queryCityById(pCityId, pCountryId);
    }



    /**
     * @see com.noeasy.money.service.INavigationService#queryCollegeById(java.lang.Integer,
     *      java.lang.Integer)
     */
    @Override
    public Map<String, String> queryCollegeById(final Integer pCollegeId, final Integer pCityId) {
        return navigationRepository.queryCollegeById(pCollegeId, pCityId);
    }



    /**
     * @see com.noeasy.money.service.INavigationService#queryColleges(java.lang.Integer)
     */
    @Override
    public List<Map<String, String>> queryColleges(final Integer pCityId) {
        return navigationRepository.queryColleges(pCityId);
    }



    /**
     * @see com.noeasy.money.service.INavigationService#queryCountries()
     */
    @Override
    public List<Map<String, String>> queryCountries() {
        return navigationRepository.queryCountries();
    }



    /**
     * @see com.noeasy.money.service.INavigationService#queryCountryById(java.lang.Integer)
     */
    @Override
    public Map<String, String> queryCountryById(final Integer pCountryId) {
        return navigationRepository.queryCountryById(pCountryId);
    }



    /**
     * @param pNavigationRepository
     *            the navigationRepository to set
     */
    public void setNavigationRepository(final INavigationRepository pNavigationRepository) {
        navigationRepository = pNavigationRepository;
    }

}
