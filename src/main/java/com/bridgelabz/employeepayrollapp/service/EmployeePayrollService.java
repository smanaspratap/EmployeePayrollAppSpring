package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService {

    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    public EmployeePayrollData getEmployeePayrollDataById(long id) {
        return employeePayrollList.get((int) id);
    }

    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollData payrollData) {
        employeePayrollList.add(payrollData);
        return payrollData;
    }

    public EmployeePayrollData updateEmployeePayrollData(long id, EmployeePayrollData payrollData) {
        employeePayrollList.set((int) id, payrollData);
        return payrollData;
    }

    public String deleteEmployeePayrollData(long id) {
        employeePayrollList.remove((int) id);
        return "Employee with id " + id + " deleted successfully";
    }
}

