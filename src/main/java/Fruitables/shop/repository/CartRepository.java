package Fruitables.shop.repository;

import Fruitables.shop.entity.Cart;
import Fruitables.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    Cart findByUser(User user);

}
