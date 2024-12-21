package Fruitables.shop.payload.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {

    private String userName;
    private String email;
    private String password;

}
