package com.demo.H5.W3.Book.management.Service;

import com.demo.H5.W3.Book.management.Exceptions.InvalidIdException;
import com.demo.H5.W3.Book.management.Model.Book;
import com.demo.H5.W3.Book.management.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    //to check book is invalid by book id
    public void checkBookIsInvalid(Integer id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(
                        () -> new InvalidIdException("Invalid id"));

    }
}
