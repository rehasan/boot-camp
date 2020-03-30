package com.tw.api.exception;


public enum ErrorCode {

    OBJECT_NOT_FOUND(1),
    OBJECT_IS_INVALID(2);

    private final int code;

    private ErrorCode(int code) {
        this.code = code;
    }

    public int getValue() {
        return code;
    }
}