package com.employeepayrollappsetup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class EmployeePayrollAppSetUpApplication {

    public static void main(String[] args) {
       ApplicationContext context= SpringApplication.run(EmployeePayrollAppSetUpApplication.class, args);
        log.info("Employee Payroll App Started in {} Environment",context.getEnvironment().getProperty("spring.datasource.username"));
    }

}
