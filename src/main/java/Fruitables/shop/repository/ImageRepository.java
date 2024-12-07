package Fruitables.shop.repository;

import Fruitables.shop.entity.Image;
import Fruitables.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

    List<Image> findByProduct(Product product);
    Image findFirstByProduct(Product product);

}
