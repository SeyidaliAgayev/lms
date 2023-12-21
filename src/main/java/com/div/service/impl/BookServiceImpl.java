package com.div.service.impl;

import com.div.entities.Author;
import com.div.entities.Book;
import com.div.service.BookService;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

import static com.div.helper.EntityFiller.bookFiller;
import static com.div.util.InputUtil.*;

public class BookServiceImpl implements BookService {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ali");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    @Override
    public Book createBook() {
        transaction.begin();
        try {
            entityManager.persist(bookFiller());
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return bookFiller();
    }

    @Override
    public Book getBookById(Long id) {
        TypedQuery<Book> bookQuery = entityManager.createQuery("select b from Book b where b.id = :id", Book.class);
        bookQuery.setParameter("id", id);
        return bookQuery.getSingleResult();
    }
    @Override
    public List<Book> getAllBooks() {
        TypedQuery<Book> bookQuery = entityManager.createQuery("select b from Book b" , Book.class);
        return bookQuery.getResultList();
    }
    @Override
    public Book updateBook(Long id) {
        TypedQuery<Book> bookQuery = entityManager.createQuery("update Book b set title = ?, isbn = ?, " +
                "publicationYear = ?, description = ?, language = ? , availableCopies = ? " +
                "where b.id = id", Book.class);
        return bookQuery.getSingleResult();
    }
    @Override
    public void deleteBook(Long id) {
        TypedQuery<Book> bookQuery = entityManager.createQuery("delete from Book b where b.id = :id", Book.class);
        bookQuery.setParameter("id", id);
    }
    @Override
    public List<Book> searchBooksByTitle(String title) {
        TypedQuery<Book> bookQuery = entityManager.createQuery("select b from Book b where b.title = :title", Book.class);
        bookQuery.setParameter("title", title);
        return bookQuery.getResultList();
    }
}
