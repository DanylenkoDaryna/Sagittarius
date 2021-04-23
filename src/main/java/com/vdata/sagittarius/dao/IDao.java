package com.vdata.sagittarius.dao;

public interface IDao<T> {

    void create(T entity);

    T read(T entity);

    void update(T entity);

    void insert(T entity);

    void delete(T entity);
}
