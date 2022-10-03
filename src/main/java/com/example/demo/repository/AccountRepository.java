package com.example.demo.repository;
import com.example.demo.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findAccountByUsername(String username);
    Account findAccountByEmail(String email);
    Account findAccountById(int id);
    //List<Account> findAllAccount();
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
