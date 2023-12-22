package com.div.service;

import com.div.entities.Author;
import com.div.entities.Book;

import java.util.List;

public interface AuthorService {
    List<Book> getAllBooksByAuthor(Long authorId);

}
