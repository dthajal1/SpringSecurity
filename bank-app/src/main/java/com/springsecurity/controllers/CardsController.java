package com.springsecurity.controllers;

import com.springsecurity.model.Cards;
import com.springsecurity.model.Customer;
import com.springsecurity.repositories.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CardsRepository cardsRepository;

    @PostMapping("/myCards")
    public List<Cards> getCardsDetails(@RequestBody Customer customer) {
        return cardsRepository.findByCustomerId(customer.getId());
    }
}
