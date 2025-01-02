package Fruitables.shop.repository;

<<<<<<< HEAD
import Fruitables.shop.entity.ShopOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopOrderItemRepository extends JpaRepository<ShopOrderItem, Integer> {

    ShopOrderItem findById(int id);

=======
import Fruitables.shop.entity.ShopOrder;
import Fruitables.shop.entity.ShopOrderItem;
import Fruitables.shop.entity.User;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopOrderItemRepository extends JpaRepository<ShopOrderItem, Integer> {
    List<ShopOrderItem> findByShopOrder(ShopOrder shopOrder);
    ShopOrderItem findById(int id);
>>>>>>> hoang_gokublack
}
