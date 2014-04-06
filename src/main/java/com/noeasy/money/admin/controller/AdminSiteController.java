package com.noeasy.money.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noeasy.money.constant.Constants;
import com.noeasy.money.model.RichTextBean;
import com.noeasy.money.service.ISiteService;
import com.noeasy.money.util.ParamUtils;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Apr 6, 2014
 */
@Controller
@RequestMapping("/admin/site")
public class AdminSiteController {

    @Resource(name = "siteService")
    ISiteService siteService;



    @RequestMapping("/article-save" + Constants.URL_SUFFIX)
    public String saveArticle(final HttpServletRequest request, final HttpServletResponse response, final Model model,
            final RichTextBean article) {
        boolean result = siteService.saveOrUpdateArticle(article);
        model.addAttribute("result", result);
        model.addAttribute("article", article);
        return "admin/site/article-save-result";
    }



    @RequestMapping("/article-add-or-update" + Constants.URL_SUFFIX)
    public String toArticleAddOrUpdate(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final String backURL, final Integer id) {
        RichTextBean article = new RichTextBean();
        if (ParamUtils.isValidIdField(id)) {
            article = siteService.queryArticle(id);
        }

        model.addAttribute("article", article);
        return "admin/site/article-edit";
    }
}
