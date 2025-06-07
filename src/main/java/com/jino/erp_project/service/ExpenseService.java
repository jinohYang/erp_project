package com.jino.erp_project.service;

import com.jino.erp_project.domain.entity.Employee;
import com.jino.erp_project.domain.entity.Expense;
import com.jino.erp_project.dto.ExpenseRequest;
import com.jino.erp_project.dto.ExpenseResponse;
import com.jino.erp_project.repository.EmployeeRepository;
import com.jino.erp_project.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final EmployeeRepository employeeRepository;

    public ExpenseResponse create(ExpenseRequest req) {
        Employee employee = employeeRepository.findById(req.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("직원 없음"));
        Expense expense = Expense.builder()
                .employee(employee)
                .date(req.getDate())
                .amount(req.getAmount())
                .detail(req.getDetail())
                .build();
        return toResponse(expenseRepository.save(expense));
    }

    public List<ExpenseResponse> findAll() {
        return expenseRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<ExpenseResponse> findAllByDate(java.time.LocalDate date) {
        return expenseRepository.findAllByDate(date).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<ExpenseResponse> findAllByEmployee(Long employeeId) {
        return expenseRepository.findAllByEmployeeId(employeeId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        expenseRepository.deleteById(id);
    }

    private ExpenseResponse toResponse(Expense expense) {
        return ExpenseResponse.builder()
                .id(expense.getId())
                .employeeId(expense.getEmployee() != null ? expense.getEmployee().getId() : null)
                .date(expense.getDate())
                .amount(expense.getAmount())
                .detail(expense.getDetail())
                .build();
    }
}
