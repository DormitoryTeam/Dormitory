package com.noeasy.money.exception;

public class PaymentErrorMetadata extends BaseErrorMetadata {

    public static final PaymentErrorMetadata EMPTY_PROPERTY     = new PaymentErrorMetadata(201, "Empty Property");



    protected PaymentErrorMetadata(int pErrorCode, String pErrorMesage) {
        super(pErrorCode, pErrorMesage);
    }

}
