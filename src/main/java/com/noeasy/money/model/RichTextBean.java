package com.noeasy.money.model;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Apr 7, 2014
 */

public class RichTextBean extends BaseBean {

    public static final String SPLIT_SYMBOL   = ",";

    public static final String NEWS           = "1";

    public static final String GO_TRAVEL      = "2";

    public static final String NEWS_NAME      = "News";

    public static final String GO_TRAVEL_NAME = "Go Travle";

    private int                mId;

    private int                mUserId;

    private String             mTitle;

    private String             mTextBody;

    private byte[]             mTextBodyByte;

    private String             mCoverPath;

    private String             mStatus;

    private String             mType;



    /**
     * @return the coverPath
     */
    public String getCoverPath() {
        return mCoverPath;
    }



    /**
     * @return the id
     */
    public int getId() {
        return mId;
    }



    /**
     * @return the status
     */
    public String getStatus() {
        return mStatus;
    }



    /**
     * @return the textBody
     */
    public String getTextBody() {
        if (StringUtils.isEmpty(mTextBody)) {
            if (ArrayUtils.isEmpty(getTextBodyByte())) {
                mTextBody = "";
            } else {
                try {
                    mTextBody = new String(getTextBodyByte(), "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return "暂时无法获取内容，请稍后再试";
                }
            }
        }
        return mTextBody;
    }



    /**
     * @return the textBodyByte
     */
    public byte[] getTextBodyByte() {
        return mTextBodyByte;
    }



    /**
     * @return the title
     */
    public String getTitle() {
        return mTitle;
    }



    /**
     * @return the type
     */
    public String getType() {
        return mType;
    }



    /**
     * @return the userId
     */
    public int getUserId() {
        return mUserId;
    }



    /**
     * @param pCoverPath
     *            the coverPath to set
     */
    public void setCoverPath(final String pCoverPath) {
        mCoverPath = pCoverPath;
    }



    /**
     * @param pId
     *            the id to set
     */
    public void setId(final int pId) {
        mId = pId;
    }



    /**
     * @param pStatus
     *            the status to set
     */
    public void setStatus(final String pStatus) {
        mStatus = pStatus;
    }



    /**
     * @param pTextBody
     *            the textBody to set
     */
    public void setTextBody(final String pTextBody) {
        mTextBody = pTextBody;
    }



    /**
     * @param pTextBodyByte
     *            the textBodyByte to set
     */
    public void setTextBodyByte(final byte[] pTextBodyByte) {
        mTextBodyByte = pTextBodyByte;
    }



    /**
     * @param pTitle
     *            the title to set
     */
    public void setTitle(final String pTitle) {
        mTitle = pTitle;
    }



    /**
     * @param pType
     *            the type to set
     */
    public void setType(final String pType) {
        mType = pType;
    }



    /**
     * @param pUserId
     *            the userId to set
     */
    public void setUserId(final int pUserId) {
        mUserId = pUserId;
    }

}
