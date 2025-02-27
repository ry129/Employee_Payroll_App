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

public class EmployeePayrollController {
    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @RequestMapping(value = {"", "/", "get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        List<EmployeePayrollData> empList=null;
        empList=employeePayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Successfull",empList);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }

    // Get Method to get employee Data with id
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataById(@PathVariable ("empId") int empId){
        EmployeePayrollData empData=null;
        empData = employeePayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO respDTO = new ResponseDTO("Get Call For Id Successfull",empData);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }

    // Post Method to create a new employee payroll data
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addNewEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
       EmployeePayrollData empData=null;
       empData=employeePayrollService.createEmployeePayrollData(empPayrollDTO);
       ResponseDTO responseDTO=new ResponseDTO("Post Call Successfull",empData);
       return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    // Put Method to update employee payroll data
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateNewEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData=null;
        empData=employeePayrollService.updateEmployeePayrollData(empPayrollDTO);
        ResponseDTO responseDTO=new ResponseDTO("Updated Call Successfull",empData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    // Delete method to delete employee payroll data with id
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted Id : " + empId);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }


}
