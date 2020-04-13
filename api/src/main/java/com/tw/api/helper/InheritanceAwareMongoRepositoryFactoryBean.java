package com.tw.api.helper;

import java.io.Serializable;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactoryBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class InheritanceAwareMongoRepositoryFactoryBean<T extends CrudRepository<S, Id>, S, Id extends Serializable> extends
        MongoRepositoryFactoryBean<T, S, Id> {

    public InheritanceAwareMongoRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport getFactoryInstance(MongoOperations operations) {
        return new InheritanceAwareMongoRepositoryFactory(operations);
    }
}