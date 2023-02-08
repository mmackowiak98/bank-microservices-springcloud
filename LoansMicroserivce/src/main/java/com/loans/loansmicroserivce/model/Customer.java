package com.loans.loansmicroserivce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Customer {

    @Id
    private int customerId;
    @OneToMany(mappedBy = "customer")
    @ToString.Exclude
    private List<Loan> loans;

}
