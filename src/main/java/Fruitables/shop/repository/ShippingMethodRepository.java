package Fruitables.shop.repository;

import Fruitables.shop.entity.ShippingMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingMethodRepository extends JpaRepository<ShippingMethod, Integer> {
    ShippingMethod findById(int id);
}
