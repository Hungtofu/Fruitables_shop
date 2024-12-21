package Fruitables.shop.repository;

import Fruitables.shop.entity.Cart;
import Fruitables.shop.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    List<CartItem> findByCart(Cart cart);
    CartItem findById(int id);

}
