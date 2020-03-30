package com.tw.api.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.api.exception.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(AppRuntimeBaseException.class)
    @ResponseBody
    public void runtimeException(AppRuntimeBaseException e, HttpServletResponse response) throws IOException {
        writeResponse(response, HttpServletResponse.SC_NOT_FOUND, e);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public void noHandlerFoundException(NoHandlerFoundException e, HttpServletResponse response) throws IOException {
        writeResponse(response, HttpServletResponse.SC_NOT_FOUND,
                new AppBaseException(e.getMessage(), ErrorCode.NO_HANDLER_FOUND));
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public void exceptions(Exception e, HttpServletResponse response) throws IOException {
        writeResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                new AppBaseException(e.getMessage(), ErrorCode.SERVER_EXCEPTION));
    }

    private void writeResponse(HttpServletResponse response, int code, BaseException e) throws IOException {
        response.setStatus(code);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(new ObjectMapper().writeValueAsString(e.getMapForResponse()));
        response.getWriter().flush();
    }
}