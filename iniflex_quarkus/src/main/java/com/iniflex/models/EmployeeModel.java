package com.iniflex.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.JOINED)
public class EmployeeModel  extends PersonModel {

    @Column(name = "employee_salary")
    public BigDecimal employeeSalary;
    @Column(name = "employee_role")
    public String employeeRole;

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
