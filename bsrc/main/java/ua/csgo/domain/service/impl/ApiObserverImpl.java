package ua.csgo.domain.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ua.csgo.domain.model.Skin;
import ua.csgo.domain.model.SkinPrice;
import ua.csgo.domain.model.api.SkinBymykel;
import ua.csgo.domain.model.api.SkinLootFarm;
import ua.csgo.domain.repository.SkinPriceRepository;
import ua.csgo.domain.repository.SkinRepository;
import ua.csgo.domain.service.ApiObserver;
import ua.csgo.domain.service.WeaponTypeResolver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ApiObserverImpl implements ApiObserver {

    final private RestTemplate template;
    final static int observeRate = 60000 * 60;
    private final WeaponTypeResolver weaponTypeResolver;
    private final SkinRepository skinRepository;
    private final SkinPriceRepository skinPriceRepository;
    @Value("${api.lootfarm.url}")
    private String lootfarmApiUrl;

    @Value("${api.bymykel.url}")
    private String bymykleApiUrl;

    public ApiObserverImpl(WeaponTypeResolver weaponTypeResolver, SkinRepository skinRepository, SkinPriceRepository skinPriceRepository) {
        this.weaponTypeResolver = weaponTypeResolver;
        this.skinRepository = skinRepository;
        this.skinPriceRepository = skinPriceRepository;
        this.template = new RestTemplate();
    }

    @Override
    @Scheduled(fixedRate = observeRate)
    public void observeApi() {
        SkinLootFarm[] skinLootFarmList = template.getForObject(lootfarmApiUrl, SkinLootFarm[].class);
        SkinBymykel[] skinBymykelList = template.getForObject(bymykleApiUrl, SkinBymykel[].class);

        List<Skin> skins = new ArrayList<>();

        for (SkinLootFarm skinLootFarm : skinLootFarmList) {
            for (SkinBymykel skinBymykel : skinBymykelList) {
                if (skinLootFarm.getName().toLowerCase().contains(skinBymykel.getName().toLowerCase())) {
                    skins.add(Skin.builder()
                            .skinId(skinBymykel.getId() + skinLootFarm.getName())
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
        List<SkinPrice> skinPrices = skins.stream().map(skin -> SkinPrice.builder()
                .price(skin.getPrice())
                .skinId(skin.getId() + skin.getName())
                .timestamp(new Date())
                .build()).toList();

        skinRepository.saveAll(skins);
        skinPriceRepository.saveAll(skinPrices);
    }
}
