package ua.csgo.domain.service;

import ua.csgo.domain.model.Skin;

import java.util.List;

public interface SkinService {
    Skin findById(int id);

    List<Skin> findAll();

    List<Skin> findAllByWeapon(String weapon);

    List<Skin> findAllByRarity(String rarity);

    List<Skin> getFavorites(int id);

    Skin addFavorite(int id);

    boolean removeFavorite(int id);
}
