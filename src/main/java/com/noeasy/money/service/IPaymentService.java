package com.noeasy.money.service;

import java.util.Map;

public interface IPaymentService {

    public static final int ASYNC_NOFIFY = 1;
    public static final int SYNC_NOFITY   = 0;



    /**
     * 1. Use pOrderId to get order information 2. 2. Create a new payment and
     * paymentInfo object and persistent
     * 
     * @param pOrderId
     * @return
     */
    Map<String, String> generateOutboundParameters(String pOrderId);



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
