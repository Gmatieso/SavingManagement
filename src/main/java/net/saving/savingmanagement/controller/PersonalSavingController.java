package net.saving.savingmanagement.controller;

import net.saving.savingmanagement.exception.ResourceNotFoundException;
import net.saving.savingmanagement.model.PersonalSaving;
import net.saving.savingmanagement.repository.PersonalSavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @PostMapping
    public  PersonalSaving createPersonalSaving(@RequestBody PersonalSaving personalSaving){
        //returns saved personalSaving object
        return  personalSavingRepository.save(personalSaving);
    }

    //build get personalSaving by id REST API
    @GetMapping("{id}")
    public ResponseEntity<PersonalSaving> getPersonalSavingById(@PathVariable long id){
        PersonalSaving personalSaving = personalSavingRepository.findById(id)
                //throw an exception if id not found
                .orElseThrow(()-> new ResourceNotFoundException("Personal Saving does not exist with id:" + id));
        return  ResponseEntity.ok(personalSaving);
    }

    //build update personalSaving REST API
    @PutMapping("{id}")
    public  ResponseEntity<PersonalSaving> updatePersonalSaving(@PathVariable long id, @RequestBody PersonalSaving personalSavingDetails) {
        PersonalSaving updatePersonalSaving = personalSavingRepository.findById(id)
                //throw and exception if id not found
                .orElseThrow(()-> new ResourceNotFoundException("Personal Saving does not exit with id:" + id));
        //else update customer if id is found
        updatePersonalSaving.setName(personalSavingDetails.getName());
        updatePersonalSaving.setTotalSavings(personalSavingDetails.getTotalSavings());

        //save this object to the database
        personalSavingRepository.save(updatePersonalSaving);
        //return updated info to the client
        return ResponseEntity.ok(updatePersonalSaving);
    }


}
