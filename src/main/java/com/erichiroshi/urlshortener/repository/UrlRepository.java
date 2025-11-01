package com.erichiroshi.urlshortener.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.erichiroshi.urlshortener.entity.UrlEntity;

public interface UrlRepository extends MongoRepository<UrlEntity, String> {

}
