package com.loans.loansmicroserivce.service;

import com.loans.loansmicroserivce.exceptions.NoLoanFoundException;
import com.loans.loansmicroserivce.model.Customer;
import com.loans.loansmicroserivce.model.Loan;
import com.loans.loansmicroserivce.repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LoanService {
    private LoanRepository loanRepository;

    public List<Loan> getLoansDetails(Customer customer) {
        return Optional.of(loanRepository.findLoandByCustomerId(customer.getCustomerId()))
                .orElseThrow(() -> new NoLoanFoundException("No loan found for customer with given Id"));
    }
}
