package com.tw.api.exception;

import java.util.HashMap;
import java.util.Map;

public class ExceptionResponse {

    private final int code;
    private final String message;

    public ExceptionResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Map<String, ?> getMapForResponse() {
        Map<String, Object> retVal = new HashMap<>();

        retVal.put("status", "error");
        retVal.put("code", code);
        retVal.put("message", message);

        return retVal;
    }
}