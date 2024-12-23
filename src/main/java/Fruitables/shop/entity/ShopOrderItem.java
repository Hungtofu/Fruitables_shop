package Fruitables.shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "shop_order_item")
public class ShopOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "shop_order_id")
    private ShopOrder shopOrder;

    @Column(name = "qty")
    private int qty;

    @Column(name = "price")
    private Double price;

    public ShopOrderItem(ShopOrder shopOrder, Product product, int qty, BigDecimal price)
    {
        this.shopOrder = shopOrder;
        this.product = product;
        this.qty = qty;
        this.price = price;

    }
}
