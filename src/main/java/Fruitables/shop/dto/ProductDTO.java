package Fruitables.shop.dto;

import Fruitables.shop.entity.Category;
import Fruitables.shop.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private int id;
    private String name;
    private Long qtyInStock;
    private Double price;
    private String description;
    private String image;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.image = product.getDescription();
    }
}
