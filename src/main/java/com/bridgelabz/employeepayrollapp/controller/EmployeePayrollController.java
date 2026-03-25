package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    @GetMapping("/")
    public ResponseEntity<List<EmployeePayrollData>> getEmployeePayrollData() {
        return new ResponseEntity<>(employeePayrollList, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeePayrollData> getEmployeePayrollDataById(@PathVariable long id) {
        return new ResponseEntity<>(employeePayrollList.get((int) id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeePayrollData> addEmployeePayrollData(
            @RequestBody EmployeePayrollData payrollData) {
        employeePayrollList.add(payrollData);
        return new ResponseEntity<>(payrollData, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeePayrollData> updateEmployeePayrollData(
            @PathVariable long id,
            @RequestBody EmployeePayrollData payrollData) {
        employeePayrollList.set((int) id, payrollData);
        return new ResponseEntity<>(payrollData, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable long id) {
        employeePayrollList.remove((int) id);
        return new ResponseEntity<>("Employee with id " + id + " deleted", HttpStatus.OK);
    }
}
