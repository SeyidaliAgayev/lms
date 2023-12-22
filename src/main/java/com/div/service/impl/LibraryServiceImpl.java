package com.div.service.impl;

import com.div.entities.Author;
import com.div.entities.Book;
import com.div.entities.Library;
import com.div.service.LibraryService;
import jakarta.persistence.*;

import java.util.List;

import static com.div.helper.EntityFiller.libraryFiller;
import static com.div.util.InputUtil.inputRequiredString;

public class LibraryServiceImpl implements LibraryService {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ali");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public Library createLibrary() {
        transaction.begin();
        Library library = null;
        try {
            library = libraryFiller();
            entityManager.persist(library);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return library;
    }

    @Override
    public Library getLibraryById(Long id) {
        TypedQuery<Library> libraryQuery = entityManager.createQuery("select l from Library l where l.id = :id", Library.class);
        libraryQuery.setParameter("id", id);
        Library singleResult = libraryQuery.getSingleResult();
        System.out.println("-------------------------------\n" + singleResult + "\n-------------------------------\n");
        return singleResult;
    }

    @Override
    public List<Library> getAllLibraries() {
        TypedQuery<Library> libraryQuery = entityManager.createQuery("select l from Library l" , Library.class);
        System.out.println(libraryQuery.getResultList());
        return libraryQuery.getResultList();
    }

    @Override
    public Library updateLibrary(Long id) {
        TypedQuery<Library> libraryQuery = entityManager.createQuery("update Library l set name = ?, address = ?, " +
                "contact = ?" +
                "where l.id = id", Library.class);
        return libraryQuery.getSingleResult();
    }

    @Override
    public void deleteLibrary(Long id) {
        TypedQuery<Library> libraryQuery = entityManager.createQuery("delete from Library l where l.id = :id", Library.class);
        libraryQuery.setParameter("id", id);
    }

    @Override
    public void addBookToLibrary(Long libraryId, Long bookId, int numberOfCopies) {
        transaction.begin();
        Book book = entityManager.find(Book.class, bookId);
        Library library = entityManager.find(Library.class, libraryId);

        library.getBooks().add(book);
        book.getLibraries().add(library);
        try {
            entityManager.merge(library);
            entityManager.merge(book);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
