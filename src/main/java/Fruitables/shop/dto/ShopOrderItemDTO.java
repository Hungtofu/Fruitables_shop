package Fruitables.shop.dto;

import Fruitables.shop.entity.CartItem;
import Fruitables.shop.entity.ShopOrderItem;
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
    private ProductDTO productDTO;
    private int qty;
    private Double price;
    private String image;
    public ShopOrderItemDTO(ShopOrderItem shopOrderItem) {
        this.productDTO = new ProductDTO(shopOrderItem.getProduct());
        this.qty = shopOrderItem.getQty();
        this.price = shopOrderItem.getPrice();
    }
}
