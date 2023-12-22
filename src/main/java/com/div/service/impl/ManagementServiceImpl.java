package com.div.service.impl;

import com.div.service.*;

import java.util.InputMismatchException;

import static com.div.util.MenuUtil.entryMenu;

public class ManagementServiceImpl implements ManagementService {
    @Override
    public void baseManagement() {
        while (true) {
            int entryOption = entryMenu();
            switch (entryOption) {
                case 1:
                    AuthorManagementServiceImpl.getInstance().authorManagement();
                    break;
                case 2:
                    BookManagementServiceImpl.getInstance().bookManagement();
                    break;
                case 3:
                    LibraryManagementServiceImpl.getInstance().libraryManagement();
                    break;
                default:
                    throw new InputMismatchException();
            }
        }
    }
}
