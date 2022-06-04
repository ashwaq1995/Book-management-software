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
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty(message = "id is required")
    @Column(name = "book_id")
    private Integer id;

    @NotEmpty(message = "userId is required")
    private Integer userId ;

    @NotEmpty(message = "bookID is required")
    private Integer bookID;

    @ManyToMany
    @JsonIgnore
    private Set<Book> books;

}
