package com.jino.erp_project.controller;

import com.jino.erp_project.common.ApiResponse;
import com.jino.erp_project.dto.InventoryRequest;
import com.jino.erp_project.dto.InventoryResponse;
import com.jino.erp_project.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @PostMapping
    public ApiResponse<InventoryResponse> register(@RequestBody InventoryRequest req) {
        InventoryResponse result = inventoryService.register(req);
        return ApiResponse.<InventoryResponse>builder()
                .success(true)
                .message("입출고 등록 성공")
                .data(result)
                .build();
    }

    @GetMapping("/product/{productId}")
    public ApiResponse<List<InventoryResponse>> findAllByProduct(@PathVariable Long productId) {
        List<InventoryResponse> result = inventoryService.findAllByProduct(productId);
        return ApiResponse.<List<InventoryResponse>>builder()
                .success(true)
                .message("상품별 입출고 내역 조회 성공")
                .data(result)
                .build();
    }

    @GetMapping
    public ApiResponse<List<InventoryResponse>> findAll() {
        List<InventoryResponse> result = inventoryService.findAll();
        return ApiResponse.<List<InventoryResponse>>builder()
                .success(true)
                .message("전체 입출고 내역 조회 성공")
                .data(result)
                .build();
    }

    @GetMapping("/product/{productId}/stock")
    public ApiResponse<Integer> getCurrentStock(@PathVariable Long productId) {
        int stock = inventoryService.getCurrentStock(productId);
        return ApiResponse.<Integer>builder()
                .success(true)
                .message("상품별 재고 현황 조회 성공")
                .data(stock)
                .build();
    }
}
