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

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.noeasy.money.constant.Constants;
import com.noeasy.money.constant.SessionConstants;
import com.noeasy.money.model.RichTextBean;
import com.noeasy.money.model.UserBean;
import com.noeasy.money.service.INavigationService;
import com.noeasy.money.service.IOrderService;
import com.noeasy.money.service.ISiteService;
import com.noeasy.money.service.IUserService;
import com.noeasy.money.util.HtmlRegexpUtil;
import com.noeasy.money.util.ParamUtils;

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

    @Resource(name = "siteService")
    ISiteService       siteService;

    @Resource(name = "userService")
    IUserService       userService;

    @Resource(name = "orderService")
    IOrderService      orderService;



    @RequestMapping("/getAirport" + Constants.URL_SUFFIX)
    @ResponseBody
    public String getAirport(final HttpServletRequest request, final HttpServletResponse response,
            final String countryId) {
        List<Map<String, Object>> cities = navigationService.queryAirports(NumberUtils.toInt(countryId));
        JSONArray cityJson = JSONArray.fromObject(cities);
        return cityJson.toString();
    }



    @RequestMapping("/getCity" + Constants.URL_SUFFIX)
    @ResponseBody
    public String getCity(final HttpServletRequest request, final HttpServletResponse response, final String cityId,
            final String countryId) {
        if (StringUtils.isBlank(cityId)) {
            List<Map<String, Object>> cities = navigationService.queryCities(NumberUtils.toInt(countryId));
            JSONArray cityJson = JSONArray.fromObject(cities);
            return cityJson.toString();
        } else {
            Map<String, Object> city = navigationService.queryCityById(NumberUtils.toInt(cityId),
                    NumberUtils.toInt(countryId));
            JSONObject cityJson = JSONObject.fromObject(city);
            return cityJson.toString();
        }
    }



    @RequestMapping("/getCollege" + Constants.URL_SUFFIX)
    @ResponseBody
    public String getCollege(final HttpServletRequest request, final HttpServletResponse response,
            final String collegeId, final String cityId) {
        if (StringUtils.isBlank(collegeId)) {
            List<Map<String, Object>> colleges = navigationService.queryColleges(NumberUtils.toInt(cityId));
            JSONArray collegeJson = JSONArray.fromObject(colleges);
            return collegeJson.toString();
        } else {
            Map<String, Object> college = navigationService.queryCollegeById(NumberUtils.toInt(collegeId),
                    NumberUtils.toInt(cityId));
            JSONObject collegeJson = JSONObject.fromObject(college);
            return collegeJson.toString();
        }
    }



    @RequestMapping("/getCountry" + Constants.URL_SUFFIX)
    @ResponseBody
    public String getCountry(final HttpServletRequest request, final HttpServletResponse response) {
        List<Map<String, Object>> countries = navigationService.queryCountries();
        JSONArray countryJson = JSONArray.fromObject(countries);
        return countryJson.toString();
    }



    @RequestMapping("/getFlight" + Constants.URL_SUFFIX)
    @ResponseBody
    public String getFlight(final HttpServletRequest request, final HttpServletResponse response,
            final Integer countryId, final Integer cityId) {
        List<Map<String, Object>> flights = navigationService.queryFlightByConditions(countryId, cityId, null);
        JSONArray countryJson = JSONArray.fromObject(flights);
        return countryJson.toString();
    }



    @RequestMapping("/article-detail" + Constants.URL_SUFFIX)
    public String toArticleDetail(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final int id, final String backURL) {
        model.addAttribute("backURL", backURL);

        RichTextBean article = new RichTextBean();
        if (ParamUtils.isValidIdField(id)) {
            article = siteService.queryArticle(id);
            model.addAttribute("backURL", MessageFormat.format("{0}?type={1}", backURL, article.getType()));
        }
        List<RichTextBean> hotArticles = siteService.queryArticleTitlesWithStatus(null, "2");
        model.addAttribute("article", article);
        model.addAttribute("hotArticles", hotArticles);
        return "navigation/articledetail";
    }



    @RequestMapping("/article-list" + Constants.URL_SUFFIX)
    public String toArticleList(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final String type, final String backURL) {
        model.addAttribute("backURL", backURL);
        List<RichTextBean> articleTitles = siteService.queryArticleTitles(type);
        model.addAttribute("articleTitles", articleTitles);
        List<RichTextBean> hotArticles = siteService.queryArticleTitlesWithStatus(null, "2");
        model.addAttribute("hotArticles", hotArticles);
        return "navigation/articlelist";
    }



    @RequestMapping("/home" + Constants.URL_SUFFIX)
    public String toHome(final HttpServletRequest request, final HttpServletResponse response, final Model model) {
        Object userIdObj = request.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        int userId = 0;
        if (userIdObj != null) {
            userId = NumberUtils.toInt(String.valueOf(userIdObj));
        }
        if (userId > 0) {
            UserBean user = userService.findUserById(userId);
            // boolean hasPickupOrder = orderService.hasOrder(user,
            // OrderType.PICKUP);
            model.addAttribute("user", user);
            // model.addAttribute("hasPickupOrder", hasPickupOrder);
        }

        List<Map<String, Object>> countries = navigationService.queryCountries();
        if (CollectionUtils.isNotEmpty(countries)) {
            Integer firstCountryId = (Integer) countries.get(0).get("id");
            List<Map<String, Object>> cities = navigationService.queryCities(firstCountryId);
            Integer firstCityId = NumberUtils.toInt(cities.get(0).get("id").toString());
            List<Map<String, Object>> colleges = navigationService.queryColleges(firstCityId);

            List<Map<String, Object>> slides = siteService.querySlides();

            List<RichTextBean> news = siteService.queryArticleTitles(RichTextBean.NEWS);
            List<RichTextBean> goTravles = siteService.queryArticleTitles(RichTextBean.GO_TRAVEL);
            for (RichTextBean article : goTravles) {
                article.setTextBody(HtmlRegexpUtil.filterHtml(article.getTextBody()));
            }
            List<Map<String, Object>> airports = navigationService.queryAirports(firstCountryId);

            model.addAttribute("countries", countries);
            model.addAttribute("cities", cities);
            model.addAttribute("colleges", colleges);
            model.addAttribute("slides", slides);
            model.addAttribute("news", news);
            model.addAttribute("goTravles", goTravles);
            model.addAttribute("airports", airports);
        }

        List<Map<String, Object>> allColleges = navigationService.queryColleges();
        List<Map<String, Object>> allCities = navigationService.queryCities();
        model.addAttribute("allCities", allCities);
        model.addAttribute("allColleges", allColleges);

        return "homepage";
    }



    @RequestMapping("/hot-cities" + Constants.URL_SUFFIX)
    public String toHotCities(final HttpServletRequest request, final HttpServletResponse response, final Model model,
            final Integer countryId, final Integer cityId) {
        List<Map<String, Object>> cityColleges = null;
        if (ParamUtils.isValidIdField(countryId)) {
            cityColleges = navigationService.queryCityCollegeByCountryId(countryId);
        } else {
            cityColleges = navigationService.queryCityCollegeByCityId(cityId);
        }
        // cityColleges = sortByCityName(cityColleges);
        model.addAttribute("cityColleges", cityColleges);
        model.addAttribute("countryId", countryId);
        model.addAttribute("cityId", cityId);

        return "navigation/citynavigation";
    }



    // private List<Map<String, Object>> sortByCityName (List<Map<String,
    // Object>> cityColleges) {
    // if (CollectionUtils.isEmpty(cityColleges)) {
    // return cityColleges;
    // }
    // List<CityCollegeWrapper> temp = new ArrayList<CityCollegeWrapper>();
    // for (Map<String, Object> cityCollege: cityColleges) {
    // temp.add(new CityCollegeWrapper(cityCollege));
    // }
    //
    // Collections.sort(temp);
    // List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
    // for (CityCollegeWrapper wrapper: temp) {
    // result.add(wrapper.getCityCollege());
    // }
    //
    // return result;
    // }

    @RequestMapping("/hot-colleges" + Constants.URL_SUFFIX)
    public String toHotColleges(final HttpServletRequest request, final HttpServletResponse response,
            final Model model, final Integer countryId, final Integer cityId) {

        List<Map<String, Object>> allColleges = navigationService.queryColleges();
        model.addAttribute("allColleges", allColleges);

        return "navigation/collegenavigation";
    }

    // class CityCollegeWrapper implements Comparable<CityCollegeWrapper>{
    // private Map<String, Object> mCityCollege;
    // CityCollegeWrapper (Map<String, Object> pCityCollege) {
    // mCityCollege = pCityCollege;
    // }
    // public String getCityName() {
    // return (String)mCityCollege.get("cityName");
    // }
    //
    // @Override
    // public int compareTo(CityCollegeWrapper target) {
    // if (!(target instanceof CityCollegeWrapper)) {
    // return 1;
    // }
    // if (null == this.getCityName() || null == target) {
    // return 1;
    // }
    // return this.getCityName().compareTo(target.getCityName());
    // }
    // public Map<String, Object> getCityCollege() {
    // return mCityCollege;
    // }
    //
    // }
}
