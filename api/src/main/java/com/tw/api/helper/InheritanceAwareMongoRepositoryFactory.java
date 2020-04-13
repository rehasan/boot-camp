package com.tw.api.helper;

import com.tw.api.repository.base.ApiMongoRepository;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;

import java.io.Serializable;

public class InheritanceAwareMongoRepositoryFactory extends MongoRepositoryFactory {

    private final MongoOperations mongoOperations;

    /**
     * Creates a new {@link MongoRepositoryFactory} with the given {@link MongoOperations}.
     *
     * @param mongoOperations must not be {@literal null}.
     */
    public InheritanceAwareMongoRepositoryFactory(MongoOperations mongoOperations) {
        super(mongoOperations);

        this.mongoOperations = mongoOperations;
    }

    @Override
    protected Class<?> getRepositoryBaseClass(final RepositoryMetadata metadata) {
        return ApiMongoRepository.class;
    }

    @Override
    protected Object getTargetRepository(final RepositoryInformation information) {
        final MongoEntityInformation<?, Serializable> entityInformation = getEntityInformation(information.getDomainType());

        return new ApiMongoRepository(entityInformation, this.mongoOperations);
    }
}