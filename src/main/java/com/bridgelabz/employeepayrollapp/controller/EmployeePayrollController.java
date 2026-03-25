package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @GetMapping("/")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        log.debug("Getting all employee payroll data");
        return new ResponseEntity<>(
                new ResponseDTO("Fetched all employees", employeePayrollService.getEmployeePayrollData()),
                HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataById(@PathVariable long id) {
        log.debug("Getting employee payroll data for id: {}", id);
        return new ResponseEntity<>(
                new ResponseDTO("Fetched employee with id: " + id, employeePayrollService.getEmployeePayrollDataById(id)),
                HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(
            @Valid @RequestBody EmployeePayrollDTO payrollDTO) {
        log.debug("Creating employee payroll data: {}", payrollDTO);
        return new ResponseEntity<>(
                new ResponseDTO("Created employee payroll data", employeePayrollService.createEmployeePayrollData(payrollDTO)),
                HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(
            @PathVariable long id,
            @Valid @RequestBody EmployeePayrollDTO payrollDTO) {
        log.debug("Updating employee payroll data for id: {}", id);
        return new ResponseEntity<>(
                new ResponseDTO("Updated employee with id: " + id, employeePayrollService.updateEmployeePayrollData(id, payrollDTO)),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable long id) {
        log.debug("Deleting employee payroll data for id: {}", id);
        return new ResponseEntity<>(
                new ResponseDTO("Deleted employee with id: " + id, employeePayrollService.deleteEmployeePayrollData(id)),
                HttpStatus.OK);
    }
}
