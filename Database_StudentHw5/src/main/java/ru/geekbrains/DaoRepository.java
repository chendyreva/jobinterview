package ru.geekbrains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collection;

public abstract class DaoRepository<T, U> implements IDaoRepository<T, U> {
    private EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    private EntityTransaction transaction;

    public DaoRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("lesson5-persistent-unit");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();
    }

    @Override
    public void persist(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public T merge(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void remove(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public T findById(U id) {
        return entityManager.find(getEntityClass(), id);
    }

    @Override
    public Collection<T> findAll() {
        final StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT e FROM ");
        queryBuilder.append(getEntityClass().getSimpleName());
        queryBuilder.append(" e");
        return entityManager.createQuery(queryBuilder.toString(), getEntityClass()).getResultList();
    }

    @Override
    public void close() {
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
