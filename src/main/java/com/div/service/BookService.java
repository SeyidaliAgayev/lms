package com.div.service;

import com.div.entities.Author;
import com.div.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> searchBooksByTitle(String title);
}
