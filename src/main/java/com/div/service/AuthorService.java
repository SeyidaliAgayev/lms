package com.div.service;

import com.div.entities.Author;
import com.div.entities.Book;

import java.util.List;

public interface AuthorService {
    Author createAuthor();
    Author getAuthorById(Long id);
    List<Author> getAllAuthors();
    Author updateAuthor(Long id);
    void deleteAuthor(Long id);
    List<Book> getAllBooksByAuthor(Long authorId);

}
