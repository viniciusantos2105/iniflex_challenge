package com.iniflex.services;

import com.iniflex.entities.Employee;
import com.iniflex.view.EmployeeView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static com.iniflex.utils.Constants.*;
import static java.util.stream.Collectors.groupingBy;

public class EmployeeService {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    private final EmployeeView employeeView;

    public EmployeeService(EmployeeView employeeView) {
        this.employeeView = employeeView;
    }

    public void removeEmployee(List<Employee> employeeList, String employeeName){
        employeeList.removeIf(employee -> employee.getPersonName().equals(employeeName));
    }
    public void listAllEmployees(List<Employee> employeeList){
        employeeList.forEach(employeeView::printEmployee);
    }

    public void increaseSalary(List<Employee> employeeList, BigDecimal percentage){
        employeeList
                .forEach(employee -> {
                    BigDecimal increaseSalary = employee.getEmployeeSalary().multiply(percentage).divide(PERCENTAGE);
                    employee.setEmployeeSalary(employee.getEmployeeSalary().add(increaseSalary));
                });
    }

    public Map<String, List<Employee>> groupByRole(List<Employee> employeeList){
        return employeeList.stream()
                .collect(groupingBy(Employee::getEmployeeRole));
    }

    public void listEmployeesByRole(Map<String, List<Employee>> employeesByRole){
        employeesByRole.forEach((role, employees) -> {
            System.out.println("===============================");
            System.out.println(ROLE + role);
            System.out.println();
            employees.forEach(employee -> {
                System.out.println(NAME+ employee.getPersonName());
                System.out.println(BIRTH_DATE + employee.getPersonBirthDate().format(dateTimeFormatter));
                System.out.println(SALARY + numberFormat.format(employee.getEmployeeSalary()));
                System.out.println();
            });
        });
    }

    public void listEmployeesAlphabetically(List<Employee> employeesList){
        employeesList.stream()
                .sorted(Comparator.comparing(Employee::getPersonName))
                .forEach(employeeView::printEmployee);
    }

    public void oldestEmployee(List<Employee> employees){
        Employee oldestEmployee = Collections.min(employees, Comparator.comparing(Employee::getPersonBirthDate));
        long employeeAge = ChronoUnit.YEARS.between(oldestEmployee.getPersonBirthDate(), LocalDate.now());
        System.out.println(NAME + oldestEmployee.getPersonName());
        System.out.println(AGE + employeeAge);
        System.out.println();
    }

    public void listSalaries(List<Employee> employees){
        BigDecimal totalSalaries = employees.stream()
                .map(Employee::getEmployeeSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(TOTAL_SALARYS + numberFormat.format(totalSalaries));
    }

    public void listEmployeesBornIn(List<Employee> employees, int... months){
        for(Employee employee : employees){
           for (int month : months){
              if(employee.getPersonBirthDate().getMonthValue() == month){
                 System.out.println(NAME + employee.getPersonName());
                 System.out.println(BIRTH_DATE + employee.getPersonBirthDate().format(dateTimeFormatter));
                 System.out.println();
              }
           }
        }
    }

    public void listMinimumWages(List<Employee> employees){
       for(Employee employee : employees){
          BigDecimal minimumWage = employee.getEmployeeSalary().divide(MINIMUM_SALARY, 0, RoundingMode.DOWN);
          System.out.println(NAME + employee.getPersonName());
          System.out.println(MINIMUM_WAGE + minimumWage);
          System.out.println();
       }
    }
}
