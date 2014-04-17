package com.noeasy.money.admin.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.noeasy.money.constant.Constants;
import com.noeasy.money.model.RichTextBean;
import com.noeasy.money.service.ISiteService;
import com.noeasy.money.util.FileUtils;
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
    public String saveArticle(final MultipartHttpServletRequest request, final HttpServletResponse response,
            final Model model, final RichTextBean article, final boolean removeCover) {
        FileUtils fileUtils = FileUtils.getInstance();
        MultipartFile multipartFile = null;
        boolean result = false;

        Iterator<String> itr = request.getFileNames();
        while (itr.hasNext()) {
            multipartFile = request.getFile(itr.next());
            String coverFileName = multipartFile.getOriginalFilename();
            if (StringUtils.isNoneBlank(coverFileName)) {
                article.setCoverPath(coverFileName);
                result = siteService.saveOrUpdateArticle(article);
                if (result) {
                    String curCoverUploadFolderPath = fileUtils.createArticleCoverFolder(article.getId());
                    try {
                        FileCopyUtils.copy(multipartFile.getBytes(), new FileOutputStream(curCoverUploadFolderPath
                                + FileUtils.SLASH + multipartFile.getOriginalFilename()));
                        System.out.println(">>>" + multipartFile.getOriginalFilename() + ">>>");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else if (removeCover) {
                article.setCoverPath(coverFileName);
            }
            result = siteService.saveOrUpdateArticle(article);
            model.addAttribute("result", result);
            model.addAttribute("article", article);
            return "admin/site/article-save-result";
        }
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



    @RequestMapping("/article-detail" + Constants.URL_SUFFIX)
    public String toArticleDetail(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final int id) {
        RichTextBean article = new RichTextBean();
        if (ParamUtils.isValidIdField(id)) {
            article = siteService.queryArticle(id);
        }
        model.addAttribute("article", article);
        return "admin/site/article-detail";
    }



    @RequestMapping("/article-list" + Constants.URL_SUFFIX)
    public String toArticleList(final HttpServletRequest request, final HttpServletResponse response, final Model model) {
        List<Map<String, Object>> articleTitles = siteService.queryArticleTitles(null);
        model.addAttribute("articleTitles", articleTitles);
        return "admin/site/article-list";
    }
}
