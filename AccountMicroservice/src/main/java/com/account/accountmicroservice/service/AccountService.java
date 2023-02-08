package com.account.accountmicroservice.service;

import com.account.accountmicroservice.exceptions.NoAccountFoundException;
import com.account.accountmicroservice.model.Account;
import com.account.accountmicroservice.model.Customer;
import com.account.accountmicroservice.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;

    public List<Account> getAccountDetails(Customer customer) {
        return Optional.of(accountRepository.findAccountByCustomerId(customer.getCustomerId()))
                .orElseThrow(() -> new NoAccountFoundException("No account found for customer with given ID"));
    }
}
