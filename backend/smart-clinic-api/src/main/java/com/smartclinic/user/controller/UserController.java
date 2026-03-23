package com.smartclinic.user.controller;

import com.smartclinic.user.dto.LoginRequest;
import com.smartclinic.user.dto.LoginResponse;
import com.smartclinic.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return userService.login(request);
    }

    @GetMapping("/testing")
    public String login() {
        return "testing";
    }
}
