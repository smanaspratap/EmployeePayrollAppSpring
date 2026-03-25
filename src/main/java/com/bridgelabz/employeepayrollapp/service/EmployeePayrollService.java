package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    public List<EmployeePayrollData> getEmployeePayrollData() {
        log.info("Fetching all employees from DB");
        return employeePayrollRepository.findAll();
    }

    public EmployeePayrollData getEmployeePayrollDataById(long id) {
        log.info("Fetching employee with id: {}", id);
        return employeePayrollRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Employee with id {} not found!", id);
                    return new EmployeePayrollException("Employee with id " + id + " not found!");
                });
    }

    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO payrollDTO) {
        EmployeePayrollData data = new EmployeePayrollData(payrollDTO);
        log.info("Saving new employee: {}", data);
        return employeePayrollRepository.save(data);
    }

    public EmployeePayrollData updateEmployeePayrollData(long id, EmployeePayrollDTO payrollDTO) {
        EmployeePayrollData data = getEmployeePayrollDataById(id);
        log.info("Updating employee id {} with data: {}", id, payrollDTO);
        data.setName(payrollDTO.getName());
        data.setSalary(payrollDTO.getSalary());
        return employeePayrollRepository.save(data);
    }

    public String deleteEmployeePayrollData(long id) {
        getEmployeePayrollDataById(id);
        log.info("Deleting employee with id: {}", id);
        employeePayrollRepository.deleteById(id);
        return "Employee with id " + id + " deleted successfully";
    }
}
