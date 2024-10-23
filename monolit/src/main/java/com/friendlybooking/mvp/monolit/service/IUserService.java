package com.friendlybooking.mvp.monolit.service;

import com.friendlybooking.mvp.monolit.model.User;

public interface IUserService {
    User registerUser(String phoneNumber, String password);
}
