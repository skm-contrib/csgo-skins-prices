package ua.csgo.domain.model.api;

import lombok.Data;

@Data
public class SkinPrice {
    private String skinId;
    private String name;
    private float price;

}
