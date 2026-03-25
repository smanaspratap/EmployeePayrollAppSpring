package com.bridgelabz.employeepayrollapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayrollData {
    private long id;
    private String name;
    private double salary;
}
