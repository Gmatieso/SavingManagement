package net.saving.savingmanagement.controller;


import net.saving.savingmanagement.exception.ResourceNotFoundException;
import net.saving.savingmanagement.model.Saving;
import net.saving.savingmanagement.repository.CustomerRepository;
import net.saving.savingmanagement.repository.SavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
//defining a base url of all the api
@RequestMapping("/api/v1/saving")
public class SavingController {

    @Autowired
    private SavingRepository savingRepository;

    //GET a list of all savings
    @GetMapping
    public List<Saving> getAllSaving() {
        return  savingRepository.findAll();
    }

    //build create saving REST API
    @PostMapping
    public  Saving createSaving(@RequestBody Saving saving){
        //return  saved saving object
        return  savingRepository.save(saving);
    }

    //build get saving by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Saving> getSavingById(@PathVariable long id) {
        Saving saving = savingRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Saving does not exist with id:" + id));
                return  ResponseEntity.ok(saving);
    }
}
