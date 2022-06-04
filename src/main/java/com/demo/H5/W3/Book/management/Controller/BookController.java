package com.demo.H5.W3.Book.management.Controller;

import com.demo.H5.W3.Book.management.DTO.Api;
import com.demo.H5.W3.Book.management.Model.Book;

import com.demo.H5.W3.Book.management.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/books")
public class BookController {

    private final BookService bookService;

    Logger logger = LoggerFactory.getLogger(BookController.class);


    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        logger.info("New request coming to getBooks");
        List<Book> books = bookService.getBooks();
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @PostMapping("/add")
    public ResponseEntity<Api> addBank(@RequestBody @Valid Book book) {
        logger.info("add book");
        bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new Api("New Book added !",201));
    }


    //to check book is invalid by book id
    @GetMapping("/book/{id}")
    public ResponseEntity<Api> checkBookIsInvalid(@PathVariable Integer id){
        logger.info("check by book id");
        bookService.checkBookIsInvalid(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Api("Valid book id",200));
    }

}
