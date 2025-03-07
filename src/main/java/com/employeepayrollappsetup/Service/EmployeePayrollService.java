package com.employeepayrollappsetup.Service;

import com.employeepayrollappsetup.DTO.EmployeePayrollDTO;
import com.employeepayrollappsetup.model.EmployeePayrollData;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    // ✅ Get All Employees
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    // ✅ Get Employee By ID (With Validation)
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        if (empId <= 0 || empId > employeePayrollList.size()) {
            throw new RuntimeException("Employee with ID " + empId + " not found");
        }
        return employeePayrollList.get(empId - 1);
    }

    // ✅ Create New Employee
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = new EmployeePayrollData(employeePayrollList.size() + 1, employeePayrollDTO);
        employeePayrollList.add(empData);
        return empData;
    }

    // ✅ Update Employee (With Validation)
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        if (empData != null) {
            empData.setName(employeePayrollDTO.name);
            empData.setSalary(employeePayrollDTO.salary);
            employeePayrollList.set(empId - 1, empData);
        }
        return empData;
    }

    // ✅ Delete Employee (With Validation)
    public void deleteEmployeePayrollData(int empId) {
        if (empId <= 0 || empId > employeePayrollList.size()) {
            throw new RuntimeException("Employee with ID " + empId + " not found");
        }
        employeePayrollList.remove(empId - 1);
    }
}

