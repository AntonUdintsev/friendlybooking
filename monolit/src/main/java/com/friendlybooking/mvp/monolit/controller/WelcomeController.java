package com.friendlybooking.mvp.monolit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class WelcomeController {

    @GetMapping()
    public String welcome() {
        return "Welcome";
    }
}