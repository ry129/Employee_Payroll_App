package com.employeepayrollappsetup.controller;
import com.employeepayrollappsetup.DTO.EmployeePayrollDTO;
import com.employeepayrollappsetup.DTO.ResponseDTO;

import com.employeepayrollappsetup.Service.IEmployeePayrollService;
import com.employeepayrollappsetup.model.EmployeePayrollData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")  // Add a base URL for all methods
public class EmployeePayrollController {
    @Autowired
    private IEmployeePayrollService employeePayrollService;

    // GET all employees
    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        List<EmployeePayrollData> empList= employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", empList);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    // GET employee by ID
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataById(@PathVariable("empId") int empId){
        EmployeePayrollData empData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO respDTO = new ResponseDTO("Get Call For Id Successful", empData);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }

    // POST create employee
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addNewEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Post Call Successful", empData);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // PUT update employee
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateNewEmployeePayrollData(@PathVariable("empId") int empId, @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = employeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Call Successful", empData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // DELETE employee
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted Id: " + empId);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }
}
