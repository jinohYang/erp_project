package com.jino.erp_project.repository;

import com.jino.erp_project.domain.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
