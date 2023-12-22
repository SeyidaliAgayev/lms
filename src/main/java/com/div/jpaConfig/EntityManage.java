package com.div.jpaConfig;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;

public class EntityManage {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ali");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();
    private static EntityManage instance = null;
    private EntityManage() {

    }
    public static EntityManage getInstance() {
        return instance == null ? new EntityManage() : instance;
    }
    public EntityTransaction getTransactionFromEntityManager() {
        EntityTransaction transaction = entityManager.getTransaction();
        return transaction;
    }
}
