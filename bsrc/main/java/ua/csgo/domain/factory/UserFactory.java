package ua.csgo.domain.factory;

import org.springframework.stereotype.Component;
import ua.csgo.domain.model.User;
import ua.csgo.web.dto.UserDTORequest;

@Component
public class UserFactory {

    public User fromDto(UserDTORequest request){
        return User.builder()
                .id(request.getId())
                .email(request.getEmail())
                .role(request.getRole())
                .password(request.getPassword())
                .build();
    }

}
