package ua.csgo.domain.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ua.csgo.domain.factory.UserFactory;
import ua.csgo.domain.model.User;
import ua.csgo.domain.repository.UserRepository;
import ua.csgo.domain.service.AuthService;
import ua.csgo.web.dto.AuthDTO;
import ua.csgo.web.dto.RegisterDTO;
import ua.csgo.web.dto.UserDTOResponse;
import ua.csgo.web.exception.UserAlreadyRegisteredException;

@Component
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserFactory userFactory;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTOResponse signup(RegisterDTO signup) {
        if (userRepository.existsByEmail(signup.getEmail()))
            throw new UserAlreadyRegisteredException("Ця електронна пошта вже зайнята");

        return userFactory.toDto(userRepository.save(userFactory.fromDto(signup)));
    }

    @Override
    public UserDTOResponse login(AuthDTO login) {
        User user = userRepository.findByEmail(login.getEmail()).orElseThrow(() -> new EntityNotFoundException("Неправильний логін або пароль"));
        if (passwordEncoder.matches(login.getPassword(), user.getPassword()))
            throw new EntityNotFoundException("Неправильний логін або пароль");

        return userFactory.toDto(user);
    }
}
