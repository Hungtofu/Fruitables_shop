package Fruitables.shop.service;

import Fruitables.shop.repository.ShopOrderItemRepository;
import Fruitables.shop.repository.ShopOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class ShopOrderService {
    private final UserService userService;
    private final ShopOrderRepository shopOrderRepository;
    private final ShopOrderItemRepository shopOrderItemRepository;


}
