package Fruitables.shop.dto;

import Fruitables.shop.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.chrono.IsoEra;

@Getter
@Setter
public class UserLoginDTO {

    @JsonProperty("access_token")
    private String accessToken;
    private UserInfo user;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserInfo{
        private int id;
        private String userName;
        private String email;
        private String img;
    }


}
