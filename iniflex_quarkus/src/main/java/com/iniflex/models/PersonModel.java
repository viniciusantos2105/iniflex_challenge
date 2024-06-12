package com.iniflex.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonModel extends PanacheEntityBase {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long personId;
    @Column(name = "person_name")
    public String personName;
    @Column(name = "person_birth_date")
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

    public LocalDate getPersonBirthDate() {
       return personBirthDate;
    }

    public void setPersonBirthDate(LocalDate personBirthDate) {
        this.personBirthDate = personBirthDate;
    }
}
