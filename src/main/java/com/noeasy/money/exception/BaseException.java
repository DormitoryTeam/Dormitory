package com.noeasy.money.exception;

public class BaseException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -3939336364622285323L;

    private ErrorMetadata     errorMetadata;



    public ErrorMetadata getErrorMetadata() {
        return errorMetadata;
    }



    public BaseException() {
        super();
        this.errorMetadata = BaseErrorMetadata.DEFAULT_METADATA;
    }



    public BaseException(final String pMessage, final Throwable pCause) {
        super(pMessage, pCause);
        this.errorMetadata = BaseErrorMetadata.DEFAULT_METADATA;
    }



    public BaseException(final String pMessage) {
        super(pMessage);
        this.errorMetadata = BaseErrorMetadata.DEFAULT_METADATA;
    }



    public BaseException(final Throwable pCause) {
        super(pCause);
        this.errorMetadata = BaseErrorMetadata.DEFAULT_METADATA;
    }



    public BaseException(ErrorMetadata pMetadata) {
        super();
        this.errorMetadata = pMetadata;
    }



    public BaseException(final String pMessage, final Throwable pCause, ErrorMetadata pMetadata) {
        super(pMessage, pCause);
        this.errorMetadata = pMetadata;
    }



    public BaseException(final String pMessage, ErrorMetadata pMetadata) {
        super(pMessage);
        this.errorMetadata = pMetadata;
    }



    public BaseException(final Throwable pCause, ErrorMetadata pMetadata) {
        super(pCause);
        this.errorMetadata = pMetadata;
    }



    @Override
    public String getMessage() {
        return super.getMessage() + "\nErrorcode: " + this.errorMetadata.getErrorCode() + ". ErrorMessage: "
                + this.errorMetadata.getErrorMessage();
    }
}
