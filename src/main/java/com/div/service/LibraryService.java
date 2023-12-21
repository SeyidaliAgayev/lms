package com.div.service;

import com.div.entities.Author;
import com.div.entities.Book;
import com.div.entities.Library;

import java.util.List;

public interface LibraryService {
    Library createLibrary();
    Library getLibraryById(Long id);
    List<Library> getAllLibraries();
    Library updateLibrary(Long id);
    void deleteLibrary(Long id);
    void addBookToLibrary(Long libraryId, Long bookId, int numberOfCopies);
}
