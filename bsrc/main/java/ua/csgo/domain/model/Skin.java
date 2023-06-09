package ua.csgo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skin {
    private String id;
    private String name;
    private String description;
    private String weapon;
    private String pattern;
    private float minFloat;
    private float maxFloat;
    private String rarity;
    private boolean stattrak;
    private String paintIndex;
    private String image;
    private float price;
    private int have;
    private int max;
    private int rate;
    private int tr;
    private int res;
    private String weaponType;
}
