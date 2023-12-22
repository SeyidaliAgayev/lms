package com.div.service.impl;

import com.div.entities.Author;
import com.div.entities.Book;
import com.div.jpaConfig.EntityManage;
import com.div.service.AuthorService;
import com.div.service.CRUDService;
import jakarta.persistence.*;

import java.util.List;


import static com.div.helper.EntityFiller.authorFiller;
import static com.div.jpaConfig.EntityManage.entityManager;


public class AuthorServiceImpl implements CRUDService<Author>, AuthorService {
    private static AuthorServiceImpl instance = null;
    private AuthorServiceImpl() {

    }
    public static AuthorServiceImpl getInstance() {
        return instance == null ? new AuthorServiceImpl() : instance;
    }
    @Override
    public Author create() {
        EntityManage.getInstance().getTransactionFromEntityManager().begin();
        Author author = null;
        try {
            author = authorFiller();
            entityManager.persist(author);
            EntityManage.getInstance().getTransactionFromEntityManager().commit();
        } catch (Exception e) {
            EntityManage.getInstance().getTransactionFromEntityManager().rollback();
        }
        return author;
    }

    @Override
    public Author getById(Long id) {
        TypedQuery<Author> authorQuery = entityManager.createQuery("select a from Author a where a.id = :id", Author.class);
        authorQuery.setParameter("id", id);
        return authorQuery.getSingleResult();
    }

    @Override
    public List<Author> getAll() {
        TypedQuery<Author> authorQuery = entityManager.createQuery("select a from Author a" , Author.class);
        return authorQuery.getResultList();
    }

    @Override
    public Author update(Long id) {
        TypedQuery<Author> authorQuery = entityManager.createQuery("update Author a set name = ?, surname = ?, " +
                "birthDate = ?, deathDate = ?, nationality = ? " +
                "where a.id = id", Author.class);
        return authorQuery.getSingleResult();
    }

    @Override
    public void delete(Long id) {
        TypedQuery<Author> authorQuery = entityManager.createQuery("delete from Author a where a.id = :id", Author.class);
        authorQuery.setParameter("id", id);
    }

    @Override
    public List<Book> getAllBooksByAuthor(Long authorId) {
        TypedQuery<Book> authorQuery = entityManager.createQuery("select b from Book b join b.author a where a.id = :authorId", Book.class);
        authorQuery.setParameter("authorId", authorId);
        return authorQuery.getResultList();
    }
}
