package com.jino.erp_project.controller;

import com.jino.erp_project.dto.ExpenseRequest;
import com.jino.erp_project.dto.ExpenseResponse;
import com.jino.erp_project.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping
    public ExpenseResponse create(@RequestBody ExpenseRequest req) {
        return expenseService.create(req);
    }

    @GetMapping
    public List<ExpenseResponse> findAll() {
        return expenseService.findAll();
    }

    @GetMapping("/date")
    public List<ExpenseResponse> findAllByDate(@RequestParam LocalDate date) {
        return expenseService.findAllByDate(date);
    }

    @GetMapping("/employee/{employeeId}")
    public List<ExpenseResponse> findAllByEmployee(@PathVariable Long employeeId) {
        return expenseService.findAllByEmployee(employeeId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        expenseService.delete(id);
    }
}
