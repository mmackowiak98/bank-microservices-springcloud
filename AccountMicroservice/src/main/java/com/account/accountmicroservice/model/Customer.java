package com.account.accountmicroservice.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter @Setter @ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    private String name;
    private String email;
    private String mobileNumber;
    @CreationTimestamp
    private LocalDate createDt;
    @OneToMany(mappedBy = "customer")
    @ToString.Exclude
    private List<Account> accounts;

}
