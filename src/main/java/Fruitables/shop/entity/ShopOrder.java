package Fruitables.shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "shop_order")
public class ShopOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "order_date")
    private Timestamp orderDate;

    @ManyToOne
    @JoinColumn(name = "payment_method")
    private UserPaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "shipping_address")
    private DeliveryInformation shippingAddress;

    @ManyToOne
    @JoinColumn(name = "shipping_method")
    private ShippingMethod shippingMethod;

    @Column(name = "order_total")
    private Double orderTotal;

    @ManyToOne
    @JoinColumn(name = "order_status")
    private OrderStatus orderStatus;

}
