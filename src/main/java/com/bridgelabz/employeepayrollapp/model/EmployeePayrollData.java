package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeePayrollData {

    private long id;
    private String name;
    private double salary;

    public EmployeePayrollData(long id, EmployeePayrollDTO employeePayrollDTO) {
        this.id = id;
        this.name = employeePayrollDTO.getName();
        this.salary = employeePayrollDTO.getSalary();
    }
}
