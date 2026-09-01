package org.example.operatorbackend.repository;

import org.example.operatorbackend.model.BookOffRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookOffRepository extends JpaRepository<BookOffRequest, Long> {
    List<BookOffRequest> findByOperatorId(Long operatorId);
}
