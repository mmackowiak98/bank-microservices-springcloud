package com.cards.cardsmicroservice.service;

import com.cards.cardsmicroservice.config.CardServiceConfig;
import com.cards.cardsmicroservice.exceptions.NoCardFoundException;
import com.cards.cardsmicroservice.model.Card;
import com.cards.cardsmicroservice.model.Customer;
import com.cards.cardsmicroservice.repository.CardRepository;
import com.cards.cardsmicroservice.util.Properties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CardService {
    private CardRepository cardRepository;

    private CardServiceConfig cardConfig;
    public List<Card> getCardDetails(Customer customer) {
        return Optional.of(cardRepository.findByCustomerId(customer.getCustomerId()))
                .orElseThrow(() -> new NoCardFoundException("No card found for customer with given Id"));
    }

    public String getPropertyDetails() {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(
                cardConfig.getMsg(),
                cardConfig.getBuildVersion(),
                cardConfig.getMailDetails(),
                cardConfig.getActiveBranches());
        try {
            return objectWriter.writeValueAsString(properties);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
