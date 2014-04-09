package com.noeasy.money.model;

/**
 * <class description>
 * 
 * @author: Yove
 * @version: 1.0, Apr 7, 2014
 */

public class RichTextBean extends BaseBean {

    public static final String SPLIT_SYMBOL = ",";

    private int                mId;

    private int                mUserId;

    private String             mTitle;

    private String             mTextBody;

    private String             mStatus;

    private String             mType;



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
        return mTextBody;
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
