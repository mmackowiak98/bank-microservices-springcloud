package com.cards.cardsmicroservice.service;

import com.cards.cardsmicroservice.exceptions.NoCardFoundException;
import com.cards.cardsmicroservice.model.Card;
import com.cards.cardsmicroservice.model.Customer;
import com.cards.cardsmicroservice.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CardService {
    private CardRepository cardRepository;

    public List<Card> getCardDetails(Customer customer) {
        return Optional.of(cardRepository.findCardsByCustomerId(customer.getCustomerId()))
                .orElseThrow(() -> new NoCardFoundException("No card found for customer with given Id"));
    }
}
