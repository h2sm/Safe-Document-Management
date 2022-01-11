package com.h2sm.mainservice.services;

import com.h2sm.mainservice.dtos.Assignment;
import com.h2sm.mainservice.dtos.Worker;
import com.h2sm.mainservice.dtos.Position;
import com.h2sm.mainservice.repository.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AssignmentService {
    private final AssignmentRepository repo;

    public void addAssignmentToDatabase(Assignment a) {
        repo.save(a);
    }

    public void deleteAssignmentToDatabase(long id) {
        repo.deleteById(id);
    }

    public void modifyAssignment(Assignment a) {
        //
    }

    public Assignment getAssignment(long id) {
        return repo.getById(id);
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
