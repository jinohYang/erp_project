package com.jino.erp_project.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserSignupRequest {
    private String username;
    private String password;
    private String email;
}
