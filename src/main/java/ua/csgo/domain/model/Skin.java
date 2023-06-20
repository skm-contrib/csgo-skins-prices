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
    private String name;
    private float price;
    private int have;
    private int max;
    private int rate;
    private int tr;
    private int res;
}
