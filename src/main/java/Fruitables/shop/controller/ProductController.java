package Fruitables.shop.controller;

import Fruitables.shop.payload.RestResponse;
import Fruitables.shop.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("/*")
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public ResponseEntity<RestResponse<Object>> getAllProduct(){
        RestResponse<Object> response = new RestResponse<Object>();
        response.setData(productService.getAllProduct());
        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

    @PostMapping("/getdetail/{id}")
    public ResponseEntity<RestResponse<Object>> getDetail(@PathVariable Long id){
        RestResponse<Object> response = new RestResponse<Object>();
        response.setData(productService.getDetail(id));
        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

}
