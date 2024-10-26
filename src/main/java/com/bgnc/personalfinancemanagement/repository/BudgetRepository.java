package com.bgnc.personalfinancemanagement.repository;

import com.bgnc.personalfinancemanagement.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
}
