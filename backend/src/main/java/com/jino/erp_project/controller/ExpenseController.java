package com.jino.erp_project.controller;

import com.jino.erp_project.common.ApiResponse;
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
    public ApiResponse<ExpenseResponse> create(@RequestBody ExpenseRequest req) {
        ExpenseResponse result = expenseService.create(req);
        return ApiResponse.<ExpenseResponse>builder()
                .success(true)
                .message("지출 등록 성공")
                .data(result)
                .build();
    }

    @GetMapping
    public ApiResponse<List<ExpenseResponse>> findAll() {
        List<ExpenseResponse> result = expenseService.findAll();
        return ApiResponse.<List<ExpenseResponse>>builder()
                .success(true)
                .message("지출 목록 조회 성공")
                .data(result)
                .build();
    }

    @GetMapping("/date")
    public ApiResponse<List<ExpenseResponse>> findAllByDate(@RequestParam LocalDate date) {
        List<ExpenseResponse> result = expenseService.findAllByDate(date);
        return ApiResponse.<List<ExpenseResponse>>builder()
                .success(true)
                .message("특정일 지출 조회 성공")
                .data(result)
                .build();
    }

    @GetMapping("/employee/{employeeId}")
    public ApiResponse<List<ExpenseResponse>> findAllByEmployee(@PathVariable Long employeeId) {
        List<ExpenseResponse> result = expenseService.findAllByEmployee(employeeId);
        return ApiResponse.<List<ExpenseResponse>>builder()
                .success(true)
                .message("직원별 지출 조회 성공")
                .data(result)
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        expenseService.delete(id);
        return ApiResponse.<Void>builder()
                .success(true)
                .message("지출 삭제 성공")
                .data(null)
                .build();
    }
}
