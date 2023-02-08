package com.cards.cardsmicroservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter @Setter @ToString
public class Customer {
    @Id
    private Long customerId;
    @OneToMany(mappedBy = "customer")
    private List<Card> cards;
}
