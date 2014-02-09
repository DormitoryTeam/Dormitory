package com.noeasy.money.service;

import java.util.Map;

public interface IAlipayService {

    public static final int ASYNC_NOFIFY = 1;
    public static final int SYNC_NOFITY  = 0;



    String gengerateRedirectURL(Integer pOrderId);



    /**
     * 
     * 1. Analyze inbound parameters. 2. update payment information. 3. update
     * order information.
     * 
     * @param nvp
     * @return
     */
    boolean handleInboundParameters(Map<String, String> nvp, int type);
}
