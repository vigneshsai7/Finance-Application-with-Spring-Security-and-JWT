package com.vignesh.banking.repository;
import com.vignesh.banking.model.Account;import org.springframework.data.jpa.repository.JpaRepository;import java.util.*;
public interface AccountRepository extends JpaRepository<Account,Long>{Optional<Account> findByAccountNumber(String n); List<Account> findByOwnerId(Long id);}
