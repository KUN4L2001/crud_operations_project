package com.example.crud_operations_project_backend.service;

import com.example.crud_operations_project_backend.dao.PersonDao;
import com.example.crud_operations_project_backend.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public List<Person> getAllPerson() {
        return personDao.getAllPerson();
    }

    public Person createPerson(Person person) {
        personDao.createPerson(person);
        return person;
    }

    public Person findPersonById(String id) {
        return personDao.findPersonById(id);
    }

    public Person updatePerson(Person updatedPerson) {
        personDao.updatePerson(updatedPerson);
        return updatedPerson;
    }

    public void deletePersonById(String id) {
        personDao.deletePersonById(id);
    }
}
