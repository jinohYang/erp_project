package com.jino.erp_project.repository;

import com.jino.erp_project.domain.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findAllByProductId(Long productId);
}
