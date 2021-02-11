package com.ganesh.swagger.model;

/*
 * @created: 11/02/2021 - 3:53 PM
 * @author: Ganesh
 */


import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee implements Serializable {

    private int employeeId;
    @ApiModelProperty(notes = "Name of the Employee",name="employeeName",required=true,value="test Employee Name")
    private String employeeName;
    @ApiModelProperty(notes = "Email of the Employee",name="email", required=true,value="test email")
    private String email;
    @ApiModelProperty(notes = "Country of the Employee",name="country", required=true,value="test country")
    private String country;
    @ApiModelProperty(notes = "Profile of the Employee",name="profile", required=true,value="test profile")
    private Profile profile;

}
