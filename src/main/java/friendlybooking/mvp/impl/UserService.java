package friendlybooking.mvp.impl;

import friendlybooking.mvp.dao.UserRepository;
import friendlybooking.mvp.service.IUserService;
import friendlybooking.mvp.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        return userRepository.save(user);
    }

    public User loginUser(String phoneNumber, String password) {
        User user = userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            throw new IllegalStateException("Invalid password");
        }

        return user;
    }
}