package net.saving.savingmanagement.controller;

import net.saving.savingmanagement.model.Transaction;
import net.saving.savingmanagement.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //build create transaction REST API
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction){
        //return saved transaction object
        return transactionRepository.save(transaction);
    }

}
