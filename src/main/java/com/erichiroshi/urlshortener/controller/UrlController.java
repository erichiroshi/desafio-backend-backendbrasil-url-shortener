package com.erichiroshi.urlshortener.controller;

import java.time.LocalDateTime;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erichiroshi.urlshortener.controller.dto.ShortenUrlRequest;
import com.erichiroshi.urlshortener.controller.dto.ShortenUrlResponse;
import com.erichiroshi.urlshortener.entity.UrlEntity;
import com.erichiroshi.urlshortener.repository.UrlRepository;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UrlController {

    private final UrlRepository urlRepository;

    public UrlController(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @PostMapping("/shorten-url")
    public ResponseEntity<ShortenUrlResponse> shortenUrl(@RequestBody ShortenUrlRequest request,
            HttpServletRequest servletRequest) {
        String id;
        do {
            id = RandomStringUtils.insecure().nextAlphanumeric(5, 10);
        } while (urlRepository.existsById(id));

        urlRepository.save(new UrlEntity(id, request.url(), LocalDateTime.now().plusMinutes(1)));

        String redirectUrl = servletRequest.getRequestURL().toString().replace("shorten-url", id);

        return ResponseEntity.ok(new ShortenUrlResponse(redirectUrl));
    }

}
