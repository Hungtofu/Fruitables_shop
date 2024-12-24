package Fruitables.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShopOrderDTO {
    private int id;
    private Timestamp orderDate;
    private int paymentMethodId;
    private int shippingAddressId;
    private int shippingMethodId;
    private Double orderTotal;
    private int orderStatusId;
}