package com.demo.H5.W3.Book.management.Controller;

import com.demo.H5.W3.Book.management.DTO.Api;
import com.demo.H5.W3.Book.management.Model.Loan;

import com.demo.H5.W3.Book.management.Service.LoanService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/loans")
public class LoanController {

    private final LoanService loanService;
    Logger logger = LoggerFactory.getLogger(LoanController.class);


    //Get all loans
    @GetMapping
    public ResponseEntity<List<Loan>> getLoans(){
        logger.info("get loans");
        List<Loan> loans = loanService.getLoans();
        return ResponseEntity.status(HttpStatus.OK).body(loans);
    }


    //Add new loan
    @PutMapping("/add")
    public ResponseEntity<Api> addLoan(@RequestBody Loan loan){
        logger.info("add loan");
        loanService.addLoan(loan);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("Loan added !",201));
    }

    @PostMapping("/lend")
    public ResponseEntity<Api> lendBook(@PathVariable Integer userId, @PathVariable Integer bookId) {
        logger.info("lend a book");
        loanService.lendBook(userId, bookId);
        return ResponseEntity.status(200).body(new Api("Book has been lent !",200));
    }

    //to check loan is invalid by loan id
    @GetMapping("/loan/{id}")
    public ResponseEntity<Api> checkLoanIsInvalid(@PathVariable Integer id){
        logger.info("check by loan id");
        loanService.checkLoanIsInvalid(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Api("Valid loan id",200));
    }

}
