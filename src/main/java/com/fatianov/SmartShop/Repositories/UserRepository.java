package com.fatianov.SmartShop.Repositories;

import com.fatianov.SmartShop.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
