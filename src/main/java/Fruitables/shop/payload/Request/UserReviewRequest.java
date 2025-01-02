package Fruitables.shop.payload.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReviewRequest {

    private int productId;
    private String name;
    private String email;
    private int ratingValue;
    private String cmt;

}
