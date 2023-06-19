package ua.csgo.domain.factory;

import org.springframework.stereotype.Component;
import ua.csgo.domain.model.User;
import ua.csgo.web.dto.AuthDTO;
import ua.csgo.web.dto.UserDTORequest;
import ua.csgo.web.dto.UserDTOResponse;

@Component
public class UserFactory {

    public User fromDto(UserDTORequest request) {
        return User.builder()
                .id(request.getId())
                .email(request.getEmail())
                .role(request.getRole())
                .password(request.getPassword())
                .build();
    }

    public User fromDto(AuthDTO authDTO) {
        return User.builder()
                .email(authDTO.getEmail())
                .password(authDTO.getPassword())
                .build();
    }

    public UserDTOResponse toDto(User user) {
        return UserDTOResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .favorites(user.getFavorites())
                .role(user.getRole())
                .build();
    }

}
