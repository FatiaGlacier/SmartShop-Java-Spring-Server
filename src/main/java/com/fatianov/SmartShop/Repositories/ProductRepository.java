package com.fatianov.SmartShop.Repositories;

import com.fatianov.SmartShop.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
