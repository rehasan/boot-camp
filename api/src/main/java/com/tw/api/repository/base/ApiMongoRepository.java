package com.tw.api.repository.base;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

public class ApiMongoRepository<T, Id> extends SimpleMongoRepository<T, Id> implements CrudRepository<T, Id> {
    public ApiMongoRepository(MongoEntityInformation<T, Id> metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
    }
}

