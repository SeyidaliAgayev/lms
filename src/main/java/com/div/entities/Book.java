package com.div.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "books", schema = "library_management")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    //TODO add toString
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
    //TODO avialivable copies burada saxlanılMAMALIDIR!
    @Column(name = "available_copies")
    private int availableCopies;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(schema = "library_management",
            name = "books_libraries",
            joinColumns = @JoinColumn(
                    name = "books_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "libraries_id"
            ))
    private List<Library> libraries = new ArrayList<>();
    @ManyToOne
    private Author author;
    
}
