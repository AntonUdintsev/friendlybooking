package friendlybooking.mvp.service;

import friendlybooking.mvp.model.User;

public interface IUserService {
    User registerUser(String phoneNumber, String password);
    User loginUser(String phoneNumber, String password);
}
