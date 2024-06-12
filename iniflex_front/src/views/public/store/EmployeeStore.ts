import {EmployeeResponse} from "@/services/response/EmployeeResponse.ts";
import {defineStore} from "pinia";
import {EmployeeService} from "@/services/EmployeeService.ts";
import {showToast} from "@/utils/showToast.ts";
import {EmployeeOldestVO} from "@/services/response/EmployeeOldestVO.ts";
import {EmployeeMinimumWageVO} from "@/services/response/EmployeeMinimumWageVO.ts";
import {TotalSalariesVO} from "@/services/response/TotalSalariesVO.ts";
import {GroupByRoleResponse} from "@/services/response/GroupByRoleResponse.ts";
export const employeeService = new EmployeeService();
export const employeeStore = defineStore({
    id: 'employee',
    state: (): employee => ({
        listEmployees: [],
        listOldestSelected: [],
        listMinimumWages: [],
        listGroupBy: [],
        allSalaries: {} as TotalSalariesVO,
        employeeOldestSelected: {} as EmployeeOldestVO
    }),
    actions: {
        async listAll(){
            this.listEmployees = await employeeService.listAll();
        },
        async listEmployeesAlphabetically(){
            this.listEmployees = await employeeService.listEmployeesAlphabetically();
            showToast("Lista ordenada com sucesso", "success");
        },
        async listEmployeesBornIn(){
          this.listEmployees = await employeeService.listEmployeesBornIn();
          showToast("Aniversariantes selecionados com sucesso", "success");
        },
        async listAllMinimumWages(){
           this.listMinimumWages = await employeeService.listMinimumWages();
        },
        async totalSalaries(){
          this.allSalaries = await employeeService.totalSalaries();
        },
        async getOldestEmployee(){
            this.employeeOldestSelected = await employeeService.getOldestEmployee();
        },
        async removeEmployee(){
            await employeeService.removeEmployee();
            await this.listAll();
            showToast("Funcionario removido com sucesso", "success");
        },
        async increaseSalary(){
            await employeeService.increaseSalary();
            await this.listAll();
            showToast("Salario aumentado com sucesso", "success");
        },
        async groupByRole(){
            this.listGroupBy = await employeeService.groupByRole();
        }
    }

})

interface employee{
    listEmployees: EmployeeResponse[];
    listOldestSelected: EmployeeOldestVO[];
    listMinimumWages: EmployeeMinimumWageVO[];
    allSalaries: TotalSalariesVO;
    employeeOldestSelected: EmployeeOldestVO;
    listGroupBy: GroupByRoleResponse[];
}