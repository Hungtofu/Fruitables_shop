package Fruitables.shop.repository;

import Fruitables.shop.dto.ProductDTO;
import Fruitables.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findById (Long id);

}
