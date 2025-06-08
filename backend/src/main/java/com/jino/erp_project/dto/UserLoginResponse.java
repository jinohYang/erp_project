package com.jino.erp_project.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserLoginResponse {
    private String token;
}
