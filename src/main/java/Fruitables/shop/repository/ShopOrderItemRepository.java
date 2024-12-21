package Fruitables.shop.repository;

import Fruitables.shop.entity.ShopOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopOrderItemRepository extends JpaRepository<ShopOrderItem, Integer> {

    ShopOrderItem findById(int id);

}
