package com.springsecurity.controllers;

import com.springsecurity.model.AccountTransactions;
import com.springsecurity.model.Customer;
import com.springsecurity.repositories.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;

    @PostMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestBody Customer customer) {
        return accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(customer.getId());
    }
}
