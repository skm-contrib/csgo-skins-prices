package ua.csgo.domain.service;

import ua.csgo.domain.model.User;

import java.util.List;

public interface UserService {

    User findById(int id);

    List<User> findAll();

    User add(User user);

    User update(User user, int id);

    boolean delete(int id);

}
