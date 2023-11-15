package com.jwt.Controoler;

import com.jwt.entity.Person;
import com.jwt.services.PersonServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {


    @Autowired
    private PersonServiceImpl personService;
    @GetMapping("/welcome")
    public String welcome(){

     return "welcome to here !!!!!!!!!!";
    }




    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Person> getPerson(){

     return personService.getAllPerson();
    }

    @GetMapping("/{personid}")
    @PreAuthorize("hasAuthority('USER')")
    public Optional<Person> gePerson(@PathVariable("personid") int personid) {

       return personService.getPerson(personid);
    }

    @PostMapping
    public Person addPerson(@Valid @RequestBody Person person) {
        Person person1 = personService.addPerson(person);
return person1;
    }
    @PutMapping
    public Person updateCourse(@Valid @RequestBody Person person) { // @valid for check validation that are mention in entity class
        return personService.updatPerson(person);
    }

    @DeleteMapping("/{personid}")
    public void deleteCourse(@PathVariable("personid") Person person) {

         personService.deletPerson(person);

    }
}
