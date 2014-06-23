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
import com.noeasy.money.enumeration.DormitoryStatus;
import com.noeasy.money.model.DormitoryBean;
import com.noeasy.money.model.DormitoryRateBean;
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
            final Model model, final DormitoryBean dormitory, final AdminDormitoryParamVector paramVector) {

        if (ArrayUtils.isNotEmpty(paramVector.getImageNames())) {
            dormitory.setPicPath(Arrays.asList(paramVector.getImageNames()));
            for (String image : paramVector.getImageNames()) {
                if (image.equals(paramVector.getCoverImageName())) {
                    dormitory.setCoverImageName(image);
                    break;
                }
            }
        }

        boolean result = dormitoryService.saveOrUpdateDormitory(dormitory);
        if (result) {
            dormitoryService.calculateDistance4Dormitory(dormitory.getId());
        }
        model.addAttribute("result", result);
        try {
            FileUtils fileUtils = FileUtils.getInstance();
            fileUtils.removeInvalidFiles(fileUtils.createUploadDormitoryImageFolder(dormitory.getId()),
                    dormitory.getPicPath());
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Map<String, Object>> countries = navigationService.queryCountries();
        Map<String, Object> currentCountry = navigationService.queryCountryByCityId(dormitory.getCityId());
        List<Map<String, Object>> cities = navigationService.queryCitiesInSameCountry(dormitory.getCityId());

        model.addAttribute("dormitory", dormitory);
        model.addAttribute("countries", countries);
        model.addAttribute("currentCountry", currentCountry);
        model.addAttribute("cities", cities);
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



    @RequestMapping("/dormitory-rate-save" + Constants.URL_SUFFIX)
    public String saveDormitoryRate(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final int id, final Integer dormitoryId, final String alias, final String comment,
            final Integer point, final Integer userId, final String status) {
        if (dormitoryId > 0) {
            dormitoryService.rateDormitory(id, dormitoryId, userId, point, comment, alias, status);
        }
        return "redirect:/admin/dormitory/dormitory-rate-edit.html?dormitoryId=" + dormitoryId;
    }



    @RequestMapping("room-save" + Constants.URL_SUFFIX)
    public String saveRoomInfo(final HttpServletRequest request, final HttpServletResponse response, final Model model,
            final String dormitoryId, final RoomInfoBean room) {
        boolean result = dormitoryService.saveOrUpdateRoombInfo(room);
        dormitoryService.updateDormitoryPrice(dormitoryId);
        model.addAttribute("result", result);
        model.addAttribute("roomId", room.getId());
        model.addAttribute("dormitoryId", dormitoryId);
        return "forward:room-edit.html?roomId=" + room.getId();
    }



    @RequestMapping("dormitory-add" + Constants.URL_SUFFIX)
    public String toDormitoryAdd(final HttpServletRequest request, final HttpServletResponse response, final Model model) {
        List<Map<String, Object>> countries = navigationService.queryCountries();
        if (CollectionUtils.isNotEmpty(countries)) {
            Integer firstCountryId = (Integer) countries.get(0).get("id");
            List<Map<String, Object>> cities = navigationService.queryCities(firstCountryId);
            List<Map<String, Object>> contractTypes = dormitoryService.queryContractTypes();
            List<Map<String, Object>> dormitoryTypes = dormitoryService.queryRoomTypes();

            model.addAttribute("countries", countries);
            model.addAttribute("cities", cities);
            model.addAttribute("contractTypes", contractTypes);
            model.addAttribute("dormitoryTypes", dormitoryTypes);
        }
        return "admin/dormitory/dormitory-edit";
    }



    @RequestMapping("dormitory-edit" + Constants.URL_SUFFIX)
    public String toDormitoryEdit(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final Integer dormitoryId) {
        if (dormitoryId != null) {
            DormitorySearchBean searchBean = new DormitorySearchBean();
            searchBean.setId(dormitoryId);
            searchBean.setPageBean(null);
            DormitoryBean dormitory = dormitoryService.queryDormitory(searchBean);

            List<Map<String, Object>> countries = navigationService.queryCountries();
            Map<String, Object> currentCountry = navigationService.queryCountryByCityId(dormitory.getCityId());
            List<Map<String, Object>> cities = navigationService.queryCitiesInSameCountry(dormitory.getCityId());

            model.addAttribute("dormitory", dormitory);
            model.addAttribute("countries", countries);
            model.addAttribute("currentCountry", currentCountry);
            model.addAttribute("cities", cities);
            model.addAttribute("emptyRoom", new RoomInfoBean());
            model.addAttribute("emptyPrice", new RoomPrice());
            model.addAttribute("emptyDormitory", new DormitoryBean());
        }
        return "admin/dormitory/dormitory-edit";
    }



    @RequestMapping("dormitory-management" + Constants.URL_SUFFIX)
    public String toDormitoryList(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final String dormitoryName, final String cityName, final String sortField,
            final String sortType, final String currentPage, final String pageSize, final String cityId,
            final String status) {
        Integer countryId = 1;
        List<Map<String, Object>> cities = navigationService.queryCities(countryId);
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
        if (StringUtils.isNotBlank(cityId)) {
            Integer cityIdVal = Integer.valueOf(cityId);
            if (cityIdVal > 0) {
                searchBean.setCityId(cityIdVal);
            }
        }
        searchBean.setSortType("DESC");
        if (DormitoryStatus.INVISIBILITY.toString().equals(status)) {
            searchBean.setStatus(DormitoryStatus.INVISIBILITY);
        } else {
            searchBean.setExcludeStatus(DormitoryStatus.INVISIBILITY);
        }
        int rowTotal = dormitoryService.queryDormitoryCount(searchBean);

        PageBean page = new PageBean(rowTotal);
        if (StringUtils.isNotBlank(pageSize)) {
            page.setPageSize(Integer.valueOf(pageSize));
        }
        if (StringUtils.isNotBlank(currentPage)) {
            page.setPageNum(Integer.valueOf(currentPage));
        }

        page.setQueryString(request.getQueryString());
        searchBean.setPageBean(page);
        List<DormitoryBean> dormitories = dormitoryService.queryDormitoryPage(searchBean);

        model.addAttribute("sortField", sortField);
        model.addAttribute("dormitories", dormitories);
        model.addAttribute("page", page);
        model.addAttribute("cityName", searchBean.getCityName());
        model.addAttribute("dormitoryName", searchBean.getDormitoryName());
        model.addAttribute("cities", cities);
        if (StringUtils.isNotBlank(cityId)) {
            model.addAttribute("cityId", Integer.valueOf(cityId));
        }
        return "admin/dormitory/dormitory-management";
    }



    @RequestMapping("dormitory-rate-edit" + Constants.URL_SUFFIX)
    public String toDormitoryRateEdit(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final int dormitoryId) {
        List<DormitoryRateBean> rates = dormitoryService.queryDormitoryRates(dormitoryId, false);
        DormitorySearchBean searchBean = new DormitorySearchBean();
        searchBean.setId(dormitoryId);
        DormitoryBean dormitory = dormitoryService.queryDormitory(searchBean);
        model.addAttribute("dormitory", dormitory);
        model.addAttribute("rates", rates);
        return "admin/dormitory/dormitory-rate-edit";
    }



    @RequestMapping("dormitory-rates" + Constants.URL_SUFFIX)
    public String toDormitoryRateList(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final String dormitoryName, final String cityName, final String sortField,
            final String sortType, final String currentPage, final String pageSize, final String cityId,
            final String status, final String ratingStatus) {
        Integer countryId = 1;
        List<Map<String, Object>> cities = navigationService.queryCities(countryId);
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
        if (StringUtils.isNotBlank(cityId)) {
            Integer cityIdVal = Integer.valueOf(cityId);
            if (cityIdVal > 0) {
                searchBean.setCityId(cityIdVal);
            }
        }
        if (StringUtils.isNoneBlank(ratingStatus)) {
            searchBean.setRatingStatus(ratingStatus);
        }
        searchBean.setSortType("DESC");
        if (DormitoryStatus.INVISIBILITY.toString().equals(status)) {
            searchBean.setStatus(DormitoryStatus.INVISIBILITY);
        } else {
            searchBean.setExcludeStatus(DormitoryStatus.INVISIBILITY);
        }
        int rowTotal = dormitoryService.queryDormitoryRateCount(searchBean);

        PageBean page = new PageBean(rowTotal);
        if (StringUtils.isNotBlank(pageSize)) {
            page.setPageSize(Integer.valueOf(pageSize));
        }
        if (StringUtils.isNotBlank(currentPage)) {
            page.setPageNum(Integer.valueOf(currentPage));
        }

        page.setQueryString(request.getQueryString());
        searchBean.setPageBean(page);
        List<DormitoryBean> dormitories = dormitoryService.queryDormitoryRates(searchBean);

        model.addAttribute("sortField", sortField);
        model.addAttribute("dormitories", dormitories);
        model.addAttribute("page", page);
        model.addAttribute("cityName", searchBean.getCityName());
        model.addAttribute("dormitoryName", searchBean.getDormitoryName());
        model.addAttribute("cities", cities);
        if (StringUtils.isNotBlank(cityId)) {
            model.addAttribute("cityId", Integer.valueOf(cityId));
        }
        return "admin/dormitory/dormitory-rates";
    }



    @RequestMapping("room-edit" + Constants.URL_SUFFIX)
    public String toRoomInfoEdit(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final String dormitoryId, final String roomId) {
        RoomInfoBean room = null;
        if (StringUtils.isNoneBlank(roomId)) {
            room = dormitoryService.queryRoomInfoById(Integer.parseInt(roomId), Integer.parseInt(dormitoryId));
        }

        if (room == null) {
            room = new RoomInfoBean();
        }
        model.addAttribute("room", room);
        model.addAttribute("roomId", roomId);
        model.addAttribute("dormitoryId", dormitoryId);
        return "admin/dormitory/dormitory-room-edit";
    }



    @RequestMapping("update-dormitory-status" + Constants.URL_SUFFIX)
    public String updateDormitoryStatus(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final String id, final DormitoryStatus status, final String queryString) {
        dormitoryService.updateDormitoryStatus(id, status);
        return "redirect:/admin/dormitory/dormitory-management.html?" + queryString;
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
