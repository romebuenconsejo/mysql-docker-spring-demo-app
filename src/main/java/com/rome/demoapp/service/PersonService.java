package com.rome.demoapp.service;

import com.rome.demoapp.domain.Person;
import com.rome.demoapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person findByID(Long id) {
        return personRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Person not found with id: "+id));
    }

    public List<Person> findAll() {
        List<Person> people = new ArrayList<>();
        Iterator<Person> iterator = personRepository.findAll().iterator();
        iterator.forEachRemaining(people::add);
        return people;
    }

    public void delete(Person person) {
        personRepository.delete(person);
    }


}
