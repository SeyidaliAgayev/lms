package com.div.service.impl;

import com.div.entities.Author;
import com.div.entities.Book;
import com.div.jpaConfig.EntityManage;
import com.div.service.BookService;
import com.div.service.CRUDService;
import jakarta.persistence.*;

import java.util.List;

import static com.div.helper.EntityFiller.authorFiller;
import static com.div.helper.EntityFiller.bookFiller;
import static com.div.jpaConfig.EntityManage.entityManager;

public class BookServiceImpl implements CRUDService<Book>, BookService {
    private static BookServiceImpl instance = null;
    private BookServiceImpl() {

    }
    public static BookServiceImpl getInstance() {
        return instance == null ? new BookServiceImpl() : instance;
    }
    @Override
    public Book create() {
        EntityManage.getInstance().getTransactionFromEntityManager().begin();
        Book book = null;
        try {
            book = bookFiller();
            entityManager.persist(book);
            EntityManage.getInstance().getTransactionFromEntityManager().commit();
        } catch (Exception e) {
            EntityManage.getInstance().getTransactionFromEntityManager().rollback();
        }
        return book;
    }

    @Override
    public Book getById(Long id) {
        TypedQuery<Book> bookQuery = entityManager.createQuery("select b from Book b where b.id = :id", Book.class);
        bookQuery.setParameter("id", id);
        return bookQuery.getSingleResult();
    }
    @Override
    public List<Book> getAll() {
        TypedQuery<Book> bookQuery = entityManager.createQuery("select b from Book b" , Book.class);
        return bookQuery.getResultList();
    }
    @Override
    public Book update(Long id) {
        TypedQuery<Book> bookQuery = entityManager.createQuery("update Book b set title = ?, isbn = ?, " +
                "publicationYear = ?, description = ?, language = ? , availableCopies = ? " +
                "where b.id = id", Book.class);
        return bookQuery.getSingleResult();
    }
    @Override
    public void delete(Long id) {
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
