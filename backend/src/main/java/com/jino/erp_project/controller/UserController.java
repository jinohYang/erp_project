package com.jino.erp_project.controller;

import com.jino.erp_project.common.ApiResponse;
import com.jino.erp_project.dto.*;
import com.jino.erp_project.domain.entity.User;
import com.jino.erp_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 회원가입
    @PostMapping("/signup")
    public ApiResponse<UserSignupResponse> signup(@RequestBody UserSignupRequest req) {
        UserSignupResponse result = userService.signup(req);
        return ApiResponse.<UserSignupResponse>builder()
                .success(true)
                .message("회원가입 성공")
                .data(result)
                .build();
    }

    // 로그인
    @PostMapping("/login")
    public ApiResponse<UserLoginResponse> login(@RequestBody UserLoginRequest req) {
        UserLoginResponse result = userService.login(req.getUsername(), req.getPassword());
        return ApiResponse.<UserLoginResponse>builder()
                .success(true)
                .message("로그인 성공")
                .data(result)
                .build();
    }

    // 내 정보(토큰 인증 기반)
    @GetMapping("/me")
    public ApiResponse<UserProfileResponse> getProfile(@AuthenticationPrincipal User user) {
        UserProfileResponse result = userService.getProfile(user);
        return ApiResponse.<UserProfileResponse>builder()
                .success(true)
                .message("내 정보 조회 성공")
                .data(result)
                .build();
    }
}
