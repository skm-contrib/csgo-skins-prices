package ua.csgo.domain.service.impl;

import org.springframework.stereotype.Service;
import ua.csgo.domain.model.Skin;
import ua.csgo.domain.repository.SkinRepository;
import ua.csgo.domain.service.SkinService;

import java.util.List;

@Service
public class SkinServiceImpl implements SkinService {

    private final SkinRepository repository;

    public SkinServiceImpl(SkinRepository repository) {
        this.repository = repository;
    }

    @Override
    public Skin findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Skin> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Skin> findAllByWeapon(String weapon) {
        return repository.findAllByWeapon(weapon);
    }

    @Override
    public List<Skin> findAllByRarity(String rarity) {
        return repository.findAllByRarity(rarity);
    }

    @Override
    public List<Skin> getFavorites(int id) {
        return repository.getFavorites(id);
    }

    @Override
    public Skin addFavorite(int id) {
        return repository.addFavorite(id);
    }

    @Override
    public boolean removeFavorite(int id) {
        return repository.removeFavorite(id);
    }
}
