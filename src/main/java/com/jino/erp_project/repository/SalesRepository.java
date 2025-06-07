package com.jino.erp_project.repository;

import com.jino.erp_project.domain.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SalesRepository extends JpaRepository<Sales, Long> {
    List<Sales> findAllByDate(LocalDate date);
    List<Sales> findAllByEmployeeId(Long employeeId);
}
