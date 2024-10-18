package friendlybooking.mvp.security;

import friendlybooking.mvp.dao.UserRepository;
import friendlybooking.mvp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;


public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByPhoneNumber(phoneNumber);

        return user.map(CustomUserDetails::new)
                .orElseThrow(()->new UsernameNotFoundException(String.format("User with phone number %s not found", phoneNumber)));
    }
}
