package com.jino.erp_project.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductRequest {
    private String name;
    private String description;
}
