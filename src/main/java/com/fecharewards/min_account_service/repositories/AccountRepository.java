package com.fecharewards.min_account_service.repositories;

import com.fecharewards.min_account_service.domains.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
