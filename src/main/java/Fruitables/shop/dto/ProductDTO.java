package Fruitables.shop.dto;

import Fruitables.shop.entity.Category;
import Fruitables.shop.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private int id;
    private Category category;
    private String name;
    private Long qtyInStock;
    private BigDecimal price;
    private String description;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.category = product.getCategory();
        this.name = product.getName();
        this.qtyInStock = product.getQtyInStock();
        this.price = product.getPrice();
        this.description = product.getDescription();
    }

}
