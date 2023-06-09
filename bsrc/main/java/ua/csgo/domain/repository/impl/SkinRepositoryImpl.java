package ua.csgo.domain.repository.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ua.csgo.domain.model.Skin;
import ua.csgo.domain.model.api.SkinBymykel;
import ua.csgo.domain.model.api.SkinLootFarm;
import ua.csgo.domain.repository.SkinRepository;
import ua.csgo.domain.service.WeaponTypeResolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SkinRepositoryImpl implements SkinRepository {

    @Value("${api.lootfarm.url}")
    private String lootfatmApiUrl;
    @Value("${api.bymykel.url}")
    private String bymykelApiUrl;

    private final WeaponTypeResolver weaponTypeResolver;

    public SkinRepositoryImpl(WeaponTypeResolver weaponTypeResolver) {
        this.weaponTypeResolver = weaponTypeResolver;
    }

    @Override
    public Skin findById(int id) {
        return null;
    }

    @Override
    public List<Skin> findAll() {
        RestTemplate template = new RestTemplate();
        SkinLootFarm[] skinLootFarmList = template.getForObject(lootfatmApiUrl, SkinLootFarm[].class);
        SkinBymykel[] skinBymykelList =template.getForObject(bymykelApiUrl, SkinBymykel[].class);

       /* List<Skin> skins = skinLootFarmList.stream().map(skinLootFarm -> {
            SkinBymykel skinBymykel = skinBymykelList.stream().filter(skinBymykel1 -> skinBymykel1.getName().toLowerCase().contains(skinLootFarm.getName().toLowerCase())).findFirst().orElse(new SkinBymykel());
            return

        }).toList();*/
        List<Skin> skins = new ArrayList<>();

        for (SkinLootFarm skinLootFarm : skinLootFarmList) {
            for (SkinBymykel skinBymykel : skinBymykelList) {
                if (skinLootFarm.getName().toLowerCase().contains(skinBymykel.getName().toLowerCase())) {
                    skins.add(Skin.builder()
                            .id(skinBymykel.getId())
                            .name(skinLootFarm.getName())
                            .description(skinBymykel.getDescription())
                            .weapon(skinBymykel.getWeapon())
                            .pattern(skinBymykel.getPattern())
                            .minFloat(skinBymykel.getMinFloat())
                            .maxFloat(skinBymykel.getMaxFloat())
                            .rarity(skinBymykel.getRarity())
                            .stattrak(skinBymykel.isStattrak())
                            .paintIndex(skinBymykel.getPaintIndex())
                            .image(skinBymykel.getImage())
                            .price(skinLootFarm.getPrice() / 100)
                            .have(skinLootFarm.getHave())
                            .max(skinLootFarm.getMax())
                            .rate(skinLootFarm.getRate())
                            .tr(skinLootFarm.getTr())
                            .res(skinLootFarm.getRes())
                            .weaponType(weaponTypeResolver.resolveWeaponType(skinBymykel.getWeapon()))
                            .build()
                    );
                }
            }
        }
        return skins;
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
