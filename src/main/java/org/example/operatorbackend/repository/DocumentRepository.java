package org.example.operatorbackend.repository;

import org.example.operatorbackend.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByOperatorId(Long operatorId);
}
