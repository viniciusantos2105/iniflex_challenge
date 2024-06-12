import {EmployeeResponse} from "./response/EmployeeResponse";
import {http} from "./api/axiosConfig";
import {EmployeeOldestVO} from "./response/EmployeeOldestVO";
import {TotalSalariesVO} from "./response/TotalSalariesVO";
import {EmployeeMinimumWageVO} from "./response/EmployeeMinimumWageVO";
import {GroupByRoleResponse} from "./response/GroupByRoleResponse";

export class EmployeeService{


        public async listAll():Promise<EmployeeResponse[]>{
            try{
                const {data} = await http.get('/employee');
                return data;
            }catch(error:any){
                throw error;
            }
        }

        public async listEmployeesAlphabetically():Promise<EmployeeResponse[]>{
            try{
                const {data} = await http.get('/employee/alphabetically');
                return data;
            }catch(error:any){
                throw error;
            }
        }

        public async listEmployeesBornIn():Promise<EmployeeResponse[]>{
            try{
                const {data} = await http.get('/employee/bornIn');
                return data;
            }catch(error:any){
                throw error;
            }
        }

        public async getOldestEmployee():Promise<EmployeeOldestVO>{
            try {
                const {data} = await http.get('/employee/oldest');
                return data;
            }catch (error:any){
                throw error;
            }
        }

        public async totalSalaries():Promise<TotalSalariesVO>{
            try {
                const {data} = await http.get('/employee/salaries');
                return data;
            }catch (error:any){
                throw error;
            }
        }

        public async listMinimumWages():Promise<EmployeeMinimumWageVO[]>{
            try{
                const {data} = await http.get('/employee/minimumWages');
                return data;
            }catch (error:any){
                throw error;
            }
        }

    public async groupByRole(): Promise<GroupByRoleResponse[]> {
        try {
            const { data } = await http.get('/employee/groupByRole');
            return data;
        } catch (error: any) {
            throw error;
        }
    }

    public async increaseSalary(): Promise<EmployeeResponse>{
        try {
            const { data } = await http.put('/employee');
            return data;
        }catch (error:any){
            throw error;
        }
    }

    public async removeEmployee(): Promise<void>{
        try {
            await http.delete('/employee');
        }catch (error:any){
            throw error;
        }
    }
}