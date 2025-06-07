package com.jino.erp_project.controller;

import com.jino.erp_project.common.ApiResponse;
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
    public ApiResponse<Department> create(@RequestParam String name) {
        Department dept = departmentService.create(name);
        return ApiResponse.<Department>builder()
                .success(true)
                .message("부서 등록 성공")
                .data(dept)
                .build();
    }

    @GetMapping
    public ApiResponse<List<Department>> findAll() {
        List<Department> result = departmentService.findAll();
        return ApiResponse.<List<Department>>builder()
                .success(true)
                .message("부서 목록 조회 성공")
                .data(result)
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        departmentService.delete(id);
        return ApiResponse.<Void>builder()
                .success(true)
                .message("부서 삭제 성공")
                .data(null)
                .build();
    }
}
