package com.account.accountmicroservice.service;

import com.account.accountmicroservice.config.AccountServiceConfig;
import com.account.accountmicroservice.exceptions.NoAccountFoundException;
import com.account.accountmicroservice.model.Account;
import com.account.accountmicroservice.model.Customer;
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

    public List<Account> getAccountDetails(Customer customer) {
        return Optional.of(accountRepository.findAccountByCustomerId(customer.getCustomerId()))
                .orElseThrow(() -> new NoAccountFoundException("No account found for customer with given ID"));
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
