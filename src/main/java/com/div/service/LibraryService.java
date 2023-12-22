package com.div.service;

import com.div.entities.Author;
import com.div.entities.Book;
import com.div.entities.Library;

import java.util.List;

public interface LibraryService {
    void addBookToLibrary(Long libraryId, Long bookId, int numberOfCopies);
}
