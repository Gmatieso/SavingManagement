package net.saving.savingmanagement.controller;

import net.saving.savingmanagement.exception.ResourceNotFoundException;
import net.saving.savingmanagement.model.Transaction;
import net.saving.savingmanagement.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    //build get Transaction by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable long id){
        Transaction transaction = transactionRepository.findById(id)
                //throw and exception if id not  found
                .orElseThrow(()-> new ResourceNotFoundException("Transaction does not exist with id:" + id));
        return  ResponseEntity.ok(transaction);
    }

    //build update transaction REST API
    @PutMapping("{id}")
    public  ResponseEntity<Transaction> updateTransation(@PathVariable long id, @RequestBody Transaction transactionDetails){
        Transaction updateTransaction = transactionRepository.findById(id)
                //throw exception if id not found
                .orElseThrow(()-> new ResourceNotFoundException("Transaction does not exist with id:" + id));
        //else update transaction if id is found
        updateTransaction.setTransactionDate(transactionDetails.getTransactionDate());
        updateTransaction.setPaymentMethod(transactionDetails.getPaymentMethod());
        updateTransaction.setAmount(transactionDetails.getAmount());

        //save this object to the database
        transactionRepository.save(updateTransaction);
        //retrun updated info to the client
        return ResponseEntity.ok(updateTransaction);
    }

}
