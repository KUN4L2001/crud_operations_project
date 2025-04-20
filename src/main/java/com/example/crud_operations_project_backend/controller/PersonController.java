package com.example.crud_operations_project_backend.controller;

import com.example.crud_operations_project_backend.dto.Person;
import com.example.crud_operations_project_backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person)
    {
        Person createdPerson = personService.createPerson(person);
        return new ResponseEntity<>(createdPerson,HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Person> findPersonById(@PathVariable String id)
    {
        Person personDB = personService.findPersonById(id);
        if(personDB != null)
        {
            return new ResponseEntity<>(personDB,HttpStatus.FOUND);
        } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePersonById(@PathVariable String id, @RequestBody Person person)
    {
        Person personDB = personService.findPersonById(id);

        if(person.getName() != null)
        {
            personDB.setName(person.getName());
        }
        if(person.getEmail() != null)
        {
            personDB.setEmail(person.getEmail());
        }
        if(person.getAge() != null)
        {
            personDB.setAge(person.getAge());
        }

        Person updatedPerson = personService.updatePerson(personDB);

        personService.updatePerson(personDB);
        return new ResponseEntity<>(personDB,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePersonById(@PathVariable String id)
    {
        Person personDB = personService.findPersonById(id);
        if(personDB != null)
        {
            personService.deletePersonById(id);
            return new ResponseEntity<>(personDB, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Person Not found with id "+id,HttpStatus.NOT_FOUND);
        }

    }
}
