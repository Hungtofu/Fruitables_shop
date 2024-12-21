package Fruitables.shop.repository;

import Fruitables.shop.entity.ShopOrderItem;
import Fruitables.shop.entity.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReviewRepository extends JpaRepository<UserReview, Integer> {


}
