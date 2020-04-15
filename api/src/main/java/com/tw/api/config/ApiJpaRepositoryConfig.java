package com.tw.api.config;

import com.tw.api.helper.ApiJpaRepositoryFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ConditionalOnProperty(prefix = "spring", name = "db.dialect", havingValue = "postgres")
@EnableJpaRepositories(
        repositoryFactoryBeanClass = ApiJpaRepositoryFactoryBean.class,
        entityManagerFactoryRef = "entityManagerFactory",
        basePackages = "com.tw.api.repository")
public class ApiJpaRepositoryConfig {

    @Value("${spring.api.datasource.url}")
    private String url;

    @Value("${spring.api.datasource.username}")
    private String username;

    @Value("${spring.api.datasource.password}")
    private String password;

    @Value("${spring.api.jpa.properties.hibernate.dialect}")
    private String dialect;

    @Value("${spring.api.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiJpaRepositoryConfig.class);

    public ApiJpaRepositoryConfig() {
        LOGGER.info("Repository Configuration: " + ApiJpaRepositoryConfig.class);
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("dataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.tw.api.entity");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(properties());

        return em;
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager platformTransactionManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    private Properties properties() {
        Properties properties = new Properties();

        properties.setProperty("hibernate.dialect", dialect);
        properties.setProperty("hibernate.hbm2ddl.auto", ddlAuto);

        return properties;
    }
}
