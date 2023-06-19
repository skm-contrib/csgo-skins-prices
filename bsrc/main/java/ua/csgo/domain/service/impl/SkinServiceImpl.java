package ua.csgo.domain.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Skin findById(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Не вдалось знайти елемент з ідентифікатором: " + id));
    }

    public List<Skin> findAll() {
        return repository.findAll();
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public List<Skin> findAll(PageRequest of, String weaponType, String weapon, String search, Sort skinSort) {
        return repository.findAll(of, weaponType, weapon, search, skinSort);
    }

}
