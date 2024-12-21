package Fruitables.shop.service;

import Fruitables.shop.entity.CartItem;
import Fruitables.shop.repository.CartItemRepository;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepo;


    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepo = cartItemRepository;
    }

    public CartItem getById(int id){
        return cartItemRepo.findById(id);
    }

    public boolean increaseQty(int cartItemID){
        CartItem cartItem = cartItemRepo.findById(cartItemID);
        cartItem.setQty(cartItem.getQty()+1);
        try {
            cartItemRepo.save(cartItem);
            return true;
        } catch (Exception e){
            System.out.println("Error increase quantity: " + e.getMessage());
        }
        return false;
    }

    public boolean decreaseQty(int cartItemID){
        CartItem cartItem = cartItemRepo.findById(cartItemID);
        cartItem.setQty(cartItem.getQty()-1);
        try {
            cartItemRepo.save(cartItem);
            return true;
        } catch (Exception e){
            System.out.println("Error decrease quantity: " + e.getMessage());
        }
        return false;
    }

}
