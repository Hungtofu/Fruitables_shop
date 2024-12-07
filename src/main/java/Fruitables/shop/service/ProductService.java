package Fruitables.shop.service;

import Fruitables.shop.dto.PageProductDTO;
import Fruitables.shop.dto.ProductDTO;
import Fruitables.shop.entity.Product;
import Fruitables.shop.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.query.Meta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepo;

    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public Product getById(int id){
        return productRepo.findById(id);
    }

    public PageProductDTO getAllProduct(Specification<Product> spec, Pageable pageable){

        PageProductDTO pageProductDTO = new PageProductDTO();

        Page<Product> productPage = this.productRepo.findAll(spec, pageable);
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product p : productPage){
            productDTOList.add(new ProductDTO(p));
        }

        pageProductDTO.setMeta(new PageProductDTO.Meta(pageable.getPageNumber()+ 1,
                pageable.getPageSize(),
                productPage.getTotalPages(),
                productPage.getTotalElements()));
        pageProductDTO.setProductDTOList(productDTOList);

        return pageProductDTO;
    }

    public ProductDTO getDetail(int id){
        Product product = productRepo.findById(id);
        return (product == null)? null : new ProductDTO(product);
    }

}
