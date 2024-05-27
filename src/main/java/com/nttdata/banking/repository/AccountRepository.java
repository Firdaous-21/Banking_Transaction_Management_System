package com.nttdata.banking.repository;

import com.nttdata.banking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
