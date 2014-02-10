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
package com.noeasy.money.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.noeasy.money.service.INavigationService;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Feb 10, 2014
 */
@Controller
@RequestMapping("/navigation")
public class NavigationController {

    @Resource(name = "navigationService")
    INavigationService navigationService;



    @RequestMapping("/getCity")
    @ResponseBody
    public String getCity(final HttpServletRequest request, final HttpServletResponse response, final String cityId,
            final String countryId) {
        if (StringUtils.isBlank(cityId)) {
            List<Map<String, String>> cities = navigationService.queryCities(NumberUtils.toInt(countryId));
            JSONArray cityJson = JSONArray.fromObject(cities);
            return cityJson.toString();
        } else {
            Map<String, String> city = navigationService.queryCityById(NumberUtils.toInt(cityId),
                    NumberUtils.toInt(countryId));
            JSONObject cityJson = JSONObject.fromObject(city);
            return cityJson.toString();
        }
    }



    @RequestMapping("/getCollege")
    @ResponseBody
    public String getCollege(final HttpServletRequest request, final HttpServletResponse response,
            final String collegeId, final String cityId) {
        if (StringUtils.isBlank(collegeId)) {
            List<Map<String, String>> colleges = navigationService.queryColleges(NumberUtils.toInt(cityId));
            JSONArray collegeJson = JSONArray.fromObject(colleges);
            return collegeJson.toString();
        } else {
            Map<String, String> college = navigationService.queryCollegeById(NumberUtils.toInt(collegeId),
                    NumberUtils.toInt(cityId));
            JSONObject collegeJson = JSONObject.fromObject(college);
            return collegeJson.toString();
        }
    }



    @RequestMapping("/getCountry")
    @ResponseBody
    public String getCountry(final HttpServletRequest request, final HttpServletResponse response) {
        List<Map<String, String>> countries = navigationService.queryCountries();
        JSONArray countryJson = JSONArray.fromObject(countries);
        return countryJson.toString();
    }
}
