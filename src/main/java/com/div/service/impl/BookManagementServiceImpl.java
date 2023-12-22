package com.div.service.impl;

import com.div.entities.Book;
import com.div.service.BookManagementService;
import com.div.service.BookService;
import com.div.service.CRUDService;

import java.util.InputMismatchException;

import static com.div.util.InputUtil.inputRequiredLong;
import static com.div.util.InputUtil.inputRequiredString;
import static com.div.util.MenuUtil.bookMenu;

public class BookManagementServiceImpl implements BookManagementService {
    private static BookManagementServiceImpl instance = null;
    private BookManagementServiceImpl() {

    }
    public static BookManagementServiceImpl getInstance() {//TODO butun clsasslarsa singleton patterni duzelt!!!
        return instance == null ? new BookManagementServiceImpl() : instance;
    }

    //TODO same problem AuthorManagamentServiceimpla bax
    @Override
    public void bookManagement() {
        while (true) {
            int bookOption = bookMenu();
            switch (bookOption) {
                case 1:
                    BookServiceImpl.getInstance().create();
                    break;
                case 2:
                    Long id = inputRequiredLong("Insert id");
                    BookServiceImpl.getInstance().getById(id);
                    break;
                case 3:
                    BookServiceImpl.getInstance().getAll();
                    break;
                case 4:
                    Long updateId = inputRequiredLong("Insert id");
                    BookServiceImpl.getInstance().update(updateId);
                    break;
                case 5:
                    Long deleteId = inputRequiredLong("Insert id");
                    BookServiceImpl.getInstance().delete(deleteId);
                    break;
                case 6:
                    String bookTitle = inputRequiredString("Insert title");
                    BookServiceImpl.getInstance().searchBooksByTitle(bookTitle);
                    break;
                default:
                    throw new InputMismatchException();
            }
        }
    }
}
