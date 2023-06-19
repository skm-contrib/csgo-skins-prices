package ua.csgo.web.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.csgo.domain.model.Skin;
import ua.csgo.domain.repository.SkinRepository;
import ua.csgo.domain.service.SkinService;

import java.util.List;

@RestController
@RequestMapping("/skins")
@RequiredArgsConstructor
public class SkinController {

    private final SkinService skinService;


    @GetMapping
    public ResponseEntity<List<Skin>> getSkins(@RequestParam(name = "page", defaultValue = "0", required = false) int page,
                                               @RequestParam(name = "count", defaultValue = "20", required = false) int count,
                                               @RequestParam(name = "weapon_type", required = false) String weaponType,
                                               @RequestParam(name = "weapon", required = false) String weapon,
                                               @RequestParam(name = "search", required = false) String search,
                                               @RequestParam(name = "sort", required = false) String sort) {
        Sort skinSort =
                sort == null
                        ? null
                        : Sort.by(sort.equals("asc")
                        ? Sort.Direction.ASC
                        : Sort.Direction.DESC, "price");

        return ResponseEntity.ok(skinService.findAll(PageRequest.of(page, count), weaponType, weapon, search, skinSort));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skin> getSkin(@PathVariable String id) {
        return ResponseEntity.ok(skinService.findById(id));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCountOfSkins() {
        return ResponseEntity.ok(skinService.count());
    }
}
