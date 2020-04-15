package com.tw.api.repository.base;

import com.tw.api.entity.BaseEntity;
import com.tw.api.repository.ApiRepository;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import java.util.UUID;

public class ApiMongoRepository<T extends BaseEntity, Id> extends SimpleMongoRepository<T, Id> implements ApiRepository<T, Id> {
    public ApiMongoRepository(MongoEntityInformation<T, Id> metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
    }

    @Override
    public <S extends T> S insert(S entity) {
        this.generateId(entity);
        
        return super.insert(entity);
    }

    @Override
    public <S extends T> S save(S entity) {
        this.generateId(entity);

        return super.save(entity);
    }

    private <S extends T> void generateId(S entity) {
        if (!entity.getIsNew()) {
            return;
        }

        entity.setId(UUID.randomUUID());
    }
}