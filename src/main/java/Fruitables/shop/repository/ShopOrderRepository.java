package Fruitables.shop.repository;

import Fruitables.shop.entity.Cart;
import Fruitables.shop.entity.ShopOrder;
import Fruitables.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopOrderRepository extends JpaRepository<ShopOrder, Integer> {
    ShopOrder findByUser(User user);
}
