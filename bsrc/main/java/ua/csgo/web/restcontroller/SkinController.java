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
    public ResponseEntity<List<Skin>> getSkins(@RequestParam(name = "search", required = false) String search,
                                               @RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                               @RequestParam(name = "count", defaultValue = "20", required = false) int count,
                                               @RequestParam(name = "weapon_type", required = false) String weaponType,
                                               @RequestParam(name = "weapon", required = false) String weapon) {
        System.out.println(search);
        System.out.println(weaponType);
        System.out.println(weapon);
        return ResponseEntity.ok(skinService.findAll(PageRequest.of(page, count), search, weaponType, weapon));
    }
}
