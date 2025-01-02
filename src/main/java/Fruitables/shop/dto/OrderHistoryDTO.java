package Fruitables.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderHistoryDTO {

    private int id;
    private double total;
    private OrderStatusDTO status;

}
