package ssafy.modo.jamkkaebi.domain.member.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDto {

    private String username;
    private String password;
}