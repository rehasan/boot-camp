package com.tw.api.repository;

import org.springframework.data.repository.CrudRepository;

public interface ApiRepository<T, Id> extends CrudRepository<T, Id> {
}
