package Fruitables.shop.dto;

import Fruitables.shop.entity.CartItem;
import Fruitables.shop.entity.Product;
import Fruitables.shop.entity.ShopOrderItem;
import Fruitables.shop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShopOrderItemDTO {
    private int id;
    private ProductDTO product;
    private int shopOrderId;
    private int qty;
    private Double price;
}
