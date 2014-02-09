package com.noeasy.money.enumeration;

public enum PaymentStatus {
    SEND_REQUEST, REQUEST_HANDLED, PENDING, FINISH, CANCELED,  ERRROR;
    public String getName() {
        return this.name();
    }



    public int getValue() {
        return this.ordinal();
    }
}
