package com.noeasy.money.enumeration;

public enum PaymentInfoType {

    REQUEST, SYNC_RESPONSE, ASYNC_RESPONSE;

    public String getName() {
        return this.name();
    }



    public int getValue() {
        return this.ordinal();
    }
}
