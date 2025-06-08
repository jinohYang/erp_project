package com.jino.erp_project.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class InventoryRequest {
    private Long productId;
    private Integer quantity;    // 입고는 양수, 출고는 음수
    private String type;         // "IN" 또는 "OUT"
    private String note;
}
