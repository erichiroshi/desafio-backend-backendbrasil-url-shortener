package com.erichiroshi.urlshortener.controller.exception;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.erichiroshi.urlshortener.service.excption.UrlNotFoundException;

@ControllerAdvice
public class RestHandlerAdvice {

    @ExceptionHandler(UrlNotFoundException.class)
    public ProblemDetail handlePicPayException(UrlNotFoundException e) {
        return e.toProblemDetail();
    }
}
