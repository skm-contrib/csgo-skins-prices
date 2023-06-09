package ua.csgo.domain.service.impl;

import org.springframework.stereotype.Component;
import ua.csgo.domain.service.WeaponTypeResolver;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class WeaponTypeResolverImpl implements WeaponTypeResolver {

    Map<List<String>, String> weaponTypes = Map.of(
            List.of("Glock-18", "P2000", "USP-S", "Dual Berettas", "P250", "Five-SeveN", "Tec-9", "CZ75-Auto",
                    "Desert Eagle", "R8 Revolver"), "Pistol",
            List.of("AK-47", "M4A4", "M4A1-S", "Galil AR", "FAMAS", "AUG", "SG 553", "AWP", "G3SG1",
                    "SCAR-20", "SSG 08"), "Rifle",
            List.of("XM1014", "MAG-7", "Sawed-Off", "Nova", "M249", "Negev"), "Heavy",
            List.of("MP9", "MP7", "UMP-45", "P90", "PP-Bizon", "MAC-10", "MP5-SD"), "Smg",
            List.of("Bayonet", "Flip Knife", "Gut Knife", "Karambit", "M9 Bayonet", "Paracord Knife",
                    "Classic Knife", "Huntsman Knife", "Falchion Knife", "Bowie Knife", "Butterfly Knife",
                    "Shadow Daggers", "Navaja Knife", "Stiletto Knife", "Ursus Knife", "Talon Knife", "Skeleton Knife",
                    "Nomad Knife", "Survival Knife"), "Knife"
    );


    @Override
    public String resolveWeaponType(String weaponName) {
        Set<List<String>> keys = weaponTypes.keySet();
        for (List<String> weapons : keys) {
            if (weapons.contains(weaponName))
                return weaponTypes.get(weapons);
            else if (weaponName.toLowerCase().contains("gloves") || weaponName.toLowerCase().contains("wraps")) {
                return "Gloves";
            }
        }
        return "No type";
    }
}
