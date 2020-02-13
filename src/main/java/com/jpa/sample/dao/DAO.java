package com.jpa.sample.dao;

import java.util.List;

public interface DAO<T> {

    public void save(T domain);

    public void update(T domain);

    public void delete(T domain);

    public T findById(Long domainId);

    public List<T> findAll();

    public List<T> findAll(int maxResults, int firstResult);
}