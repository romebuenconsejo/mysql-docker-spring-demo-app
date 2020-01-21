package com.rome.demoapp;

import com.rome.demoapp.domain.Person;
import com.rome.demoapp.repository.PersonRepository;
import com.rome.demoapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class DemoAppApplication {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoAppApplication.class, args);
    }

    @PostConstruct
    public void checkIfWorkd() {
        personRepository.deleteAll();

        personService.create(new Person("Duke", LocalDate.of(2006,10,1)));
        personService.create(new Person("Forrest", LocalDate.of(1999,5,15)));

        List<Person> findAll = personService.findAll();
        for(Person person: findAll) {
            System.out.println(person.getId()+":"+person.getName());
        }
    }

}
