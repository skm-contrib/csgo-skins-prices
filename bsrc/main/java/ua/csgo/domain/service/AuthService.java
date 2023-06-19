package ua.csgo.domain.service;

import ua.csgo.domain.model.User;
import ua.csgo.web.dto.UserDTORequest;

public interface AuthService {

    User signup(UserDTORequest login);
    User login(UserDTORequest login);
}
