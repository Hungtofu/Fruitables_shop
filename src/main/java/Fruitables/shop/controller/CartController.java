package Fruitables.shop.controller;

import Fruitables.shop.dto.CartItemDTO;
import Fruitables.shop.entity.CartItem;
import Fruitables.shop.entity.Product;
import Fruitables.shop.payload.Request.AddToCartRequest;
import Fruitables.shop.service.CartItemService;
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
    private final CartItemService cartItemService;

    public CartController(ProductService productService, CartService cartService, CartItemService cartItemService) {
        this.productService = productService;
        this.cartService = cartService;
        this.cartItemService = cartItemService;
    }

    @PostMapping("/additem")
    public ResponseEntity<Boolean> addProduct(@RequestBody AddToCartRequest request){
        String email = SecurityUtil.getCurrentUserLogin().isPresent()? SecurityUtil.getCurrentUserLogin().get() : "";
        Product product = productService.getById(request.getProductId());
        if(email.isEmpty() || product == null || product.getQtyInStock() < request.getQty()){
            return ResponseEntity.status(HttpStatus.OK.value()).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK.value()).body( cartService.addProductToUserCart(email, product, request.getQty()));
    }

    @PostMapping("/item/increase/{id}")
    public ResponseEntity<Boolean> increaseQty(@PathVariable int id){
        String email = SecurityUtil.getCurrentUserLogin().isPresent()? SecurityUtil.getCurrentUserLogin().get() : "";
        if(email.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK.value()).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK.value()).body(cartItemService.increaseQty(id));
    }

    @PostMapping("/item/decrease/{id}")
    public ResponseEntity<Boolean> decreaseQty(@PathVariable int id){
        String email = SecurityUtil.getCurrentUserLogin().isPresent()? SecurityUtil.getCurrentUserLogin().get() : "";
        if(email.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK.value()).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK.value()).body(cartItemService.decreaseQty(id));
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

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteCartItem(@PathVariable int id){
        String email = SecurityUtil.getCurrentUserLogin().isPresent()? SecurityUtil.getCurrentUserLogin().get() : "";
        if(email.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK.value()).body(false);
        }

        return ResponseEntity.status(HttpStatus.OK.value()).body(cartItemService.deleteCartItem(email, id));
    }

}
