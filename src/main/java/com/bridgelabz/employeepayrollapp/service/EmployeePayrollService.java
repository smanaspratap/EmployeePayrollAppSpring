package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService {

    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
    private long idCounter = 1;

    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    public EmployeePayrollData getEmployeePayrollDataById(long id) {
        return employeePayrollList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO payrollDTO) {
        EmployeePayrollData data = new EmployeePayrollData(idCounter++, payrollDTO);
        employeePayrollList.add(data);
        return data;
    }

    public EmployeePayrollData updateEmployeePayrollData(long id, EmployeePayrollDTO payrollDTO) {
        EmployeePayrollData data = getEmployeePayrollDataById(id);
        if (data != null) {
            data.setName(payrollDTO.getName());
            data.setSalary(payrollDTO.getSalary());
        }
        return data;
    }

    public String deleteEmployeePayrollData(long id) {
        employeePayrollList.removeIf(e -> e.getId() == id);
        return "Employee with id " + id + " deleted successfully";
    }
}
