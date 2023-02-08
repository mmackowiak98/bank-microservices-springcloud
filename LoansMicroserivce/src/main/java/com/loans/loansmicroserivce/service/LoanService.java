package com.loans.loansmicroserivce.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.loans.loansmicroserivce.config.LoanServiceConfig;
import com.loans.loansmicroserivce.exceptions.NoLoanFoundException;
import com.loans.loansmicroserivce.model.Customer;
import com.loans.loansmicroserivce.model.Loan;
import com.loans.loansmicroserivce.repository.LoanRepository;
import com.loans.loansmicroserivce.util.Properties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LoanService {
    private LoanRepository loanRepository;
    private LoanServiceConfig loanConfig;

    public List<Loan> getLoansDetails(Customer customer) {
        return Optional.of(loanRepository.findLoandByCustomerId(customer.getCustomerId()))
                .orElseThrow(() -> new NoLoanFoundException("No loan found for customer with given Id"));
    }

    public String getPropertyDetails() {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(
                loanConfig.getMsg(),
                loanConfig.getBuildVersion(),
                loanConfig.getMailDetails(),
                loanConfig.getActiveBranches());
        try {
            return objectWriter.writeValueAsString(properties);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
