package ua.csgo.web.restcontroller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.csgo.domain.model.Skin;
import ua.csgo.domain.service.FavoritesService;

import java.util.List;

@RestController
@RequestMapping("/favorites")
@RequiredArgsConstructor
public class FavoritesController {
    private final FavoritesService favoritesService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Skin>> getUserFavorites(@PathVariable int id,
                                                       @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                                       @RequestParam(name = "count", required = false, defaultValue = "20") int count) {
        return ResponseEntity.ok(favoritesService.findAll(PageRequest.of(page, count), id));
    }

    @GetMapping("/{id}/{skin_id}")
    public ResponseEntity<Boolean> isSkinInFavorites(@PathVariable int id,
                                                     @PathVariable(name = "skin_id") String skinId){
        return ResponseEntity.ok(favoritesService.isSkinInFavorites(id, skinId));
    }

    @PostMapping("/{id}/{skin_id}")
    public ResponseEntity<Skin> addFavorite(@PathVariable int id,
                                            @PathVariable(name = "skin_id") String skinId) {
        return ResponseEntity.ok(favoritesService.add(id, skinId));
    }

    @DeleteMapping("/{id}/{skin_id}")
    public ResponseEntity<String> removeFavorite(@PathVariable int id,
                                                 @PathVariable(name = "skin_id") String skinId) {
        return ResponseEntity.ok(favoritesService.remove(id, skinId));
    }


}
