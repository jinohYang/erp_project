package com.jino.erp_project.controller;

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
    public InventoryResponse register(@RequestBody InventoryRequest req) {
        return inventoryService.register(req);
    }

    @GetMapping("/product/{productId}")
    public List<InventoryResponse> findAllByProduct(@PathVariable Long productId) {
        return inventoryService.findAllByProduct(productId);
    }

    @GetMapping
    public List<InventoryResponse> findAll() {
        return inventoryService.findAll();
    }

    // 상품별 재고수량(집계)
    @GetMapping("/product/{productId}/stock")
    public int getCurrentStock(@PathVariable Long productId) {
        return inventoryService.getCurrentStock(productId);
    }
}
