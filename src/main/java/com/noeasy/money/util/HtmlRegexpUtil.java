package com.noeasy.money.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlRegexpUtil {

    private final static String regxpForHtml = "<([^>]*)>";



    /**
     * 
     * Filter tag.
     * 
     * @param str
     * @return
     */
    public static String filterHtml(final String str) {
        Pattern pattern = Pattern.compile(regxpForHtml);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        boolean result1 = matcher.find();
        while (result1) {
            matcher.appendReplacement(sb, "");
            result1 = matcher.find();
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

}
