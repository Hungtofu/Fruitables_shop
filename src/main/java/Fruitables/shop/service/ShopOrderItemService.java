package Fruitables.shop.service;

import Fruitables.shop.entity.CartItem;
import Fruitables.shop.entity.ShopOrderItem;
import Fruitables.shop.repository.CartItemRepository;
import Fruitables.shop.repository.ShopOrderItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ShopOrderItemService {
    private final ShopOrderItemRepository shopOrderItemRepository;
    private final CartItemRepository cartItemRepository;
    public ShopOrderItemService(ShopOrderItemRepository shopOrderItemRepository, CartItemRepository cartItemRepository)
    {
        this.shopOrderItemRepository = shopOrderItemRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public boolean increaseQtyAndPrice(int cartItemId, int shopOrderItemId)
    {
        CartItem cartItem = cartItemRepository.findById(cartItemId);
        cartItem.setQty(cartItem.getQty()-1);
        ShopOrderItem shopOrderItem = shopOrderItemRepository.findById(shopOrderItemId);
        shopOrderItem.setQty(shopOrderItem.getQty()+1);
        // shopOrderItem.setPrice(shopOrderItem.getPrice() - shopOrderItem.getProduct().getPrice());
        try {
            shopOrderItemRepository.save(shopOrderItem);
            cartItemRepository.delete(cartItem);
            return true;
        } catch (Exception e){
            System.out.println("Error increase quantity: " + e.getMessage());
        }
        return false;
    }

    public boolean decreaseQtyAndPrice(int cartItemId, int shopOrderItemId)
    {
        /*
        CartItem cartItem = cartItemRepository.findById(cartItemId);
        cartItem.setQty(cartItem.getQty()-1);
         */
        ShopOrderItem shopOrderItem = shopOrderItemRepository.findById(shopOrderItemId);
        shopOrderItem.setQty(shopOrderItem.getQty()-1);
        // shopOrderItem.setPrice(shopOrderItem.getPrice() - shopOrderItem.getProduct().getPrice());
        try {
            shopOrderItemRepository.save(shopOrderItem);
            // cartItemRepository.delete(cartItem);
            return true;
        } catch (Exception e){
            System.out.println("Error decrease quantity: " + e.getMessage());
        }
        return false;
    }
}
