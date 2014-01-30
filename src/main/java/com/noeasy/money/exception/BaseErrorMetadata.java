package com.noeasy.money.exception;

public class BaseErrorMetadata implements ErrorMetadata {

    private int errorCode;
    private String errorMessage;
    
    private static final int DEAFULT_CODE = 0;
    private static final String DEFAULT_MESSAGE = "Default Message";
    
    public static final BaseErrorMetadata DEFAULT_METADATA = new BaseErrorMetadata(DEAFULT_CODE, DEFAULT_MESSAGE);
    
    protected BaseErrorMetadata(int pErrorCode, String pErrorMesage) {
        super();
        errorCode = pErrorCode;
        errorMessage = pErrorMesage;
    }
    
    public void setErrorCode(int pErrorCode) {
        errorCode = pErrorCode;
    }

    public void setErrorMessage(String pErrorMessage) {
        errorMessage = pErrorMessage;
    }

    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Override
    public boolean equals(Object pObject) {
        if (!(pObject instanceof BaseErrorMetadata)) {
            return false;
        }
        return this.getErrorCode() == ((BaseErrorMetadata)pObject).getErrorCode();
    }
}
