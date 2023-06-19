package ua.csgo.domain.service;

import org.springframework.data.domain.Pageable;
import ua.csgo.domain.model.Skin;

import java.util.List;

public interface SkinService {
    Skin findById(String id);

    List<Skin> findAll();

    List<Skin> findAll(Pageable page, String search, String weaponType, String weapon) ;

    long count();
}
