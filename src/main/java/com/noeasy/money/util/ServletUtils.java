package com.noeasy.money.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.noeasy.money.constant.SessionConstants;
import com.noeasy.money.model.OrderBean;
import com.noeasy.money.model.UserBean;
import com.noeasy.money.model.UserInfoBean;
import com.noeasy.money.model.UserPreferBean;
import com.noeasy.money.service.impl.OrderService;

public class ServletUtils {
    public static boolean isGet(HttpServletRequest pRequest) {
        return "GET".equalsIgnoreCase(pRequest.getMethod());
    }



    public static boolean isPost(HttpServletRequest pRequest) {
        return "POST".equalsIgnoreCase(pRequest.getMethod());
    }



    public static boolean isLogin(HttpServletRequest pRequest) {
        Integer userId = (Integer) pRequest.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        String login = (String) pRequest.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_LOGIN);
        if (null != userId && null != login) {
            return true;
        }
        return false;

    }



    public static String getLoign(HttpServletRequest pRequest) {
        String login = (String) pRequest.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_LOGIN);
        return login;
    }



    public static Integer getUserId(HttpServletRequest pRequest) {
        Integer userId = (Integer) pRequest.getSession().getAttribute(SessionConstants.SESSION_KEY_USER_ID);
        return userId;
    }



    public static OrderBean getOrderFromSession(HttpServletRequest pRequest) {
        return (OrderBean) pRequest.getSession().getAttribute(SessionConstants.SESSION_KEY_ORDER);
    }



    public static void setOrder2Session(HttpServletRequest pRequest, OrderBean order) {
        pRequest.getSession().setAttribute(SessionConstants.SESSION_KEY_ORDER, order);
    }



    public static void setUser2Session(HttpServletRequest request, UserBean user) {
        request.getSession().setAttribute(SessionConstants.SESSION_KEY_USER_ID, user.getId());
        request.getSession().setAttribute(SessionConstants.SESSION_KEY_USER_LOGIN, user.getLogin());

    }



    public static UserInfoBean getUserInfoFromRequest(HttpServletRequest pRequest) {
        UserInfoBean userInfo = new UserInfoBean();
        userInfo.setName(pRequest.getParameter("name"));
        userInfo.setLastName(pRequest.getParameter("lastName"));
        userInfo.setNationality(pRequest.getParameter("nationality"));
        userInfo.setEmail(pRequest.getParameter("email"));
        userInfo.setQq(pRequest.getParameter("qq"));
        userInfo.setWechat(pRequest.getParameter("wechat"));
        userInfo.setPhone(pRequest.getParameter("phone"));
        userInfo.setCountry(pRequest.getParameter("country"));
        userInfo.setProvince(pRequest.getParameter("province"));
        userInfo.setCity(pRequest.getParameter("city"));
        userInfo.setAddress(pRequest.getParameter("address"));
        String birthdayStr = pRequest.getParameter("birthday");
        if (StringUtils.isNotBlank(birthdayStr)) {
            userInfo.setBirthday(DateUtils.stringToDate(birthdayStr));
        }
        String genderStr = pRequest.getParameter("gender");
        if (StringUtils.isNotBlank(genderStr)) {
            userInfo.setGender(Integer.valueOf(genderStr));
        }
        String idStr = pRequest.getParameter("infoId");
        if (StringUtils.isNotBlank(idStr)) {
            userInfo.setId(Integer.valueOf(idStr));
        }
        userInfo.setCounty(pRequest.getParameter("county"));
        userInfo.setPostalcode(pRequest.getParameter("postalcode"));
        userInfo.setRelationship(pRequest.getParameter("relationship"));
        return userInfo;
    }


    public static UserPreferBean getUserPerferFromRequest(HttpServletRequest pRequest) {
    
        return getUserPerferFromRequest(pRequest, null);
    }

    public static UserPreferBean getUserPerferFromRequest(HttpServletRequest pRequest, UserPreferBean userPrefer) {
        if( null == userPrefer) {
            userPrefer = new UserPreferBean();
        }
        
        String preferIdStr = pRequest.getParameter("preferId");
        if (StringUtils.isNotBlank(preferIdStr)) {
            userPrefer.setId(Integer.valueOf(preferIdStr));
        }
        String smokeStr = pRequest.getParameter("smoke");
        if (StringUtils.isNotBlank(smokeStr)) {
            if ("Y".equalsIgnoreCase(smokeStr)) {
                userPrefer.setSmoke(Boolean.TRUE);
            } else {
                userPrefer.setSmoke(Boolean.FALSE);
            }
        }

        String vegetarianismStr = pRequest.getParameter("vegetarianism");
        if (StringUtils.isNotBlank(vegetarianismStr)) {
            if ("Y".equalsIgnoreCase(vegetarianismStr)) {
                userPrefer.setVegetarianism(Boolean.TRUE);
            } else {
                userPrefer.setVegetarianism(Boolean.FALSE);
            }
        }
        String yourGrade = pRequest.getParameter("yourGrade");
        if (StringUtils.isNotBlank(yourGrade)) {
            userPrefer.setYourGrade(yourGrade);
        }
        String roomMemberGrade = pRequest.getParameter("roomMemberGrade");
        if (StringUtils.isNotBlank(roomMemberGrade)) {
            userPrefer.setRoomMemberGrade(roomMemberGrade);
        }

        String roomMemberGenderStr = pRequest.getParameter("roomMemberGender");
        if (StringUtils.isNotBlank(roomMemberGenderStr)) {
            userPrefer.setRoomMemberGender(Integer.valueOf(roomMemberGenderStr));
        }

        String major = pRequest.getParameter("major");
        if (StringUtils.isNotBlank(major)) {
            userPrefer.setMajor(major);
        }

        String college = pRequest.getParameter("college");
        if (StringUtils.isNotBlank(college)) {
            userPrefer.setCollege(college);
        }

        String floor = pRequest.getParameter("floor");
        if (StringUtils.isNotBlank(floor)) {
            userPrefer.setFloor(floor);
        }

        String orientationStr = pRequest.getParameter("orientation");
        if (StringUtils.isNotBlank(orientationStr)) {
            userPrefer.setOrientation(Integer.valueOf(orientationStr));
        }

        String graduateSchool = pRequest.getParameter("graduateSchool");
        if (StringUtils.isNotBlank(graduateSchool)) {
            userPrefer.setGraduateSchool(graduateSchool);
        }

        String needPushStr = pRequest.getParameter("needPush");
        if (StringUtils.isNotBlank(needPushStr)) {
            if ("Y".equalsIgnoreCase(needPushStr)) {
                userPrefer.setNeedPush(Boolean.TRUE);
            } else {
                userPrefer.setNeedPush(Boolean.FALSE);
            }
        }

        String readClause = pRequest.getParameter("readClause");
        if (StringUtils.isNotBlank(readClause)) {
            if ("Y".equalsIgnoreCase(readClause)) {
                userPrefer.setReadClause(Boolean.TRUE);
            } else {
                userPrefer.setReadClause(Boolean.FALSE);
            }
        }
        return userPrefer;
    }
}
