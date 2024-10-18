package friendlybooking.mvp.controller;

import friendlybooking.mvp.model.User;
import friendlybooking.mvp.model.UserLoginRequest;
import friendlybooking.mvp.model.UserRegisterRequest;
import friendlybooking.mvp.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody UserLoginRequest request) {
        return ResponseEntity.ok(userService.loginUser(request.getPhoneNumber(), request.getPassword()));
    }
}