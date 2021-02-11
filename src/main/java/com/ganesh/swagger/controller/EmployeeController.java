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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


}
