package ua.csgo.web.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTORequest {

    private int id;
    @NotBlank(message = "Нікнейм не може бути порожнім")
    private String nickname;
    @NotBlank(message = "Електрона адреса не може бути порожньою")
    @Email(message = "Електрона адреса не коректна")
    private String email;
    private String password;
    private String role;
}
