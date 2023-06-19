package ua.csgo.domain.service;

import ua.csgo.domain.model.User;
import ua.csgo.web.dto.AuthDTO;
import ua.csgo.web.dto.UserDTORequest;

public interface AuthService {

    User signup(AuthDTO login);
    User login(AuthDTO login);
}
