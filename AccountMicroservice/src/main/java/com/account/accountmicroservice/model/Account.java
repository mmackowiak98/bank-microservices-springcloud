package com.account.accountmicroservice.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter @Setter @ToString
public class Account {

    @Id
    private long accountNumber;

    private String accountType;

    private String branchAddress;

    private LocalDate createDt;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;


}
