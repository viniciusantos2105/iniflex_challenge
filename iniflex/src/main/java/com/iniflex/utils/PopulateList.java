package com.iniflex.utils;


import com.iniflex.entities.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PopulateList {

    public List<Employee> populateList(){
        String operador = "Operador";
        String gerente = "Gerente";
        return new ArrayList<>(List.of(
                new Employee("Maria", "18/10/2000", new BigDecimal("2009.44"), operador),
                new Employee("João", "12/05/1990", new BigDecimal("2284.38"), operador),
                new Employee("Caio", "02/05/1961", new BigDecimal("9836.14"), "Coordenador"),
                new Employee("Miguel", "14/10/1988", new BigDecimal("19199.88"), "Diretor"),
                new Employee("Alice", "05/01/1995", new BigDecimal("2234.68"), "Recepcionista"),
                new Employee("Heitor", "19/11/1999", new BigDecimal("1582.72"), operador),
                new Employee("Arthur", "31/03/1993", new BigDecimal("4071.84"), "Contador"),
                new Employee("Laura", "08/07/1994", new BigDecimal("3017.45"), gerente),
                new Employee("Heloísa", "24/05/2003", new BigDecimal("1606.85"), "Eletricista"),
                new Employee("Helena", "02/09/1996", new BigDecimal("2799.93"), gerente)
        ));
    }

}
