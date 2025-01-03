package Fruitables.shop.service;

import Fruitables.shop.dto.*;
import Fruitables.shop.entity.*;
import Fruitables.shop.payload.Request.PaymentRequest;
import Fruitables.shop.repository.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopOrderService {
    private final UserService userService;
    private final ShopOrderRepository shopOrderRepository;
    private final ShopOrderItemRepository shopOrderItemRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final PaymentTypeRepository paymentTypeRepository;
    private final DeliveryInformationRepository deliveryInformationRepository;
    private final ShippingMethodRepository shippingMethodRepository;
    private final OrderStatusRepository orderStatusRepository;
    private final ProductRepository productRepository;
    private final UserPaymentMethodRepository userPaymentMethodRepo;


    public ShopOrderService(UserService userService, ShopOrderRepository shopOrderRepository, ShopOrderItemRepository shopOrderItemRepository, CartRepository cartRepository, CartItemRepository cartItemRepository, PaymentTypeRepository paymentTypeRepository, DeliveryInformationRepository deliveryInformationRepository, ShippingMethodRepository shippingMethodRepository, OrderStatusRepository orderStatusRepository, ProductRepository productRepository, UserPaymentMethodRepository userPaymentMethodRepo)
    {
        this.userService = userService;
        this.shopOrderRepository = shopOrderRepository;
        this.shopOrderItemRepository = shopOrderItemRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.paymentTypeRepository = paymentTypeRepository;
        this.deliveryInformationRepository = deliveryInformationRepository;
        this.shippingMethodRepository = shippingMethodRepository;
        this.orderStatusRepository = orderStatusRepository;
        this.productRepository = productRepository;
        this.userPaymentMethodRepo = userPaymentMethodRepo;
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
    public List<OrderHistoryDTO> getShopOrdersOfAUser(String email)
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
        List<OrderHistoryDTO> orderHistoryDTO = new ArrayList<>();
        for (ShopOrder s : orderList)
        {
            OrderHistoryDTO order = new OrderHistoryDTO();
            order.setId(s.getId());
            order.setTotal(s.getOrderTotal());
            order.setStatus(new OrderStatusDTO(s.getOrderStatus()));
            orderHistoryDTO.add(order);
        }
        return orderHistoryDTO;
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
            shopOrderItemDTO.setProduct(new ProductDTO(s.getProduct()));
            shopOrderItemDTO.setPrice(s.getPrice());
            shopOrderItemDTO.setShopOrderId(shopOrderId);
            shopOrderItemDTOList.add(shopOrderItemDTO);
        }
        return shopOrderItemDTOList;
    }

    public boolean createShopOrderFromCart(String email, PaymentRequest request)
    {
        try {
            User user = userService.findByEmail(email);
            Cart cart = cartRepository.findByUser(user);
            double total = 0.0;
            List<CartItem> cartItemList = cartItemRepository.findByCart(cart);
            if (cartItemList != null) {
                ShopOrder currentShopOrder = new ShopOrder();
                currentShopOrder.setUser(user);
                currentShopOrder.setOrderDate(Timestamp.from(Instant.now()));
                currentShopOrder.setPaymentMethod(userPaymentMethodRepo.findById(request.getUserPaymentMethodId()));
                currentShopOrder.setShippingAddress(deliveryInformationRepository.findById(request.getShippingAddressId()));
                currentShopOrder.setShippingMethod(shippingMethodRepository.findById(request.getShippingMethodId()));
                currentShopOrder.setOrderStatus(orderStatusRepository.findById(request.getOrderStatusId()));
                shopOrderRepository.save(currentShopOrder);
                for (CartItem c : cartItemList) {
                    Product product = productRepository.findById(c.getProduct().getId());
                    if (product.getQtyInStock() - c.getQty() >= 0) {
                        ShopOrderItem shopOrderItem = new ShopOrderItem();

                        shopOrderItem.setShopOrder(currentShopOrder);
                        shopOrderItem.setQty(c.getQty());
                        shopOrderItem.setProduct(c.getProduct());
                        shopOrderItem.setPrice(c.getProduct().getPrice() * c.getQty());

                        product.setQtyInStock(product.getQtyInStock() - c.getQty());
                        total = c.getQty()*c.getProduct().getPrice();

                        shopOrderItemRepository.save(shopOrderItem);
                        productRepository.save(product);
                    }
                    cartItemRepository.delete(c);
                }

                currentShopOrder.setOrderTotal(total + currentShopOrder.getShippingMethod().getPrice());
                shopOrderRepository.save(currentShopOrder);
                return true;
            }
            return false;
        } catch (Exception e){
            System.out.println("Erorr payment: " + e.getMessage());
        }
        return false;

    }
}
