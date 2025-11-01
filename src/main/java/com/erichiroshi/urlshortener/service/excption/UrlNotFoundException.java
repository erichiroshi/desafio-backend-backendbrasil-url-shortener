package com.erichiroshi.urlshortener.service.excption;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class UrlNotFoundException extends RuntimeException {

    private final String detail;

    public UrlNotFoundException(String detail) {
        this.detail = detail;
    }

    public ProblemDetail toProblemDetail() {
        ProblemDetail pb = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, detail);
        pb.setTitle("URL Not Found");
        pb.setProperty("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        return pb;
    }

}