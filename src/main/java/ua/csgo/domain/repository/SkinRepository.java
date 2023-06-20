package ua.csgo.domain.repository;


import ua.csgo.domain.model.Skin;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface SkinRepository {

    Skin findById(int id);

    List<Skin> findAll();

    List<Skin> findAllByWeapon(String weapon);

    List<Skin> findAllByRarity(String rarity);

    List<Skin> getFavorites(int id);

    Skin addFavorite(int id);

    boolean removeFavorite(int id);
}
