package com.pre.order.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User create(String name, String email, String password, String address, String phone) {
        try {
            User user = new User();
            user.setName(passwordEncoder.encode(name));
            user.setEmail(email);
            user.setAddress(passwordEncoder.encode(address));
            user.setPhone(passwordEncoder.encode(phone));
            user.setPassword(passwordEncoder.encode(password));
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("사용자 생성 중 오류가 발생했습니다");
        }
    }
}
