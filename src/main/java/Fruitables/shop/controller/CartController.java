package Fruitables.shop.controller;

import Fruitables.shop.dto.CartItemDTO;
import Fruitables.shop.entity.Product;
import Fruitables.shop.service.CartService;
import Fruitables.shop.service.ProductService;
import Fruitables.shop.util.SecurityUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(("/cart"))
public class CartController {

    private final ProductService productService;
    private final CartService cartService;

    public CartController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @PostMapping("/item")
    public ResponseEntity<Boolean> addProduct(@RequestParam int productId, @RequestParam int qty){
        String email = SecurityUtil.getCurrentUserLogin().isPresent()? SecurityUtil.getCurrentUserLogin().get() : "";
        Product product = productService.getById(productId);
        if(email.isEmpty() || product == null || product.getQtyInStock() < qty){
            return ResponseEntity.status(HttpStatus.OK.value()).body(null);
        }

        boolean success = cartService.addProductToUserCart(email, product, qty);
        return ResponseEntity.status(HttpStatus.OK.value()).body(success);
    }

    @GetMapping("/items")
    public ResponseEntity<?> getItemByCart(){
        String email = SecurityUtil.getCurrentUserLogin().isPresent()? SecurityUtil.getCurrentUserLogin().get() : "";
        if(email.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK.value()).body(null);
        }

        List<CartItemDTO> cartItemDTOList = cartService.getCartItemByUser(email);
        return ResponseEntity.status(HttpStatus.OK.value()).body(cartItemDTOList);
    }

}
