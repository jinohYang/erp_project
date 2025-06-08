package com.jino.erp_project.service;

import com.jino.erp_project.domain.entity.Inventory;
import com.jino.erp_project.domain.entity.Product;
import com.jino.erp_project.dto.InventoryRequest;
import com.jino.erp_project.dto.InventoryResponse;
import com.jino.erp_project.repository.InventoryRepository;
import com.jino.erp_project.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final ProductRepository productRepository;

    public InventoryResponse register(InventoryRequest req) {
        Product product = productRepository.findById(req.getProductId())
                .orElseThrow(() -> new RuntimeException("상품 없음"));
        Inventory inventory = Inventory.builder()
                .product(product)
                .dateTime(LocalDateTime.now())
                .quantity(req.getQuantity())
                .type(req.getType())
                .note(req.getNote())
                .build();
        return toResponse(inventoryRepository.save(inventory));
    }

    public List<InventoryResponse> findAllByProduct(Long productId) {
        return inventoryRepository.findAllByProductId(productId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<InventoryResponse> findAll() {
        return inventoryRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    // 재고현황(수량 계산)
    public int getCurrentStock(Long productId) {
        return inventoryRepository.findAllByProductId(productId).stream()
                .mapToInt(Inventory::getQuantity)
                .sum();
    }

    private InventoryResponse toResponse(Inventory inventory) {
        return InventoryResponse.builder()
                .id(inventory.getId())
                .productId(inventory.getProduct().getId())
                .productName(inventory.getProduct().getName())
                .dateTime(inventory.getDateTime())
                .quantity(inventory.getQuantity())
                .type(inventory.getType())
                .note(inventory.getNote())
                .build();
    }
}
