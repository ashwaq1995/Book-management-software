package com.demo.H5.W3.Book.management.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty(message = "id is required")
    @Column(name = "book_id")
    private Integer id;

    @NotEmpty(message = "name is required")
    @Column(name = "book_name")
    private String name;

    @NotEmpty(message = "genre is required")
    private String genre;

    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Loan> loans;
}
