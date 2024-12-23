package Fruitables.shop.dto;

import Fruitables.shop.entity.ShippingMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShippingMethodDTO {
    private int id;
    private String name;
    private Double price;

    public ShippingMethodDTO(ShippingMethod ship)
    {
        this.id = ship.getId();
        this.name = ship.getName();
        this.price = ship.getPrice();
    }
}
