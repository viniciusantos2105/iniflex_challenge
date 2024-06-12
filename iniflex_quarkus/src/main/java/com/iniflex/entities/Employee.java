package com.iniflex.entities;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Employee extends Person{

    private BigDecimal employeeSalary;
    private String employeeRole;

    public String getEmployeeSalary() {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return numberFormat.format(employeeSalary);
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
