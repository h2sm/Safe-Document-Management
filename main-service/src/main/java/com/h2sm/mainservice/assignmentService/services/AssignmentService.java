package com.h2sm.mainservice.assignmentService.services;

import com.h2sm.mainservice.assignmentService.dto.Assignment;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {

    public void addAssignmentToDatabase(Assignment a){
        //add
    }

    public void deleteAssignmentToDatabase(long id){
        getAssignment(id); // and delete
        //delete
    }

    public void modifyAssignment(Assignment a){

    }
    public Assignment getAssignment(long id){
        return null;
    }
}
