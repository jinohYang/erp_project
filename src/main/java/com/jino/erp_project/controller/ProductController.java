package com.jino.erp_project.controller;

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
    public ProductResponse create(@RequestBody ProductRequest req) {
        return productService.create(req);
    }

    @GetMapping
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
