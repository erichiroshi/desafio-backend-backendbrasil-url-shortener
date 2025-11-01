package com.erichiroshi.urlshortener.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Document(collection = "urls")
public class UrlEntity {

    @Id
    private String id;

    private String fullUrl;

    @Indexed(expireAfter = "0s")
    private LocalDateTime expiresAt;

}