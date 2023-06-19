package ua.csgo.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ua.csgo.domain.model.User;
import ua.csgo.domain.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class AdminInitializer implements ApplicationRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (!userRepository.existsByEmail("admin@gmail.com"))
            userRepository.save(User.builder()
                    .nickname("admin")
                    .email("admin@gmail.com")
                    .role("ROLE_ADMIN")
                    .password(passwordEncoder.encode("admin"))
                    .build());
    }
}
