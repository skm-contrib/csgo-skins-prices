package ua.csgo.domain.repository.impl;

import org.springframework.stereotype.Repository;
import ua.csgo.domain.model.Skin;
import ua.csgo.domain.repository.SkinRepository;

import java.util.List;

@Repository
public class SkinRepositoryImpl implements SkinRepository {
    @Override
    public Skin findById(int id) {
        return null;
    }

    @Override
    public List<Skin> findAll() {
        return null;
    }

    @Override
    public List<Skin> findAllByWeapon(String weapon) {
        return null;
    }

    @Override
    public List<Skin> findAllByRarity(String rarity) {
        return null;
    }

    @Override
    public List<Skin> getFavorites(int id) {
        return null;
    }

    @Override
    public Skin addFavorite(int id) {
        return null;
    }

    @Override
    public boolean removeFavorite(int id) {
        return false;
    }
}
