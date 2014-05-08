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

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Feb 10, 2014
 */

public interface INavigationRepository {

    List<Map<String, Object>> queryCities();



    List<Map<String, Object>> queryCities(Integer pCountryId);



    List<Map<String, Object>> queryCitiesInSameCountry(Integer pCityId);



    Map<String, Object> queryCityById(Integer pCityId, Integer pCountryId);



    List<Map<String, Object>> queryCityCollegeByCityId(Integer pCityId);



    List<Map<String, Object>> queryCityCollegeByCountryId(Integer pCountryId);



    Map<String, Object> queryCollegeById(Integer pCollegeId, Integer pCityId);



    List<Map<String, Object>> queryColleges();



    List<Map<String, Object>> queryColleges(Integer pCityId);



    List<Map<String, Object>> queryCountries();



    Map<String, Object> queryCountryByCityId(Integer pCityId);



    Map<String, Object> queryCountryById(Integer pCountryId);



    List<Map<String, Object>> queryFlightByConditions(Integer pCountryId, Integer pCityId, String pFilghtNum);



    List<Map<String, Object>> queryAirports(int pCountryId);



    Map<String, Object> queryAirprotById(Integer pCountryId);
}
