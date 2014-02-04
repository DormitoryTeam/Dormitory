package com.noeasy.money.enumeration;

public enum OrderType {

    DORMIOTRY, PICKUP;

    public String getName() {
        return this.name();
    }



    public int getValue() {
        return this.ordinal();
    }
}
