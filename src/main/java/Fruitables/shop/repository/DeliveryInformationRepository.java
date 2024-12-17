package Fruitables.shop.repository;

import Fruitables.shop.entity.DeliveryInformation;
import Fruitables.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryInformationRepository extends JpaRepository<DeliveryInformation, Integer> {
    DeliveryInformation findByUser(User user);
}
