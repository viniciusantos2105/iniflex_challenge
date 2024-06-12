package com.iniflex.entities;

import java.time.LocalDate;
public class Person {
    private String personName;
    private LocalDate personBirthDate;

    public Person(String personName, LocalDate personBirthDate) {
        this.personName = personName;
        this.personBirthDate = personBirthDate;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public LocalDate getPersonBirthDate() {
        return personBirthDate;
    }

    public void setPersonBirthDate(LocalDate personBirthDate) {
        this.personBirthDate = personBirthDate;
    }
}