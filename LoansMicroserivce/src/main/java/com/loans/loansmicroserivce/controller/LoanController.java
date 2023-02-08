package com.loans.loansmicroserivce.controller;

import com.loans.loansmicroserivce.model.Customer;
import com.loans.loansmicroserivce.model.Loan;
import com.loans.loansmicroserivce.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class LoanController {
    private LoanService loanService;

    @PostMapping("/myLoans")
    public List<Loan> getLoansDetails(@RequestBody Customer customer) {
        return loanService.getLoansDetails(customer);
    }
    @GetMapping("/loan/properties")
    public String getPropertyDetails() {
        return loanService.getPropertyDetails();
    }

}
