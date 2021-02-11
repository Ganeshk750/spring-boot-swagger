package com.ganesh.swagger.controller;

/*
 * @created: 11/02/2021 - 4:14 PM
 * @author: Ganesh
 */


import com.ganesh.swagger.model.Employee;
import com.ganesh.swagger.repository.TestEmployeeDB;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "Swagger2RestController")
public class EmployeeController {

    private final TestEmployeeDB testEmployeeDB;

    private final static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @ApiOperation(value = "Get list of Employees in the System ", response = Iterable.class, tags = "getEmployees")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/getEmployees")
    public List<Employee> getAllEmployees(){
        logger.info("-----INFO-----: "+ "getAllEmployees()");
        return testEmployeeDB.getAllEmployeeDetails();
    }

    @ApiOperation(value = "Get specific Employee in the System ", response = Employee.class, tags = "getEmployee")
    @GetMapping("/getEmployee/{employeeName}")
    public Employee getEmployeeByName(@PathVariable String employeeName){

        logger.info("-----INFO-----: "+ "--getEmployeeByName()-- :"+ "By: "+ employeeName.toLowerCase());
        Employee emp = testEmployeeDB.getAllEmployeeDetails()
                .stream()
                .filter(name -> name.getEmployeeName().equalsIgnoreCase(employeeName))
                .collect(Collectors.toList()).get(0);
        return emp;
    }

    @ApiOperation(value = "Get specific Employee By Country in the System ", response = Employee.class, tags = "getByCountry")
    @GetMapping("/getByCountry/{countryName}")
    public List<Employee> getEmployeeByCountry(@PathVariable String countryName){

        logger.info("-----INFO-----: "+ "--getEmployeeByCountry()-- :"+ "By: "+ countryName.toLowerCase());

        List<Employee> getEmpByCountry = testEmployeeDB.getAllEmployeeDetails()
                .stream()
                .filter(name -> name.getCountry().equalsIgnoreCase(countryName))
                .collect(Collectors.toList());
        return getEmpByCountry;
    }


    @ApiOperation(value = "Get specific Employee By Profile in the System ", response = Employee.class, tags = "getByProfile")
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
