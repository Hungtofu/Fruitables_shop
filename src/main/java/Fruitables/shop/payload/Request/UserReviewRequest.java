package Fruitables.shop.payload.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReviewRequest {

    private int shopOrderItemId;
    private int ratingValue;
    private String cmt;

}
