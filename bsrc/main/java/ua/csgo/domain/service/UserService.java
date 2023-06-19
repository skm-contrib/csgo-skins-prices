package ua.csgo.domain.service;

import ua.csgo.domain.model.User;
import ua.csgo.web.dto.UserDTORequest;
import ua.csgo.web.dto.UserDTOResponse;

import java.util.List;

public interface UserService {

    User findById(int id);

    List<UserDTOResponse> findAll();

    UserDTOResponse add(UserDTORequest user);

    UserDTOResponse update(UserDTORequest user, int id);

    boolean delete(int id);
}
