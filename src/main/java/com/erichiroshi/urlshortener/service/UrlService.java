package com.erichiroshi.urlshortener.service;

import java.net.URI;
import java.time.LocalDateTime;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.erichiroshi.urlshortener.controller.dto.ShortenUrlRequest;
import com.erichiroshi.urlshortener.entity.UrlEntity;
import com.erichiroshi.urlshortener.repository.UrlRepository;
import com.erichiroshi.urlshortener.service.excption.UrlNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String shortenUrl(ShortenUrlRequest request, HttpServletRequest servletRequest) {
        String id;

        do {
            id = RandomStringUtils.insecure().nextAlphanumeric(5, 10);
        } while (urlRepository.existsById(id));

        urlRepository.save(new UrlEntity(id, request.url(), LocalDateTime.now().plusMinutes(1)));

        return servletRequest.getRequestURL().toString().replace("shorten-url", id);
    }

    public HttpHeaders redirect(String id) {

        UrlEntity url = urlRepository.findById(id).orElseThrow(() -> new UrlNotFoundException("URL not found: " + id));

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url.getFullUrl()));
        return headers;
    }
}