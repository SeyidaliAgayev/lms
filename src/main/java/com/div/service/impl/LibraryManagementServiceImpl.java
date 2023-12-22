package com.div.service.impl;


import com.div.service.LibraryManagementService;


import java.util.InputMismatchException;

import static com.div.util.InputUtil.inputRequiredInt;
import static com.div.util.InputUtil.inputRequiredLong;
import static com.div.util.MenuUtil.libraryMenu;

public class LibraryManagementServiceImpl implements LibraryManagementService {
    private static LibraryManagementServiceImpl instance = null;
    private LibraryManagementServiceImpl() {

    }
    public static LibraryManagementServiceImpl getInstance() {
        return instance == null ? new LibraryManagementServiceImpl() : instance;
    }

    @Override
    public void libraryManagement() {
        while (true) {
            int libraryOption = libraryMenu();
            switch (libraryOption) {
                case 1:
                    LibraryServiceImpl.getInstance().create();
                    break;
                case 2:
                    Long id = inputRequiredLong("Insert id");
                    LibraryServiceImpl.getInstance().getById(id);
                    break;
                case 3:
                    LibraryServiceImpl.getInstance().getAll();
                    break;
                case 4:
                    Long updateId = inputRequiredLong("Insert id");
                    LibraryServiceImpl.getInstance().update(updateId);
                    break;
                case 5:
                    Long deleteId = inputRequiredLong("Insert id");
                    LibraryServiceImpl.getInstance().delete(deleteId);
                    break;
                case 6:
                    Long libraryId = inputRequiredLong("Insert library id");
                    Long bookId = inputRequiredLong("Insert book id");
                    int numberOfCopies = inputRequiredInt("Insert number of copies of book: ");
                    LibraryServiceImpl.getInstance().addBookToLibrary(libraryId, bookId, numberOfCopies);
                    break;
                default:
                    throw new InputMismatchException();
            }
        }
    }
}
