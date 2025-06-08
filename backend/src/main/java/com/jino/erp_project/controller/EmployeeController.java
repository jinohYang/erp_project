package com.jino.erp_project.controller;

import com.jino.erp_project.common.ApiResponse;
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

    @PostMapping
    public ApiResponse<EmployeeResponse> create(@RequestBody EmployeeRequest req) {
        EmployeeResponse result = employeeService.create(req);
        return ApiResponse.<EmployeeResponse>builder()
                .success(true)
                .message("직원 등록 성공")
                .data(result)
                .build();
    }

    @GetMapping
    public ApiResponse<List<EmployeeResponse>> findAll() {
        List<EmployeeResponse> result = employeeService.findAll();
        return ApiResponse.<List<EmployeeResponse>>builder()
                .success(true)
                .message("직원 목록 조회 성공")
                .data(result)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<EmployeeResponse> findById(@PathVariable Long id) {
        EmployeeResponse result = employeeService.findById(id);
        return ApiResponse.<EmployeeResponse>builder()
                .success(true)
                .message("직원 상세 조회 성공")
                .data(result)
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<EmployeeResponse> update(@PathVariable Long id, @RequestBody EmployeeRequest req) {
        EmployeeResponse result = employeeService.update(id, req);
        return ApiResponse.<EmployeeResponse>builder()
                .success(true)
                .message("직원 정보 수정 성공")
                .data(result)
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ApiResponse.<Void>builder()
                .success(true)
                .message("직원 삭제 성공")
                .data(null)
                .build();
    }
}
