package com.noeasy.money.admin.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.math.NumberUtils;

import com.noeasy.money.model.RoomInfoBean;
import com.noeasy.money.model.RoomPrice;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Mar 31, 2014
 */

public class AdminDormitoryUtil {

    private static String ROOM_INFO_PARAM_PREFIX  = "p_room_";

    private static String ROOM_PRICE_PARAM_PREFIX = "p_price_";

    private static String SEPARATOR               = "_";



    public List<RoomInfoBean> assembleRoomInfoBeansFromParameterMap(final Map pParameterMap) {
        Map<String, RoomInfoBean> roomInfoMap = new HashMap<String, RoomInfoBean>();
        RoomInfoBean roomInfo = null;
        RoomPrice roomPrice = null;
        String id = null;

        Map<String, String> paramMap = pParameterMap;
        for (Entry<String, String> entry : paramMap.entrySet()) {
            if (entry.getKey().startsWith(ROOM_INFO_PARAM_PREFIX)) {
                String key = entry.getKey().substring(ROOM_INFO_PARAM_PREFIX.length());
                String[] inputParamNameWithId = key.split(SEPARATOR);
                id = inputParamNameWithId[0];
                if (roomInfoMap.containsKey(id)) {
                    roomInfo = roomInfoMap.get(id);
                } else {
                    roomInfo = new RoomInfoBean();
                    roomInfo.setId(NumberUtils.toInt(id));
                    roomInfoMap.put(id, roomInfo);
                }
            }
        }

        return null;
    }
}
