package com.employeepayrollappsetup.Service;

import com.employeepayrollappsetup.DTO.EmployeePayrollDTO;
import com.employeepayrollappsetup.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollData(int empId);
}
