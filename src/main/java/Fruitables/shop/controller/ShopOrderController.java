package Fruitables.shop.controller;

import Fruitables.shop.dto.ShopOrderItemDTO;
import Fruitables.shop.entity.Product;
import Fruitables.shop.service.CartService;
import Fruitables.shop.service.ProductService;
import Fruitables.shop.service.ShopOrderService;
import Fruitables.shop.util.SecurityUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/shoporder")

public class ShopOrderController {
    private final ShopOrderService shopOrderService;
    private final CartService cartService;
    private final ProductService productService;

    public ShopOrderController(ProductService productService, CartService cartService, ShopOrderService shopOrderService)
    {
        this.productService = productService;
        this.cartService = cartService;
        this.shopOrderService = shopOrderService;
    }

    @PostMapping("/product_item")
    public ResponseEntity<Boolean> addProduct(@RequestParam int productId, @RequestParam int qty, @RequestParam BigDecimal price)
    {
        String email = SecurityUtil.getCurrentUserLogin().isPresent() ? SecurityUtil.getCurrentUserLogin().get() : "";
        Product product = productService.getById(productId);
        if (email.isEmpty() || product == null || product.getQtyInStock() < qty)
        {
            return ResponseEntity.status(HttpStatus.OK.value()).body(null);
        }
        boolean success = shopOrderService.addProductToUserShopOrder(email, product, qty, price);
        return ResponseEntity.status(HttpStatus.OK.value()).body(success);
    }

    @PostMapping("/cart/{cardId}")
    public ResponseEntity<?> createShopOrderFromCart(@PathVariable Long cartId) {
        String email = SecurityUtil.getCurrentUserLogin().isPresent() ? SecurityUtil.getCurrentUserLogin().get() : "";
        if (email.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK.value()).body(null);
        }

        try {
            ShopOrderService.createShopOrderItemsFromCartItems(email, cartId);
            return ResponseEntity.ok("Shop Order created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/items")
    public ResponseEntity<?> getItemByShopOrder() {
        String email = SecurityUtil.getCurrentUserLogin().isPresent() ? SecurityUtil.getCurrentUserLogin().get() : "";
        if (email.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK.value()).body(null);
        }
        List<ShopOrderItemDTO> shopOrderItemDTOList = shopOrderService.getShopOrderItemByUser(email);
        return ResponseEntity.status(HttpStatus.OK.value()).body(shopOrderItemDTOList);
    }
}
