package ua.csgo.domain.service;

import ua.csgo.domain.model.User;
import ua.csgo.web.dto.AuthDTO;
import ua.csgo.web.dto.RegisterDTO;
import ua.csgo.web.dto.UserDTORequest;
import ua.csgo.web.dto.UserDTOResponse;

public interface AuthService {

    UserDTOResponse signup(RegisterDTO login);
    UserDTOResponse login(AuthDTO login);
}
