package com.iniflex.controllers;

import com.iniflex.utils.PopulateList;
import com.iniflex.entities.Employee;
import com.iniflex.services.EmployeeService;
import com.iniflex.view.EmployeeView;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import static com.iniflex.view.EmployeeView.printMenu;

public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        EmployeeView employeeView = new EmployeeView(dateTimeFormatter, numberFormat);
        this.service = new EmployeeService(employeeView);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employeeList = new PopulateList().populateList();
        while (true) {
            printMenu();
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    service.removeEmployee(employeeList, "João");
                    break;
                case 2:
                    service.listAllEmployees(employeeList);
                    break;
                case 3:
                    service.increaseSalary(employeeList, new BigDecimal("10"));
                    break;
                case 4:
                    Map<String, List<Employee>> listGroupByRole = service.groupByRole(employeeList);
                    service.listEmployeesByRole(listGroupByRole);
                    break;
                case 5:
                    service.listEmployeesBornIn(employeeList, 10, 12);
                    break;
                case 6:
                    service.oldestEmployee(employeeList);
                    break;
                case 7:
                    service.listEmployeesAlphabetically(employeeList);
                    break;
                case 8:
                    service.listSalaries(employeeList);
                    break;
                case 9:
                    service.listMinimumWages(employeeList);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente");
                    break;
            }
        }
    }
}