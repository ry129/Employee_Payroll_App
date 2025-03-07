package com.employeepayrollappsetup.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class EmployeePayrollDTO {


    @Pattern(regexp="[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee name is Invalid")
    @NotEmpty(message="Employee name cannot be null")
    public String name;

    @Min(value=500,message="Min Wage should be more than 500")
    public long salary;

    public EmployeePayrollDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }
    public String toString(){
        return "Name is " + name + "salary is : " + salary;
    }
}

