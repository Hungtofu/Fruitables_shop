package Fruitables.shop.service;

import Fruitables.shop.dto.CartItemDTO;
import Fruitables.shop.dto.ProductDTO;
import Fruitables.shop.entity.*;
import Fruitables.shop.repository.CartItemRepository;
import Fruitables.shop.repository.CartRepository;
import Fruitables.shop.util.ImgUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private final UserService userService;
    private final CartRepository cartRepo;
    private final CartItemRepository cartItemRepo;
    private final ImgUtil imgUtil;

    public CartService(UserService userService, CartRepository cartRepo, CartItemRepository cartItemRepo, ImgUtil imgUtil) {
        this.userService = userService;
        this.cartRepo = cartRepo;
        this.cartItemRepo = cartItemRepo;
        this.imgUtil = imgUtil;
    }


    public Cart initUserCart (String userEmail){
        User user = userService.findByEmail(userEmail);
        Cart cart = cartRepo.findByUser(user);
        if(cart == null){
            Cart newCart = new Cart();
            newCart.setUser(user);
            cartRepo.save(newCart);
            return newCart;
        }
        return cart;
    }

    public boolean addProductToUserCart(String email, Product product, int qty){
        Cart cart = initUserCart(email);
        CartItem cartItem = cartItemRepo.findByProduct(product);
        if(cartItem == null){
            cartItem = new CartItem(cart, product, qty);
        } else {
            cartItem.setQty(cartItem.getQty() + qty);
        }
        try {
            cartItemRepo.save(cartItem);
            return true;
        } catch (Exception e){
            System.out.print("Error save cart item: "+ e.getMessage());
            return false;
        }
    }

    public List<CartItemDTO> getCartItemByUser(String email){
        User user = userService.findByEmail(email);
        Cart cart = cartRepo.findByUser(user);
        List<CartItem> cartItemList = cartItemRepo.findByCart(cart);

        List<CartItemDTO> cartItemDTOList = new ArrayList<>();
        for (CartItem c : cartItemList){
            CartItemDTO cartItemDTO = new CartItemDTO();
            cartItemDTO.setId(c.getId());
            cartItemDTO.setQty(c.getQty());
            cartItemDTO.setProductDTO(new ProductDTO(c.getProduct()));
            cartItemDTOList.add(cartItemDTO);
            cartItemDTO.setImage(imgUtil.getOneProductImage(c.getProduct()));
        }
        return cartItemDTOList;
    }



}
