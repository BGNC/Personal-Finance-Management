package com.bgnc.personalfinancemanagement.repository;

import com.bgnc.personalfinancemanagement.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
