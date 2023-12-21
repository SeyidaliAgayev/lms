package com.div.service.impl;

import com.div.service.BookManagementService;
import com.div.service.BookService;

import java.util.InputMismatchException;

import static com.div.util.InputUtil.inputRequiredLong;
import static com.div.util.InputUtil.inputRequiredString;
import static com.div.util.MenuUtil.authorMenu;
import static com.div.util.MenuUtil.bookMenu;

public class BookManagementServiceImpl implements BookManagementService {
    BookService bookService = new BookServiceImpl();
    @Override
    public void bookManagement() {
        while (true) {
            int bookOption = bookMenu();
            switch (bookOption) {
                case 1:
                    bookService.createBook();
                    break;
                case 2:
                    Long id = inputRequiredLong("Insert id");
                    bookService.getBookById(id);
                    break;
                case 3:
                    bookService.getAllBooks();
                    break;
                case 4:
                    Long updateId = inputRequiredLong("Insert id");
                    bookService.updateBook(updateId);
                    break;
                case 5:
                    Long deleteId = inputRequiredLong("Insert id");
                    bookService.deleteBook(deleteId);
                    break;
                case 6:
                    String bookTitle = inputRequiredString("Insert title");
                    bookService.searchBooksByTitle(bookTitle);
                    break;
                default:
                    throw new InputMismatchException();
            }
        }
    }
}
