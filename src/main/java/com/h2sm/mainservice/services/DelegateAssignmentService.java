package com.h2sm.mainservice.services;

import com.h2sm.mainservice.dtos.Assignment;
import com.h2sm.mainservice.dtos.DelegatedAssignment;
import com.h2sm.mainservice.dtos.Worker;
import com.h2sm.mainservice.repository.DelegateAssignmentRepository;
import com.h2sm.mainservice.utils.ContextUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DelegateAssignmentService {
    private final DelegateAssignmentRepository repo;

    public boolean checkIfAssignmentIsDelegated(Assignment a) {
        return repo.isAssignmentDelegated(a.getAid());
    }

    public void addDelegatedAssignment(DelegatedAssignment d) {
        repo.save(d);
    }

    public void deleteDelegatedAssignment(DelegatedAssignment d) {
        repo.delete(d);
    }

    public Worker getNewAssignee(DelegatedAssignment d) {
        return repo.findWhoIsANewAssignee(d.getId()).orElseThrow(() -> new UsernameNotFoundException("New assignee not found"));
    }

    public void saveDelegatedAssignment(DelegatedAssignment d) {
        repo.save(d);
    }

    public List<DelegatedAssignment> getDelegatedAssignmentsForThisWorker() {
        return repo.getAllDelegatedAssignmentsForThisUser(ContextUtil.getAuthorizedUserName());
    }

}
