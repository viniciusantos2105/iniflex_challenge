package com.iniflex.repositories;

import com.iniflex.models.PersonModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<PersonModel> {
}
