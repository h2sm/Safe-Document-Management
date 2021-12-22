package com.h2sm.mainservice.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Employee implements Serializable {
    private long employeeID;
    private String name;
    private String surname;
    private String email;
    private String login;
//    private String password;
    private Position position;
    private List<Assignment> listOfAssignmentsConnectedToThisUser;
}
