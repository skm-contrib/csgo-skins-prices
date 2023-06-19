package ua.csgo.domain.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ua.csgo.domain.model.User;
import ua.csgo.web.dto.AuthDTO;
import ua.csgo.web.dto.UserDTORequest;
import ua.csgo.web.dto.UserDTOResponse;

@Component
@RequiredArgsConstructor
public class UserFactory {

    private final PasswordEncoder passwordEncoder;

    public User fromDto(UserDTORequest request) {
        return User.builder()
                .id(request.getId())
                .nickname(request.getNickname())
                .email(request.getEmail())
                .role(request.getRole())
                .password(request.getPassword())
                .build();
    }

    public User fromDto(AuthDTO authDTO) {
        return User.builder()
                .nickname(authDTO.getNickname())
                .email(authDTO.getEmail())
                .password(passwordEncoder.encode(authDTO.getPassword()))
                .role("ROLE_USER")
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
