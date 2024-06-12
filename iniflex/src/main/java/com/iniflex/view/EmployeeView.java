package com.iniflex.view;

import com.iniflex.entities.Employee;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;

import static com.iniflex.utils.Constants.*;

public class EmployeeView {
    private final DateTimeFormatter dateTimeFormatter;
    private final NumberFormat numberFormat;

    public EmployeeView(DateTimeFormatter dateTimeFormatter, NumberFormat numberFormat) {
        this.dateTimeFormatter = dateTimeFormatter;
        this.numberFormat = numberFormat;
    }

    public void printEmployee(Employee employee) {
        System.out.println(NAME + employee.getPersonName());
        System.out.println(BIRTH_DATE + employee.getPersonBirthDate().format(dateTimeFormatter));
        System.out.println(SALARY + numberFormat.format(employee.getEmployeeSalary()));
        System.out.println(ROLE + employee.getEmployeeRole());
        System.out.println();
    }

    public static void printMenu(){
        System.out.println("===============================");
        System.out.println("Escolha uma opção:");
        System.out.println("1. Remover João");
        System.out.println("2. Imprimir funcionários");
        System.out.println("3. Aumentar salários");
        System.out.println("4. Imprimir funcionários por função");
        System.out.println("5. Imprimir aniversariantes de Outubro e Dezembro");
        System.out.println("6. Imprimir funcionário mais velho");
        System.out.println("7. Imprimir funcionários em ordem alfabética");
        System.out.println("8. Imprimir total de salários");
        System.out.println("9. Imprimir salários mínimos");
        System.out.println("0. Sair");
        System.out.println("===============================");
    }
}
