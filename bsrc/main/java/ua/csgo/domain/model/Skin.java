package ua.csgo.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "skins")
public class Skin {
    @Id
    @Column(name = "skin_id")
    private String skinId;
    private String id;
    @Column(columnDefinition = "TEXT")
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String weapon;
    private String pattern;
    @Column(name = "min_float")
    private float minFloat;
    @Column(name = "max_float")
    private float maxFloat;
    private String rarity;
    private boolean stattrak;
    @Column(name = "paint_index")
    private String paintIndex;
    private String image;
    private float price;
    private int have;
    private int max;
    private int rate;
    private int tr;
    private int res;
    @Column(name = "weapon_type")
    private String weaponType;
    @ManyToMany(mappedBy = "favorites")
    @JsonIgnoreProperties("favorites")
    private List<User> users;

    @OneToMany(mappedBy = "skin")
    @JsonIgnoreProperties("skin")
    private List<SkinPrice> skinPrices;
}
