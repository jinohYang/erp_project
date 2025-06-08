package com.jino.erp_project.dto;

import lombok.*;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EmployeeResponse {
    private Long id;
    private Long userId;
    private String name;
    private String phone;
    private LocalDate hireDate;
    private String status;

    private Long departmentId;
    private String departmentName;
    private Long positionId;
    private String positionName;

}
