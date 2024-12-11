package Fruitables.shop.dto;

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
    private BigDecimal price;
    private String image;
}
