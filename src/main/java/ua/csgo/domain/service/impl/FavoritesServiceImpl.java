package ua.csgo.domain.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.csgo.domain.model.Skin;
import ua.csgo.domain.model.User;
import ua.csgo.domain.repository.SkinRepository;
import ua.csgo.domain.repository.UserRepository;
import ua.csgo.domain.service.FavoritesService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoritesServiceImpl implements FavoritesService {
    private final UserRepository userRepository;
    private final SkinRepository skinRepository;

    @Override
    public List<Skin> findAll(Pageable page, int id) {
        return userRepository.findById(id).get().getFavorites();
    }

    @Override
    public Skin add(int id, String skinId) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Неможливо знайти користувача з ідентифікатором: " + id));
        Skin skin = skinRepository.findById(skinId).orElseThrow(() ->
                new EntityNotFoundException("Неможливо знайти скін з ідентифікатором: " + skinId));

        user.getFavorites().add(skin);
        userRepository.save(user);
        return skin;
    }

    @Override
    public String remove(int id, String skinId) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Неможливо знайти користувача з ідентифікатором: " + id));

        user.getFavorites().removeIf(skinToRemove -> skinToRemove.getSkinId().equals(skinId));
        userRepository.save(user);
        return "Успішно видалено з обраних";
    }

    @Override
    public boolean isSkinInFavorites(int id, String skinId) {
        return skinRepository.isSkinInFavorites(id, skinId);
    }
}
