package Fruitables.shop.controller;

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
    public ResponseEntity<RestResponse<Object>> getAllProduct(
            @Filter Specification<Product> spec,
            Pageable pageable){

        RestResponse<Object> response = new RestResponse<Object>();
        response.setData(productService.getAllProduct(spec, pageable));
        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

    @PostMapping("/getdetail/{id}")
    public ResponseEntity<RestResponse<Object>> getDetail(@PathVariable Long id){
        RestResponse<Object> response = new RestResponse<Object>();
        response.setData(productService.getDetail(id));
        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

}
