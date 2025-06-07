package com.jino.erp_project.service;

import com.jino.erp_project.domain.entity.User;
import com.jino.erp_project.dto.*;
import com.jino.erp_project.repository.UserRepository;
import com.jino.erp_project.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    // 회원가입
    public UserSignupResponse signup(UserSignupRequest req) {
        // 중복 체크
        if (userRepository.findByUsername(req.getUsername()).isPresent()) {
            throw new RuntimeException("이미 사용중인 아이디입니다.");
        }
        User user = User.builder()
                .username(req.getUsername())
                .password(passwordEncoder.encode(req.getPassword()))
                .email(req.getEmail())
                .role("USER") // 기본 권한
                .build();
        User saved = userRepository.save(user);

        return UserSignupResponse.builder()
                .id(saved.getId())
                .username(saved.getUsername())
                .email(saved.getEmail())
                .build();
    }

    // 로그인(JWT 토큰 발급)
    public UserLoginResponse login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 아이디입니다."));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
        // JWT 토큰 발급
        String token = jwtTokenProvider.createToken(user.getUsername(), user.getRole());
        return UserLoginResponse.builder()
                .token(token)
                .build();
    }

    // 내 정보 조회
    public UserProfileResponse getProfile(User user) {
        // (User 객체는 AuthenticationPrincipal에서 받아옴, 이미 인증된 사용자)
        return UserProfileResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
