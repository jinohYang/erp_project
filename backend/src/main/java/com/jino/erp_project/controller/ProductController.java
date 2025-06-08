package com.jino.erp_project.controller;

import com.jino.erp_project.common.ApiResponse;
import com.jino.erp_project.dto.ProductRequest;
import com.jino.erp_project.dto.ProductResponse;
import com.jino.erp_project.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ApiResponse<ProductResponse> create(@RequestBody ProductRequest req) {
        ProductResponse result = productService.create(req);
        return ApiResponse.<ProductResponse>builder()
                .success(true)
                .message("상품 등록 성공")
                .data(result)
                .build();
    }

    @GetMapping
    public ApiResponse<List<ProductResponse>> findAll() {
        List<ProductResponse> result = productService.findAll();
        return ApiResponse.<List<ProductResponse>>builder()
                .success(true)
                .message("상품 목록 조회 성공")
                .data(result)
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ApiResponse.<Void>builder()
                .success(true)
                .message("상품 삭제 성공")
                .data(null)
                .build();
    }
}
