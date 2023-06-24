package net.saving.savingmanagement.controller;


import net.saving.savingmanagement.model.Saving;
import net.saving.savingmanagement.repository.CustomerRepository;
import net.saving.savingmanagement.repository.SavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
