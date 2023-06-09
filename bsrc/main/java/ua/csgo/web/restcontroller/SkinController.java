package ua.csgo.web.restcontroller;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.csgo.domain.model.Skin;
import ua.csgo.domain.service.SkinService;

import java.util.List;

@RestController
@RequestMapping("/skins")
public class SkinController {

    private final SkinService skinService;

    public SkinController(SkinService skinService) {
        this.skinService = skinService;
    }

    @GetMapping
    public ResponseEntity<List<Skin>> getSkins(@RequestParam(name = "search", defaultValue = "", required = false) String search,
                                               @RequestParam(name = "page", defaultValue = "1", required = false) int page,
                                               @RequestParam(name = "weapon_type", defaultValue = "", required = false) String weaponType,
                                               @RequestParam(name = "weapon", defaultValue = "", required = false) String weapon) {
        return ResponseEntity.ok(skinService.findAll(PageRequest.of(page, 20), search, weaponType, weapon));
    }
/*
    @GetMapping
    public ResponseEntity<List<Skin>> getSkins() {
        return ResponseEntity.ok(skinService.findAll());
    }*/

   /* @GetMapping(params = {"rarity"})
    public ResponseEntity<List<Skin>> getAllSkinsByRarity(@PathVariable String rarity) {
        return ResponseEntity.ok(skinService.findAllByRarity(rarity));
    }

    @GetMapping(params = {"weapon"})
    public ResponseEntity<List<Skin>> getAllSkinsByWeapon(@PathVariable String weapon) {
        return ResponseEntity.ok(skinService.findAllByWeapon(weapon));
    }

    @GetMapping(params = {"id"})
    public ResponseEntity<List<Skin>> getFavorites(@PathVariable int id) {
        return ResponseEntity.ok(skinService.getFavorites(id));
    }

    @PostMapping(params = {"id"})
    public ResponseEntity<Skin> addFavorite(@PathVariable int id) {
        return ResponseEntity.ok(skinService.addFavorite(id));
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity<String> daleteFavorite(@PathVariable int id) {
        return ResponseEntity.ok(skinService.removeFavorite(id) ? "Скін з id: " + id + " видалено з улюблених" : "Не видалено");
    }
*/
}
