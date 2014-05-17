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

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.noeasy.money.constant.Constants;
import com.noeasy.money.model.DormitoryBean;
import com.noeasy.money.model.DormitorySearchBean;
import com.noeasy.money.model.PageBean;
import com.noeasy.money.model.RoomInfoBean;
import com.noeasy.money.model.RoomPrice;
import com.noeasy.money.service.IDormitoryService;
import com.noeasy.money.service.INavigationService;
import com.noeasy.money.util.FileUtils;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Feb 16, 2014
 */
@Controller
@RequestMapping("/admin/dormitory")
public class AdminDormitoryController {

    @Resource(name = "dormitoryService")
    IDormitoryService  dormitoryService;

    @Resource(name = "navigationService")
    INavigationService navigationService;



    @RequestMapping("dormitory-save" + Constants.URL_SUFFIX)
    public String dormitoryUpdate(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final DormitoryBean dormitory, final AdminDormitoryParamVector paramVector,
            final String backURL) {

        int roomTypeCount = ((List) request.getSession().getServletContext().getAttribute("roomTypes")).size();
        int contractCount = ((List) request.getSession().getServletContext().getAttribute("contractTypes")).size();

        if (ArrayUtils.isNotEmpty(paramVector.getImageNames())) {
            dormitory.setPicPath(Arrays.asList(paramVector.getImageNames()));
        }

        double minPrice = Double.MAX_VALUE;
        for (int i = 0; i < roomTypeCount; i++) {
            RoomInfoBean room = dormitory.getRooms().get(i);
            for (int j = 0; j < contractCount; j++) {
                RoomPrice price = paramVector.getPrices().get(i * contractCount + j);
                room.getContractPrice().add(price);

                if (price.getSalePrice() > 0d && price.getSalePrice().compareTo(minPrice) < 0) {
                    minPrice = price.getSalePrice();
                }
            }
        }
        if (minPrice < Double.MAX_VALUE) {
            dormitory.setSalePrice(minPrice);
        }

        double minWeekPrice = Double.MAX_VALUE;
        for (int i = 0; i < roomTypeCount; i++) {
            RoomInfoBean room = dormitory.getRooms().get(i);
            for (int j = 0; j < contractCount; j++) {
                RoomPrice price = paramVector.getPrices().get(i * contractCount + j);
                room.getContractPrice().add(price);

                if (price.getWeekPrice() > 0d && price.getWeekPrice().compareTo(minWeekPrice) < 0) {
                    minWeekPrice = price.getWeekPrice();
                }
            }
        }
        if (minWeekPrice < Double.MAX_VALUE) {
            dormitory.setWeekPrice(minWeekPrice);
        }
        
        boolean result = dormitoryService.saveOrUpdateDormitory(dormitory);
        if (result) {
            dormitoryService.calculateDistance4Dormitory(dormitory.getId());
        }
        model.addAttribute("result", result);
        FileUtils fileUtils = FileUtils.getInstance();
        fileUtils.removeInvalidFiles(fileUtils.createUploadDormitoryImageFolder(dormitory.getId()),
                dormitory.getPicPath());

        List<Map<String, Object>> countries = navigationService.queryCountries();
        Map<String, Object> currentCountry = navigationService.queryCountryByCityId(dormitory.getCityId());
        List<Map<String, Object>> cities = navigationService.queryCitiesInSameCountry(dormitory.getCityId());
        List<Map<String, Object>> companies = navigationService.queryCompanies();

        model.addAttribute("dormitory", dormitory);
        model.addAttribute("backURL", backURL);
        model.addAttribute("countries", countries);
        model.addAttribute("currentCountry", currentCountry);
        model.addAttribute("cities", cities);
        model.addAttribute("companies", companies);
        model.addAttribute("emptyRoom", new RoomInfoBean());
        model.addAttribute("emptyPrice", new RoomPrice());
        model.addAttribute("emptyDormitory", new DormitoryBean());
        return "admin/dormitory/dormitory-edit";
    }



    @InitBinder
    public void initBinder(final WebDataBinder binder) {
        binder.setAutoGrowCollectionLimit(1024);
    }



