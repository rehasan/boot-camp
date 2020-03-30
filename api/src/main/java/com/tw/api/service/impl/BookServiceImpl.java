package com.tw.api.service.impl;

import com.tw.api.entity.Book;
import com.tw.api.repository.BookRepository;
import com.tw.api.service.AbstractService;
import com.tw.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends AbstractService<Book, Long> implements BookService {

    protected BookRepository repository;

    @Autowired
    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<Book, Long> getRepository() {
        return repository;
    }
}
