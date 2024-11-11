package Fruitables.shop.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity(name = "shop_order")
public class ShopOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "order_date", nullable = false)
    private Timestamp orderDate;

    @ManyToOne
    @JoinColumn(name = "payment_method", nullable = false)
    private PaymentType paymentMethod;

    @ManyToOne
    @JoinColumn(name = "shipping_address", nullable = false)
    private DeliveryInformation shippingAdress;

    @ManyToOne
    @JoinColumn(name = "shipping_method", nullable = false)
    private ShippingMethod shippingMethod;

    @Column(name = "order_total", nullable = false)
    private BigDecimal orderTotal;

    @ManyToOne
    @JoinColumn(name = "order_status", nullable = false)
    private OrderStatus orderStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public PaymentType getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentType paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public DeliveryInformation getShippingAdress() {
        return shippingAdress;
    }

    public void setShippingAdress(DeliveryInformation shippingAdress) {
        this.shippingAdress = shippingAdress;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
