package com.h2sm.mainservice.services;

import com.h2sm.mainservice.dtos.Assignment;
import com.h2sm.mainservice.dtos.Worker;
import com.h2sm.mainservice.dtos.Position;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AssignmentService {

    public void addAssignmentToDatabase(Assignment a) {
        //add
    }

    public void deleteAssignmentToDatabase(long id) {
        getAssignment(id); // and delete
        //delete
    }

    public void modifyAssignment(Assignment a) {
        addAssignmentToDatabase(a);
    }

    public Assignment getAssignment(long id) {
        return null;
    }

    public Assignment pushAnAssignmentToAnotherPerson(Assignment assignment, Worker to) {
        return null;
    }

    public List<Assignment> getAllAssignmentsOfThisUser(){
        var x = new Assignment(new Worker(), new Worker());
        var y = new Assignment(new Worker(), new Worker());
        var list = List.of(x,y);
        return list;
    }

    public boolean canMakeAnAssignment(Assignment a) {
        var userFromPosition = a.getWhoCreated().getPosition();
        var userToPosition = a.getWhoAssignee().getPosition();
        //necessary checks
        return userFromPosition.equals(Position.Director)
                || userFromPosition.equals(Position.HeadOfDepartment)
                || !userToPosition.equals(Position.Director)
                || !userFromPosition.equals(Position.DepartmentWorker);
    }
}
