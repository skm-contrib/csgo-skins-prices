package ua.csgo.domain.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ua.csgo.domain.model.User;
import ua.csgo.domain.repository.UserRepository;
import ua.csgo.web.dto.AuthDTO;
import ua.csgo.web.dto.RegisterDTO;
import ua.csgo.web.dto.UserDTORequest;
import ua.csgo.web.dto.UserDTOResponse;

@Component
@RequiredArgsConstructor
public class UserFactory {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public User fromDto(UserDTORequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        return User.builder()
                .id(request.getId())
                .nickname(request.getNickname())
                .email(request.getEmail())
                .role(request.getRole())
                .password(request.getPassword() == null ? user.getPassword() : request.getPassword())
                .build();
    }
    public User fromDto(RegisterDTO request) {
        return User.builder()
                .nickname(request.getNickname())
                .email(request.getEmail())
                .role("ROLE_USER")
                .password(request.getPassword())
                .build();
    }

    public User fromDto(AuthDTO authDTO) {
        return User.builder()
                .email(authDTO.getEmail())
                .password(passwordEncoder.encode(authDTO.getPassword()))
                .build();
    }

    public UserDTOResponse toDto(User user) {
        return UserDTOResponse.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .favorites(user.getFavorites())
                .role(user.getRole())
                .build();
    }

}
