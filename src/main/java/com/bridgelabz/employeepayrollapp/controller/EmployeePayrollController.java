package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping("/")
    public ResponseEntity<List<EmployeePayrollData>> getEmployeePayrollData() {
        return new ResponseEntity<>(employeePayrollService.getEmployeePayrollData(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeePayrollData> getEmployeePayrollDataById(@PathVariable long id) {
        return new ResponseEntity<>(employeePayrollService.getEmployeePayrollDataById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeePayrollData> addEmployeePayrollData(
            @Valid @RequestBody EmployeePayrollDTO payrollDTO) {
        return new ResponseEntity<>(employeePayrollService.createEmployeePayrollData(payrollDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeePayrollData> updateEmployeePayrollData(
            @PathVariable long id,
            @Valid @RequestBody EmployeePayrollDTO payrollDTO) {
        return new ResponseEntity<>(employeePayrollService.updateEmployeePayrollData(id, payrollDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable long id) {
        return new ResponseEntity<>(employeePayrollService.deleteEmployeePayrollData(id), HttpStatus.OK);
    }
}
