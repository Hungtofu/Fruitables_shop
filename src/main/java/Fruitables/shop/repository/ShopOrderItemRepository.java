package Fruitables.shop.repository;

import Fruitables.shop.entity.ShopOrder;
import Fruitables.shop.entity.ShopOrderItem;
import Fruitables.shop.entity.User;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopOrderItemRepository extends JpaRepository<ShopOrderItem, Integer> {
    List<ShopOrderItem> findByShopOrder(ShopOrder shopOrder);
}
