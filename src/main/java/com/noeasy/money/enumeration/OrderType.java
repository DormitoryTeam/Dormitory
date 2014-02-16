package com.noeasy.money.enumeration;

public enum OrderType {

    DORMITORY, PICKUP;

    private static final String TYPE_DORMITORY = "D";



    public String getName() {
        return this.name();
    }



    public int getValue() {
        return this.ordinal();
    }



    public static OrderType getType(String orderType) {
        if (TYPE_DORMITORY.equalsIgnoreCase(orderType)) {
            return DORMITORY;
        }
        return PICKUP;
    }
}
