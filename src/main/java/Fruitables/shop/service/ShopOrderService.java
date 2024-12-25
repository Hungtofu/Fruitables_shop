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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    Double total = 0.0;
    Double price = 0.0;

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

    /*
    public boolean addUserShopOrder(String userEmail, ShopOrderDTO dto, int shopOrderId)
    {
        User user = userService.findByEmail(userEmail);
        ShopOrder shopOrder = shopOrderRepository.findByUserAndId(user, shopOrderId);
        List<ShopOrderItem> shopOrderItemList = shopOrderItemRepository.findByShopOrder(shopOrder);
        if (shopOrder == null)
        {
            ShopOrder newShopOrder = new ShopOrder();
            newShopOrder.setUser(user);
            newShopOrder.setOrderDate(dto.getOrderDate());
            newShopOrder.setPaymentMethod(userPaymentMethodRepository.findById(dto.getPaymentMethodId()));
            newShopOrder.setShippingAddress(deliveryInformationRepository.findById(dto.getShippingAddressId()));
            newShopOrder.setShippingMethod(shippingMethodRepository.findById(dto.getShippingMethodId));
            private Double total = 0;
            private Double price = 0;
            for (ShopOrderItem s : shopOrderItemList)
            {
                price = s.getPrice() * s.getQty();
                total += price;
            }
            dto.getOrderTotal() = total;
            newShopOrder.setOrderTotal(dto.getOrderTotal());
            newShopOrder.setOrderStatus(orderStatusRepository.findById(dto.getOrderStatusId()));
            shopOrderRepository.save(newShopOrder);
            return newShopOrder;
        }
        return shopOrder;
    }
    /

     */
    public List<ShopOrderDTO> getShopOrdersOfAUser(String email)
    {
        /*
        private int id;
        private Timestamp orderDate;
        private int paymentMethodId;
        private int shippingAddressId;
        private int shippingMethodId;
        private Double orderTotal;
        private int orderStatusId;
        /
         */
        User user = userService.findByEmail(email);
        List<ShopOrder> orderList = shopOrderRepository.findByUser(user);
        List<ShopOrderDTO> orderDTOList = new ArrayList<>();
        for (ShopOrder s : orderList)
        {
            ShopOrderDTO shopOrderDTO = new ShopOrderDTO();
            shopOrderDTO.setId(s.getId());
            shopOrderDTO.setUser(user);
            shopOrderDTO.setTimestamp(s.getTimestamp());
            shopOrderDTO.setPaymentMethodId(s.getPaymentMethodId());
            shopOrderDTO.setShippingAddressId(s.getShippingAddressId());
            shopOrderDTO.setShippingMethodId(s.getShippingMethodId());
            shopOrderDTO.setOrderTotal(s.getOrderTotal());
            shopOrderDTO.setOrderStatusId(s.getOrderStatusId());
            orderDTOList.add(shopOrderDTO);
        }
        return orderDTOList;
    }

    public List<ShopOrderItemDTO> getShopOrderItemsOfAShopOrder(String email, int shopOrderId)
    {
        User user = userService.findByEmail(email);
        ShopOrder shopOrder = shopOrderRepository.findByUserAndId(user, shopOrderId);
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

    public boolean createShopOrderFromCart(String email, int paymentMethodId, int shippingAddressId, int shippingMethodId, int orderStatusId)
    {

        User user = userService.findByEmail(email);
        Cart cart = cartRepository.findByUser(user);

        List<CartItem> cartItemList = cartItemRepository.findByCart(cart);
        if (cartItemList != null) {
            ShopOrder shopOrder = new ShopOrder();
            shopOrder.setUser(user);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.now();
            shopOrder.setOrderDate(dtf.format(localDate));
            shopOrder.setPaymentMethod(userPaymentMethodRepository.findById(paymentMethodId));
            shopOrder.setShippingAddress(deliveryInformationRepository.findById(shippingAddressId));
            shopOrder.setShippingMethod(shippingMethodRepository.findById(shippingMethodId));
            shopOrder.setOrderStatus(orderStatusRepository.findById(orderStatusId));
            shopOrder.setOrderTotal(0.0);
            shopOrderRepository.save(shopOrder);
            for (CartItem c : cartItemList) {
                Product product = productRepository.findById(c.getProduct().getId());
                if (product.getQtyInStock() - c.getQty() >= 0) {
                    ShopOrderItem shopOrderItem = new ShopOrderItem();
                    // shopOrderItem.setId(c.getId());
                    shopOrderItem.setQty(c.getQty());
                    shopOrderItem.setProduct(productRepository.findById(c.getProduct().getId()));
                    product.setQtyInStock(product.getQtyInStock() - c.getQty());
                    shopOrderItem.setShopOrder(shopOrderRepository.findByUserAndId(user, shopOrder.getId()));
                    shopOrderItem.setPrice(c.getProduct().getPrice());
                    price = c.getPrice() * c.getQty();
                    total = total + price;

                    shopOrderItemRepository.save(shopOrderItem);
                    productRepository.save(product);
                }
            }
            shopOrder.setOrderTotal(total);
            shopOrderRepository.save(shopOrder);
            return true;
        }
        return false;
    }
}
