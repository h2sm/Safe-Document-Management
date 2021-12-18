package com.h2sm.mainservice.assignmentService.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.h2sm.mainservice.assignmentService.dto.Assignment;
import com.h2sm.mainservice.assignmentService.services.AssignmentService;
import com.h2sm.mainservice.employeeService.employees.Employee;
import com.h2sm.mainservice.employeeService.positions.Position;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller("/assignments")
@RequiredArgsConstructor
public class AssignmentsController {//сервис поручений
    private final AssignmentService service;

    @PostMapping("/new")
    public Assignment makeNewAssignment(Employee userFrom, Employee userTo, Assignment assignment) {        //create an assignment
        var userFromPosition = userFrom.getPosition();
        if (userFromPosition.equals(Position.Director) || userFromPosition.equals(Position.HeadOfDepartment)) {
            assignment.setWhoAssigned(userFrom);
            assignment.setWhoWasAssignee(userTo);
            assignment.setDateOfAssign(new Date());
            service.addAssignmentToDatabase(assignment);
            return assignment;
        } else {
            return null;
        }
    }

    @GetMapping("/delete/{id}")
    public boolean deleteAnAssignment(@PathVariable long id) {//delete an assignment
        service.deleteAssignmentToDatabase(id);
        return true;
    }

    @PostMapping("/modify")
    public String modifyAnAssignment(Assignment a) {
        service.modifyAssignment(a);
        return "null";
    }

    @GetMapping("/get/{id}")
    public Assignment getAnAssignment(@PathVariable long id) {
        return service.getAssignment(id);
    }

    @PostMapping("/push")
    public Assignment pushAnAssignmentToAnotherPerson(Employee from,
                                                      Employee to,
                                                      Assignment assignment) {
        return service.pushAnAssignmentToAnotherPerson(from, to, assignment);
    }


}
