package com.account.accountmicroservice.controller;

import com.account.accountmicroservice.model.Account;
import com.account.accountmicroservice.model.Customer;
import com.account.accountmicroservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;

    @PostMapping("/myAccount")
    public List<Account> getAccountDetails(@RequestBody Customer customer) {
        return accountService.getAccountDetails(customer);
    }

    @GetMapping("/account/properties")
    public String getPropertyDetails() {
        return accountService.getPropertyDetails();
    }
}
