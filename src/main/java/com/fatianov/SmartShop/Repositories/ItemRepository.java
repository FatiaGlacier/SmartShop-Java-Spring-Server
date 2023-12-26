package com.fatianov.SmartShop.Repositories;

import com.fatianov.SmartShop.Entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
