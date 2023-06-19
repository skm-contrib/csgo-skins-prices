package ua.csgo.web.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.csgo.domain.model.User;
import ua.csgo.web.dto.AuthDTO;
import ua.csgo.web.dto.UserDTORequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<User> authenticate(AuthDTO authDTO){
        return null;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(UserDTORequest request){
        return null;
    }



}
