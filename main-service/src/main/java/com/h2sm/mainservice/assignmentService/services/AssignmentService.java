package com.h2sm.mainservice.assignmentService.services;

import com.h2sm.mainservice.assignmentService.dto.Assignment;
import com.h2sm.mainservice.employeeService.employees.Employee;
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
        addAssignmentToDatabase(a);
    }
    public Assignment getAssignment(long id){
        return null;
    }
    public Assignment pushAnAssignmentToAnotherPerson(Employee from,
                                                      Employee to,
                                                      Assignment assignment){
        return null;
    }
}
