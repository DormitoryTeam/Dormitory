package com.noeasy.money.admin.tag;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.noeasy.money.admin.util.OrderTokenUtil;

/**
 * 
 * @author: Yove
 * @version: 1.0, May 29, 2014
 */

public class OrderTokenTag extends SimpleTagSupport {

    private String orderId;

    private String prefix;



    /**
     * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
     */
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        Writer out = getJspContext().getOut();
        out.write(OrderTokenUtil.getOrderToken(orderId, prefix));
    }



    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }



    /**
     * @return the prefix
     */
    public String getPrefix() {
        return prefix;
    }



    /**
     * @param pOrderId
     *            the orderId to set
     */
    public void setOrderId(final String pOrderId) {
        orderId = pOrderId;
    }



    /**
     * @param pPrefix
     *            the prefix to set
     */
    public void setPrefix(final String pPrefix) {
        prefix = pPrefix;
    }
}
