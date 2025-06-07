package com.jino.erp_project.controller;

import com.jino.erp_project.dto.SalesRequest;
import com.jino.erp_project.dto.SalesResponse;
import com.jino.erp_project.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SalesController {
    private final SalesService salesService;

    @PostMapping
    public SalesResponse create(@RequestBody SalesRequest req) {
        return salesService.create(req);
    }

    @GetMapping
    public List<SalesResponse> findAll() {
        return salesService.findAll();
    }

    @GetMapping("/date")
    public List<SalesResponse> findAllByDate(@RequestParam LocalDate date) {
        return salesService.findAllByDate(date);
    }

    @GetMapping("/employee/{employeeId}")
    public List<SalesResponse> findAllByEmployee(@PathVariable Long employeeId) {
        return salesService.findAllByEmployee(employeeId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        salesService.delete(id);
    }
}
