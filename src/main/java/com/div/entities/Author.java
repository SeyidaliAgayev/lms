package com.div.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "authors", schema = "library_management")
@Getter
@Setter
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "author_name", length = 50)
    private String name;
    @Column(name = "author_surname", length = 50)
    private String surname;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "death_date")
    private LocalDate deathDate;
    private String nationality;
    @OneToMany
    private List<Book> books;

}
