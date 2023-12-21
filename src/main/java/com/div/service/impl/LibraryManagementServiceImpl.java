package com.div.service.impl;

import com.div.service.LibraryManagementService;
import com.div.service.LibraryService;

import java.util.InputMismatchException;

import static com.div.util.InputUtil.inputRequiredInt;
import static com.div.util.InputUtil.inputRequiredLong;
import static com.div.util.MenuUtil.authorMenu;
import static com.div.util.MenuUtil.libraryMenu;

public class LibraryManagementServiceImpl implements LibraryManagementService {
    LibraryService libraryService = new LibraryServiceImpl();
    @Override
    public void libraryManagement() {
        while (true) {
            int libraryOption = libraryMenu();
            switch (libraryOption) {
                case 1:
                    libraryService.createLibrary();
                    break;
                case 2:
                    Long id = inputRequiredLong("Insert id");
                    libraryService.getLibraryById(id);
                    break;
                case 3:
                    libraryService.getAllLibraries();
                    break;
                case 4:
                    Long updateId = inputRequiredLong("Insert id");
                    libraryService.updateLibrary(updateId);
                    break;
                case 5:
                    Long deleteId = inputRequiredLong("Insert id");
                    libraryService.deleteLibrary(deleteId);
                    break;
                case 6:
                    Long libraryId = inputRequiredLong("Insert library id");
                    Long bookId = inputRequiredLong("Insert book id");
                    int numberOfCopies = inputRequiredInt("Insert number of copies of book: ");
                    libraryService.addBookToLibrary(libraryId, bookId, numberOfCopies);
                    break;
                default:
                    throw new InputMismatchException();
            }
        }
    }
}
