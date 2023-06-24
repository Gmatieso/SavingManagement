package net.saving.savingmanagement.controller;

import net.saving.savingmanagement.exception.ResourceNotFoundException;
import net.saving.savingmanagement.model.Customer;
import net.saving.savingmanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    //build create customer REST API
    @PostMapping
    public Customer createEmployee(@RequestBody Customer customer) {
        //returns saved customer object
        return customerRepository.save(customer);
    }

    //build get customer by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with id:" + id));
        return ResponseEntity.ok(customer);
    }

    //build update customer REST API
    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody Customer customerDetails) {
        Customer updateCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with id:" + id));
        updateCustomer.setName(customerDetails.getName());
        updateCustomer.setPhoneNumber(customerDetails.getPhoneNumber());
        updateCustomer.setEmailId(customerDetails.getEmailId());
        updateCustomer.setMemberNumber(customerDetails.getMemberNumber());

        //save this object to the database
        customerRepository.save(updateCustomer);
        //return updated info to the client
        return ResponseEntity.ok(updateCustomer);
    }

    // build delete Customer   REST API
    @DeleteMapping("{id}")
    public  ResponseEntity<HttpStatus> deleteCustomer(@PathVariable  long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Customer does not exist with id:" + id));
        //delete employee details frm the database
        customerRepository.delete(customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
