package com.vignesh.banking.repository;
import com.vignesh.banking.model.Transaction;import org.springframework.data.domain.*;import org.springframework.data.jpa.repository.JpaRepository;
public interface TransactionRepository extends JpaRepository<Transaction,Long>{Page<Transaction> findByAccountIdOrderByCreatedAtDesc(Long id,Pageable p);}
