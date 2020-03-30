package com.tw.api.exception;

import java.util.HashMap;
import java.util.Map;

public class BaseException extends RuntimeException {
    protected ErrorCode code;

    public BaseException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }

    public Map<String, ?> getMapForResponse() {
        Map<String, Object> retVal = new HashMap<>();

        retVal.put("status", "error");
        retVal.put("code", code.getValue());
        retVal.put("message", getMessage());

        return retVal;
    }
}