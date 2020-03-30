package com.tw.api.exception;

public class NotFoundBaseException extends AppRuntimeBaseException {

    static final long serialVersionUID = 10002L;

    public NotFoundBaseException(String message, ErrorCode code) {
        super(message, code);
    }
}
