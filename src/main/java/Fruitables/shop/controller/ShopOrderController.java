package Fruitables.shop.controller;

import Fruitables.shop.dto.ShopOrderDTO;
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
    public ResponseEntity<Boolean> addProduct(@RequestParam int productId, @RequestBody ShopOrderDTO shopOrderDTO,@RequestParam int qty, @RequestParam Double price)
    {
        String email = SecurityUtil.getCurrentUserLogin().isPresent() ? SecurityUtil.getCurrentUserLogin().get() : "";
        Product product = productService.getById(productId);

        if (email.isEmpty() || product == null || product.getQtyInStock() < qty)
        {
            return ResponseEntity.status(HttpStatus.OK.value()).body(null);
        }
        boolean success = shopOrderService.addProductToUserShopOrder(email, shopOrderDTO, product, qty, price);
        return ResponseEntity.status(HttpStatus.OK.value()).body(success);
    }

    @PostMapping("/cart_item")
    public ResponseEntity<?> createShopOrderFromCart() {
        String email = SecurityUtil.getCurrentUserLogin().isPresent() ? SecurityUtil.getCurrentUserLogin().get() : "";
        if (email.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK.value()).body(null);
        }
        boolean success = shopOrderService.createShopOrderItemsFromCartItems(email);
        return ResponseEntity.status(HttpStatus.OK.value()).body(success);
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
