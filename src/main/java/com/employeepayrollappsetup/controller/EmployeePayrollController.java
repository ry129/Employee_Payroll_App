package com.employeepayrollappsetup.controller;
import com.employeepayrollappsetup.DTO.EmployeePayrollDTO;
import com.employeepayrollappsetup.DTO.ResponseDTO;
import com.employeepayrollappsetup.model.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController

public class EmployeePayrollController {

    @RequestMapping(value = {"", "/", "get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(){
        EmployeePayrollData empData=null;
        empData=new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",30000));
        ResponseDTO respDTO = new ResponseDTO("Get Call Successfull",empData);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }

    // Get Method to get employee Data with id
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollDataById(@PathVariable ("empId") int empId){
        EmployeePayrollData empData=null;
        empData = new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",30000));
        ResponseDTO respDTO = new ResponseDTO("Get Call For Id Successfull",empData);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }

    // Post Method to create a new employee payroll data
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addNewEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
       EmployeePayrollData empData=null;
       empData=new EmployeePayrollData(1,empPayrollDTO);
       ResponseDTO responseDTO=new ResponseDTO("Post Call Successfull",empData);
       return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    // Put Method to update employee payroll data
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateNewEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData=null;
        empData=new EmployeePayrollData(1,empPayrollDTO);
        ResponseDTO responseDTO=new ResponseDTO("Updated Call Successfull",empData);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    // Delete method to delete employee payroll data with id
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted Id : " + empId);
        return new ResponseEntity<>(respDTO, HttpStatus.OK);
    }


}
