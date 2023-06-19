package ua.csgo.web.restcontroller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.csgo.domain.model.User;
import ua.csgo.domain.service.AuthService;
import ua.csgo.web.dto.AuthDTO;
import ua.csgo.web.dto.UserDTORequest;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<User> authenticate(@Valid AuthDTO authDTO){
        return ResponseEntity.ok(authService.login(authDTO));
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@Valid AuthDTO authDTO){
        return ResponseEntity.ok(authService.signup(authDTO));
    }



}
