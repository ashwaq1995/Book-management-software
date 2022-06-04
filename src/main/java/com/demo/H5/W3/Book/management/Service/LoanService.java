package com.demo.H5.W3.Book.management.Service;

import com.demo.H5.W3.Book.management.Exceptions.InvalidIdException;
import com.demo.H5.W3.Book.management.Model.Book;
import com.demo.H5.W3.Book.management.Model.Loan;

import com.demo.H5.W3.Book.management.Model.User;
import com.demo.H5.W3.Book.management.Repository.BookRepository;
import com.demo.H5.W3.Book.management.Repository.LoanRepository;
import com.demo.H5.W3.Book.management.Repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    public List<Loan> getLoans() {
        return loanRepository.findAll();
    }

    public void addLoan(Loan loan) {
        loanRepository.save(loan);
    }

    public void lendBook(Integer userId, Integer bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(
                        () -> new InvalidIdException("Invalid id"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(
                        () -> new InvalidIdException("Invalid id"));

        Loan loan = new Loan(null,userId, bookId,null);
        loanRepository.save(loan);
    }

    //to check loan is invalid by loan id
    public Loan checkLoanIsInvalid(Integer id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(
                        () -> new InvalidIdException("Invalid id"));
        return loan;

    }
}
