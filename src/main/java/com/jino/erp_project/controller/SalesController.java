package com.jino.erp_project.controller;

import com.jino.erp_project.common.ApiResponse;
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
    public ApiResponse<SalesResponse> create(@RequestBody SalesRequest req) {
        SalesResponse result = salesService.create(req);
        return ApiResponse.<SalesResponse>builder()
                .success(true)
                .message("매출 등록 성공")
                .data(result)
                .build();
    }

    @GetMapping
    public ApiResponse<List<SalesResponse>> findAll() {
        List<SalesResponse> result = salesService.findAll();
        return ApiResponse.<List<SalesResponse>>builder()
                .success(true)
                .message("매출 목록 조회 성공")
                .data(result)
                .build();
    }

    @GetMapping("/date")
    public ApiResponse<List<SalesResponse>> findAllByDate(@RequestParam LocalDate date) {
        List<SalesResponse> result = salesService.findAllByDate(date);
        return ApiResponse.<List<SalesResponse>>builder()
                .success(true)
                .message("특정일 매출 조회 성공")
                .data(result)
                .build();
    }

    @GetMapping("/employee/{employeeId}")
    public ApiResponse<List<SalesResponse>> findAllByEmployee(@PathVariable Long employeeId) {
        List<SalesResponse> result = salesService.findAllByEmployee(employeeId);
        return ApiResponse.<List<SalesResponse>>builder()
                .success(true)
                .message("직원별 매출 조회 성공")
                .data(result)
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        salesService.delete(id);
        return ApiResponse.<Void>builder()
                .success(true)
                .message("매출 삭제 성공")
                .data(null)
                .build();
    }
}
