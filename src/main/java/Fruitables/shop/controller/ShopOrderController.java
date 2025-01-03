package Fruitables.shop.controller;

import Fruitables.shop.dto.OrderHistoryDTO;
import Fruitables.shop.dto.ShopOrderDTO;
import Fruitables.shop.dto.ShopOrderItemDTO;
import Fruitables.shop.entity.Product;
import Fruitables.shop.payload.Request.PaymentRequest;
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

    public ShopOrderController(ShopOrderService shopOrderService)
    {
        this.shopOrderService = shopOrderService;
    }

    /*
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
    /
     */

    @PostMapping("/add_order")
    public ResponseEntity<?> addShopOrder(@RequestBody PaymentRequest request) {
        String email = SecurityUtil.getCurrentUserLogin().isPresent() ? SecurityUtil.getCurrentUserLogin().get() : "";
        if (email.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK.value()).body(null);
        }
        boolean success = shopOrderService.createShopOrderFromCart(email, request);
        return ResponseEntity.status(HttpStatus.OK.value()).body(success);
    }

    @GetMapping("/orders")
    public ResponseEntity<?> getShopOrdersOfTheUser() {
        String email = SecurityUtil.getCurrentUserLogin().isPresent() ? SecurityUtil.getCurrentUserLogin().get() : "";
        if (email.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK.value()).body(null);
        }
        List<OrderHistoryDTO> shopOrderDTOList = shopOrderService.getShopOrdersOfAUser(email);
        return ResponseEntity.status(HttpStatus.OK.value()).body(shopOrderDTOList);
    }

    @GetMapping("/order/{shopOrderId}")
    public ResponseEntity<?> getAShopOrder(@RequestParam int shopOrderId) {
        String email = SecurityUtil.getCurrentUserLogin().isPresent() ? SecurityUtil.getCurrentUserLogin().get() : "";
        if (email.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK.value()).body(null);
        }
        List<ShopOrderItemDTO> shopOrderItemDTOList = shopOrderService.getShopOrderItemsOfAShopOrder(email, shopOrderId);
        return ResponseEntity.status(HttpStatus.OK.value()).body(shopOrderItemDTOList);
    }
}
