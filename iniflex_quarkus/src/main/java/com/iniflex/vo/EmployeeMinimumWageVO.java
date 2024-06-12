package com.iniflex.vo;

import java.math.BigDecimal;

public class EmployeeMinimumWageVO {

    private String employeeName;
    private BigDecimal employeeSalary;

    public EmployeeMinimumWageVO(String employeeName, BigDecimal employeeSalary) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public BigDecimal getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(BigDecimal employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
}
