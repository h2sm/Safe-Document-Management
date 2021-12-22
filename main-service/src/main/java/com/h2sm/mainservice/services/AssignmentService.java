package com.h2sm.mainservice.services;

import com.h2sm.mainservice.dtos.Assignment;
import com.h2sm.mainservice.dtos.Employee;
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

    public Assignment pushAnAssignmentToAnotherPerson(Employee from,
                                                      Employee to,
                                                      Assignment assignment) {
        return null;
    }

    public List<Assignment> getAllAssignmentsOfThisUser(){
        var x = new Assignment(new Employee(), new Employee(), new Date());
        var y = new Assignment(new Employee(), new Employee(), new Date());
        var list = List.of(x,y);
        return list;
    }

    public boolean canMakeAnAssignment(Employee userFrom, Employee userTo) {
        var userFromPosition = userFrom.getPosition();
        var userToPosition = userTo.getPosition();
        //necessary checks
        return userFromPosition.equals(Position.Director)
                || userFromPosition.equals(Position.HeadOfDepartment)
                || !userToPosition.equals(Position.Director)
                || !userFromPosition.equals(Position.DepartmentWorker);
    }
}