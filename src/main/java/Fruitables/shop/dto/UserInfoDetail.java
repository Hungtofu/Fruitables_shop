package Fruitables.shop.dto;

import Fruitables.shop.util.constant.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDetail {

    private int id;
    private String email;
    private String userName;
    private GenderEnum gender;
    private String image;

    private Instant dob;
    private String createdBy;
    private Instant createdAt;
    private String updatedBy;
    private Instant updatedAt;

}
