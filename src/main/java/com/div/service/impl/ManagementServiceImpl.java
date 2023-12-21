package com.div.service.impl;

import com.div.service.*;

import java.util.InputMismatchException;

import static com.div.util.InputUtil.inputRequiredInt;
import static com.div.util.InputUtil.inputRequiredLong;
import static com.div.util.MenuUtil.authorMenu;
import static com.div.util.MenuUtil.entryMenu;

public class ManagementServiceImpl implements ManagementService {
    AuthorManagementService authorManagementService = new AuthorManagementServiceImpl();
    BookManagementService bookManagementService = new BookManagementServiceImpl();
    LibraryManagementService libraryManagementService = new LibraryManagementServiceImpl();


    @Override
    public void baseManagement() {
        while (true) {
            int entryOption = entryMenu();
            switch (entryOption) {
                case 1:
                    authorManagementService.authorManagement();
                    break;
                case 2:
                    bookManagementService.bookManagement();
                    break;
                case 3:
                    libraryManagementService.libraryManagement();
                    break;
                default:
                    throw new InputMismatchException();
            }
        }
    }
}
