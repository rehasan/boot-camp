package com.tw.api.exception;

import java.util.Map;

public interface BaseException {
    Map<String, ?> getMapForResponse();
}
