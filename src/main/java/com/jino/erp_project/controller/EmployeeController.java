package com.jino.erp_project.controller;

import com.jino.erp_project.dto.EmployeeRequest;
import com.jino.erp_project.dto.EmployeeResponse;
import com.jino.erp_project.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    // 직원 등록
    @PostMapping
    public EmployeeResponse create(@RequestBody EmployeeRequest req) {
        return employeeService.create(req);
    }

    // 직원 목록
    @GetMapping
    public List<EmployeeResponse> findAll() {
        return employeeService.findAll();
    }

    // 직원 단일 조회
    @GetMapping("/{id}")
    public EmployeeResponse findById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    // 직원 수정
    @PutMapping("/{id}")
    public EmployeeResponse update(@PathVariable Long id, @RequestBody EmployeeRequest req) {
        return employeeService.update(id, req);
    }

    // 직원 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }
}
