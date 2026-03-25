package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    public EmployeePayrollData getEmployeePayrollDataById(long id) {
        return employeePayrollRepository.findById(id)
                .orElseThrow(() -> new EmployeePayrollException(
                        "Employee with id " + id + " not found!"));
    }

    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO payrollDTO) {
        EmployeePayrollData data = new EmployeePayrollData(payrollDTO);
        return employeePayrollRepository.save(data);
    }

    public EmployeePayrollData updateEmployeePayrollData(long id, EmployeePayrollDTO payrollDTO) {
        EmployeePayrollData data = getEmployeePayrollDataById(id);
        data.setName(payrollDTO.getName());
        data.setSalary(payrollDTO.getSalary());
        return employeePayrollRepository.save(data);
    }

    public String deleteEmployeePayrollData(long id) {
        getEmployeePayrollDataById(id); // throws if not found
        employeePayrollRepository.deleteById(id);
        return "Employee with id " + id + " deleted successfully";
    }
}
