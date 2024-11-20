package Fruitables.shop.dto;

import Fruitables.shop.entity.Category;
import Fruitables.shop.entity.Product;

import java.math.BigDecimal;

public class ProductDTO {

    private int id;
    private Category category;
    private String name;
    private Long qtyInStock;
    private BigDecimal price;
    private String description;

    public ProductDTO() {
    }

    public ProductDTO(int id, Category category, String name, Long qtyInStock, BigDecimal price, String description) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.qtyInStock = qtyInStock;
        this.price = price;
        this.description = description;
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.category = product.getCategory();
        this.name = product.getName();
        this.qtyInStock = product.getQtyInStock();
        this.price = product.getPrice();
        this.description = product.getDescription();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(Long qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
