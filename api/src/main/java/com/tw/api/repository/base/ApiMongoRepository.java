package com.tw.api.repository.base;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class ApiMongoRepository<T, Id> extends SimpleMongoRepository<T, Id>
        implements ApiRepository<T, Id> {

    public ApiMongoRepository(MongoEntityInformation<T, Id> metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
    }
}

