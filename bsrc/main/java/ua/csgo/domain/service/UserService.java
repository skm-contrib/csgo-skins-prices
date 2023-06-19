package ua.csgo.domain.service;

import ua.csgo.domain.model.User;
import ua.csgo.web.dto.UserDTORequest;

import java.util.List;

public interface UserService {

    User findById(int id);

    List<User> findAll();

    User add(UserDTORequest user);

    User update(UserDTORequest user, int id);

    boolean delete(int id);
}
