package com.ganesh.swagger.model;

/*
 * @created: 11/02/2021 - 3:53 PM
 * @author: Ganesh
 */


import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee implements Serializable {

    private int employeeId;
    private String employeeName;
    private String email;
    private String country;
    private Profile profile;

}