    @RequestMapping(value = "/dormitory-image-preview" + Constants.URL_SUFFIX)
    public void previewDormitoryUploadImage(final HttpServletResponse response, final Integer dormitoryId,
            final String fileName) {
        FileUtils fileUtils = FileUtils.getInstance();
        File getFile = fileUtils.getFile(fileUtils.createUploadDormitoryImageFolder(dormitoryId), fileName);
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



    @RequestMapping("dormitory-add" + Constants.URL_SUFFIX)
    public String toDormitoryAdd(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final String backURL) {
        List<Map<String, Object>> countries = navigationService.queryCountries();
        if (CollectionUtils.isNotEmpty(countries)) {
            Integer firstCountryId = (Integer) countries.get(0).get("id");
            List<Map<String, Object>> cities = navigationService.queryCities(firstCountryId);
            List<Map<String, Object>> contractTypes = dormitoryService.queryContractTypes();
            List<Map<String, Object>> dormitoryTypes = dormitoryService.queryRoomTypes();
            List<Map<String, Object>> companies = navigationService.queryCompanies();

            model.addAttribute("backURL", backURL);
            model.addAttribute("countries", countries);
            model.addAttribute("cities", cities);
            model.addAttribute("companies", companies);
            model.addAttribute("contractTypes", contractTypes);
            model.addAttribute("dormitoryTypes", dormitoryTypes);
            model.addAttribute("emptyRoom", new RoomInfoBean());
            model.addAttribute("emptyPrice", new RoomPrice());
        }
        return "admin/dormitory/dormitory-edit";
    }



    @RequestMapping("dormitory-edit" + Constants.URL_SUFFIX)
    public String toDormitoryEdit(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final Integer dormitoryId, final String backURL) {
        if (dormitoryId != null) {
            DormitorySearchBean searchBean = new DormitorySearchBean();
            searchBean.setId(dormitoryId);
            searchBean.setPageBean(null);
            DormitoryBean dormitory = dormitoryService.queryDormitory(searchBean);

            List<Map<String, Object>> countries = navigationService.queryCountries();
            Map<String, Object> currentCountry = navigationService.queryCountryByCityId(dormitory.getCityId());
            List<Map<String, Object>> cities = navigationService.queryCitiesInSameCountry(dormitory.getCityId());
            List<Map<String, Object>> companies = navigationService.queryCompanies();

            model.addAttribute("dormitory", dormitory);
            model.addAttribute("backURL", backURL);
            model.addAttribute("countries", countries);
            model.addAttribute("currentCountry", currentCountry);
            model.addAttribute("cities", cities);
            model.addAttribute("companies", companies);
            model.addAttribute("emptyRoom", new RoomInfoBean());
            model.addAttribute("emptyPrice", new RoomPrice());
            model.addAttribute("emptyDormitory", new DormitoryBean());
        }
        return "admin/dormitory/dormitory-edit";
    }



    @RequestMapping("dormitory-management" + Constants.URL_SUFFIX)
    public String toDormitoryList(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final String dormitoryName, final String cityName, final String sortField,
            final String sortType, final String currentPage, final String pageSize) {
        DormitorySearchBean searchBean = new DormitorySearchBean();
        searchBean.setCollegeId(null);

        if (StringUtils.isNotBlank(dormitoryName)) {
            searchBean.setDormitoryName(dormitoryName);
        }
        if (StringUtils.isNoneBlank(cityName)) {
            searchBean.setCityName(cityName);
        }
        if (StringUtils.isNoneBlank(sortField)) {
            searchBean.setSortField(sortField);
            if (StringUtils.isNoneBlank(sortType)) {
                searchBean.setSortType(sortType);
            }
        }
        int rowTotal = dormitoryService.queryDormitoryCount(searchBean);

        PageBean page = new PageBean(rowTotal);
        if (StringUtils.isNotBlank(currentPage)) {
            page.setPageNum(Integer.valueOf(currentPage));
        }
        if (StringUtils.isNotBlank(pageSize)) {
            page.setPageSize(Integer.valueOf(pageSize));
        }
        page.setQueryString(request.getQueryString());
        searchBean.setPageBean(page);
        List<DormitoryBean> dormitories = dormitoryService.queryDormitoryPage(searchBean);

        model.addAttribute("sortField", sortField);
        model.addAttribute("dormitories", dormitories);
        model.addAttribute("page", page);
        model.addAttribute("cityName", searchBean.getCityName());
        model.addAttribute("dormitoryName", searchBean.getDormitoryName());

        return "admin/dormitory/dormitory-management";
    }



    @RequestMapping(value = "dormitory-image-upload" + Constants.URL_SUFFIX, method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> uploadDormitoryImage(final MultipartHttpServletRequest request,
            final HttpServletResponse response, final Integer dormitoryId) {
        List<Map<String, Object>> fileMetaList = new ArrayList<Map<String, Object>>();
        FileUtils fileUtils = FileUtils.getInstance();
        String curDormitoryUploadFolderPath = fileUtils.createUploadDormitoryImageFolder(dormitoryId);
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
                FileCopyUtils.copy(multipartFile.getBytes(), new FileOutputStream(curDormitoryUploadFolderPath
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
