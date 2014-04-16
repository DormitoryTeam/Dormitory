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

import com.noeasy.money.model.RichTextBean;
import com.noeasy.money.repository.ISiteRepository;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Mar 6, 2014
 */
@Repository("siteRepository")
public class SiteRepository extends BaseRepository implements ISiteRepository {

    /**
     * @see com.noeasy.money.repository.ISiteRepository#deleteSlide()
     */
    @Override
    public boolean deleteSlide() {
        return getSqlSession().delete("com.noeasy.money.model.Site.deleteSlide") > 0;
    }



    /**
     * @see com.noeasy.money.repository.ISiteRepository#queryAllSlides()
     */
    @Override
    public List<Map<String, Object>> queryAllSlides() {
        return getSqlSession().selectList("com.noeasy.money.model.Site.selectAllSlide");
    }



    /**
     * @see com.noeasy.money.repository.ISiteRepository#queryArticle(int)
     */
    @Override
    public RichTextBean queryArticle(final int pId) {
        return getSqlSession().selectOne("com.noeasy.money.model.Site.selectArticle", pId);
    }



    /**
     * @see com.noeasy.money.repository.ISiteRepository#queryArticlePage()
     */
    @Override
    public List<RichTextBean> queryArticlePage() {
        return getSqlSession().selectList("com.noeasy.money.model.Site.selectArticlePage");
    }



    /**
     * @see com.noeasy.money.repository.ISiteRepository#queryArticleTitle(java.lang.String,
     *      java.lang.String)
     */
    @Override
    public List<Map<String, Object>> queryArticleTitle(final String pType, final String pStatus) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status", pStatus);
        params.put("type", pType);
        return getSqlSession().selectList("com.noeasy.money.model.Site.selectArticleTitle", params);
    }



    /**
     * @see com.noeasy.money.repository.ISiteRepository#querySlides()
     */
    @Override
    public List<Map<String, Object>> querySlides() {
        return getSqlSession().selectList("com.noeasy.money.model.Site.selectSlide");
    }



    /**
     * @see com.noeasy.money.repository.ISiteRepository#saveArticle(com.noeasy.money.model.RichTextBean)
     */
    @Override
    public boolean saveArticle(final RichTextBean pRichTextBean) {
        return getSqlSession().insert("com.noeasy.money.model.Site.saveArticle", pRichTextBean) > 0;
    }



    /**
     * @see com.noeasy.money.repository.ISiteRepository#saveSlide(java.lang.String,
     *      java.lang.String, java.lang.String, java.lang.String, String)
     */
    @Override
    public boolean saveSlide(final String pDescription, final String pPath, final Integer pIndex,
            final Integer pStatus, final String pType) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("desc", pDescription);
        params.put("path", pPath);
        params.put("index", pIndex);
        params.put("status", pStatus);
        params.put("type", pType);
        return getSqlSession().insert("com.noeasy.money.model.Site.insertSlide", params) > 0;
    }



    /**
     * @see com.noeasy.money.repository.ISiteRepository#updateArticle(com.noeasy.money.model.RichTextBean)
     */
    @Override
    public boolean updateArticle(final RichTextBean pRichTextBean) {
        return getSqlSession().update("com.noeasy.money.model.Site.updateArticle", pRichTextBean) > 0;
    }



    /**
     * @see com.noeasy.money.repository.ISiteRepository#updateSlide(java.lang.Integer,
     *      java.lang.String, java.lang.String, java.lang.String, String)
     */
    @Override
    public boolean updateSlide(final Integer pId, final String pDescription, final Integer pIndex,
            final String pStatus, final String pType) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("desc", pDescription);
        params.put("index", pIndex);
        params.put("status", pStatus);
        params.put("id", pId);
        params.put("type", pType);
        return getSqlSession().update("com.noeasy.money.model.Site.updateSlide", params) > 0;
    }

}
