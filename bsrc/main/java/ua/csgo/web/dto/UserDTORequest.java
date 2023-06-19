package ua.csgo.web.dto;


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
    private String nickname;
    private String email;
    private String password;
    private String role;
}
