package Fruitables.shop.service;

import Fruitables.shop.dto.CartItemDTO;
import Fruitables.shop.dto.ProductDTO;
import Fruitables.shop.dto.ShopOrderDTO;
import Fruitables.shop.dto.ShopOrderItemDTO;
import Fruitables.shop.entity.*;
import Fruitables.shop.repository.*;
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
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final UserPaymentMethodRepository userPaymentMethodRepository;
    private final DeliveryInformationRepository deliveryInformationRepository;
    private final ShippingMethodRepository shippingMethodRepository;
    private final OrderStatusRepository orderStatusRepository;
    private final ProductRepository productRepository;

    public ShopOrderService(UserService userService, ShopOrderRepository shopOrderRepository, ShopOrderItemRepository shopOrderItemRepository, ImgUtil imgUtil, CartRepository cartRepository, CartItemRepository cartItemRepository, UserPaymentMethodRepository userPaymentMethodRepository, DeliveryInformationRepository deliveryInformationRepository, ShippingMethodRepository shippingMethodRepository, OrderStatusRepository orderStatusRepository, ProductRepository productRepository)
    {
        this.userService = userService;
        this.shopOrderRepository = shopOrderRepository;
        this.shopOrderItemRepository = shopOrderItemRepository;
        this.imgUtil = imgUtil;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.userPaymentMethodRepository = userPaymentMethodRepository;
        this.deliveryInformationRepository = deliveryInformationRepository;
        this.shippingMethodRepository = shippingMethodRepository;
        this.orderStatusRepository = orderStatusRepository;
        this.productRepository = productRepository;
    }

    public ShopOrder initUserShopOrder(String userEmail, ShopOrderDTO dto)
    {
        User user = userService.findByEmail(userEmail);
        ShopOrder shopOrder = shopOrderRepository.findByUser(user);
        if (shopOrder == null)
        {
            ShopOrder newShopOrder = new ShopOrder();
            newShopOrder.setUser(user);
            newShopOrder.setOrderDate(dto.getOrderDate());
            newShopOrder.setPaymentMethod(userPaymentMethodRepository.findById(dto.getPaymentMethodId()));
            newShopOrder.setShippingAddress(deliveryInformationRepository.findById(dto.getShippingAddressId()));
            newShopOrder.setShippingMethod(shippingMethodRepository.findById(dto.getShippingMethodId));
            newShopOrder.setOrderTotal(dto.getOrderTotal());
            newShopOrder.setOrderStatus(orderStatusRepository.findById(dto.getOrderStatusId()));
            shopOrderRepository.save(newShopOrder);
            return newShopOrder;
        }
        return shopOrder;
    }

    public boolean addProductToUserShopOrder(String email, ShopOrderDTO dto, Product product, int qty, BigDecimal price)
    {
        ShopOrder shopOrder = initUserShopOrder(email, dto);
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
            shopOrderItemDTO.setId(s.getId());
            shopOrderItemDTO.setQty(s.getQty());
            shopOrderItemDTO.setProductDTO(new ProductDTO(s.getProduct()));
            shopOrderItemDTO.setPrice(s.getPrice());
            shopOrderItemDTOList.add(shopOrderItemDTO);
            shopOrderItemDTO.setImage(imgUtil.getOneProductImage(s.getProduct()));
        }
        return shopOrderItemDTOList;
    }

    public boolean createShopOrderItemsFromCartItems(String email)
    {
        User user = userService.findByEmail(email);
        Cart cart = cartRepository.findByUser(user);
        ShopOrder shopOrder = shopOrderRepository.findByUser(user);
        List<CartItem> cartItemList = cartItemRepository.findByCart(cart);

        try {
            for (CartItem c : cartItemList)
            {
                ShopOrderItem shopOrderItem = new ShopOrderItem();
                shopOrderItem.setId(c.getId());
                shopOrderItem.setQty(c.getQty());
                shopOrderItem.setProduct(productRepository.findById(c.getProduct().getId()));
                shopOrderItem.setShopOrder(shopOrderItemRepository.findById(shopOrder.getId));
                shopOrderItem.setPrice(c.getProduct().getPrice());
                shopOrderItemRepository.save(shopOrderItem);
            }
            cartItemRepository.deleteAll(cartItemList);
            return true;
        }
        catch (Exception e) {
            System.out.print("Error adding shop order items from cart items: "+ e.getMessage());
            return false;
        }
    }
}
