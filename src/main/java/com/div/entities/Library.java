package com.div.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libraries", schema = "library_management")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "library_name")
    private String name;
    @Column(name = "library_address", length = 100)
    private String address;
    @Column(name = "library_contact", length = 50)
    private String contact;
    @ManyToMany(mappedBy = "libraries")
    private List<Book> books = new ArrayList<>();
}
