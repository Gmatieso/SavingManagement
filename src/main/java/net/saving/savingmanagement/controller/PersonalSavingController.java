package net.saving.savingmanagement.controller;

import net.saving.savingmanagement.model.PersonalSaving;
import net.saving.savingmanagement.repository.PersonalSavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<PersonalSaving> getAllPersonalSaving() {
        return personalSavingRepository.findAll();
    }

}
