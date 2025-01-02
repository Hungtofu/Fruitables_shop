package Fruitables.shop.controller;

import Fruitables.shop.dto.PageProductDTO;
import Fruitables.shop.dto.ProductDTO;
import Fruitables.shop.dto.ProductDetailDTO;
import Fruitables.shop.entity.Product;
import Fruitables.shop.payload.RestResponse;
import Fruitables.shop.service.ProductService;
import com.turkraft.springfilter.boot.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("/*")
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public ResponseEntity<PageProductDTO> getAllProduct(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK.value()).body(productService.getAllProduct(pageable));
    }

    @GetMapping("/filter")
    public ResponseEntity<PageProductDTO> getProductByFilter(
            @Filter Specification<Product> spec,
            Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK.value()).body(productService.getProductByFilter(spec, pageable));
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProductDetailDTO> getDetail(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK.value()).body(productService.getDetail(id));
    }

}
