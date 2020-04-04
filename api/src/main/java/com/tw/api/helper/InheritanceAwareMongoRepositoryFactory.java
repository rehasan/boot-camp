package com.tw.api.helper;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;

public class InheritanceAwareMongoRepositoryFactory extends MongoRepositoryFactory {
    /**
     * Creates a new {@link MongoRepositoryFactory} with the given {@link MongoOperations}.
     *
     * @param mongoOperations must not be {@literal null}.
     */
    public InheritanceAwareMongoRepositoryFactory(MongoOperations mongoOperations) {
        super(mongoOperations);
    }
}