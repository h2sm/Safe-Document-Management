package com.h2sm.mainservice.services;

import com.h2sm.mainservice.dtos.Assignment;
import com.h2sm.mainservice.dtos.DelegatedAssignment;
import com.h2sm.mainservice.dtos.Worker;
import com.h2sm.mainservice.dtos.Position;
import com.h2sm.mainservice.repository.AssignmentRepository;
import com.h2sm.mainservice.utils.ContextUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AssignmentService {
    private final AssignmentRepository aRepo;

    public void addAssignmentToDatabase(Assignment a) {
        aRepo.save(a);
    }

    public void deleteAssignmentToDatabase(long id) {
        aRepo.deleteById(id);
    }

    public void modifyAssignment(Assignment a) {
        //
    }

    public Assignment getAssignment(long id) {
        return aRepo.getById(id);
    }

    public List<Assignment> getAllAssignmentsForThisUser(){
        return aRepo.getAssignmentsForThisUser(ContextUtil.getAuthorizedUserName());
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
