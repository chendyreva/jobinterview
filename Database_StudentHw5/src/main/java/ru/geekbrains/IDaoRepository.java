package ru.geekbrains;

import java.util.Collection;

public interface IDaoRepository<T, U> {
    void persist(T entity);

    T merge(T entity);

    void remove(T entity);

    T findById(U id);

    Collection<T> findAll();

    void close();

    Class<T> getEntityClass();
}
