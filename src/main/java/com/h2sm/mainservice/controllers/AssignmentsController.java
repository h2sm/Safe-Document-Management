package com.h2sm.mainservice.controllers;

import com.h2sm.mainservice.dtos.Assignment;
import com.h2sm.mainservice.dtos.DelegatedAssignment;
import com.h2sm.mainservice.services.AssignmentService;
import com.h2sm.mainservice.dtos.Worker;
import com.h2sm.mainservice.services.DelegateAssignmentService;
import com.h2sm.mainservice.services.WorkerService;
import com.h2sm.mainservice.utils.ContextUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AssignmentsController {//сервис поручений
    private final AssignmentService service;
    private final DelegateAssignmentService delegateAssignmentService;
    private final WorkerService workerService;

//    @PostMapping("/assignments/new")
    @RequestMapping(value = "/assignments/new", method = RequestMethod.POST)
    public Assignment makeNewAssignment(@RequestParam(name="assigneeEmail") String assigneeEmail) {//create an assignment
        System.out.println(assigneeEmail);
        var worker = workerService.getWorkerByEmail(assigneeEmail);
        var thisWorker = workerService.getWorkerByEmail(ContextUtil.getAuthorizedUserName());
        System.out.println(worker);
        System.out.println(thisWorker);
        var a = new Assignment(thisWorker, worker);
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

    @GetMapping("/assignments/getGivenToMe")
    public List<Assignment> getAllAssGivenToMe(){
        return service.getAllAssignmentsForThisUser();
    }
    @GetMapping(value = "/assignments/getAss")
    public List<Assignment> getAllAss() {
        return service.getGivenAssignments();
    }

    @GetMapping(value = "/assignments/delegatedToMe")
    public List<DelegatedAssignment> getAllDelegatedToMe() {
        return delegateAssignmentService.getDelegatedAssignmentsForThisWorker();
    }

    @RequestMapping(value = "/assignments/delegate", method = RequestMethod.POST)
    public void delegateAssignment(@RequestParam(value = "newAssigneeEmail") String newAssigneeEmail,
                                   @RequestParam(value = "assignmentId") Long assignmentId) {
        delegateAssignmentService.addDelegatedAssignment(newAssigneeEmail, assignmentId);
    }

    @PostMapping("/assignments/delegate/delete")
    public void deleteDelegation(DelegatedAssignment da) {
        delegateAssignmentService.deleteDelegatedAssignment(da);
    }

}
