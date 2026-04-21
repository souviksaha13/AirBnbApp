package com.springboot.projects.AirBnbApp.repository;

import com.springboot.projects.AirBnbApp.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
