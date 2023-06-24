package net.saving.savingmanagement.controller;

import net.saving.savingmanagement.model.Customer;
import net.saving.savingmanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
//defining a base url of all the api
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    //GET a list of all customers
    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    //build create customer REST API

    @PostMapping
    public Customer createEmployee(@RequestBody Customer customer){
        //returns saved customer object
        return customerRepository.save(customer);
    }

}
