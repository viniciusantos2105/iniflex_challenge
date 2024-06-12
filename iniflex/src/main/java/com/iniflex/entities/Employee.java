package com.iniflex.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee extends Person{
    private BigDecimal employeeSalary;
    private String employeeRole;

    public Employee(String name, String birthDate, BigDecimal employeeSalary, String employeeRole) {
        super(name, LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        this.employeeSalary = employeeSalary;
        this.employeeRole = employeeRole;
    }

    public BigDecimal getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(BigDecimal employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }


}