package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        return new ResponseEntity<>(
                new ResponseDTO("Fetched all employees", employeePayrollService.getEmployeePayrollData()),
                HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataById(@PathVariable long id) {
        return new ResponseEntity<>(
                new ResponseDTO("Fetched employee with id: " + id, employeePayrollService.getEmployeePayrollDataById(id)),
                HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(
            @Valid @RequestBody EmployeePayrollDTO payrollDTO) {
        return new ResponseEntity<>(
                new ResponseDTO("Created employee payroll data", employeePayrollService.createEmployeePayrollData(payrollDTO)),
                HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(
            @PathVariable long id,
            @Valid @RequestBody EmployeePayrollDTO payrollDTO) {
        return new ResponseEntity<>(
                new ResponseDTO("Updated employee with id: " + id, employeePayrollService.updateEmployeePayrollData(id, payrollDTO)),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable long id) {
        return new ResponseEntity<>(
                new ResponseDTO("Deleted employee with id: " + id, employeePayrollService.deleteEmployeePayrollData(id)),
                HttpStatus.OK);
    }
}
