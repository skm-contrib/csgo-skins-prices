package ua.csgo.domain.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SkinBymykel {
    private String id;

    private String name;
    private String description;
    private String weapon;
    private String pattern;
    @JsonProperty("min_float")
    private float minFloat;
    @JsonProperty("max_float")
    private float maxFloat;
    private String rarity;
    private boolean stattrak;
    @JsonProperty("paint_index")
    private String paintIndex;
    private String image;
}
