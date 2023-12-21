package com.div.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "books", schema = "library_management")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "ISBN", unique = true, length = 13)
    private String isbn;
    @Column(name = "publication_year", length = 4)
    private String publicationYear;
    private String description;
    private String language;
    @Column(name = "available_copies")
    private int availableCopies;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(schema = "library_management",
            name = "books_libraries",
            joinColumns = @JoinColumn(
                    name = "books_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "libraries_id", referencedColumnName = "id"
            ))
    private List<Library> libraries;
    @ManyToOne
    private Author author;
}
