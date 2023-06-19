package ua.csgo.domain.service.impl;

import org.springframework.stereotype.Component;
import ua.csgo.domain.model.User;
import ua.csgo.domain.repository.UserRepository;
import ua.csgo.domain.service.AuthService;
import ua.csgo.web.dto.UserDTORequest;

@Component
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;

    @Override
    public User signup(UserDTORequest signup) {
        if (userRepository.existsByEmail(signup.getEmail()));
            throw new

        return null;
    }

    @Override
    public User login(UserDTORequest login) {
        return null;
    }
}
