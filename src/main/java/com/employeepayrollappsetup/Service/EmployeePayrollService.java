package com.employeepayrollappsetup.Service;
import com.employeepayrollappsetup.DTO.EmployeePayrollDTO;
import com.employeepayrollappsetup.model.EmployeePayrollData;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    public List<EmployeePayrollData> getEmployeePayrollData(){
        List<EmployeePayrollData> empDataList=new ArrayList<>();
        empDataList.add(new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",3000)));
     return empDataList;
    }
    public EmployeePayrollData getEmployeePayrollDataById(int empId){
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",30000));
        return empData;
    }
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData empData=null;
        empData=new EmployeePayrollData(1,employeePayrollDTO);
        return empData;
    }
    public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO){
        EmployeePayrollData empData=null;
        empData=new EmployeePayrollData(1,employeePayrollDTO);
        return empData;
    }
     public void deleteEmployeePayrollData(int empId){}


}
