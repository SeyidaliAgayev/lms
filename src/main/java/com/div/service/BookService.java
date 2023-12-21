package com.div.service;

import com.div.entities.Author;
import com.div.entities.Book;

import java.util.List;

public interface BookService {
    Book createBook();
    Book getBookById(Long id);
    List<Book> getAllBooks();
    Book updateBook(Long id);
    void deleteBook(Long id);
    List<Book> searchBooksByTitle(String title);
}
