package com.tw.api.repository;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

public class ApiMongoRepository<T, Id> extends SimpleMongoRepository<T, Id> implements ApiRepository<T, Id> {

    public ApiMongoRepository(MongoEntityInformation<T, Id> metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
    }
}

