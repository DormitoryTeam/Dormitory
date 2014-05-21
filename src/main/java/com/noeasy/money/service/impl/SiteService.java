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

import com.noeasy.money.model.RichTextBean;
import com.noeasy.money.repository.ISiteRepository;
import com.noeasy.money.service.ISiteService;

/**
 * <class description>
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
     * @see com.noeasy.money.service.ISiteService#queryActiveArticleTitles(java.lang.String)
     */
    @Override
    public List<Map<String, Object>> queryActiveArticleTitles(final String pType) {
        return siteRepository.queryArticleTitle(pType, "1");
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
    public List<Map<String, Object>> queryArticleTitles(final String pType) {
        return siteRepository.queryArticleTitle(pType, null);
    }



    /**
     * @see com.noeasy.money.service.ISiteService#queryCompanies()
     */
    @Override
    public List<Map<String, Object>> queryCompanies() {
        return siteRepository.queryCompanies();
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
     * @see com.noeasy.money.service.ISiteService#saveSlide(java.lang.String,
     *      java.lang.String, java.lang.Integer, java.lang.Integer)
     */
    @Override
    public boolean saveSlide(final String pDescription, final String pPath, final Integer pIndex, final Integer pStatus) {
        return siteRepository.saveSlide(pDescription, pPath, pIndex, pStatus, null);
    }



    /**
     * @see com.noeasy.money.service.ISiteService#updateCompanyStatus(String,
     *      String)
     */
    @Override
    public boolean updateCompanyStatus(final String pCompanyId, final String pStatus) {
        return siteRepository.updateCompanyStatus(pCompanyId, pStatus);
    }

}
