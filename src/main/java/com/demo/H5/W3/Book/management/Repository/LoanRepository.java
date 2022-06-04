package com.demo.H5.W3.Book.management.Repository;


import com.demo.H5.W3.Book.management.Model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
}