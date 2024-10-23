package com.friendlybooking.mvp.monolit.controller;

import com.friendlybooking.mvp.monolit.model.User;
import com.friendlybooking.mvp.monolit.model.UserRegisterRequest;
import com.friendlybooking.mvp.monolit.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegisterRequest request) {
        return ResponseEntity.ok(userService.registerUser(request.getPhoneNumber(), request.getPassword()));
    }
}