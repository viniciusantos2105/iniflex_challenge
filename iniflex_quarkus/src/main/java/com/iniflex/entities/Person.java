package com.iniflex.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {

    public Long personId;
    public String personName;
    public LocalDate personBirthDate;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonBirthDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return personBirthDate.format(formatter);
    }

    public void setPersonBirthDate(LocalDate personBirthDate) {
        this.personBirthDate = personBirthDate;
    }
}
