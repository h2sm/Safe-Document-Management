package com.h2sm.mainservice.controllers;

import com.h2sm.mainservice.dtos.Assignment;
import com.h2sm.mainservice.services.AssignmentService;
import com.h2sm.mainservice.dtos.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assignments")
public class AssignmentsController {//сервис поручений
    private final AssignmentService service;
    private final MediaType type = MediaType.APPLICATION_JSON;

    @PostMapping("/new")
    public Assignment makeNewAssignment(Worker userFrom, Worker userTo) {//create an assignment
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

    @GetMapping(value = "/getAll")
    public List<Assignment> getAllAssignments(){
        return service.getAllAssignmentsOfThisUser();
    }

    @PostMapping("/push")
    public Assignment pushAnAssignmentToAnotherPerson(Worker from,
                                                      Worker to,
                                                      Assignment assignment) {
        return service.pushAnAssignmentToAnotherPerson(from, to, assignment);
    }


}
