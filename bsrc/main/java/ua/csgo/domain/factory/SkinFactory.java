package ua.csgo.domain.factory;

import org.springframework.stereotype.Component;
import ua.csgo.domain.model.Skin;
import ua.csgo.domain.model.api.SkinBymykel;
import ua.csgo.domain.model.api.SkinLootFarm;
import ua.csgo.domain.service.WeaponTypeResolver;

@Component
public class SkinFactory {

    private final WeaponTypeResolver weaponTypeResolver;

    public SkinFactory(WeaponTypeResolver weaponTypeResolver) {
        this.weaponTypeResolver = weaponTypeResolver;
    }

    public Skin fromApi(SkinBymykel skinBymykel, SkinLootFarm skinLootFarm){
        return Skin.builder()
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
                .build();
    }
}
