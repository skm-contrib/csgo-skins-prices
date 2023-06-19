package ua.csgo.web.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.csgo.domain.model.User;
import ua.csgo.domain.service.UserService;
import ua.csgo.web.dto.UserDTORequest;
import ua.csgo.web.dto.UserDTOResponse;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTOResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<UserDTOResponse> addUser(@RequestBody UserDTORequest user) {
        return ResponseEntity.ok(userService.add(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTOResponse> updateUser(@RequestBody UserDTORequest user, @PathVariable int id) {
        return ResponseEntity.ok(userService.update(user, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.delete(id));
    }
}
