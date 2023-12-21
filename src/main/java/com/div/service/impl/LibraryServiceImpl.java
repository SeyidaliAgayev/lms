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
        try {
            entityManager.persist(libraryFiller());
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return libraryFiller();
    }

    @Override
    public Library getLibraryById(Long id) {
        TypedQuery<Library> libraryQuery = entityManager.createQuery("select l from Library l where l.id = :id", Library.class);
        libraryQuery.setParameter("id", id);
        return libraryQuery.getSingleResult();
    }

    @Override
    public List<Library> getAllLibraries() {
        TypedQuery<Library> libraryQuery = entityManager.createQuery("select l from Library l" , Library.class);
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
        TypedQuery<Book> findBookQuery = entityManager.createQuery("select b from Book b where b.id = :bookId", Book.class);
        findBookQuery.setParameter("bookId", bookId);
        Book addedBook = findBookQuery.getSingleResult();

        TypedQuery<Library> findLibraryQuery = entityManager.createQuery("select l from Library l where l.id = :libraryId", Library.class);
        findLibraryQuery.setParameter("libraryId" , libraryId);
        Library addedLibrary = findLibraryQuery.getSingleResult();

        addedLibrary.getBooks().add(addedBook);
        addedBook.getLibraries().add(addedLibrary);
    }
}
