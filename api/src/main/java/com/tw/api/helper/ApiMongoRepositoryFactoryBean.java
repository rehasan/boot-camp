package com.tw.api.helper;

import java.io.Serializable;

import com.tw.api.repository.base.ApiMongoRepository;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactoryBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class ApiMongoRepositoryFactoryBean<T extends CrudRepository<S, Id>, S, Id extends Serializable> extends
        MongoRepositoryFactoryBean<T, S, Id> {

    public ApiMongoRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport getFactoryInstance(MongoOperations operations) {
        return new ApiMongoRepositoryFactory(operations);
    }

    private static class ApiMongoRepositoryFactory extends MongoRepositoryFactory {
        private final MongoOperations mongoOperations;

        /**
         * Creates a new {@link MongoRepositoryFactory} with the given {@link MongoOperations}.
         *
         * @param mongoOperations must not be {@literal null}.
         */
        ApiMongoRepositoryFactory(MongoOperations mongoOperations) {
            super(mongoOperations);

            this.mongoOperations = mongoOperations;
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            Class<?> repositoryInterface = metadata.getRepositoryInterface();
            if (ApiMongoRepository.class.isAssignableFrom(repositoryInterface)) {
                return ApiMongoRepository.class;
            } else {
                return super.getRepositoryBaseClass(metadata);
            }
        }

        @Override
        protected Object getTargetRepository(final RepositoryInformation information) {
            MongoEntityInformation<?, Serializable> entityInformation = this.getEntityInformation(information.getDomainType());

            return new ApiMongoRepository(entityInformation, this.mongoOperations);
        }
    }
}