package com.account.accountmicroservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Loan {

    private int loanNumber;

    private int customerId;

    private Date startDt;

    private String loanType;

    private int totalLoan;

    private int amountPaid;

    private int outstandingAmount;

    private String createDt;

}