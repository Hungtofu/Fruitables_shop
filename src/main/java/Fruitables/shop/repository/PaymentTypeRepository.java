package Fruitables.shop.repository;

import Fruitables.shop.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer> {
    PaymentType findById(int id);
}
