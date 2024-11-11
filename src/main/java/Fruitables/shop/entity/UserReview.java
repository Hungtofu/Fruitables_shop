package Fruitables.shop.entity;

import jakarta.persistence.*;

@Entity(name = "user_review")
public class UserReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "ordered_product_id", nullable = false)
    private ShopOrderItem orderProduct;

    @Column(name = "rating_value", nullable = false)
    private int ratingValue;

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

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

    public ShopOrderItem getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(ShopOrderItem orderProduct) {
        this.orderProduct = orderProduct;
    }

    public int getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(int ratingValue) {
        this.ratingValue = ratingValue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
