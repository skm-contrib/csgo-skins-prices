package ua.csgo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.csgo.domain.model.Skin;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOResponse {
    private int id;
    private String email;
    private String role;
    private List<Skin> favorites;
}
