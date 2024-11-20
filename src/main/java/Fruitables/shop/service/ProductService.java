package Fruitables.shop.service;

import Fruitables.shop.dto.ProductDTO;
import Fruitables.shop.entity.Product;
import Fruitables.shop.repository.ProductRepository;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepo;

    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public List<ProductDTO> getAllProduct(){
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product p : productRepo.findAll()){
            productDTOList.add(new ProductDTO(p));
        }
        return productDTOList;
    }

    public ProductDTO getDetail(Long id){
        Product product = productRepo.findById(id);
        return (product == null)? null : new ProductDTO(product);
    }

}
