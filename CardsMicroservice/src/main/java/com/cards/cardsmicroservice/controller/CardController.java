package com.cards.cardsmicroservice.controller;

import com.cards.cardsmicroservice.model.Card;
import com.cards.cardsmicroservice.model.Customer;
import com.cards.cardsmicroservice.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CardController {
    private CardService cardService;

    @PostMapping("/myCards")
    public List<Card> getCardDetails(@RequestBody Customer customer) {
        return cardService.getCardDetails(customer);
    }
}
