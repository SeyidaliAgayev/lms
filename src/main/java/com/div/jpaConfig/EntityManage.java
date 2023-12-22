package com.div.jpaConfig;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;

public class EntityManage {
    //TODO remove unused imports
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ali");//TODO deyerleri final et
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();
    private static EntityManage instance = null;
    private EntityManage() {

    }

    //TODO Onsuzda yuxarıdakı entitymanagerFactory və EntityManager public və staticdir kənardan yeni entity manager yaradıla bilər  final deyil hemçinin bunu düzəlt!
    public static EntityManage getInstance() {//TODO sencede burada instance hemise null olmayacaq ?
        return instance == null ? new EntityManage() : instance;
    }//TODO  inline variable ehtiyac yoxdur sadece retrun istifade ede bilersen
    public EntityTransaction getTransactionFromEntityManager() {
        EntityTransaction transaction = entityManager.getTransaction();
        return transaction;
    }
}
