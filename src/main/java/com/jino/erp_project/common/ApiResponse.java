// src/main/java/com/jino/erp_project/common/ApiResponse.java
package com.jino.erp_project.common;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
}
