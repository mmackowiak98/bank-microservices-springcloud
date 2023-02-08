package com.loans.loansmicroserivce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loanNumber;
    private Date startDt;
    private String loanType;
    private int totalLoan;
    private int amountPaid;
    private int outstandingAmount;
    @CreationTimestamp
    private LocalDate createDt;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

}
