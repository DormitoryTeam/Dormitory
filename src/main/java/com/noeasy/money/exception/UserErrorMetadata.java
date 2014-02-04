package com.noeasy.money.exception;

public class UserErrorMetadata extends BaseErrorMetadata {

    public static final UserErrorMetadata USER_EXIST     = new UserErrorMetadata(101, "User exit");
    public static final UserErrorMetadata NULL_USER_BEAN = new UserErrorMetadata(102, "Userbean is null");



    protected UserErrorMetadata(int pErrorCode, String pErrorMesage) {
        super(pErrorCode, pErrorMesage);
    }

}
