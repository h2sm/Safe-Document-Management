package com.h2sm.mainservice.repository;

import com.h2sm.mainservice.dtos.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
