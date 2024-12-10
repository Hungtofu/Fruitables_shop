package Fruitables.shop.controller;

import Fruitables.shop.service.ShopOrderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/shoporder")

public class ShopOrderController {
    private final ShopOrderService shopOrderService;

}
