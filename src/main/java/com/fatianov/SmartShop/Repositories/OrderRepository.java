package com.fatianov.SmartShop.Repositories;

import com.fatianov.SmartShop.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
