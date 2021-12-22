package com.h2sm.mainservice.controllers;

import com.h2sm.mainservice.dtos.Assignment;
import com.h2sm.mainservice.services.AssignmentService;
import com.h2sm.mainservice.dtos.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController("/assignments")
@RequiredArgsConstructor
public class AssignmentsController {//сервис поручений
    private final AssignmentService service;

    @PostMapping("/new")
    public Assignment makeNewAssignment(Employee userFrom, Employee userTo) {//create an assignment
        if (service.canMakeAnAssignment(userFrom,userTo)){
            var newAssignment = new Assignment(userFrom, userTo, new Date());
            service.addAssignmentToDatabase(newAssignment);
            return newAssignment;
        } else {
            return null;
        }
    }

    @GetMapping("/del/{id}")
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

    @RequestMapping("/getAll")
    public List<Assignment> getAllAssignments(){
        return service.getAllAssignmentsOfThisUser();
    }

    @PostMapping("/push")
    public Assignment pushAnAssignmentToAnotherPerson(Employee from,
                                                      Employee to,
                                                      Assignment assignment) {
        return service.pushAnAssignmentToAnotherPerson(from, to, assignment);
    }


}
