package com.jino.erp_project.repository;

import com.jino.erp_project.domain.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findAllByDate(LocalDate date);
    List<Expense> findAllByEmployeeId(Long employeeId);
}
