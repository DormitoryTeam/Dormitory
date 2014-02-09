package com.noeasy.money.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.noeasy.money.exception.BaseException;

public class DateUtils {

    public static final String DEFAULT_DATE_FORMAT_RULE = "yyyy-MM-dd";

    public static final String DATE_TIME_FORAMT_RULE    = "yyyy-MM-dd HH:mm:ss";



    public static Date stringToDate(final String dateStr) {
        return stringToDate(dateStr, DEFAULT_DATE_FORMAT_RULE);
    }



    public static Date stringToDate(final String dateStr, final String formatRule) {
        if (StringUtils.isBlank(dateStr)) {
            throw new IllegalArgumentException("dateStr is blank.");
        }
        if (StringUtils.isBlank(formatRule)) {
            throw new IllegalArgumentException("formatRule is blank.");
        }
        Date date = null;
        try {
            DateFormat format = new SimpleDateFormat(formatRule);
            date = format.parse(dateStr);
            return date;
        } catch (ParseException e) {
            throw new BaseException("Parse Date from search bean error.", e);
        }
    }



    public static String dateToString(final Date date, final String formatRule) {
        if (StringUtils.isBlank(formatRule)) {
            throw new IllegalArgumentException("formatRule is blank.");
        }
        if (null == date) {
            throw new IllegalArgumentException("date is null.");
        }
        String result = null;
        DateFormat formatter = new SimpleDateFormat(formatRule);
        result = formatter.format(date);
        return result;
    }



    public static String dateToString(final Date date) {
        return dateToString(date, DEFAULT_DATE_FORMAT_RULE);
    }

}
