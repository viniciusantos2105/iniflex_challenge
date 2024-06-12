package com.iniflex.repositories;

import com.iniflex.models.EmployeeModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

import static com.iniflex.utils.Constants.MOUNTH_TEN;
import static com.iniflex.utils.Constants.MOUNTH_TWELVE;

@ApplicationScoped
public class EmployeeRepository implements PanacheRepository<EmployeeModel> {

    @PersistenceContext
    private EntityManager entityManager;

    public void removeByName(String personName){
        Query query = entityManager.createQuery("DELETE FROM EmployeeModel  e " +
                "WHERE lower(e.personName) = lower(:personName) ");
        query.setParameter("personName", personName);
        query.executeUpdate();
    }

    public List<EmployeeModel>listEmployeesAlphabetically(){
       TypedQuery<EmployeeModel> query = entityManager.createQuery("SELECT e FROM EmployeeModel e ORDER BY e.personName ASC", EmployeeModel.class);
       return query.getResultList();
    }

    public List<EmployeeModel> listEmployeesBornIn(){
        TypedQuery<EmployeeModel> query = entityManager.createQuery("SELECT e FROM EmployeeModel e " +
                "WHERE EXTRACT(MONTH FROM e.personBirthDate) = :mounthTen " +
                "OR  EXTRACT(MONTH FROM e.personBirthDate) = :mounthTwelve", EmployeeModel.class);
        query.setParameter("mounthTen", MOUNTH_TEN);
        query.setParameter("mounthTwelve", MOUNTH_TWELVE);
        return query.getResultList();
    }

    public EmployeeModel getOldestEmployee(){
        TypedQuery<EmployeeModel> query = entityManager.createQuery("SELECT e FROM EmployeeModel e " +
                "ORDER BY e.personBirthDate ASC", EmployeeModel.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
