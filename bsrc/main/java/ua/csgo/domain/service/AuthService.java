package ua.csgo.domain.service;

import ua.csgo.domain.model.User;
import ua.csgo.web.dto.AuthDTO;
import ua.csgo.web.dto.UserDTORequest;
import ua.csgo.web.dto.UserDTOResponse;

public interface AuthService {

    UserDTOResponse signup(AuthDTO login);
    UserDTOResponse login(AuthDTO login);
}
