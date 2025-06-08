package com.jino.erp_project.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserProfileResponse {
    private Long id;
    private String username;
    private String email;
    // 기타 프로필 정보 필드 추가 가능
}
