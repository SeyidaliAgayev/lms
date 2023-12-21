package com.div.service.impl;

import com.div.entities.Author;
import com.div.entities.Book;
import com.div.service.AuthorService;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


import static com.div.helper.EntityFiller.authorFiller;
import static com.div.util.InputUtil.inputRequiredDate;
import static com.div.util.InputUtil.inputRequiredString;

public class AuthorServiceImpl implements AuthorService {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ali");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    @Override
    public Author createAuthor() {
        transaction.begin();
        try {
            entityManager.persist(authorFiller());
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return authorFiller();
    }

    @Override
    public Author getAuthorById(Long id) {
        TypedQuery<Author> authorQuery = entityManager.createQuery("select a from Author a where a.id = :id", Author.class);
        authorQuery.setParameter("id", id);
        return authorQuery.getSingleResult();
    }

    @Override
    public List<Author> getAllAuthors() {
        TypedQuery<Author> authorQuery = entityManager.createQuery("select a from Author a" , Author.class);
        return authorQuery.getResultList();
    }

    @Override
    public Author updateAuthor(Long id) {
        TypedQuery<Author> authorQuery = entityManager.createQuery("update Author a set name = ?, surname = ?, " +
                "birthDate = ?, deathDate = ?, nationality = ? " +
                "where a.id = id", Author.class);
        return authorQuery.getSingleResult();
    }

    @Override
    public void deleteAuthor(Long id) {
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
