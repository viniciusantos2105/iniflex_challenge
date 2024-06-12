package com.iniflex.services;

import com.iniflex.models.EmployeeModel;
import com.iniflex.repositories.EmployeeRepository;
import com.iniflex.vo.EmployeeMinimumWageVO;
import com.iniflex.vo.EmployeeOldestVO;
import com.iniflex.vo.TotalSalariesVO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.iniflex.utils.Constants.MINIMUM_SALARY;
import static com.iniflex.utils.Constants.PERCENTAGE;
import static java.util.stream.Collectors.groupingBy;

@ApplicationScoped
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Inject
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.listAll();
    }

    public List<EmployeeModel> listEmployeesAlphabetically(){
        return employeeRepository.listEmployeesAlphabetically();
    }

    public List<EmployeeModel> listEmployeesBornIn(){
        return employeeRepository.listEmployeesBornIn();
    }

    public EmployeeOldestVO getOldestEmployee(){
        EmployeeModel employeeModel = employeeRepository.getOldestEmployee();
        long employeeAge = ChronoUnit.YEARS.between(employeeModel.getPersonBirthDate(), LocalDate.now());
        return new EmployeeOldestVO(employeeModel.getPersonName(), (int) employeeAge);
    }

    public TotalSalariesVO getTotalSalaries(){
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        List<EmployeeModel> employeeList = employeeRepository.listAll();
        BigDecimal totalSalaries = employeeList.stream()
                .map(EmployeeModel::getEmployeeSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new TotalSalariesVO(numberFormat.format(totalSalaries));
    }

    public List<EmployeeMinimumWageVO> listMinimumWages(){
        List<EmployeeModel> employeeList = employeeRepository.listAll();
        List<EmployeeMinimumWageVO> employeeMinimumWageVOList = new ArrayList<>();
        for(EmployeeModel employee : employeeList){
            BigDecimal minimumWage = employee.getEmployeeSalary().divide(MINIMUM_SALARY, 0, RoundingMode.DOWN);
             employeeMinimumWageVOList.add(new EmployeeMinimumWageVO(employee.getPersonName(), minimumWage));
        }
        return employeeMinimumWageVOList;
    }

    public Map<String, List<EmployeeModel>> groupByRole(){
        List<EmployeeModel> employeeList = employeeRepository.listAll();
        return employeeList.stream()
                .collect(groupingBy(EmployeeModel::getEmployeeRole));
    }

    @Transactional
    public List<EmployeeModel> increaseSalary(BigDecimal percentage){
        List<EmployeeModel> employeeList = employeeRepository.listAll();
        employeeList
                .forEach(employee -> {
                    BigDecimal increaseSalary = employee.getEmployeeSalary().multiply(percentage).divide(PERCENTAGE);
                    employee.setEmployeeSalary(employee.getEmployeeSalary().add(increaseSalary));
                    employeeRepository.persistAndFlush(employee);
                });
        return employeeList;
    }

    @Transactional
    public void removeEmployee(String personName){
        employeeRepository.removeByName(personName);
    }
}