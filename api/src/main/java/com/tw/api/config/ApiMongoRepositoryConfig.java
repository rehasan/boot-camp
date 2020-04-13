package com.tw.api.config;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.tw.api.helper.InheritanceAwareMongoRepositoryFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ConditionalOnProperty(prefix = "spring", name = "db.dialect", havingValue = "mongo", matchIfMissing = true)
@EnableMongoRepositories(
        repositoryFactoryBeanClass = InheritanceAwareMongoRepositoryFactoryBean.class,
        basePackages = "com.tw.api.repository")
public class ApiMongoRepositoryConfig {

    @Value("${spring.data.mongodb.uri}")
    private String uri;

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiMongoRepositoryConfig.class);

    public ApiMongoRepositoryConfig() {
        LOGGER.info("Repository Configuration: " + ApiMongoRepositoryConfig.class);
    }

    public @Bean
    MongoDbFactory mongoDbFactory() {
        ConnectionString connectionString = new ConnectionString(uri);
        MongoClient mongoClient = MongoClients.create(connectionString);

        return new SimpleMongoClientDbFactory((ConnectionString) mongoClient);
    }
}
