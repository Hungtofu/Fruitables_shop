package Fruitables.shop.dto;

import Fruitables.shop.entity.Category;
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
public class ProductDetailDTO {

    private int id;
    private CategoryDTO category;
    private String name;
    private int qtyInStock;
    private double price;
    private String description;
    private List<String> image;

    public ProductDetailDTO(CategoryDTO category, String name, int qtyInStock, double price, String description, List<String> image) {
        this.category = category;
        this.name = name;
        this.qtyInStock = qtyInStock;
        this.price = price;
        this.description = description;
        this.image = image;
    }
}
