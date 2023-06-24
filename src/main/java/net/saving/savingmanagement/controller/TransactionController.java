package net.saving.savingmanagement.controller;

import net.saving.savingmanagement.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
//defining a base url of all the api
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    //wiring our repository with our controller
    @Autowired
    private TransactionRepository transactionRepository;
}
