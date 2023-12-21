package com.div.helper;

import com.div.entities.Author;
import com.div.entities.Book;
import com.div.entities.Library;

import java.time.LocalDate;

import static com.div.util.InputUtil.*;

public class EntityFiller {
    public static Author authorFiller() {
        String name = inputRequiredString("Insert author name: ");
        String surname = inputRequiredString("Insert author surname: ");
        LocalDate birthDate = inputRequiredDate("Insert birth date: ");
        LocalDate death_date = inputRequiredDate("Insert death date: ");
        String nationality = inputRequiredString("Insert nationality: ");

        Author newAuthor = new Author();
        newAuthor.setName(name);
        newAuthor.setSurname(surname);
        newAuthor.setBirthDate(birthDate);
        newAuthor.setDeathDate(death_date);
        newAuthor.setNationality(nationality);
        return newAuthor;
    }

    public static Book bookFiller() {
        String title = inputRequiredString("Insert title: ");
        String ISBN = inputRequiredString("Insert ISBN: ");
        String publicationYear  = inputRequiredString("Insert publication year: ");
        String description = inputRequiredString("Insert description: ");
        String language = inputRequiredString("Insert language: ");
        int availableCopies = inputRequiredInt("Insert number of available copies: ");

        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setIsbn(ISBN);
        newBook.setPublicationYear(publicationYear);
        newBook.setDescription(description);
        newBook.setLanguage(language);
        newBook.setAvailableCopies(availableCopies);

        return newBook;
    }

    public static Library libraryFiller() {
        String name = inputRequiredString("Insert name: ");
        String address = inputRequiredString("Insert address: ");
        String contact  = inputRequiredString("Insert contact: ");

        Library newLibrary = new Library();
        newLibrary.setName(name);
        newLibrary.setAddress(address);
        newLibrary.setContact(contact);

        return newLibrary;
    }
}
