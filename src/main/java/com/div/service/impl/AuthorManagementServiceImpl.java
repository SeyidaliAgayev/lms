package com.div.service.impl;

import com.div.service.AuthorManagementService;
import com.div.service.AuthorService;

import java.util.InputMismatchException;

import static com.div.util.InputUtil.inputRequiredLong;
import static com.div.util.MenuUtil.authorMenu;

public class AuthorManagementServiceImpl implements AuthorManagementService {
    AuthorService authorService = new AuthorServiceImpl();
    @Override
    public void authorManagement() {
        while (true) {
            int authorOption = authorMenu();
            switch (authorOption) {
                case 1:
                    authorService.createAuthor();
                    break;
                case 2:
                    Long id = inputRequiredLong("Insert id");
                    authorService.getAuthorById(id);
                    break;
                case 3:
                    authorService.getAllAuthors();
                    break;
                case 4:
                    Long updateId = inputRequiredLong("Insert id");
                    authorService.updateAuthor(updateId);
                    break;
                case 5:
                    Long deleteId = inputRequiredLong("Insert id");
                    authorService.deleteAuthor(deleteId);
                    break;
                case 6:
                    Long authorId = inputRequiredLong("Insert id");
                    authorService.getAllBooksByAuthor(authorId);
                    break;
                default:
                    throw new InputMismatchException();
            }
        }
    }
}
