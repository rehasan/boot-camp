package com.tw.api.config;

import com.tw.api.repository.ApiJpaRepository;
import com.tw.api.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
/*@EnableJpaRepositories("com.tw.api.repository")*/
@ConditionalOnProperty(name = "db.dialect", havingValue = "postgres")
public class ApiJpaRepositoryConfig {
    /*
    private final ApiJpaRepository apiJpaRepository;

    @Autowired
    public ApiRepositoryConfig(ApiMongoRepository apiMongoRepository) {
        this.apiMongoRepository = apiMongoRepository;
    }

    @Bean

    public ApiRepository apiJpaRepository() {
        return apiJpaRepository;
    }*/
}