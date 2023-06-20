package ua.csgo.domain.repository.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ua.csgo.domain.model.Skin;
import ua.csgo.domain.repository.SkinRepository;

import java.util.Arrays;
import java.util.List;

@Repository
public class SkinRepositoryImpl implements SkinRepository {

    @Value("${api.url}")
    private String apiUrl;

    @Override
    public Skin findById(int id) {
        return null;
    }

    @Override
    public List<Skin> findAll() {
        RestTemplate template = new RestTemplate();
        return Arrays.stream(template.getForObject(apiUrl, Skin[].class)).toList();
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
