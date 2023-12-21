package com.div.util;

import static com.div.util.InputUtil.inputRequiredInt;

public class MenuUtil {
    public static int entryMenu() {
        System.out.println("[1].Author\n" +
                "[2].Book\n" +
                "[3].Library\n" +
                "[0].Exit Program\n");
        return inputRequiredInt("Choose an option: ");
    }

    public static int authorMenu() {
        System.out.println("[1].Create Author\n" +
                "[2].Get Author By Id\n" +
                "[3].Get All Authors\n" +
                "[4].Update Author\n" +
                "[5].Delete Author\n" +
                "[6].Get All Books By Author" +
                "[0].Exit Program\n");
        return inputRequiredInt("Choose an option: ");
    }

    public static int bookMenu() {
        System.out.println("[1].Create Book\n" +
                "[2].Get Book By Id\n" +
                "[3].Get All Books\n" +
                "[4].Update Book\n" +
                "[5].Delete Book\n" +
                "[6].Search Books By Title\n" +
                "[0].Exit Program\n");
        return inputRequiredInt("Choose an option: ");
    }
    public static int libraryMenu() {
        System.out.println("[1].Create Library\n" +
                "[2].Get Library By Id\n" +
                "[3].Get All Libraries\n" +
                "[4].Update Library\n" +
                "[5].Delete Library\n" +
                "[6].Add Book To Library" +
                "[0].Exit Program\n");
        return inputRequiredInt("Choose an option: ");
    }



}
