package com.tw.api.config;

import com.tw.api.helper.InheritanceAwareMongoRepositoryFactoryBean;
import com.tw.api.repository.base.ApiMongoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ConditionalOnProperty(name = "db.dialect", havingValue = "mongo", matchIfMissing = true)
/*@EnableMongoRepositories(repositoryBaseClass = ApiMongoRepository.class,
        repositoryFactoryBeanClass = InheritanceAwareMongoRepositoryFactoryBean.class)*/

@EnableMongoRepositories("com.tw.api.repository")
public class ApiMongoRepositoryConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiMongoRepositoryConfig.class);

    public ApiMongoRepositoryConfig() {
        LOGGER.info("Repository Configuration: " + ApiMongoRepositoryConfig.class);
    }
}
