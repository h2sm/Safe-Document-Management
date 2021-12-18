package com.h2sm.mainservice.assignmentService.controller;

import com.h2sm.mainservice.employeeService.employees.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/assignments")
public class AssignmentsController {
    @PostMapping("/new")
    public String makeNewAssignment(Employee userFrom, Employee userTo){
        //create an assignment
        //check if user has rights to do so
        return "null";
    }
    @GetMapping("/delete")
    public String deleteAnAssignment(){
        return "null";
    }
}
