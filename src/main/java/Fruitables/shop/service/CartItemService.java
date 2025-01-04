package Fruitables.shop.service;

import Fruitables.shop.entity.CartItem;
import Fruitables.shop.entity.User;
import Fruitables.shop.repository.CartItemRepository;
import Fruitables.shop.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {
    private final CartItemRepository cartItemRepo;
    private final UserRepository userRepository;

    public CartItemService(CartItemRepository cartItemRepository, UserRepository userRepository) {
        this.cartItemRepo = cartItemRepository;
        this.userRepository = userRepository;
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

    public boolean deleteCartItem(String email, int cartItemId){
        User user = userRepository.findByEmail(email);
        if(user != null){
            CartItem cartItem = cartItemRepo.findById(cartItemId);
            cartItemRepo.delete(cartItem);
            return true;
        }
        return false;
    }
}
