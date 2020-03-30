package com.tw.api.exception;

public class NotFoundException extends BaseException {
    public NotFoundException(String message, ErrorCode code) {
        super(message, code);
    }
}
