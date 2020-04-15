package com.tw.api.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.tw.api.helper.ApiMongoRepositoryFactoryBean;
import com.tw.api.repository.base.ApiMongoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ConditionalOnProperty(prefix = "spring", name = "db.dialect", havingValue = "mongo", matchIfMissing = true)
@EnableMongoRepositories(
        repositoryFactoryBeanClass = ApiMongoRepositoryFactoryBean.class,
        basePackages = "com.tw.api.repository")
public class ApiMongoRepositoryConfig {

    private MongoClientURI mongoClientURI;

    @Value("${spring.data.mongodb.uri}")
    private String uri;

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiMongoRepositoryConfig.class);

    public ApiMongoRepositoryConfig() {
        LOGGER.info("Repository Configuration: " + ApiMongoRepositoryConfig.class);
    }

    @Bean(name = "mongoClient")
    public MongoClient mongoClient() {
        return new MongoClient(this.getUri());
    }

    @Bean(name = "mongoTemplate")
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), this.getUri().getDatabase());
    }

    private MongoClientURI getUri() {
        return this.mongoClientURI == null
                ? this.mongoClientURI = new MongoClientURI(uri) : this.mongoClientURI;
    }
}
