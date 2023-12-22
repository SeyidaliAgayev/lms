package com.div.service.impl;

import com.div.entities.Book;
import com.div.entities.Library;
import com.div.jpaConfig.EntityManage;
import com.div.service.LibraryService;
import com.div.service.CRUDService;
import jakarta.persistence.*;

import java.util.List;

import static com.div.helper.EntityFiller.libraryFiller;
import static com.div.jpaConfig.EntityManage.entityManager;

public class LibraryServiceImpl implements CRUDService<Library>, LibraryService {
    private static LibraryServiceImpl instance = null;
    private LibraryServiceImpl() {

    }
    public static LibraryServiceImpl getInstance() {
        return instance == null ? new LibraryServiceImpl() : instance;
    }

    @Override
    public Library create() {
        EntityManage.getInstance().getTransactionFromEntityManager().begin();
        Library library = null;
        try {
            library = libraryFiller();
            entityManager.persist(library);
            EntityManage.getInstance().getTransactionFromEntityManager().commit();
        } catch (Exception e) {
            EntityManage.getInstance().getTransactionFromEntityManager().rollback();
        }
        return library;
    }

    @Override
    public Library getById(Long id) {
        TypedQuery<Library> libraryQuery = entityManager.createQuery("select l from Library l where l.id = :id", Library.class);
        libraryQuery.setParameter("id", id);
        Library singleResult = libraryQuery.getSingleResult();
        System.out.println("-------------------------------\n" + singleResult + "\n-------------------------------\n");
        return singleResult;
    }

    @Override
    public List<Library> getAll() {
        TypedQuery<Library> libraryQuery = entityManager.createQuery("select l from Library l" , Library.class);
        System.out.println(libraryQuery.getResultList());
        return libraryQuery.getResultList();
    }

    @Override
    public Library update(Long id) {
        TypedQuery<Library> libraryQuery = entityManager.createQuery("update Library l set name = ?, address = ?, " +
                "contact = ?" +
                "where l.id = id", Library.class);
        return libraryQuery.getSingleResult();
    }

    @Override
    public void delete(Long id) {
        TypedQuery<Library> libraryQuery = entityManager.createQuery("delete from Library l where l.id = :id", Library.class);
        libraryQuery.setParameter("id", id);
    }

    @Override
    public void addBookToLibrary(Long libraryId, Long bookId, int numberOfCopies) {
        EntityManage.getInstance().getTransactionFromEntityManager().begin();
        Book book = entityManager.find(Book.class, bookId);
        Library library = entityManager.find(Library.class, libraryId);

        library.getBooks().add(book);
        book.getLibraries().add(library);
        int copies = book.getAvailableCopies() - numberOfCopies;
        book.setAvailableCopies(copies);

        try {
            entityManager.merge(library);
            entityManager.merge(book);
            EntityManage.getInstance().getTransactionFromEntityManager().commit();
        } catch (Exception e) {
            EntityManage.getInstance().getTransactionFromEntityManager().rollback();
        }
    }
}
