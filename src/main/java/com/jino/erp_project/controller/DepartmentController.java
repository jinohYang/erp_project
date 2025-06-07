package com.jino.erp_project.controller;

import com.jino.erp_project.domain.entity.Department;
import com.jino.erp_project.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public Department create(@RequestParam String name) {
        return departmentService.create(name);
    }

    @GetMapping
    public List<Department> findAll() {
        return departmentService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        departmentService.delete(id);
    }
}
