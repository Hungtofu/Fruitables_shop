package Fruitables.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserReviewDTO {

    private int id;
    private String userName;
    private String userImgProfile;
    private int ratingValue;
    private String cmt;

}
