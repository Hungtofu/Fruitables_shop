package Fruitables.shop.repository;

import Fruitables.shop.entity.Product;
import Fruitables.shop.entity.ShopOrderItem;
import Fruitables.shop.entity.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReviewRepository extends JpaRepository<UserReview, Integer> {

    List<UserReview> findByProduct(Product product);

}
