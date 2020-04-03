package com.tw.api.service;

import com.tw.api.exception.ErrorCode;
import com.tw.api.exception.RecordNotFoundBaseException;
import com.tw.api.repository.base.ApiRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T, Id> implements BaseService<T, Id> {
    protected abstract ApiRepository<T, Id> getRepository();

    @Override
    public T getById(Id id) {
        Optional<T> aTable = getRepository().findById(id);

        return aTable
                .orElseThrow(() -> new RecordNotFoundBaseException("Cannot find entity by id:" + id, ErrorCode.OBJECT_NOT_FOUND));
    }

    @Override
    public List<T> getAll() {
        return (List<T>) getRepository().findAll();
    }
}
