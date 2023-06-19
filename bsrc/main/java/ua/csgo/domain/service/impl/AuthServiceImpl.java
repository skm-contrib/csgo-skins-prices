package ua.csgo.domain.service.impl;

import org.springframework.stereotype.Component;
import ua.csgo.domain.factory.UserFactory;
import ua.csgo.domain.model.User;
import ua.csgo.domain.repository.UserRepository;
import ua.csgo.domain.service.AuthService;
import ua.csgo.web.dto.UserDTORequest;
import ua.csgo.web.exception.UserAlreadyRegisteredException;

@Component
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private UserFactory userFactory;

    @Override
    public User signup(UserDTORequest signup) {
        if (userRepository.existsByEmail(signup.getEmail()))
            throw new UserAlreadyRegisteredException("Ця електронна пошта вже зайнята");

        return userRepository.save(userFactory.fromDto(signup));
    }

    @Override
    public User login(UserDTORequest login) {

        return null;
    }
}
