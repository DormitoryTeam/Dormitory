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
package com.noeasy.money.admin.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.noeasy.money.constant.Constants;
import com.noeasy.money.service.ISiteService;
import com.noeasy.money.util.FileUtils;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Mar 6, 2014
 */
@Controller
@RequestMapping("/admin")
public class AdminSlideController {

    @Resource(name = "siteService")
    ISiteService siteService;



    @RequestMapping(value = "/slide-image-preview" + Constants.URL_SUFFIX)
    public void previewDormitoryUploadImage(final HttpServletResponse response, final Integer dormitoryId,
            final String fileName) {
        FileUtils fileUtils = FileUtils.getInstance();
        File getFile = fileUtils.getFile(fileUtils.createUploadSlideImageFolder(), fileName);
        if (getFile != null) {
            try {
                response.setContentType("image/jpeg");
                response.setHeader("Content-disposition", "attachment; filename=\"" + getFile.getName() + "\"");
                FileCopyUtils.copy(FileCopyUtils.copyToByteArray(getFile), response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    @RequestMapping("/slide-save" + Constants.URL_SUFFIX)
    public String slideSave(final HttpServletRequest request, final HttpServletResponse response, final Model model,
            final String[] imageNames, final int[] imageIndexes, final int[] imageShow, final String[] urls) {
        if (imageNames != null && imageIndexes != null && imageShow != null) {
            if (imageNames.length == imageIndexes.length && imageNames.length == imageShow.length) {
                siteService.deleteSlide();
                for (int i = 0; i < imageNames.length; i++) {
                    if (imageShow[i] == 0) {
                        imageIndexes[i] = Integer.MAX_VALUE;
                    }
                    if(null != urls && i < urls.length) {
                        siteService.saveSlide(urls[i], imageNames[i], imageIndexes[i], imageShow[i]);
                    } else {
                        siteService.saveSlide("", imageNames[i], imageIndexes[i], imageShow[i]);
                    }
                    
                }
                model.addAttribute("result", true);

                FileUtils fileUtils = FileUtils.getInstance();
                List<String> validFiles = Arrays.asList(imageNames);
                fileUtils.removeInvalidFiles(fileUtils.getUploadSlideImagePaht(), validFiles);
            }
        }
        return "admin/site/slide-save-result";
    }



    @RequestMapping("/slide-management" + Constants.URL_SUFFIX)
    public String toSlideManagement(final HttpServletRequest request, final HttpServletResponse response,
            final Model model) {
        List<Map<String, Object>> slides = siteService.queryAllSlides();
        model.addAttribute("slides", slides);
        return "admin/site/slide-management";
    }



    @RequestMapping(value = "slide-image-upload" + Constants.URL_SUFFIX, method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> uploadDormitoryImage(final MultipartHttpServletRequest request,
            final HttpServletResponse response) {
        List<Map<String, Object>> fileMetaList = new ArrayList<Map<String, Object>>();
        FileUtils fileUtils = FileUtils.getInstance();
        String curSlideUploadFolderPath = fileUtils.createUploadSlideImageFolder();
        MultipartFile multipartFile = null;
        HashMap<String, Object> fileMeta = null;

        Iterator<String> itr = request.getFileNames();
        while (itr.hasNext()) {
            multipartFile = request.getFile(itr.next());
            fileMeta = new HashMap<String, Object>();
            fileMeta.put("name", multipartFile.getOriginalFilename());
            fileMeta.put("type", multipartFile.getContentType());
            fileMeta.put("size", multipartFile.getSize() / 1024);
            try {
                FileCopyUtils.copy(multipartFile.getBytes(), new FileOutputStream(curSlideUploadFolderPath
                        + FileUtils.SLASH + multipartFile.getOriginalFilename()));
                System.out.println(">>>" + multipartFile.getOriginalFilename() + ">>>");
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileMetaList.add(fileMeta);
        }

        return fileMetaList;
    }
}
