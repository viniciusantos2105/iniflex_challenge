import {EmployeeResponse} from "./EmployeeResponse";

export interface GroupByRoleResponse {
    [key: string]: EmployeeResponse[];
}