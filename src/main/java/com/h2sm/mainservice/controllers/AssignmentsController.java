package com.h2sm.mainservice.controllers;

import com.h2sm.mainservice.dtos.Assignment;
import com.h2sm.mainservice.dtos.DelegatedAssignment;
import com.h2sm.mainservice.services.AssignmentService;
import com.h2sm.mainservice.dtos.Worker;
import com.h2sm.mainservice.services.DelegateAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequiredArgsConstructor
public class AssignmentsController {//сервис поручений
    private final AssignmentService service;
    private final DelegateAssignmentService delegateAssignmentService;

    @PostMapping("/assignments/new")
    public Assignment makeNewAssignment(Assignment a) {//create an assignment
        if (service.canMakeAnAssignment(a)) {
            service.addAssignmentToDatabase(a);
            return a;
        } else {
            return null;
        }
    }

    @GetMapping("/assignments/del/{id}")
    public boolean deleteAnAssignment(@PathVariable long id) {//delete an assignment
        service.deleteAssignmentToDatabase(id);
        return true;
    }

    @PostMapping("/assignments/modify")
    public String modifyAnAssignment(Assignment a) {
        service.modifyAssignment(a);
        return "null";
    }

    @GetMapping("/assignments/get/{id}")
    public Assignment getAnAssignment(@PathVariable long id) {
        return service.getAssignment(id);
    }

    @GetMapping(value = "/getAll")
    public String getAllAssignments(Model model) {
        List<DelegatedAssignment> daList = delegateAssignmentService.getDelegatedAssignmentsForThisWorker();
        model.addAttribute("tasks", daList);
//        service.getAllAssignmentsOfThisUser().stream().forEach(assignment -> {
//
//        });
        return "table/tableTask";
    }
    @GetMapping(value = "/assignments/getAss")
    public List<Assignment> getAllAss(){
        return service.getAllAssignmentsForThisUser();
    }

    @PostMapping("/assignments/delegate")
    public void delegateAssignment(Worker to,
                                   Assignment assignment,
                                   Model model) {
        delegateAssignmentService.addDelegatedAssignment(new DelegatedAssignment(assignment, to));
    }

    @PostMapping("/assignments/delegate/delete")
    public void deleteDelegation(DelegatedAssignment da) {
        delegateAssignmentService.deleteDelegatedAssignment(da);
    }

}
