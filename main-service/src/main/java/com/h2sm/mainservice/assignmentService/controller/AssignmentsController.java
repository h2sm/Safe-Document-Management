package com.h2sm.mainservice.assignmentService.controller;

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
    public Assignment makeNewAssignment(Employee userFrom, Employee userTo) {        //create an assignment
        var userFromPosition = userFrom.getPosition();
        var userToPosition = userTo.getPosition();
        if (userFromPosition.equals(Position.Director)
                || userFromPosition.equals(Position.HeadOfDepartment)
                || !userToPosition.equals(Position.Director)
                || !userFromPosition.equals(Position.DepartmentWorker)){//necessary checks

            var newAssignment = new Assignment(userFrom, userTo, new Date());
            service.addAssignmentToDatabase(newAssignment);
            return newAssignment;
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
