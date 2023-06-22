package ua.csgo.domain.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.csgo.domain.factory.UserFactory;
import ua.csgo.domain.model.User;
import ua.csgo.domain.repository.UserRepository;
import ua.csgo.domain.service.UserService;
import ua.csgo.web.dto.UserDTORequest;
import ua.csgo.web.dto.UserDTOResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository repository;
    private final UserFactory userFactory;

    @Override
    public UserDTOResponse findById(int id) {
        return userFactory.toDto(repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Не можливо знайти користувача з id: " + id)));
    }

    @Override
    public List<UserDTOResponse> findAll() {
        return repository.findAll().stream().map(userFactory::toDto).toList();
    }

    @Override
    public UserDTOResponse add(UserDTORequest user) {
        return userFactory.toDto(repository.save(userFactory.fromDto(user)));
    }

    @Override
    public UserDTOResponse update(UserDTORequest user, int id) {
        checkExists(id);
        User userToSave = userFactory.fromDto(user);
        userToSave.setId(id);
        return userFactory.toDto(repository.save(userToSave));
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
