package com.account.accountmicroservice.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter @Setter @ToString
public class Account {

    @Column(name = "customer_id")
    private Long customerId;
    @Column(name="account_number")
    @Id
    private long accountNumber;
    @Column(name="account_type")
    private String accountType;
    @Column(name = "branch_address")
    private String branchAddress;
    @Column(name = "create_dt")
    private LocalDate createDt;

}
