package Fruitables.shop.repository;

import Fruitables.shop.entity.DeliveryInformation;
import Fruitables.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryInformationRepository extends JpaRepository<DeliveryInformation, Integer> {
    List<DeliveryInformation> findByUser(User user);
}
