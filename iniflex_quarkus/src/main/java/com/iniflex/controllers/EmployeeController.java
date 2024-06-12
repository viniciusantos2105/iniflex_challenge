package com.iniflex.controllers;

import com.iniflex.adapters.Adapter;
import com.iniflex.entities.Employee;
import com.iniflex.models.EmployeeModel;
import com.iniflex.services.EmployeeService;
import com.iniflex.vo.EmployeeMinimumWageVO;
import com.iniflex.vo.EmployeeOldestVO;
import com.iniflex.vo.TotalSalariesVO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api/employee")
@Tag(name = "Employee", description = "Controladora de funcionários")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final Adapter adapter;

    public EmployeeController(EmployeeService employeeService, Adapter adapter) {
        this.employeeService = employeeService;
        this.adapter = adapter;
    }

    private Response getResponse(List<EmployeeModel> employeeListModel) {
        List<Employee> employeeList = new ArrayList<>();
        employeeListModel.forEach(employeeModel -> {
            Employee employee = adapter.map(employeeModel, Employee.class);
            employeeList.add(employee);
        });
        return Response.status(200).entity(employeeList).build();
    }

    private Response getResponseMap(Map<String, List<EmployeeModel>> groupByRole){
        Map<String, List<Employee>> groupByRoleMap = new HashMap<>();

        for (Map.Entry<String, List<EmployeeModel>> entry : groupByRole.entrySet()) {
            List<Employee> employees = new ArrayList<>();
            for (EmployeeModel model : entry.getValue()) {
                employees.add(adapter.map(model, Employee.class));
            }
            groupByRoleMap.put(entry.getKey(), employees);
        }
        return Response.status(200).entity(groupByRoleMap).build();
    }

    @GET
    @Operation(summary = "Imprimir todos os funcionários com todas suas informações" )
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAll() {
        List<EmployeeModel> employeeListModel = employeeService.getAllEmployees();
        return getResponse(employeeListModel);
    }

    @GET
    @Operation(summary = "Imprimir a lista de funcionários por ordem alfabética.")
    @Path("/alphabetically")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listEmployeesAlphabetically(){
        List<EmployeeModel> employeeListModel = employeeService.listEmployeesAlphabetically();
        return getResponse(employeeListModel);
    }

    @GET
    @Operation(summary = "Imprimir os funcionários que fazem aniversário no mês 10 e 12")
    @Path("/bornIn")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listEmployeesBornIn(){
        List<EmployeeModel> employeeListModel = employeeService.listEmployeesBornIn();
        return getResponse(employeeListModel);
    }

    @GET
    @Operation(summary = "Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade")
    @Path("/oldest")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOldestEmployee(){
       EmployeeOldestVO employeeOldestVO = employeeService.getOldestEmployee();
        return Response.status(200).entity(employeeOldestVO).build();
    }

    @GET
    @Operation(summary = "Imprimir o total dos salários dos funcionários.")
    @Path("/salaries")
    @Produces(MediaType.APPLICATION_JSON)
    public Response totalSalaries(){
        TotalSalariesVO totalSalariesVO = employeeService.getTotalSalaries();
        return Response.status(200).entity(totalSalariesVO).build();
    }

    @GET
    @Operation(summary = "Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo ")
    @Path("/minimumWages")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listMinimumWages(){
        List<EmployeeMinimumWageVO> employeeListModel = employeeService.listMinimumWages();
        return Response.status(200).entity(employeeListModel).build();
    }

    @GET
    @Operation(summary = "Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”")
    @Path("/groupByRole")
    @Produces(MediaType.APPLICATION_JSON)
    public Response groupByRole(){
        Map<String, List<EmployeeModel>> groupByRole = employeeService.groupByRole();
        return getResponseMap(groupByRole);
    }

    @PUT
    @Operation(summary = "Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor" )
    @Produces(MediaType.APPLICATION_JSON)
    public Response increaseSalary(){
        List<EmployeeModel> employeeListModel = employeeService.increaseSalary(new BigDecimal(10));
        return getResponse(employeeListModel);
    }

    @DELETE
    @Operation(summary = "Remover o funcionário “João” da lista" )
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeEmployee(){
        employeeService.removeEmployee("João");
        return Response.status(200).build();
    }
}
