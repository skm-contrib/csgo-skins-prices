package ua.csgo.domain.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ua.csgo.domain.factory.SkinFactory;
import ua.csgo.domain.model.Skin;
import ua.csgo.domain.model.SkinPrice;
import ua.csgo.domain.model.api.SkinBymykel;
import ua.csgo.domain.model.api.SkinLootFarm;
import ua.csgo.domain.repository.SkinPriceRepository;
import ua.csgo.domain.repository.SkinRepository;
import ua.csgo.domain.service.ApiObserver;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ApiObserverImpl implements ApiObserver {

    final private RestTemplate template;
    final static int observeRate = 60000 * 60;
    private final SkinRepository skinRepository;
    private final SkinFactory skinFactory;
    private final SkinPriceRepository skinPriceRepository;
    @Value("${api.lootfarm.url}")
    private String lootfarmApiUrl;

    @Value("${api.bymykel.url}")
    private String bymykleApiUrl;

    public ApiObserverImpl(SkinRepository skinRepository, SkinFactory skinFactory, SkinPriceRepository skinPriceRepository) {
        this.skinRepository = skinRepository;
        this.skinFactory = skinFactory;
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
                    skins.add(skinFactory.fromApi(skinBymykel, skinLootFarm));
                }
            }
        }
        List<SkinPrice> skinPrices = skins.stream().map(skin -> SkinPrice.builder()
                .price(skin.getPrice())
                .skin(skin)
                .timestamp(new Date())
                .build()).toList();

        skinRepository.saveAll(skins);
        skinPriceRepository.saveAll(skinPrices);
    }

    private List<Skin> findSkins(List<Skin> skins) {
        Map<String, List<Skin>> sortedSkins = new HashMap<>();

        for (Skin skin : skins) {
            List<Skin> currentSkins = sortedSkins.getOrDefault(skin.getWeapon(), new ArrayList<>());
            if (currentSkins.size() < 11) {
                currentSkins.add(skin);
            }
            sortedSkins.put(skin.getWeapon(), currentSkins);
        }

        return sortedSkins.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
