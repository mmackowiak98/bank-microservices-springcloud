package com.account.accountmicroservice.service;

import com.account.accountmicroservice.config.AccountServiceConfig;
import com.account.accountmicroservice.exceptions.NoAccountFoundException;
import com.account.accountmicroservice.model.*;
import com.account.accountmicroservice.repository.AccountRepository;
import com.account.accountmicroservice.util.Properties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;

    private AccountServiceConfig accountConfig;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    public Account getAccountDetails(Customer customer) {
        return Optional.of(accountRepository.findByCustomerId(customer.getCustomerId()))
                .orElseThrow(() -> new NoAccountFoundException("No account found for customer with given ID"));
    }

    public CustomerDetails getCustomerDetails(Customer customer) {

        Account byCustomerId = accountRepository.findByCustomerId(customer.getCustomerId());
        List<Card> cardDetails = cardsFeignClient.getCardDetails(customer);
        List<Loan> loanDetails = loansFeignClient.getLoanDetails(customer);

        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setAccount(byCustomerId);
        customerDetails.setCards(cardDetails);
        customerDetails.setLoans(loanDetails);

        return customerDetails;

    }

    public String getPropertyDetails() {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(
                accountConfig.getMsg(),
                accountConfig.getBuildVersion(),
                accountConfig.getMailDetails(),
                accountConfig.getActiveBranches());
        try {
            return objectWriter.writeValueAsString(properties);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
