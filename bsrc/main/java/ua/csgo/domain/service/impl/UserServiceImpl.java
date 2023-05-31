package ua.csgo.domain.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ua.csgo.domain.model.User;
import ua.csgo.domain.repository.UserRepository;
import ua.csgo.domain.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findById(int id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Не можливо знайти користувача з id: " + id));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User add(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user, int id) {
        checkExists(id);

        return repository.save(user);
    }

    @Override
    public boolean delete(int id) {
        checkExists(id);

        repository.deleteById(id);
        return true;
    }

    private void checkExists(int id) {
        if (!repository.existsById(id))
            throw new EntityNotFoundException("Не можливо знайти користувача з id: " + id);
    }
}
