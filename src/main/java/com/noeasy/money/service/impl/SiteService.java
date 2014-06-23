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

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.noeasy.money.model.PageBean;
import com.noeasy.money.model.SimpleSearchBean;
import com.noeasy.money.model.RichTextBean;
import com.noeasy.money.repository.ISiteRepository;
import com.noeasy.money.service.ISiteService;

/**
 * 
 * @author: Yove
 * @version: 1.0, Mar 6, 2014
 */
@Service(value = "siteService")
public class SiteService implements ISiteService {

    @Resource(name = "siteRepository")
    ISiteRepository siteRepository;



    /**
     * @see com.noeasy.money.service.ISiteService#deleteSlide()
     */
    @Override
    public boolean deleteSlide() {
        return siteRepository.deleteSlide();
    }



    /**
     * @see com.noeasy.money.service.ISiteService#queryAllSlides()
     */
    @Override
    public List<Map<String, Object>> queryAllSlides() {
        return siteRepository.queryAllSlides();
    }



    /**
     * @see com.noeasy.money.service.ISiteService#queryArticle(int)
     */
    @Override
    public RichTextBean queryArticle(final int pId) {
        return siteRepository.queryArticle(pId);
    }



    /**
     * @see com.noeasy.money.service.ISiteService#queryArticlePage()
     */
    @Override
    public List<RichTextBean> queryArticlePage() {
        return siteRepository.queryArticlePage();
    }



    /**
     * @see com.noeasy.money.service.ISiteService#queryArticleTitles(java.lang.String)
     */
    @Override
    public List<RichTextBean> queryArticleTitles(final String pType) {
        return siteRepository.queryArticleTitleWithStatus(pType, null, null);
    }



    /**
     * @see com.noeasy.money.service.ISiteService#queryArticleTitlesWithStatus(java.lang.String,
     *      String, String)
     */
    @Override
    public List<RichTextBean> queryArticleTitlesWithStatus(final String pType, final String pStatus,
            final String pExcludeStatus) {
        return siteRepository.queryArticleTitleWithStatus(pType, pStatus, pExcludeStatus);
    }



    /**
     * @see com.noeasy.money.service.ISiteService#queryCities(java.lang.String)
     */
    @Override
    public List<Map<String, Object>> queryCities(final SimpleSearchBean pSearchBean) {
        return siteRepository.queryCities(pSearchBean);
    }

    @Override
    public Integer queryCitiesCount(SimpleSearchBean pSearchBean) {
        return siteRepository.queryCitiesCount(pSearchBean);
    }

    /**
     * @see com.noeasy.money.service.ISiteService#queryColleges(java.lang.String,
     *      java.lang.String)
     */
    @Override
    public List<Map<String, Object>> queryColleges(final String pCollegeName, final String pCityId, PageBean pPageBean) {
        return siteRepository.queryColleges(pCollegeName, pCityId, pPageBean);
    }



    @Override
    public Integer queryCollegesCount(String pCollegeName, String pCityId) {
        return siteRepository.queryCollegesCount(pCollegeName, pCityId);
    }



    /**
     * @see com.noeasy.money.service.ISiteService#queryCompanies()
     */
    @Override
    public List<Map<String, Object>> queryCompanies(SimpleSearchBean searchBean) {
        return siteRepository.queryCompanies(searchBean);
    }



    /**
     * @see com.noeasy.money.service.ISiteService#querySlides()
     */
    @Override
    public List<Map<String, Object>> querySlides() {
        return siteRepository.querySlides();
    }



    /**
     * @see com.noeasy.money.service.ISiteService#saveCompnay(java.lang.String)
     */
    @Override
    public boolean saveCompnay(final String pCompanyName) {
        return siteRepository.saveCompnay(pCompanyName);
    }



    /**
     * @see com.noeasy.money.service.ISiteService#saveOrUpdateArticle(com.noeasy.money.model.RichTextBean)
     */
    @Override
    public boolean saveOrUpdateArticle(final RichTextBean pRichTextBean) {
        if (pRichTextBean.getId() == 0) {
            return siteRepository.saveArticle(pRichTextBean);
        } else {
            return siteRepository.updateArticle(pRichTextBean);
        }
    }



    /**
     * @see com.noeasy.money.service.ISiteService#saveOrUpdateCity(java.lang.String,
     *      java.lang.String, java.lang.String, String, java.lang.String)
     */
    @Override
    public boolean saveOrUpdateCity(final String pId, final String pName, final String pOriginalName,
            final String pTopCity, final String pStatus) {
        if (StringUtils.isBlank(pId)) {
            return siteRepository.saveCity(pName, pOriginalName, pTopCity, pStatus);
        } else {
            return siteRepository.updateCity(pId, pName, pOriginalName, pTopCity, pStatus);
        }
    }



    /**
     * @see com.noeasy.money.service.ISiteService#saveOrUpdateCollege(java.lang.String,
     *      java.lang.String, java.lang.String, java.lang.String,
     *      java.lang.String, java.lang.String, java.lang.String, String,
     *      java.lang.String)
     */
    @Override
    public boolean saveOrUpdateCollege(final String pId, final String pCityId, final String pName,
            final String pOriginalName, final String pLatitude, final String pLongitude, final String pPostalCode,
            final String pTopCollege, final String pStatus) {
        if (StringUtils.isBlank(pId)) {
            return siteRepository.saveCollege(pName, pOriginalName, pCityId, pLatitude, pLongitude, pPostalCode,
                    pTopCollege, pStatus);
        } else {
            return siteRepository.updateCollege(pId, pCityId, pName, pOriginalName, pLatitude, pLongitude, pPostalCode,
                    pTopCollege, pStatus);
        }
    }



    /**
     * @see com.noeasy.money.service.ISiteService#saveSlide(java.lang.String,
     *      java.lang.String, java.lang.Integer, java.lang.Integer)
     */
    @Override
    public boolean saveSlide(final String pURL, final String pPath, final Integer pIndex, final Integer pStatus) {
        return siteRepository.saveSlide(pURL, pPath, pIndex, pStatus, null);
    }



    /**
     * @see com.noeasy.money.service.ISiteService#updateCompanyStatus(String,
     *      String)
     */
    @Override
    public boolean updateCompanyStatus(final String pCompanyId, final String pStatus) {
        return siteRepository.updateCompanyStatus(pCompanyId, pStatus);
    }



    @Override
    public Integer queryCompaniesCount(SimpleSearchBean searchBean) {
        return siteRepository.queryCompaniesCount(searchBean);
    }

}
