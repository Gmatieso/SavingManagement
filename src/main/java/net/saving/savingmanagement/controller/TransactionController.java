package net.saving.savingmanagement.controller;

import net.saving.savingmanagement.model.Transaction;
import net.saving.savingmanagement.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
//defining a base url of all the api
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    //wiring our repository with our controller
    @Autowired
    private TransactionRepository transactionRepository;

    //GET a list of all transaction
    @GetMapping
    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }
}
