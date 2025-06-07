package com.jino.erp_project.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inventories")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Inventory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private LocalDateTime dateTime;      // 입출고일시

    private Integer quantity;            // 입출고 수량 (양수=입고, 음수=출고)
    private String type;                 // "IN"(입고) / "OUT"(출고)
    private String note;                 // 비고/사유 등
}
