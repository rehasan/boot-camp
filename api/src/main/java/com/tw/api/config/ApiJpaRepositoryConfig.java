package com.tw.api.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.tw.api.repository")
@ConditionalOnProperty(name = "db.dialect", havingValue = "postgres")
public class ApiJpaRepositoryConfig {

}