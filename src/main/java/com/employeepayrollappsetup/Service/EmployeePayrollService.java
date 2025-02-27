package com.employeepayrollappsetup.Service;
import com.employeepayrollappsetup.DTO.EmployeePayrollDTO;
import com.employeepayrollappsetup.model.EmployeePayrollData;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    private List<EmployeePayrollData>employeePayrollList=new ArrayList<>();
    public List<EmployeePayrollData> getEmployeePayrollData(){
        return employeePayrollList;
    }
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollList.get(empId-1);
    }
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData empData=null;
        empData=new EmployeePayrollData(employeePayrollList.size()+1,employeePayrollDTO);
        return empData;
    }
    public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData empData=this.getEmployeePayrollDataById(empId);
        empData.setName(employeePayrollDTO.name);
        empData.setSalary(employeePayrollDTO.salary);
      employeePayrollList.set(empId-1,empData);
        return empData;
    }
     public void deleteEmployeePayrollData(int empId){
        employeePayrollList.remove(empId-1);
     }


}
