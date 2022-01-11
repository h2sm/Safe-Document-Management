package com.h2sm.mainservice.repository;

import com.h2sm.mainservice.dtos.Assignment;
import com.h2sm.mainservice.dtos.DelegatedAssignment;
import com.h2sm.mainservice.dtos.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DelegateAssignmentRepository extends JpaRepository<Assignment, Long> {
    @Query(value = "select exists(select * from delegateassignment where assignmentid = ?1)", nativeQuery = true)
    boolean isAssignmentDelegated(long a);
    @Query(value = "select a from assignment a, delegateassignment b where b.assignmentid = a.aid", nativeQuery = true)
    List<DelegatedAssignment> findAllDelegatedAssignments();
    @Query(value = "select a from assignment a, delegateassignment b where b.assignmentid = ?1", nativeQuery = true)
    Optional<Assignment> findExactDelegatedAssignment(long id);
    @Query(value = "select * from worker where uid = (select changedassignee from delegateassignment d, assignment a where a.aid = ?1 and d.assignmentid =?1)", nativeQuery = true)
    Optional<Worker> findWhoIsANewAssignee(long assignmentID);
}
