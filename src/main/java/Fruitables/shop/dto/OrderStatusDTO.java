package Fruitables.shop.dto;

import Fruitables.shop.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatusDTO {
    private int id;
    private String status;
    public OrderStatusDTO(OrderStatus orderStatus)
    {
        this.id = orderStatus.getId();
        this.status = orderStatus.getStatus();
    }
}
