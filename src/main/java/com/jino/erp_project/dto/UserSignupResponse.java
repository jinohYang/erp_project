package com.jino.erp_project.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserSignupResponse {
    private Long id;
    private String username;
    private String email;
}
