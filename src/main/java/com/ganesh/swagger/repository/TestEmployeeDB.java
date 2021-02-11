package com.ganesh.swagger.repository;

/*
 * @created: 11/02/2021 - 4:05 PM
 * @author: Ganesh
 */


import com.ganesh.swagger.model.Employee;
import com.ganesh.swagger.model.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class TestEmployeeDB {

    public List<Employee> getAllEmployeeDetails(){
        return Stream.of(
                new Employee(1, "Aryan", "aryan@gmail.com", "India", Profile.TESTER),
                new Employee(2, "Vikash", "vikash@gmail.com", "USA", Profile.MANAGER),
                new Employee(3, "Pyush", "pyush@gmail.com", "India", Profile.TESTER),
                new Employee(4, "Ayush", "ayush@gmail.com", "NEPAL", Profile.DEVELOPER),
                new Employee(5, "Mukul", "mukul@gmail.com", "USA", Profile.PROJECT_MANAGER),
                new Employee(6, "Gupta", "gupta@gmail.com", "India", Profile.HR),
                new Employee(7, "Ganesh", "ganesh@gmail.com", "India", Profile.ADMIN)
        ).collect(Collectors.toList());
    }
}
