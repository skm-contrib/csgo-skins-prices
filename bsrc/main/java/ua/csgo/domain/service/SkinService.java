package ua.csgo.domain.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import ua.csgo.domain.model.Skin;

import java.util.List;

public interface SkinService {
    Skin findById(String id);

    List<Skin> findAll();


    long count();

    List<Skin> findAll(PageRequest of, String weaponType, String weapon, String search, Sort skinSort);
}
