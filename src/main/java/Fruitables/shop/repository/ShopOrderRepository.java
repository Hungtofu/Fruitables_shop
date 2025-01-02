package Fruitables.shop.repository;

import Fruitables.shop.entity.Cart;
import Fruitables.shop.entity.ShopOrder;
import Fruitables.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopOrderRepository extends JpaRepository<ShopOrder, Integer> {
    List<ShopOrder> findByUser(User user);
    ShopOrder findByUserAndId(User user, int id);
}
