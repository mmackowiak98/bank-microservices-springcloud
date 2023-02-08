package com.cards.cardsmicroservice.repository;

import com.cards.cardsmicroservice.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    @Query("select c from Card c where c.customer.customerId = ?1")
    List<Card> findCardsByCustomerId(Long customerId);

}
