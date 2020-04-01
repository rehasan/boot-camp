package com.tw.api.config;

import com.tw.api.ApiApplication;
import com.tw.api.entity.Book;
import com.tw.api.repository.ApiRepository;
import com.tw.api.repository.ApiJpaRepository;
import com.tw.api.repository.ApiMongoRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
public class ApiRepositoryConfig {

    @Bean
    @ConditionalOnProperty(name = "db.dialect", havingValue = "postgres", matchIfMissing = true)
    public ApiRepository apiJpaRepository() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.tw.api");
        return new ApiJpaRepository(ApiApplication.class, emf.createEntityManager());
    }

    @Bean
    @ConditionalOnProperty(name = "db.dialect", havingValue = "mongo")
    public ApiRepository apiMongoRepository() {
        return new ApiMongoRepository(null, null);
    }
}