package org.example.operatorbackend.repository;

import org.example.operatorbackend.model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Long> {

    Optional<Operator> findByEmail(String email);

    List<Operator> findByCompanyId(Long companyId);

    List<Operator> findByIsLoggedInTrue();
}