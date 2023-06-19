package ua.csgo.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AuthDTO {
    @NotBlank(message = "Електрона адреса не має бути порожня")
    @Email(message = "Електрона адреса не коректна")
    private String email;
    @NotBlank(message = "Пароль не може бути порожнім")
    @Size(min = 5, message = "Пароль не може бути менше 5 символів ")
    private String password;
}
