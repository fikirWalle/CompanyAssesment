package com.fecharewards.min_account_service.repositories;

import com.fecharewards.min_account_service.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {


}
