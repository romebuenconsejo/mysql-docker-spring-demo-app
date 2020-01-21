package com.rome.demoapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private LocalDate birthDate;

    public Person() {
    }

    public Person(Long id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthdate;
    }

    public Person(@NotNull String name,@NotNull LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
