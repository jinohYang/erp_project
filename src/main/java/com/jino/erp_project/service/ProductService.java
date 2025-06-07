package com.jino.erp_project.service;

import com.jino.erp_project.domain.entity.Product;
import com.jino.erp_project.dto.ProductRequest;
import com.jino.erp_project.dto.ProductResponse;
import com.jino.erp_project.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse create(ProductRequest req) {
        Product product = Product.builder()
                .name(req.getName())
                .description(req.getDescription())
                .build();
        return toResponse(productRepository.save(product));
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    private ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .build();
    }
}
