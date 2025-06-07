package com.jino.erp_project.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class InventoryResponse {
    private Long id;
    private Long productId;
    private String productName;
    private LocalDateTime dateTime;
    private Integer quantity;
    private String type;
    private String note;
}
