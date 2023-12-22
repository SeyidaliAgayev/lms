package com.div.service.impl;

import com.div.entities.Author;
import com.div.service.AuthorManagementService;
import com.div.service.AuthorService;
import com.div.service.CRUDService;

import java.util.InputMismatchException;

import static com.div.util.InputUtil.inputRequiredLong;
import static com.div.util.MenuUtil.authorMenu;

public class AuthorManagementServiceImpl implements AuthorManagementService {
    private static AuthorManagementServiceImpl instance = null;
    private AuthorManagementServiceImpl() {

    }
    public static AuthorManagementServiceImpl getInstance() {
        return instance == null ? new AuthorManagementServiceImpl() : instance;
    }
    @Override
    public void authorManagement() {
        while (true) {
            int authorOption = authorMenu();
            switch (authorOption) {
                case 1:
                    AuthorServiceImpl.getInstance().create();
                    break;
                case 2:
                    Long id = inputRequiredLong("Insert id");
                    AuthorServiceImpl.getInstance().getById(id);
                    break;
                case 3:
                    AuthorServiceImpl.getInstance().getAll();
                    break;
                case 4:
                    Long updateId = inputRequiredLong("Insert id");
                    AuthorServiceImpl.getInstance().update(updateId);
                    break;
                case 5:
                    Long deleteId = inputRequiredLong("Insert id");
                    AuthorServiceImpl.getInstance().delete(deleteId);
                    break;
                case 6:
                    Long authorId = inputRequiredLong("Insert id");
                    AuthorServiceImpl.getInstance().getAllBooksByAuthor(authorId);
                    break;
                default:
                    throw new InputMismatchException();
            }
        }
    }
}
