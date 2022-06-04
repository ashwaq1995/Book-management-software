package com.demo.H5.W3.Book.management.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty(message = "id is required")
    private Integer id;

    @NotEmpty(message = "username is required")
    private String username;

    @NotEmpty(message = "password is required")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Book> books;
}
