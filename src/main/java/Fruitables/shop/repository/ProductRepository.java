package Fruitables.shop.repository;

import Fruitables.shop.dto.ProductDTO;
import Fruitables.shop.entity.Category;
import Fruitables.shop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

    Product findById (int id);
    Page<Product> findByCategory(Category category, Pageable pageable);

}
