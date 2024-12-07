package Fruitables.shop.dto;

import Fruitables.shop.entity.CartItem;
import Fruitables.shop.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {

    private int id;
    private ProductDTO productDTO;
    private int qty;
    private String image;


}
