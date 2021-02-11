package com.ganesh.swagger.controller;

/*
 * @created: 11/02/2021 - 4:14 PM
 * @author: Ganesh
 */


import com.ganesh.swagger.model.Employee;
import com.ganesh.swagger.repository.TestEmployeeDB;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final TestEmployeeDB testEmployeeDB;

    private final static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/getEmployees")
    public List<Employee> getAllEmployees(){
        logger.info("-----INFO-----: "+ "getAllEmployees()");
        return testEmployeeDB.getAllEmployeeDetails();
    }

    @GetMapping("/getEmployee/{employeeName}")
    public Employee getEmployeeByName(@PathVariable String employeeName){

        logger.info("-----INFO-----: "+ "--getEmployeeByName()-- :"+ "By: "+ employeeName.toLowerCase());
        Employee emp = testEmployeeDB.getAllEmployeeDetails()
                .stream()
                .filter(name -> name.getEmployeeName().equalsIgnoreCase(employeeName))
                .collect(Collectors.toList()).get(0);
        return emp;
    }

    @GetMapping("/getByCountry/{countryName}")
    public List<Employee> getEmployeeByCountry(@PathVariable String countryName){

        logger.info("-----INFO-----: "+ "--getEmployeeByCountry()-- :"+ "By: "+ countryName.toLowerCase());

        List<Employee> getEmpByCountry = testEmployeeDB.getAllEmployeeDetails()
                .stream()
                .filter(name -> name.getCountry().equalsIgnoreCase(countryName))
                .collect(Collectors.toList());
        return getEmpByCountry;
    }


    @GetMapping("/getByProfile/{profile}")
    public List<Employee> getEmployeeByProfile(@PathVariable String profile){

        logger.info("-----INFO-----: "+ "--getEmployeeByProfile()-- :"+ "By: "+ profile.toLowerCase());
        List<Employee> getEmpByProfile = testEmployeeDB.getAllEmployeeDetails()
                .stream()
                .filter(name -> name.getProfile().toString().equalsIgnoreCase(profile))
                .collect(Collectors.toList());
        return getEmpByProfile;

    }
}
