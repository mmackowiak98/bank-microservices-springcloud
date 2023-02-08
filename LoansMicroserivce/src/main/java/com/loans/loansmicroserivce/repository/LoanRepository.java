package com.loans.loansmicroserivce.repository;

import com.loans.loansmicroserivce.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    @Query("select l from Loan l where l.customer.customerId = ?1")
    List<Loan> findLoandByCustomerId(int customerId);

}
