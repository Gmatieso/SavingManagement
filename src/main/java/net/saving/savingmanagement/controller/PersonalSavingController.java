package net.saving.savingmanagement.controller;

import net.saving.savingmanagement.model.PersonalSaving;
import net.saving.savingmanagement.repository.PersonalSavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
//defining a base url of all the api
@RequestMapping("/api/v1/personalsaving")
public class PersonalSavingController {
    //wiring our repository with our controller
    @Autowired
    private PersonalSavingRepository personalSavingRepository;

    //GET a list of all personalsaving
    @GetMapping
    public List<PersonalSaving> getAllPersonalSaving() {
        return personalSavingRepository.findAll();
    }

    //build create PersonalSaving  REST API
    public  PersonalSaving createPersonalSaving(@RequestBody PersonalSaving personalSaving){
        //returns saved personalSaving object
        return  personalSavingRepository.save(personalSaving);
    }

}
