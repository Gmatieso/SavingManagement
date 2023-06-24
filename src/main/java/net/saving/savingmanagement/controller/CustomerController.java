package net.saving.savingmanagement.controller;

import net.saving.savingmanagement.model.Customer;
import net.saving.savingmanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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
}
