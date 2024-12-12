package Fruitables.shop.service;

import Fruitables.shop.dto.CartItemDTO;
import Fruitables.shop.dto.ProductDTO;
import Fruitables.shop.dto.ShopOrderItemDTO;
import Fruitables.shop.entity.*;
import Fruitables.shop.repository.ShopOrderItemRepository;
import Fruitables.shop.repository.ShopOrderRepository;
import Fruitables.shop.util.ImgUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopOrderService {
    private final UserService userService;
    private final ShopOrderRepository shopOrderRepository;
    private final ShopOrderItemRepository shopOrderItemRepository;
    private final ImgUtil imgUtil;

    public ShopOrderService(UserService userService, ShopOrderRepository shopOrderRepository, ShopOrderItemRepository shopOrderItemRepository, ImgUtil imgUtil)
    {
        this.userService = userService;
        this.shopOrderRepository = shopOrderRepository;
        this.shopOrderItemRepository = shopOrderItemRepository;
        this.imgUtil = imgUtil;
    }

    public ShopOrder initUserShopOrder(String userEmail)
    {
        User user = userService.findByEmail(userEmail);
        ShopOrder shopOrder = shopOrderRepository.findByUser(user);
        if (shopOrder == null)
        {
            ShopOrder newShopOrder = new ShopOrder();
            newShopOrder.setUser(user);
            shopOrderRepository.save(newShopOrder);
            return newShopOrder;
        }
        return shopOrder;
    }

    public boolean addProductToUserShopOrder(String email, Product product, int qty, BigDecimal price)
    {
        ShopOrder shopOrder = initUserShopOrder(email);
        ShopOrderItem shopOrderItem = new ShopOrderItem(shopOrder, product, qty, price);
        try {
            shopOrderItemRepository.save(shopOrderItem);
            return true;
        } catch (Exception e) {
            System.out.print("Error save shop order item: "+ e.getMessage());
            return false;
        }
    }

    public List<ShopOrderItemDTO> getShopOrderItemByUser(String email)
    {
        User user = userService.findByEmail(email);
        ShopOrder shopOrder = shopOrderRepository.findByUser(user);
        List<ShopOrderItem> shopOrderItemList = shopOrderItemRepository.findByShopOrder(shopOrder);

        List<ShopOrderItemDTO> shopOrderItemDTOList = new ArrayList<>();
        for (ShopOrderItem s : shopOrderItemList)
        {
            ShopOrderItemDTO shopOrderItemDTO = new ShopOrderItemDTO();
            shopOrderItemDTO.setId(s.getId);
            shopOrderItemDTO.setQty(s.getQty);
            shopOrderItemDTO.setProductDTO(new ProductDTO(s.getProduct()));
            shopOrderItemDTO.setPrice(s.getPrice);
            shopOrderItemDTOList.add(shopOrderItemDTO);
            shopOrderItemDTO.setImage(imgUtil.getOneProductImage(s.getProduct()));
        }
    }
}
