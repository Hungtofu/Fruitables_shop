package Fruitables.shop.payload.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddToCartRequest {

    private int productId;
    private int qty;

}
