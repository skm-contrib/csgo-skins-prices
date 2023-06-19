package ua.csgo.domain.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.csgo.domain.factory.UserFactory;
import ua.csgo.domain.model.User;
import ua.csgo.domain.repository.UserRepository;
import ua.csgo.domain.service.AuthService;
import ua.csgo.web.dto.AuthDTO;
import ua.csgo.web.dto.UserDTOResponse;
import ua.csgo.web.exception.UserAlreadyRegisteredException;

@Component
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserFactory userFactory;

    @Override
    public UserDTOResponse signup(AuthDTO signup) {
        if (userRepository.existsByEmail(signup.getEmail()))
            throw new UserAlreadyRegisteredException("Ця електронна пошта вже зайнята");

        return userFactory.toDto(userRepository.save(userFactory.fromDto(signup)));
    }

    @Override
    public UserDTOResponse login(AuthDTO login) {
        return userFactory.toDto(userRepository.findByEmailAndPassword(login.getEmail(), login.getPassword())
                .orElseThrow(() -> new EntityNotFoundException("Не правильний логін або пароль")));
    }
}
