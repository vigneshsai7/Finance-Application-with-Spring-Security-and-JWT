package com.vignesh.banking.service;
import com.vignesh.banking.model.Account;import com.vignesh.banking.repository.*;import org.springframework.stereotype.Service;import java.util.List;
@Service public class AdminService{ private final AccountRepository accounts; public AdminService(AccountRepository a){accounts=a;} public List<Account> allAccounts(){return accounts.findAll();} public Account freeze(Long id,boolean frozen){ var a=accounts.findById(id).orElseThrow(()->new RuntimeException("Account not found")); a.setFrozen(frozen); return accounts.save(a); } }
