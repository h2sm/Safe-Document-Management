package com.h2sm.mainservice.controllers;

import com.h2sm.mainservice.dtos.Assignment;
import com.h2sm.mainservice.dtos.DelegatedAssignment;
import com.h2sm.mainservice.services.AssignmentService;
import com.h2sm.mainservice.dtos.Worker;
import com.h2sm.mainservice.services.DelegateAssService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assignments")
public class AssignmentsController {//сервис поручений
    private final AssignmentService service;
    private final DelegateAssService delegateAssService;

    @PostMapping("/new")
    public Assignment makeNewAssignment(Assignment a, Model model) {//create an assignment
        if (service.canMakeAnAssignment(a)) {
            service.addAssignmentToDatabase(a);
            return a;
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
    public List<Assignment> getAllAssignments() {
        return service.getAllAssignmentsOfThisUser();
    }

    @PostMapping("/delegate")
    public void delegateAssignment(Worker to,
                                   Assignment assignment,
                                   Model model){
        delegateAssService.addDelegatedAssignment(new DelegatedAssignment(assignment, to));
        //return service.pushAnAssignmentToAnotherPerson(assignment, to);
    }

}
