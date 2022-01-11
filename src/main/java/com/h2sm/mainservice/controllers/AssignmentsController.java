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

@Controller
@RequiredArgsConstructor
@RequestMapping("/assignments")
public class AssignmentsController {//сервис поручений
    private final AssignmentService service;
    private final DelegateAssignmentService delegateAssignmentService;

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
    public String getAllAssignments(Model model) {
        List<DelegatedAssignment> daList = delegateAssignmentService.getDelegatedAssignmentsForThisWorker();
        model.addAttribute("tasks", daList);
//        service.getAllAssignmentsOfThisUser().stream().forEach(assignment -> {
//
//        });
        return "table/tableTask";
    }

    @PostMapping("/delegate")
    public void delegateAssignment(Worker to,
                                   Assignment assignment,
                                   Model model) {
        delegateAssignmentService.addDelegatedAssignment(new DelegatedAssignment(assignment, to));
    }

    @PostMapping("/delegate/delete")
    public void deleteDelegation(DelegatedAssignment da) {
        delegateAssignmentService.deleteDelegatedAssignment(da);
    }

}
