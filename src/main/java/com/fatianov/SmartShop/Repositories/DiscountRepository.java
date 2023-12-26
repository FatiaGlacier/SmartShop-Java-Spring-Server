package com.fatianov.SmartShop.Repositories;

import com.fatianov.SmartShop.Entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
