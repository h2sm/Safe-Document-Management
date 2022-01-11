package com.h2sm.mainservice.repository;

import com.h2sm.mainservice.dtos.Assignment;
import com.h2sm.mainservice.dtos.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
//    List<Assignment> getAssignmentByWhoAssigneeId(Long id);
//    List<Assignment> getAssignmentByWhoCreatedId(Long id);

    List<Assignment> findAssignmentByWhoAssignee_Id(Long id);
    List<Assignment> findAssignmentByWhoCreated_Id(Long id);
    Optional<Assignment> findAssignmentByAid(Long id);
    List<Assignment> findUnsignedAssignments();
}
