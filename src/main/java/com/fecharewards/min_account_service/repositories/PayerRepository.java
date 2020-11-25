package com.fecharewards.min_account_service.repositories;

import com.fecharewards.min_account_service.domains.Payer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayerRepository extends JpaRepository<Payer,Integer> {


}
