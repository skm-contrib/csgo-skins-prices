package ua.csgo.domain.service;

import org.springframework.data.domain.Pageable;
import ua.csgo.domain.model.Skin;

import java.util.List;

public interface FavoritesService {

    List<Skin> findAll(Pageable page, int id);

    Skin add(int id, String skinId);

    String remove(int id, String skinId);

    boolean isSkinInFavorites(int id, String skinId);
}
