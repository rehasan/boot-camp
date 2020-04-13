package com.tw.api.repository.base;

import com.tw.api.repository.ApiRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;

@NoRepositoryBean
public class ApiJpaRepository<T, Id>
        extends SimpleJpaRepository<T, Id> implements ApiRepository<T, Id> {

    public ApiJpaRepository(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
    }
}
