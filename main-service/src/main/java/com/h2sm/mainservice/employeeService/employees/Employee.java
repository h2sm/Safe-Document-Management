package com.h2sm.mainservice.employeeService.employees;

import com.h2sm.mainservice.assignmentService.dto.Assignment;
import com.h2sm.mainservice.employeeService.positions.Position;
import lombok.Data;

import java.util.List;

@Data
public class Employee {
    private long employeeID;
    private String name;
    private String surname;
    private String email;
    private String login;
//    private String password;
    private Position position;
    private List<Assignment> listOfAssignmentsConnectedToThisUser;
}
