package com.tw.api.config;

import com.tw.api.repository.base.ApiMongoRepository;
import com.tw.api.repository.base.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.tw.api.repository")
@ConditionalOnProperty(name = "db.dialect", havingValue = "mongo", matchIfMissing = true)
public class ApiMongoRepositoryConfig {

    private final ApiMongoRepository apiMongoRepository;

    @Autowired
    public ApiMongoRepositoryConfig(ApiMongoRepository apiMongoRepository) {
        this.apiMongoRepository = apiMongoRepository;
    }

    @Bean
    public ApiRepository apiMongoRepository() {
        return apiMongoRepository;
    }
}