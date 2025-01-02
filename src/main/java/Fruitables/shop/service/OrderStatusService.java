package Fruitables.shop.service;

import Fruitables.shop.dto.OrderStatusDTO;
import Fruitables.shop.entity.OrderStatus;
import Fruitables.shop.repository.OrderStatusRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderStatusService {
    private final OrderStatusRepository order;
    public OrderStatusService(OrderStatusRepository order)
    {
        this.order = order;
    }
    public List<OrderStatusDTO> getAllOrderStatus ()
    {
        List<OrderStatusDTO> orderList = new ArrayList<>();
        for (OrderStatus o : this.order.findAll())
        {
            orderList.add(new OrderStatusDTO(o));
        }
        return orderList;
    }
}
