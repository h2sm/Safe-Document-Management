package com.h2sm.mainservice.repository;

import com.h2sm.mainservice.dtos.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
    @Query(value = "select * from worker where uemail = ?1", nativeQuery = true)
    Optional<Worker> findByEmail(String email);
}
