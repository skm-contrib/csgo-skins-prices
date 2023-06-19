package ua.csgo.domain.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.csgo.domain.factory.UserFactory;
import ua.csgo.domain.model.User;
import ua.csgo.domain.repository.UserRepository;
import ua.csgo.domain.service.UserService;
import ua.csgo.web.dto.UserDTORequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository repository;
    private final UserFactory userFactory;

    @Override
    public User findById(int id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Не можливо знайти користувача з id: " + id));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User add(UserDTORequest user) {
        return repository.save(userFactory.fromDto(user));
    }

    @Override
    public User update(UserDTORequest user, int id) {
        checkExists(id);

        return repository.save(userFactory.fromDto(user));
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
