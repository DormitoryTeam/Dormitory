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
package com.noeasy.money.service;

import java.util.List;
import java.util.Map;

import com.noeasy.money.model.PageBean;
import com.noeasy.money.model.SimpleSearchBean;
import com.noeasy.money.model.RichTextBean;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Mar 6, 2014
 */

public interface ISiteService {

    boolean deleteSlide();



    List<Map<String, Object>> queryAllSlides();



    RichTextBean queryArticle(int pId);



    List<RichTextBean> queryArticlePage();



    List<RichTextBean> queryArticleTitles(String pType);



    List<RichTextBean> queryArticleTitlesWithStatus(String pType, String pStatus, String pExcludeStatus);



    List<Map<String, Object>> queryCities(SimpleSearchBean searchBean);



    Integer queryCitiesCount(SimpleSearchBean searchBean);



    List<Map<String, Object>> queryColleges(String collegeName, String cityId, PageBean pPageBean);



    Integer queryCollegesCount(String collegeName, String cityId);



    List<Map<String, Object>> queryCompanies(SimpleSearchBean searchBean);



    Integer queryCompaniesCount(SimpleSearchBean searchBean);



    List<Map<String, Object>> querySlides();



    boolean saveCompnay(String pCompanyName);



    boolean saveOrUpdateArticle(RichTextBean pRichTextBean);



    boolean saveOrUpdateCity(String pId, String pName, String pOriginalName, String pTopCity, String pStatus);



    boolean saveOrUpdateCollege(String pId, String pCityId, String pName, String pOriginalName, String pLatitude,
            String pLongitude, String pPostalCode, String pTopCollege, String status);



    boolean saveSlide(String pURL, String pPath, Integer pIndex, Integer pStatus);



    boolean updateCompanyStatus(String pCompanyId, String pStatus);



    List<Map<String, Object>> queryEmail(String type, String status);



    boolean saveOrUpdateEmail(String Id, String email, String type, String status);
}
