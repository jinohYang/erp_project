package com.jino.erp_project.controller;

import com.jino.erp_project.dto.UserLoginRequest;
import com.jino.erp_project.dto.UserLoginResponse;
import com.jino.erp_project.dto.UserSignupRequest;
import com.jino.erp_project.domain.entity.User;
import com.jino.erp_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public User signup(@RequestBody UserSignupRequest req) {
        return userService.signup(req);
    }

    @PostMapping("/login")
    public UserLoginResponse login(@RequestBody UserLoginRequest req) {
        String token = userService.login(req.getUsername(), req.getPassword());
        return new UserLoginResponse(token);
    }

}
