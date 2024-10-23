package com.friendlybooking.mvp.monolit.impl;

import com.friendlybooking.mvp.monolit.dao.UserRepository;
import com.friendlybooking.mvp.monolit.model.User;
import com.friendlybooking.mvp.monolit.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    public User registerUser(String phoneNumber, String password) {
        if (userRepository.existsByPhoneNumber(phoneNumber)) {
            throw new IllegalStateException("User already exists");
        }

        User user = new User();
        user.setPhoneNumber(phoneNumber);
        return userRepository.save(user);
    }
}