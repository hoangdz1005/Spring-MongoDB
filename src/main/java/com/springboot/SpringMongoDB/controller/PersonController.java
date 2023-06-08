package com.springboot.SpringMongoDB.controller;

import com.springboot.SpringMongoDB.model.Person;
import com.springboot.SpringMongoDB.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;
    @GetMapping("/persons")
    public ResponseEntity<?> getAllPersons() {
        return ResponseEntity.status(HttpStatus.OK).body(personRepository.findAll());
    }
    @GetMapping("/persons/{firstname}")
    public ResponseEntity<?> getPersonsByFirstname(@PathVariable(name = "firstname") String firstname) {
        return ResponseEntity.status(HttpStatus.OK).body(personRepository.findByFirstname(firstname));
    }
    @PostMapping("/persons")
    public ResponseEntity<?> createPerson(@RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personRepository.save(person));
    }
    @GetMapping("/persons/address")
    public ResponseEntity<?> getPersonByAddress(@RequestParam String address) {
        return ResponseEntity.status(HttpStatus.OK).body(personRepository.findPersonByAddress(address));
    }
    @GetMapping("/persons/age")
    public ResponseEntity<?> getPersonByAgeRange(@RequestParam(name = "minAge") int minAge, @RequestParam(name = "maxAge") int maxAge) {
        return ResponseEntity.status(HttpStatus.OK).body(personRepository.findByAgeRange(minAge, maxAge));
    }
}
