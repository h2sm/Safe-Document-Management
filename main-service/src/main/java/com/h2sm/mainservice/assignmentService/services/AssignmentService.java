package com.h2sm.mainservice.assignmentService.services;

import com.h2sm.mainservice.assignmentService.dto.Assignment;
import com.h2sm.mainservice.employeeService.employees.Employee;
import com.h2sm.mainservice.employeeService.positions.Position;
import org.springframework.stereotype.Service;

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
        return null;
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
